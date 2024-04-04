package arrayLogic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Utilidades.Util;

public class LArray4 {
    String sfichero = "src\\Utilidades\\Datos4.txt";
    private ArrayList<Array4> array4s;

    public LArray4() {
        array4s = new ArrayList<>();
    }

    public void CargarDatos() {
        File fichero = new File(sfichero);
        Scanner s = null;
        try {
            s = new Scanner(fichero);

            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String[] cortarString = linea.split(",");
                Array4 x = new Array4(cortarString[0],cortarString[1],cortarString[2]);
                array4s.add(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (s != null)
                    s.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public void Llenado() {

        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantos nodos va a ingresar?"));

        for (int i = 0; i < op; i++) {

            String dato1 = JOptionPane.showInputDialog(null,
                    "Ingrese un dato con los siguientes parametros:    \nDonde la primera sea una letra mayúscula, seguida de 3 números o cifras o dígitos, seguido de un espacio, nuevamente 3 números, el signo - y finalice con 6 números");
            String expre = "^[A-Z]\\d{3}\\s\\d{3}-\\d{6}$";
            while (!dato1.matches(expre)) {
                dato1 = JOptionPane.showInputDialog(null,
                        "(Error intente de nuevo)\nIngrese un dato con los siguientes parametros:    \nDonde la primera sea una letra mayúscula, seguida de 3 números o cifras o dígitos, seguido de un espacio, nuevamente 3 números, el signo - y finalice con 6 números");
            }

            String dato2 = JOptionPane.showInputDialog(null,
                    "Ingrese un dato con los siguientes parametros: \ninicie con 4 números donde el primero es el 1, seguido de 6 letras en mayúscula y finaliza con 2 número entre el 3 y el 9 ");
            expre = "^[1][0-9]{3}[A-Z]{6}[2-9]{2}$";
            while (!dato2.matches(expre)) {
                dato2 = JOptionPane.showInputDialog(null,
                        "(Error intente de nuevo)\nIngrese un dato con los siguientes parametros: \ninicie con 4 números donde el primero es el 1, seguido de 6 letras en mayúscula y finaliza con 2 número entre el 3 y el 9 ");
            }

            String codigo = JOptionPane.showInputDialog(null,
                    "Ingrese un Codigo con los siguientes parametros: \ninicie con la letra E en mayúscula, seguida del signo -, seguido de las letras en mayúscula ISSN, siguiendo un espacio y 4 números, el signo - y finalizando con 4 números ");
            expre = "^[E]-ISSN\\s\\d{4}-\\d{4}";
            while (!codigo.matches(expre)) {
                codigo = JOptionPane.showInputDialog(null,
                        "(Error intente de nuevo)\nIngrese un Codigo con los siguientes parametros: \ninicie con la letra E en mayúscula, seguida del signo -, seguido de las letras en mayúscula ISSN, siguiendo un espacio y 4 números, el signo - y finalizando con 4 números ");
            }
            Array4 x = new Array4(dato1, dato2, codigo);

            array4s.add(x);
        }
    }

    public void Listar(){
        String s = "";
        for (Array4 array4 : array4s) {
           s+= array4.getDato1()+"---Dato1\n";
            s+=array4.getDato2()+"---Dato2\n";
            s+=array4.getCodigo()+"---Codigo\n";
            s+="---------\n";
        }
        Util.Listar(s, "Array4");
    }

    public void Seguidos(){
        String regex = "(\\d)\\1";
        Pattern pattern = Pattern.compile(regex);
        ArrayList<Array4> x = new ArrayList<>();
        for (Array4 array4 : array4s) {
       
            String vect[] = array4.getCodigo().split("[ -]");
            Matcher matcher = pattern.matcher(vect[2]);
            Matcher matcher2 = pattern.matcher(vect[3]);

            if (matcher.find() || matcher2.find()) {
                x.add(array4);
            } 
        }
        Listar(x);
        
    }

    public void Listar(ArrayList<Array4> x){
        String s = "";
        for (Array4 array4 : x) {
           s+= "Dato 1: "+array4.getDato1();
            s+="Dato 2: "+array4.getDato2();
            s+="Codigo: "+array4.getCodigo();
        }
        Util.Listar(s, "Array4");
    }

    public ArrayList<Array4> getArray4() {
        return array4s;
    }

}
