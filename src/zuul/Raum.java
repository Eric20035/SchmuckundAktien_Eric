/**
 * Diese Klasse modelliert R�ume in der Welt von Zuul.
 * 
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden.
 * M�gliche Ausg�nge liegen im Norden, Osten, S�den und Westen.
 * F�r jede Richtung h�lt ein Raum eine Referenz auf den 
 * benachbarten Raum.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
package zuul;

public class Raum 
{
    private String beschreibung;
    private Raum nordausgang;
    private Raum suedausgang;
    private Raum ostausgang;
    private Raum westausgang;
    private Raum uptreppe;
    private Raum downtreppe;

    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausgänge.
     * @param beschreibung enthält eine Beschreibung in der Form
     *        "in einer Küche" oder "auf einem Sportplatz".
     */
    public Raum(String beschreibung) 
    {
        this.beschreibung = beschreibung;
    }


private  Raum getAusgang(String richtung) {

    if (richtung.equals("north")){
        return nordausgang;
    }
    if (richtung.equals("south")){
        return suedausgang;
    }
    if (richtung.equals("west")){
        return westausgang;
    }
    if (richtung.equals("east")){
        return ostausgang;
    }
    if (richtung.equals("up")){
        return uptreppe;
    }
    if (richtung.equals("down")){
        return downtreppe;
    }
}

    /**
     * Definiere die Ausgaenge dieses Raums. Jede Richtung
     * f�hrt entweder in einen anderen Raum oder ist 'null'
     * (kein Ausgang).
     * @param norden Der Nordeingang.
     * @param osten Der Osteingang.
     * @param sueden Der Suedeingang.
     * @param westen Der Westeingang.
     *
     *
     */


    public void setzeAusgaenge(Raum norden, Raum osten,
                               Raum sueden, Raum westen, Raum up, Raum down)
    {
        if(norden != null)
            nordausgang = norden;
        if(osten != null)
            ostausgang = osten;
        if(sueden != null)
            suedausgang = sueden;
        if(westen != null)
            westausgang = westen;
        if(up != null)
            uptreppe = up;
        if(down != null)
            downtreppe = down;
    }

    private String ausgaengeToString(){
       Raum r =Raum.this.getAusgang();
        System.out.println("Du kannst nach  "+r + "laufen");
    }



    /**
     * @return Die Beschreibung dieses Raums.
     */
    public String gibBeschreibung()
    {
        return beschreibung;
    }



}
