package arrayLogic;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Utilidades.Util;

public class Array2 {
    public ArrayList<ArrayList<Integer>> Array_2 = new ArrayList<>();

    public Array2() {

    }

    public void LlenarArray2() {
        int datos = 3;
        int maxNodos = Integer.parseInt(JOptionPane.showInputDialog(null,"Cuantos nodos ingresara?"));
        int num = 0;
        for (int i = 0; i < maxNodos; i++) {
            num = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "Ingresa el numero para ingresar los numeros en el nodo"));
            System.out.println("-/-/-/-/-/-/-/" + num);
            ArrayList<Integer> x = new ArrayList<>();
            Array_2.add(x);
            for (int j = 0; j < datos; j++) {
                Array_2.get(i).add(verificacion(Integer.toString(num).charAt(0), Integer.toString(num).length(), num));
            }
            datos += 2;
        }
    }

    public int verificacion(char r, int i, int num) {
        int num2 = Util.Llenado(1, num);
        String expr = "[1-" + r + "]{1," + i + "}";
        String valor = "" + num2;

        if (valor.matches(expr)) {
            return num2;
        }
        return verificacion(r, i, num);
    }

    public void Listar() {
        int datos = 3;
        String s = "";
        for (int i = 0; i < Array_2.size(); i++) {
            s+="[";
            for (int j = 0; j < datos; j++) {
                s+= Array_2.get(i).get(j)+"  ";
            }
            s+="]--";
            datos += 2;
        }

        Util.Listar(s, "Array_2");
    }

    public void NumeroMayor() {
        int datos = 3;
        int NumeroMayor = 0;

        for (int i = 0; i < Array_2.size(); i++) {
            int x = Integer.toString(NumeroMayor).length();
            
            char d = Integer.toString(NumeroMayor).charAt(0);
            char c = ' ';
            if (x>1) {
                c =  Integer.toString(NumeroMayor).charAt(1); 
            }
            for (int j = 0; j < datos; j++) {
                int n = Array_2.get(i).get(j);
                if (verificacion(x, d, n, c)) {
                    NumeroMayor = Array_2.get(i).get(j);
                }
            }
            datos += 2;

        }
        System.out.println(NumeroMayor);

    }

    public void Mayor() {
        int datos = 3;
        int NumeroMayor = 0;

        for (int i = 0; i < Array_2.size(); i++) {
            for (int j = 0; j < datos; j++) {
                if (NumeroMayor<=Array_2.get(i).get(j)) {
                    NumeroMayor = Array_2.get(i).get(j);
                }
            }
            datos += 2;

        }
        JOptionPane.showMessageDialog(null,"Numero mayor es: " +NumeroMayor);

    }

    public Boolean verificacion(int i, char r, int n, char c) {

        String expr = "[" + r + "-9]{" + i + ",10}";
        String valor = "" + n;

        if (valor.matches(expr)) {
            return true;
        }
        return false;
    }

    public ArrayList<ArrayList<Integer>> getArray2(){
        return Array_2;
    }
}
