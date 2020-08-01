public class Contador {

    private int cuenta;
    private final String id;

    public Contador(String id) {
        this.id = id;
        cuenta = 0;
    }

    public void incrementar() {
        cuenta += 1;
    }

    public void decrementar() {

        cuenta -= 1;
    }

    public int incrementos() {
        return cuenta;
    }

    public String toString() {

        return this.id + "-" + this.cuenta;
    }
}