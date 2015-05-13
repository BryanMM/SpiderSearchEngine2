/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Spiderbot;
import Arboles.Heap;
import Arboles.RedBlackT;
import Arboles.Tree_AVL;
import Logica.*;
import EstructurasDeDatos.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import xmlreader.*;


/**
 *
 * @author Gabo
 */
public class MySpiderBot implements Runnable {
    private int _maxthreads;
    private int _recursivity;
    private long _reindex;
    private Facade _facade;
    private Cola<MyURL> _colaURL;
 
    private XMLWriter _xmlDatos;
   
    
    private String _sourceDirectory;
    private Pattern _p = Pattern.compile("[a-zA-Z']{3,}");
  
    private Heap _heapDocumentos;
    private  MyDoc _nuevoDocumento;
    
    /**
     * Contructor que inicializa todas la variables necesarias

     * @throws IOException
     */
    public MySpiderBot(Facade pManager) throws IOException{
        this._xmlDatos = new XMLWriter();
        
        _colaURL=new Cola();
       
     
        _heapDocumentos = new Heap();
        
        this._facade=pManager;
    }

    /**
     * Metodo que se enarga de cargar el xml de configuracion para el spiderbot
     */
    public void configurarVariables(){
        XMLConfig _lector=new XMLConfig();
        _lector.ReadConfig();
        this._maxthreads=Integer.parseInt(_lector.getConfiguracion().datoIndice(0).toString());
        this._recursivity=Integer.parseInt(_lector.getConfiguracion().datoIndice(1).toString());
        this._reindex=Long.parseLong(_lector.getConfiguracion().datoIndice(2).toString());
        System.out.println(this._maxthreads+" "+this._recursivity+" "+this._reindex);
    }
 
            
    
    /**
     * Metodo que inseta en la cola los urls obtenidos desde un 
     * @param pDireccion directorio del documento
     */
    public void encolarURL(String pDireccion){
        XMLReader _lector=new XMLReader();
        _lector.Read(pDireccion);
        for(int i=0;i<_lector.getURL1().getCantidadElementos();i++){
            MyURL nuevo =new MyURL();
            nuevo.setLink(_lector.getURL1().datoIndice(i));
            nuevo.setIndice(0);
            
            _colaURL.enqueue(nuevo);
        }
        System.out.println("COLA CARGADA DESDE XML");
        
                
    }

    /**
     * Metodo que crea los hilos segun la cantidad de maxthreads
     * @throws IOException
     */
    public void  crearHilos() throws IOException{
         for(int i=0;i<_maxthreads;i++){
            
             
             Thread _threadBuscador = new Thread(this);
             _threadBuscador.start();
            
            
        }
    }
     
    /**
     *
     * @param pSource
     * @throws IOException
     * @throws FileNotFoundException
     * @throws TikaException
     * @throws SAXException
     */
    public synchronized void obtenerDatos(String pSource) throws IOException, FileNotFoundException, TikaException, SAXException{
       if(pSource.startsWith("http")){
           System.out.println(pSource);
            _nuevoDocumento = new MyDoc();
            _nuevoDocumento.setDireccion(pSource);
            _nuevoDocumento.setArbolKeywords(getOLFilesandParse(pSource));
            _heapDocumentos.insertar(_nuevoDocumento);        
      }
       else{
            getFiles(pSource);
   }}
   
