import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LTarjetas {

    private ArrayList<TarjetaCredito> tarjetas = new ArrayList<>();

    public LTarjetas() {

    }

    public void Ingreso() {
        String visa = "^5[0-9]{15}$";
        String master = "^4[0-9]{15}$";
        String nomb = "^[A-Z']$";
        String cvv = "^[0-9]{3}$";
        TarjetaCredito x = new TarjetaCredito();

        String num = JOptionPane.showInputDialog(null, "Ingresa el numero de la tarjeta");

        while (!num.matches(visa) || !num.matches(master)) {
            num = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el numero de la tarjeta");
        }

        x.setNumTarj(Long.parseLong(num));
        if (num.matches(visa)) {
            x.setTipo("Visa");
        }else if(num.matches(master)){
            x.setTipo("MasterCard");
        }

        String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre que esta en la tarjeta");

        while (!nombre.matches(nomb)) {
            num = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el nombre que esta en la tarjeta");
        }

        x.setNombre(nombre);

        String apellido = JOptionPane.showInputDialog(null, "Ingresa el apellido que esta en la tarjeta");

        while (!apellido.matches(nomb)) {
            apellido = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el apellido que esta en la tarjeta");
        }

        x.setApellido(apellido);

        String codigo = JOptionPane.showInputDialog(null, "Ingresa el codigo de verificacion que esta en la tarjeta");

        while (!codigo.matches(cvv)) {
            codigo = JOptionPane.showInputDialog(null,
                    "(Error intente de nuevo)\nIngresa el codigo de verificacion que esta en la tarjeta");
        }

        x.setCvv(Short.parseShort(codigo));

        tarjetas.add(x);
    }

    public void Listar(){
        
    }
}
