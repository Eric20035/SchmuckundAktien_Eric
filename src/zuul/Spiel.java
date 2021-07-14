/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul".
 *  "Die Welt von Zuul" ist ein sehr einfaches, textbasiertes
 *  Adventure-Game. Ein Spieler kann sich in einer Umgebung bewegen,
 *  mehr nicht. Das Spiel sollte auf jeden Fall ausgebaut werden,
 *  damit es interessanter wird!
 * 
 *  Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und
 *  an ihr die Methode "spielen" aufgerufen werden.
 * 
 *  Diese Instanz erzeugt und initialisiert alle anderen Objekte
 *  der Anwendung: Sie legt alle R�ume und einen Parser an und
 *  startet das Spiel. Sie wertet auch die Befehle aus, die der
 *  Parser liefert, und sorgt f�r ihre Ausf�hrung.
 * 
 * @author  Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */
package zuul;

public class Spiel 
{
    private Parser parser;
    private Raum aktuellerRaum;
        
    /**
     * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
     */
    public Spiel() 
    {
        raeumeAnlegen();
        parser = new Parser();
    }

    /**
     * Erzeuge alle Raeume und verbinde ihre Ausgaenge miteinander.
     */
    private void raeumeAnlegen()
    {
         Raum lichtung, waldstueck, taverne, hexenhaus, dorfplatz, gaestezimmer, keller, geheimgang, piratenhöhle;
      
        // die Raeume erzeugen
        lichtung = new Raum ("auf einer Lichtung, umgeben von dunklen Tannen");
        waldstueck = new Raum ("im dunklen Wald");
        taverne = new Raum ("in der Taverne, mit zwielichtigen Gestalten an der Theke");
        hexenhaus = new Raum ("im Hexenhaus");
        dorfplatz = new Raum ("auf dem Dorfplatz");
        gaestezimmer= new Raum ("Sie sind im Gaestezimmer");
        keller= new Raum ("Sie sind im Keller");
        geheimgang= new Raum ("Sie sind im Geheimgang");
        piratenhöhle= new Raum ("Sie sind in der Piratenhöhle");
        
        // die Ausgaenge initialisieren
        lichtung.setAusgang(null, null, null, waldstueck,null,null);
        waldstueck.setAusgang(null, lichtung, dorfplatz, null,null,null);
        taverne.setAusgang(dorfplatz, null, null, null,gaestezimmer,keller);
        hexenhaus.setAusgang(null, dorfplatz, null, null,null,null);
        dorfplatz.setAusgang(waldstueck, null, taverne, hexenhaus,null,null);
        gaestezimmer.setAusgang(null,null,null,null,null,taverne);
        keller.setAusgang(null,null,null,null,taverne,null);
        piratenhöhle.setAusgang(null,null,null,geheimgang,null,null);
        geheimgang.setAusgang(null,piratenhöhle,keller,null,null,null);
        aktuellerRaum = lichtung;
        // das Spiel startet auf der Lichtung
    }

    /**
     * Die Hauptmethode zum Spielen. Laeuft bis zum Ende des Spiels
     * in einer Schleife.
     */
    public void spielen() 
    {            
        willkommenstextAusgeben();

        // Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
        // und fuehren sie aus, bis das Spiel beendet wird.
                
        boolean beendet = false;
        while (! beendet) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
        }
        System.out.println("Danke fuer dieses Spiel. Auf Wiedersehen.");
    }

    /**
     * Einen Begruessungstext fuer den Spieler ausgeben.
     */
    private void willkommenstextAusgeben()
    {
        System.out.println();
        System.out.println("Willkommen zu Zuul!");
        System.out.println("Entdecke die Welt von Zuul. Doch Vorsicht, ueberall lauern Gefahren!");
        System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
        System.out.println();
        System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
        RaumInfoAusgeben();
    }

    /**
     * Verarbeite einen gegebenen Befehl (fuehre ihn aus).
     * @param befehl Der zu verarbeitende Befehl.
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean verarbeiteBefehl(Befehl befehl) 
    {
        boolean moechteBeenden = false;

        if(befehl.istUnbekannt()) {
            System.out.println("Ich weiss nicht, was Sie meinen...");
            return false;
        }

        String befehlswort = befehl.gibBefehlswort();
        if (befehlswort.equals("help"))
            hilfstextAusgeben();
        else if (befehlswort.equals("go"))
            wechsleRaum(befehl);
        else if (befehlswort.equals("quit")) {
            moechteBeenden = beenden(befehl);
        }
        return moechteBeenden;
    }

    // Implementierung der Benutzerbefehle:

    /**
     * Gib Hilfsinformationen aus.
     * Hier geben wir eine etwas alberne und unklare Beschreibung
     * aus, sowie eine Liste der Befehlswoerter.
     */
    private void hilfstextAusgeben() 
    {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren in der Welt von Zuul herum.");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verfuegung:");
        System.out.println("   go quit help");
    }

    /**
     * Versuche, den Raum zu wechseln. Wenn es einen Ausgang gibt,
     * wechsele in den neuen Raum, ansonsten gib eine Fehlermeldung
     * aus.
     */
    private void wechsleRaum(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
        	// Gibt es kein zweites Wort, wissen wir nicht, wohin...
            System.out.println("Wohin moechten Sie gehen?");
            return;
        }

        String richtung = befehl.gibZweitesWort();

        // Wir versuchen den Raum zu verlassen.
        Raum  naechsterRaum = null;
        naechsterRaum=this.aktuellerRaum.getAusgang(richtung);

        if (naechsterRaum == null) {
            System.out.println("Dort ist keine Tuer!");
        }
        else {
            aktuellerRaum = naechsterRaum;
            System.out.println("Sie sind " + aktuellerRaum.gibBeschreibung());
            RaumInfoAusgeben();
        }
    }

    /**
     * "quit" wurde eingegeben. ueberpruefe den Rest des Befehls,
     * ob das Spiel wirklich beendet werden soll.
     * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean beenden(Befehl befehl) 
    {
        if(befehl.hatZweitesWort()) {
            System.out.println("Was soll beendet werden?");
            return false;
        }
        else {
            return true;  // Das Spiel soll beendet werden.
        }
    }
    private String RaumInfoAusgeben(){
        System.out.print("Ausgaenge sind: ");

        String ausgaenge= this.aktuellerRaum.ausgaengeToString();
        System.out.println(ausgaenge);

        return null;
    }
}
