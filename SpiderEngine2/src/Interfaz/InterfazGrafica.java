/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import EstructurasDeDatos.ListaCircularDoble;
import Logica.Keyword;
import Logica.Facade;
import Logica.MyURL;
import SpiderEngine.Autocompletado;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentListener;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import xmlreader.XMLData;
import xmlreader.XMLReader;

/**
 *
 * @author Gabo
 */
    public class InterfazGrafica extends javax.swing.JFrame {

    /**
     *
     */
        public String palabra;
        private Facade _manager;
        private int timer=0;
        private ListaCircularDoble<String> topSearch = new ListaCircularDoble();
        //private ArrayList<String> keywords;
        private static final String COMMIT_ACTION = "commit";
        private ListaCircularDoble<String> _palabra;
        private ListaCircularDoble<Keyword> urlwords;
        ListaCircularDoble<MyURL> Datas;
        private ListaCircularDoble<MyURL> _listaHipervinculos;
        private ListaCircularDoble<String> links;

        public void setWords(Keyword pWord){
        urlwords.insertarFinal(pWord);}

    /**
     * Creates new form InterfazGrafica
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */
    public InterfazGrafica(Facade pManager) throws IOException, URISyntaxException, ParserConfigurationException, SAXException {
        _palabra = new ListaCircularDoble<String>();
        _listaHipervinculos=new ListaCircularDoble();
        links = new ListaCircularDoble();
        links.insertarFinal("C:\\Users\\IsaacNúñez\\Dropbox\\Datos 1\\PROYECTO #3 STAGE 2\\SpiderEngine2\\lecturas\\Carpeta Prueba\\Trabajo en Clase.pdf");
        links.insertarFinal("C:\\Users\\IsaacNúñez\\Dropbox\\Datos 1\\PROYECTO #3 STAGE 2\\SpiderEngine2\\lecturas\\Carpeta Prueba\\Extended1\\Cap.13-Movimiento_PeriÃ³dico-D.Venegas-V3.pdf");
        this._manager=pManager;
        initComponents();
        Autocompletar();
        HiperLink(this.string().toString(), this.string2().toString());
        
        //HiperLink();
    }
    
    public StringBuilder string(){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < this.links.getCantidadElementos(); i++){
            string.append("<a href=\"");
            string.append(this.links.datoIndice(i));
            string.append("\">"+this.links.datoIndice(i)+"</a><p>");
        }
        return string;
    }
    
    public StringBuilder string2(){
        StringBuilder string2 = new StringBuilder();
        for (int a = 0; a < this.links.getCantidadElementos(); a++){
            string2.append(this.links.datoIndice(a));
        }
        return string2;
    }

    /**
     *
     * @throws IOException
     * @throws URISyntaxException
     */
    public void HiperLink(String pURL, String pURL2) throws IOException, URISyntaxException{
        System.out.println("Esta seteando el link");
        jEditorPane1.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));//Es el método que define el tipo de jEditorPane va a adoptar.
        jEditorPane1.setEditable(false);//Aquí se define si el tamaño del jEditorPane se puede cambiar
        jEditorPane1.setText(pURL); //aquí se define el texto el cual va a incluir el jEditorPane
        jEditorPane1.addHyperlinkListener(new HyperlinkListener() {
        public void hyperlinkUpdate(HyperlinkEvent e) { //Este método permite que cuando el usuario haga click en uno de los links, se pueda abrir en el buscador predeterminado de la computadora
            if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                System.out.println("Holis");
                if(Desktop.isDesktopSupported()) {
                       try {
                           File file = new File("pURL2");
                           Desktop.getDesktop().open(file);
                           /*Runtime coso = Runtime.getRuntime();
                           coso.exec("xdg-open ");*/
                       } catch (IOException ex) {
                           Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
                       }
}System.out.println("Holis");
            }   else{
                        Runtime runtime = Runtime.getRuntime();
                        URI uri = new File(pURL2).toURI();
                        String ruta = pURL2+uri;
                try {
                    Process p = runtime.exec(ruta);
                } catch (IOException ex) {
                    Logger.getLogger(InterfazGrafica.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
}}
});     

        
    }
    

    /**
     *
     * @return devuelve lo que el usuario ingresó para poder realizar la búsqueda.
     */
    public String getSearch(){
        return palabra;
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        _busqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        Search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("MingLiU_HKSCS", 0, 25)); // NOI18N
        jLabel1.setText("Spider Search Engine: Stage 2 ");

        jEditorPane1.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(jEditorPane1);

        Search.setText("Búsqueda");
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_busqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Search, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//Es el método que al hacer click, guarda lo introducido en una variable para luego ser buscado y poder devolverle los resultados en el jEditorPane
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        palabra = _busqueda.getText().toLowerCase();
        //results(palabra);
        //System.out.println(palabra);
        _palabra.insertarFinal(palabra);
        _busqueda.setText(null);
        //this._listaHipervinculos= this._manager.getSpiderEngine().buscar(palabra);
        System.out.println(this._listaHipervinculos.getCantidadElementos());
        for(int i=0;i<this._listaHipervinculos.getCantidadElementos();i++){
            System.out.println(_listaHipervinculos.datoIndice(i).getLink());
        }
        
        
    }//GEN-LAST:event_SearchActionPerformed
    
    public void Autocompletar(){
        _busqueda.setFocusTraversalKeysEnabled(false);
        Autocompletado complete = new Autocompletado( _busqueda, _palabra);
        _busqueda.getDocument().addDocumentListener(complete);
        _busqueda.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
        _busqueda.getActionMap().put(COMMIT_ACTION, complete.new AccionTerminado());
    }
    public static void main(String args[]) throws IOException, URISyntaxException, ParserConfigurationException, SAXException, InterruptedException{
        InterfazGrafica _interfaz = new InterfazGrafica(new Facade());
        _interfaz.setVisible(true);
    }
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Search;
    public javax.swing.JTextField _busqueda;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

