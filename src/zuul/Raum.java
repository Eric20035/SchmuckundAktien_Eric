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

import java.util.HashMap;

public class Raum
{
    private String beschreibung;
    private  Raum nordausgang;
    private  Raum suedausgang;
    private  Raum ostausgang;
    private  Raum westausgang;
    private  Raum uptreppe;
    private  Raum downtreppe;
    private HashMap<String, Raum> ausgaenge;

    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausgänge.
     * @param beschreibung enthält eine Beschreibung in der Form
     *        "in einer Küche" oder "auf einem Sportplatz".
     */
    public Raum(String beschreibung)
    {
        this.beschreibung = beschreibung;
        this.ausgaenge= new HashMap<>();
    }




    public void setAusgang(String richtung, Raum nachbar) {
    ausgaenge.put(richtung,nachbar);
}

    /**
     * Definiere die Ausgaenge dieses Raums. Jede Richtung
     * f�hrt entweder in einen anderen Raum oder ist 'null'
     * (kein Ausgang).
    // * @param norden Der Nordeingang.
    // * @param osten Der Osteingang.
    // * @param sueden Der Suedeingang.
    // * @param westen Der Westeingang.
     *
     *
     */
    public Raum getAusgaenge(String richtung) {



        Raum r=ausgaenge.get(richtung);



        return r;
    }






    public String ausgaengeToString() {
        String richtungen = "";
        for(String richtungFuerDenAktuellenEintragAusHashmap: ausgaenge.keySet()) {
            richtungen += richtungFuerDenAktuellenEintragAusHashmap + " ";
        }
        return richtungen;
    }



    /**
     * @return Die Beschreibung dieses Raums.
     */
    public String gibBeschreibung()
    {
        return beschreibung;
    }



}
