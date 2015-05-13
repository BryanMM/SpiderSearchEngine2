package Arboles;

import Logica.Keyword;
import java.util.Random;

public class test {

	public static void main(String[] args) {
            RedBlackT coso = new RedBlackT();
		/*// TODO Auto-generated method stub
		BinaryT coso = new BinaryT();
                Keyword coso1 = new Keyword("hola");
                //coso.insert(coso1);
                //coso.insert(coso1);
                */
                Random rand = new Random();
                for(int i=0; i!= 10000; i++){
                    coso.insert(rand.nextInt());}
                
                
                //coso.insert(coso2);
                
                
                //Keyword coso3 = (Keyword) coso.contains(coso2);
              //  System.out.println(coso3.getPalabra());
                
	
            
            coso.insert(12);
            coso.insert(14);
            coso.insert(11);
            coso.getData();

}}
