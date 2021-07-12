import java.util.ArrayList;

public class TestProgramm  {

    //Eric Victor Löw

    public static void main(String[] args) {

        Tresor tresor= new Tresor();
        Schmuck schmuck1= new Schmuck(2,234,"Halskette");
        Schmuck schmuck2= new Schmuck(3, 2345,"Ring");
        Aktie aktie1= new Aktie(003,24565,"Effos",250,567);
        Aktie aktie2= new Aktie(004,23509,"Awarex",345,6789);

        tresor.addGegenstand(schmuck1);

        tresor.addGegenstand(schmuck2);

        tresor.addGegenstand(aktie1);

        tresor.addGegenstand(aktie2);

        System.out.println(tresor.toString());
        System.out.println(tresor.getVersicherungswertInTresor());





    }


}
