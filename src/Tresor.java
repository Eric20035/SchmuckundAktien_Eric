import java.util.ArrayList;

public class Tresor  {



    private ArrayList<Gegenstand> gegenstaende;

    public Tresor() {
        gegenstaende = new ArrayList<>();
    }

    public void addGegenstand(Gegenstand gegenstand){
        gegenstaende.add(gegenstand);

    }

    public double getVersicherungswertInTresor(){
        double versicherungswertSumme=0;
        for (int i=0; gegenstaende.size()>i;i++){
            //gegenstaende.get(i).getVersicherungswert();


            versicherungswertSumme=versicherungswertSumme+gegenstaende.get(i).getVersicherungswert();
        }

        return versicherungswertSumme;
    }


    @Override
    public String toString() {
        return "Tresor{" +
                "gegenstaende=" + gegenstaende +
                '}';
    }
}
