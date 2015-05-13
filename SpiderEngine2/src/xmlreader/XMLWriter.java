/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlreader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import EstructurasDeDatos.*;
import Logica.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabo
 */
public class XMLWriter {
    private boolean flag=true;
    private FileWriter escribir;
    private BufferedWriter Buffer;

    /**
     * 
     * @throws IOException
     */
    public XMLWriter() throws IOException{
        this.escribir = new FileWriter("MyXMLURL.xml",true);
        this.Buffer=new BufferedWriter(escribir);
        
      
            
            
        
        

        
    }

    /**
     *
     */
    public void abrirEtiquetas(){
         try {
            this.escribir = new FileWriter("MyXMLURL.xml",true);
            this.Buffer=new BufferedWriter(escribir);
            escribir.write("<?xml version=\"1.0\"?>"+"\n");
            escribir.write("<project>"+"\n");
            

            escribir.close();
             Buffer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     *
     */
    public void cerrarEtiquetas(){
         try {
            this.escribir = new FileWriter("MyXMLURL.xml",true);
            this.Buffer=new BufferedWriter(escribir);
            escribir.write("</project>"+"\n");
            escribir.close();
             Buffer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    /**
     * 
     * @param pKeywords 
     * @param pURL
     * @param numero
     * @throws IOException
     */
    public synchronized void  Write(ListaCircularDoble<Keyword> pKeywords, String pURL,int numero) throws IOException{
            
            
            
            
       
            //File file2 = new File("MyXMLURL.xml");
           this.escribir = new FileWriter("MyXMLURL.xml",true);
           this.Buffer=new BufferedWriter(escribir);
           escribir.write("<URL>"+"\n");
           escribir.write("<Link>"+pURL+"</Link>"+"\n");
           escribir.write("<CantidadAparicion>"+numero+"</CantidadAparicion>"+"\n");
            System.out.println("pkey; "+pKeywords.getCantidadElementos());
            for(int i=0;i<pKeywords.getCantidadElementos();i++){
                escribir.write("<Keyword>"+pKeywords.datoIndice(i).getPalabra()+":"+pKeywords.datoIndice(i).getCantidadRepeticiones()+"</Keyword>"+"\n");
                
            }
            escribir.write("</URL>"+"\n");
            
           
          
           escribir.close();
           Buffer.close();
            
            
        
           
            
           
            
       
    }

    /**
     *
     * @param pDocumento
     * @throws IOException
     */
    public synchronized void  escribirEnXML(MyDoc pDocumento) throws IOException{
            
            
            
            
       
            //File file2 = new File("MyXMLURL.xml");
           this.escribir = new FileWriter("MyXMLURL.xml",true);
           this.Buffer=new BufferedWriter(escribir);
           escribir.write("<URL>"+"\n");
           escribir.write("<Directorio>"+pDocumento.getDireccion()+"</Directorio>"+"\n");
           escribir.write("<CantidadPalabras>"+pDocumento.getArbolKeywords().getCantEle()+"</CantidadPalabras>"+"\n");
            
           for(int i = 0; i<pDocumento.getArbolKeywords().Datos().getCantidadElementos();i++){
                escribir.write("<Keyword>"+pDocumento.getArbolKeywords().Datos().datoIndice(i).getPalabra()+":"+pDocumento.getArbolKeywords().Datos().datoIndice(i).getCantidadRepeticiones()+"</Keyword>"+"\n");
               
           }
              //  escribir.write("<Keyword>"+pKeywords.datoIndice(i).getPalabra()+":"+pKeywords.datoIndice(i).getCantidadRepeticiones()+"</Keyword>"+"\n");
                
           // }
            escribir.write("</URL>"+"\n");
            
           
          
           escribir.close();
           Buffer.close();
            
            
        
           
            
           
            
       
    }

    /**
     *
     * @return
     */
    public FileWriter getEscribir() {
        return escribir;
    }

    /**
     *
     * @param escribir
     */
    public void setEscribir(FileWriter escribir) {
        this.escribir = escribir;
    }

    /**
     *
     * @return
     */
    public BufferedWriter getBuffer() {
        return Buffer;
    }

    /**
     *
     * @param Buffer
     */
    public void setBuffer(BufferedWriter Buffer) {
        this.Buffer = Buffer;
    }
    
     
}

    

