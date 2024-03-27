

import java.util.ArrayList;

import Utilidades.Util;


public class Array_1 {
    public static ArrayList<Array_1> Array_1 = new ArrayList<>();
    private double[] vect;

    
    public Array_1() {
        Util x = new Util();
       int i = 1;//x.Primo();
       for (int index = 0; index < i; index++) {
        Array_1 z = new Array_1();
        z.setVect(0, verificacion(index));
        z.setVect(1, verificacion((int)z.getVect(0)));
        z.setVect(2, verificacion((int)z.getVect(1)));
       }
    }
    public int verificacion(int i){
            int num = Util.Llenado(1);
            String expr = "["+i+"-9]";
            String valor = ""+num;

        if(valor.matches(expr)){
            return num;
        }
        return verificacion(i);
    }
    public static ArrayList<Array_1> getArray_1() {
        return Array_1;
    }
    public double getVect(int i) {
        return vect[i];
    }
    public double[] getVect() {
        return vect;
    }
    public void setVect(double vect[]) {
        this.vect = vect ;
    }
    public void setVect(int n, double i) {
        this.vect[n] = i;
    }

    



}