    /**
     * Metodo que se encarga de buscar dentro de los directorios los demas directorios asi como los documentos y los almacena en las estructuras
     * @param pSource
     * 
     */
       private void getOLFilesandParse(String pURL) throws MalformedURLException, IOException{
            DefaultHttpClient httpclient = new DefaultHttpClient();
            StringBuilder coso = new StringBuilder();
            try {
                HttpGet httpGet = new HttpGet(pURL);
                HttpResponse response = httpclient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                InputStream input = null;
                if (entity != null) {
                    try{
                        input = entity.getContent();
                        BodyContentHandler handler = new BodyContentHandler();
                        Metadata metadata = new Metadata();
                        AutoDetectParser parser = new AutoDetectParser();
                        ParseContext parseContext = new ParseContext();
                        parser.parse(input, handler,metadata);
                        coso.append(handler);
                        tokenizer(coso.toString());
                        
     
                } catch (Exception e) {                     
                    e.printStackTrace();
                }finally{
                    if(input != null){
                        try {
                            input.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                }
            }catch (Exception exception) {
                exception.printStackTrace();
            }
    
}
   private void getFiles(String Source) throws IOException, FileNotFoundException, TikaException, SAXException{
       File _Documents = new File(Source);
       File[] Docs = _Documents.listFiles();
       int i=0;
       for(File pFile : Docs){
           
           if(!pFile.isDirectory() && i<this._recursivity){
               
                
                 _nuevoDocumento= new MyDoc();
                _nuevoDocumento.setDireccion(pFile.getAbsolutePath());
                _nuevoDocumento.setArbolKeywords(DocParser(pFile.getAbsolutePath()) );
                //_nuevoDocumento.setKeywords(DocParser(pFile.getAbsolutePath()));
                _heapDocumentos.insertar(_nuevoDocumento);
                
                System.out.println("Documento "+ pFile.getName()+" encontrado");
                System.out.println("Heap de "+_heapDocumentos.getArreglo().getCantidadElementos()+ " elementos");
           }
           else{
               i++;
               MyURL _nuevoURL = new MyURL();
               _nuevoURL.setLink(pFile.getAbsolutePath());
               _colaURL.enqueue(_nuevoURL);
               System.out.println(" Directorio: "+pFile.getAbsolutePath()+" insertado en cola");
           }
       }
   }

   private Tree_AVL DocParser(String pRoute) throws FileNotFoundException, IOException, TikaException, SAXException{
            StringBuilder text = new StringBuilder();
            InputStream in = new FileInputStream(new File(pRoute));
            BodyContentHandler TextHand = new BodyContentHandler(10*1024*1024);
            AutoDetectParser parser = new AutoDetectParser();
            Metadata meta = new Metadata();
            parser.parse(in,TextHand,meta);
            text.append(TextHand);
            return tokenizer(text.toString());
            
            
   
   }
   private Tree_AVL tokenizer(String pText){
       Tree_AVL _nuevoAVL = new Tree_AVL();
       Matcher m = _p.matcher(pText);
       int cantidad=0;
       while(m.find()){
           Keyword tmp = new Keyword(m.group());
           cantidad++;
           tmp.setDirectorio(_sourceDirectory);
           _nuevoAVL.Inserta_AVL(tmp);
           
         /*  if(_avlKeywords.equals(tmp)){
                  Keyword result = (Keyword) _avlKeywords.Busqueda(tmp).getDatos();
                  int j = result.getCantidadRepeticiones();
                  result.setCantidadRepeticiones(j+=1);}
           else{
                tmp.setUrl(_sourceDirectory);
                _avlKeywords.Inserta_AVL(tmp);
                System.out.println("Palabra: "+ m.group());*/
           
       }
      // System.out.println("Cantidad Palabras "+ cantidad);
     //  _nuevoDocumento.setCantidadPalabras(cantidad);
      // _nuevoDocumento.setListaKeywords(_nuevoAVL);
       return _nuevoAVL;
   }
       
   
       
   

    /**
     *
     * @param pUrl
     * @param pUrl
     */
    public void agregarURL(String pUrl){
        MyURL _urlNuevo = new MyURL(pUrl);
        _colaURL.enqueue(_urlNuevo);
    }

    /**
     *
     * @throws java.io.IOException
     * @throws org.apache.tika.exception.TikaException
     * @throws IOException
     * @throws org.xml.sax.SAXException
     * @throws TikaException
     * @throws FileNotFoundException
     * @throws SAXException
     */
    public void generarXML() throws IOException, TikaException, FileNotFoundException, SAXException{
        _xmlDatos.abrirEtiquetas();
            for(int i=0;i<this._heapDocumentos.getArreglo().getCantidadElementos();i++){
               // MyDoc temp = (MyDoc)_heapDocumentos.getArreglo().datoIndice(0);
                MyDoc temp = (MyDoc)_heapDocumentos.obtenerDato();
                System.out.println(temp.getDireccion());
                temp.setArbolKeywords(DocParser(temp.getDireccion()));
                _xmlDatos.escribirEnXML(temp);
            }
        _xmlDatos.cerrarEtiquetas();
        
        
    }

   
     

    @Override
    public void run() {
        while(true){
            if(!_colaURL.estaVacia()){
                try {
                    obtenerDatos(_colaURL.dequeue().getLink());
                    //getSourse(colaURL.dequeue());
                    //
                } catch (IOException ex) {
                    Logger.getLogger(MySpiderBot.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TikaException ex) {
                    Logger.getLogger(MySpiderBot.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(MySpiderBot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                try {
                    Thread.sleep(_reindex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MySpiderBot.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
    }

    /**
     *
     * @return
     */
    public Cola<MyURL> getColaURL() {
        return _colaURL;
    }

    /**
     *
     * @param _colaURL
     */
    public void setColaURL(Cola<MyURL> _colaURL) {
        this._colaURL = _colaURL;
    }

    public int getMaxthreads() {
        return _maxthreads;
    }

    public void setMaxthreads(int _maxthreads) {
        this._maxthreads = _maxthreads;
    }

    public int getRecursivity() {
        return _recursivity;
    }

    public void setRecursivity(int _recursivity) {
        this._recursivity = _recursivity;
    }

    public long getReindex() {
        return _reindex;
    }

    public void setReindex(long _reindex) {
        this._reindex = _reindex;
    }

    public Facade getFacade() {
        return _facade;
    }

    public void setFacade(Facade _facade) {
        this._facade = _facade;
    }

    public XMLWriter getXmlDatos() {
        return _xmlDatos;
    }

    public void setXmlDatos(XMLWriter _xmlDatos) {
        this._xmlDatos = _xmlDatos;
    }

    public String getSourceDirectory() {
        return _sourceDirectory;
    }

    public void setSourceDirectory(String _sourceDirectory) {
        this._sourceDirectory = _sourceDirectory;
    }

    public Pattern getP() {
        return _p;
    }

    public void setP(Pattern _p) {
        this._p = _p;
    }

    public Heap getHeapDocumentos() {
        return _heapDocumentos;
    }

    public void setHeapDocumentos(Heap _heapDocumentos) {
        this._heapDocumentos = _heapDocumentos;
    }

    public MyDoc getNuevoDocumento() {
        return _nuevoDocumento;
    }

    public void setNuevoDocumento(MyDoc _nuevoDocumento) {
        this._nuevoDocumento = _nuevoDocumento;
    }
    
    
    
    
    
    
    
}
