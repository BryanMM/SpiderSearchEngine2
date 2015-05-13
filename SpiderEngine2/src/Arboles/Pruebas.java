/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Arboles;

/**
 *
 * @author Gabriel
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Heap<Integer> _nuevoHeap=new Heap();
        _nuevoHeap.insertar(8);
        _nuevoHeap.insertar(15);
        _nuevoHeap.insertar(7);
        _nuevoHeap.insertar(9);
        _nuevoHeap.insertar(11);
        _nuevoHeap.insertar(14);
        _nuevoHeap.insertar(18);
        _nuevoHeap.insertar(1);
        _nuevoHeap.insertar(3);
        _nuevoHeap.insertar(13);
        _nuevoHeap.insertar(5);
        _nuevoHeap.insertar(2);
        _nuevoHeap.insertar(25);
        _nuevoHeap.insertar(31);
        _nuevoHeap.insertar(4);
        _nuevoHeap.insertar(85);
        _nuevoHeap.insertar(19);
        _nuevoHeap.insertar(44);
        _nuevoHeap.insertar(5);
        _nuevoHeap.insertar(64);
        _nuevoHeap.insertar(0);
        _nuevoHeap.imprimir();
        System.out.println("HEAP");
         _nuevoHeap.heapMayores();
         _nuevoHeap.imprimir();
    
        
        Heap<String> _nuevoHeap2=new Heap();
        _nuevoHeap2.insertar("A");
        _nuevoHeap2.insertar("H");
        _nuevoHeap2.insertar("O");
        _nuevoHeap2.insertar("D");
        _nuevoHeap2.insertar("P");
        _nuevoHeap2.insertar("E");
        _nuevoHeap2.insertar("R");
        _nuevoHeap2.insertar("W");
        _nuevoHeap2.insertar("M");
        _nuevoHeap2.insertar("G");
        _nuevoHeap2.insertar("L");
        _nuevoHeap2.insertar("N");
        _nuevoHeap2.insertar("Z");
        _nuevoHeap2.insertar("S");
        _nuevoHeap2.insertar("Q");
        
        _nuevoHeap2.imprimir();
        System.out.println("HEAP");
         _nuevoHeap2.heapMayores();
         _nuevoHeap2.imprimir();
         
        
         
         
         
    }
    
}
