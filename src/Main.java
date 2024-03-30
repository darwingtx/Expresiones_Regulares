
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Utilidades.Util;

public class Main {

       public static void main(String[] args) {
       Array_3 x = new Array_3();
       x.CargarDatos("D:\\Users\\Usuario\\Documents\\NetBeansProjects\\AP4\\Expresiones_Regulares\\src\\Utilidades\\cargabasica.txt");
       x.agregarObj();
       ArrayList<Array_3> T = Array_3.Array_3;
       x.buscarTd();
       
       
       }
    }

    /* //manera de mostrar
     ArrayList<Array_1> T = Array_1.getArray_1();
        for (int i = 0; i < T.size(); i++) {
           for(int j=0;j<3;j++){
                   System.out.println( T.get(i).getVect(j));
           }
        }
     
    */

   
    public static void main(String[] args) {
        // Array_1 x = new Array_1();
        // x.llenarArray_1();
        // ArrayList<Array_1> T = Array_1.getArray_1();
        // for (int i = 0; i < T.size(); i++) {
        // for(int j=0;j<3;j++){
        // System.out.println( T.get(i).getVect(j));
        // }
        // }

        Array2 x = new Array2();
        x.LlenarArray2();
        x.Listar();
        x.NumeroMayor();
    }
}