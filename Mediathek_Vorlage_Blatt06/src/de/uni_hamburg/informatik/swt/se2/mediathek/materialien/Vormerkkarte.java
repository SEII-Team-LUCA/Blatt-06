package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

//import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * @author Aurora
 *
 */
public class Vormerkkarte
{
    private Kunde _ausleiher;
    private List<Kunde> _vormerker;

    //private final Medium _medium;

    public Vormerkkarte(Kunde ausleiher)
    {
        _ausleiher = ausleiher;
        _vormerker = new LinkedList<Kunde>();
        // _medium = medium;
    }

    /**
     * Setzt einen Ausleiher für ein Medium
     * 
     * @param ausleiher
     * 
     * @require ausleiher != null
     */
    public void leiheAus(Kunde ausleiher)
    {
        assert ausleiher != null : "Vorbedingung verletzt: null";
        if (pruefeObAusleihenMoeglich(ausleiher))
        {
            _ausleiher = ausleiher;
        }
    }

    /**
     * Fügt einen Vormerker für ein Medium hinzu
     * 
     * @param vormerker
     * 
     * @require vormerker != null
     */
    public void fuegeVormerkerHinzu(Kunde vormerker)
    {
        assert vormerker != null : "Vorbedingung verletzt: null";
        if (pruefeObVormerkenMoeglich(vormerker))
        {
            _vormerker.add(vormerker);
        }
    }

    /**
     * Prüft ob ein Kunde das Medium ausleihen darf:
     * Das Medium darf nicht ausgeliehen sein.
     * Der erste Vormerker muss entweder der Kunde selber sein, oder es darf keinen geben.
     * 
     * @param ausleiher
     * @return ob Ausleihen moeglich ist
     * 
     * @require ausleiher != null
     */
    private boolean pruefeObAusleihenMoeglich(Kunde ausleiher)
    {
        assert ausleiher != null : "Vorbedingung verletzt: null";
        return (_ausleiher == null && (_vormerker.get(0) == ausleiher || _vormerker.get(0) == null));
    }

    /**
     * Prüft ob ein Kunde das Medium vormerken darf:
     * Er darf nicht bereits in der Liste der Vormerker enthalten sein.
     * Es dürfen nicht schon 3 Kunden das Medium vorgemerkt haben.
     * Er darf nicht der aktuelle Ausleiher der Mediums sein.
     * 
     * @param ausleiher
     * @return ob Vormerken moeglich ist
     * 
     * @require vormerker != null
     */

    private boolean pruefeObVormerkenMoeglich(Kunde vormerker)
    {
        assert vormerker != null : "Vorbedingung verletzt: null";
        //ToDo Hier müssen noch die ganzen Vormerkbedingungen verarbeitet werden
        return (!_vormerker.contains(vormerker) && _vormerker.size() < 3 && vormerker != _ausleiher);
    }

    /**
     * Entfernt einen Kunden aus dem Vormerker-Status für ein Medium
     * 
     * @param vormerker
     * 
     * @require vormerker != null
     */
    public void entferneVormerker(Kunde vormerker)
    {
        assert vormerker != null : "Vorbedingung verletzt: null";
        if (_vormerker.contains(vormerker))
        {
            _vormerker.remove(_vormerker.indexOf(vormerker));
        }
    }

    /**
     * Sagt dem Medium es wurde zurückgegeben und setzt den Ausleiher gleich null
     */

    public void wurdeZurueckgegeben()
    {
        _ausleiher = null;
    }

    //   public Medium getMedium()
    //   {
    //      return _medium;
    //  }
}
