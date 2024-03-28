

import java.util.ArrayList;

import Utilidades.Util;


public class Array_1 {
    public static ArrayList<Array_1> Array_1 = new ArrayList<>();
    private long[] vect = new long[3];

    
    public Array_1() {
    
    }
    public void llenarArray_1(){
        Util x = new Util();
        int i = x.Primo();
        for (int index = 0; index < i; index++) {
         Array_1 z = new Array_1();
         z.setVect(0, verificacion(index+1,'0'));
         z.setVect(1, verificacion(index+1, Long.toString(z.getVect(0)).charAt(0)));
         z.setVect(2, verificacion(index+1,  Long.toString(z.getVect(1)).charAt(0)));
         Array_1.add(z);
        }

    }
    public int verificacion(int i, char r){
            int num = Util.Llenado(i);
            String expr = "["+r+"-9]{"+i+"}";
            String valor = ""+num;

        if(valor.matches(expr)){
            return num;
        }
        return verificacion(i,r);
    }
    public static ArrayList<Array_1> getArray_1() {
        return Array_1;
    }
    public long getVect(int i) {
        return vect[i];
    }
    public long[] getVect() {
        return vect;
    }
    public void setVect(long vect[]) {
        this.vect = vect ;
    }
    public void setVect(int n, long i) {
        this.vect[n] = i;
    }

}