public class CantidadDeTestException extends Exception{
    public Integer cantidad;

    public CantidadDeTestException(Integer cantidad) {
        super("la cantidad de tests es insuficiente para realizar el chequeo");
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
