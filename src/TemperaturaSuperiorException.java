public class TemperaturaSuperiorException extends Throwable {
    public Integer numeroDeTest;
    public String barrio;

    public TemperaturaSuperiorException(Integer numeroDeTest, String barrio) {
        this.numeroDeTest = numeroDeTest;
        this.barrio = barrio;
    }

    public Integer getNumeroDeTest() {
        return numeroDeTest;
    }

    public void setNumeroDeTest(Integer numeroDeTest) {
        this.numeroDeTest = numeroDeTest;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}
