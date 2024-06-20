import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sano implements Serializable {
    private List<Persona> sanos= new ArrayList<>();

    public Sano(List<Persona> sanos) {
        this.sanos = sanos;
    }

    public Sano() {
    }

    public List<Persona> getSanos() {
        return sanos;
    }

    public void setSanos(List<Persona> sanos) {
        this.sanos = sanos;
    }
}
