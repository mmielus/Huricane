package Components;

/**
 *
 *
 */
public class Stoper {

    private long start;
    private long stop;
    private String nazwa;


    public Stoper() {
        this("");
    }


    public Stoper(String nazwa) {
        this.nazwa = nazwa;
    }


    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        stop = System.currentTimeMillis();
    }

    public double pobierzWynik() {

        return (stop - start) / 1000.0;
    }


    public String toString() {

        return nazwa + ": " + this.pobierzWynik() + " s.";
    }
}
