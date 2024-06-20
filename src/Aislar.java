import java.io.Serializable;

public class Aislar implements Serializable {
    private Integer kit;
    private Integer temperatura;
    private String barrio;

    public Aislar() {
    }

    public Aislar(Integer kit, Integer temperatura, String barrio) {
        this.kit = kit;
        this.temperatura = temperatura;
        this.barrio = barrio;
    }

    public Integer getKit() {
        return kit;
    }

    public void setKit(Integer kit) {
        this.kit = kit;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}
