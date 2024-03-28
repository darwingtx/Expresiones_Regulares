
import java.util.ArrayList;


import Utilidades.Util;

    public class Main {

       public static void main(String[] args) {
        Array_1 x = new Array_1();
        x.llenarArray_1();
        ArrayList<Array_1> T = Array_1.getArray_1();
        for (int i = 0; i < T.size(); i++) {
           for(int j=0;j<3;j++){
                   System.out.println( T.get(i).getVect(j));
           }
        }
    }
}
    
   