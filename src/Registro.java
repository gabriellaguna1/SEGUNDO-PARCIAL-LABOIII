public class Registro {
    private Integer i=0;
    private Integer nroRegistro;
    private Integer dni;
    private Integer temperatura;

    public Registro() {
    }

    public Registro(Integer dni, Integer temperatura) {
        this.nroRegistro=i++;
        this.dni = dni;
        this.temperatura = temperatura;
    }
    public Integer getNroRegistro(){
        return this.nroRegistro;
    }
    public void setNroRegistro(Integer nroRegistro){
        this.nroRegistro= nroRegistro;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "nroRegistro=" + nroRegistro +
                ", dni=" + dni +
                ", temperatura=" + temperatura +
                '}';
    }
}
