public class Aktie extends Gegenstand{

    private String unternehmen;
    private double nennwert;
    private double kurswert;

    public Aktie(int id, double versicherungswert, String unternehmen, double nennwert, double kurswert) {
        super( id, versicherungswert);
        this.unternehmen = unternehmen;
        this.nennwert = nennwert;
        this.kurswert = kurswert;
    }
     double versicherungswert= kurswert;

    public String getUnternehmen() {
        return unternehmen;
    }

    public double getNennwert() {
        return nennwert;
    }

    public double getKurswert() {
        return kurswert;
    }

    @Override
    public String toString() {
        return "Aktie{" +
                "unternehmen='" + unternehmen + '\'' +
                ", nennwert=" + nennwert +
                ", kurswert=" + kurswert +
                '}';
    }
}
