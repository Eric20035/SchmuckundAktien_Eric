public abstract class Gegenstand {


    private int id;
    private double versicherungswert;

    public Gegenstand(int id, double versicherungswert) {
        this.id = id;
        this.versicherungswert = versicherungswert;
    }

    public int getId() {
        return id;
    }

    public double getVersicherungswert() {
        return versicherungswert;
    }
}
