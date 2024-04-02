package arrayLogic;

import java.util.*;
import javax.swing.JOptionPane;

import Utilidades.Util;

public class Array_1 {
    public static ArrayList<Array_1> Array_1 = new ArrayList<>();
    private long[] vect = new long[3];

    public Array_1() {

    }

    public static void llenarArray_1() {
        if(!Array_1.isEmpty()){
            Array_1.clear();
        }
        Util x = new Util();
        int i = 4;//x.Primo();
        for (int index = 0; index < i; index++) {
         Array_1 z = new Array_1();
         z.setVect(0, verificacion(index+1,'0'));
         z.setVect(1, verificacion(index+1, Long.toString(z.getVect(0)).charAt(0)));
         z.setVect(2, verificacion(index+1,  Long.toString(z.getVect(1)).charAt(0)));
         Array_1.add(z);
        }

    }
   
    private static int verificacion(int i, char r){
            int num = Util.Llenado(i);
            String expr = "["+r+"-9]{"+i+"}";
            String valor = ""+num;

    if(valor.matches(expr)){
        return num;
    }
    return 0;
}

    public static void promedio() {
        if (Array_1.size() % 2 == 0) {
            promediopar();
        } else {
            promedioImpar();
        }
    }

    public static void mostrar() {
        ArrayList<Array_1> T = Array_1;
        String s = "";
        for (int i = 0; i < T.size(); i++) {
            s += "[";
            for (int j = 0; j < 3; j++) {

                s += T.get(i).getVect(j) + ",";
            }
            s += "]\n";
        }
        JOptionPane.showMessageDialog(null, s);
    }

    private static void promedioImpar() {
        float prom = 0;
        String cadP = "-";
        int j = 0;
        Array_1 z = Array_1.get(j);
        for (int i = 0; i < Array_1.size(); i += 2) {
            z = Array_1.get(j);
            prom = z.getVect(0) + z.getVect(1) + z.getVect(2);
            cadP += prom / 3 + "-";
            if (i + 1 != Array_1.size()) {
                z = Array_1.get((Array_1.size() - 1) - j);
                prom = z.getVect(0) + z.getVect(1) + z.getVect(2);
                cadP += prom / 3 + "-";
            }
            j++;
        }
        JOptionPane.showMessageDialog(null, cadP);

    }

    private static void promediopar() {
        float prom = 0;
        String cadP = "-";
        int j = 0;
        for (int i = 0; i < Array_1.size(); i += 2) {
            Array_1 z = Array_1.get(j);
            prom = (z.getVect(0) + z.getVect(1) + z.getVect(2)) / 3;
            cadP += prom + "-";
            z = Array_1.get((Array_1.size() - 1) - j);
            prom = z.getVect(0) + z.getVect(1) + z.getVect(2);
            cadP += prom / 3 + "-";
            j++;
        }
        JOptionPane.showMessageDialog(null, cadP);

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
        this.vect = vect;
    }

    public void setVect(int n, long i) {
        this.vect[n] = i;
    }

}