/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpiderEngine;

import EstructurasDeDatos.ListaCircularDoble;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Isaac Núñez
 */
public class Autocompletado implements DocumentListener{

    private static enum Modo{
        INSERTAR,
        TERMINACION
    };
    private static JTextField _busqueda;
    private ListaCircularDoble<String> _palabra = new ListaCircularDoble();
    private static Modo forma = Modo.INSERTAR;

    public Autocompletado(JTextField _busqueda, ListaCircularDoble<String> _palabra) {
        this._busqueda = _busqueda;
        this._palabra = _palabra;
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
    }
    public void insertUpdate(DocumentEvent e){
        if (e.getLength() != 1){
            return;
        }
        
        int posicion = e.getOffset();
        String contenido = null;
        try{
            contenido = _busqueda.getText(0, posicion+1);
        }catch(BadLocationException ev){
        }
        int a;
        for (a = posicion; a >= 0; a--){
            if (!Character.isLetter(contenido.charAt(a)))
                break;
        }
        if (posicion - a < 3)
            return;
                
        String prefijo =  contenido.substring(a+1).toLowerCase();
        for(int d = _palabra.IndiceDato(prefijo); -d <= _palabra.getCantidadElementos(); d--){
            String comparacion = _palabra.datoIndice(-d-1);
            if (comparacion.startsWith(prefijo)){
                String terminar = comparacion.substring(posicion - a);
                SwingUtilities.invokeLater(new TareaTerminado(terminar, posicion+1));
            }
        }
    }
    public class AccionTerminado extends AbstractAction{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (forma == Modo.TERMINACION){
                int total = _busqueda.getSelectionEnd();
                StringBuilder sb = new StringBuilder(_busqueda.getText());
                sb.insert(total, "");
                _busqueda.setText(sb.toString());
                _busqueda.moveCaretPosition(total);
                forma = Modo.INSERTAR;
            }else{
                _busqueda.replaceSelection("\t");
            }
        }
    }

    private static class TareaTerminado implements Runnable {
        private String terminado;
        private int gps;

        public TareaTerminado(String terminacion, int i) {
            this.terminado = terminacion;
            this.gps = i;
        }

        @Override
        public void run() {
            StringBuilder sp = new StringBuilder(_busqueda.getText());
            sp.insert(this.gps, this.terminado);
            _busqueda.setText(sp.toString());
            _busqueda.moveCaretPosition(this.gps);
            forma = Modo.TERMINACION;
        }
    }
    
    
}
