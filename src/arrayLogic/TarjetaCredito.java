package arrayLogic;



public class TarjetaCredito {
    
    private String tipo;
    private long numTarj;
    private String fecha;
    private String nombre;
    private String apellido;
    private Short cvv;



    
    public TarjetaCredito() {
        
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public long getNumTarj() {
        return numTarj;
    }
    public void setNumTarj(long numTarj) {
        this.numTarj = numTarj;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Short getCvv() {
        return cvv;
    }
    public void setCvv(Short cvv) {
        this.cvv = cvv;
    }

    

}
