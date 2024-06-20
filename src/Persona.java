public class Persona {
    private String nombreYApellido;
    private Integer edad;
    private String barrio;
    private Integer dni;
    private String ocupacion;

    public Persona() {
    }

    public Persona(String nombreYApellido, Integer edad, String barrio, Integer dni, String ocupacion) {
        this.nombreYApellido = nombreYApellido;
        this.edad = edad;
        this.barrio = barrio;
        this.dni = dni;
        this.ocupacion = ocupacion;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombreYApellido='" + nombreYApellido + '\'' +
                ", edad=" + edad +
                ", barrio='" + barrio + '\'' +
                ", dni=" + dni +
                ", ocupacion='" + ocupacion + '\'' +
                '}';
    }
}
