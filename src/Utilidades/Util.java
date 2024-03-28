package Utilidades;
import java.util.Random;


public class Util {

    public Util(){

    }

    //Dado un numero que son los digito del numero a devolver aleatorio
    public static int Llenado(int digit) {
        int min = (int) Math.pow(10, digit - 1);
        int max = (int) Math.pow(10, digit) - 1;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    //Da un numero primo
    public  int Primo(){
        int n = (int) (Math.random() * 10 + 1);
        if (isPrimo(n) == true){
            return n;
        }else{
            return Primo();
        }
    }

    private static boolean isPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
