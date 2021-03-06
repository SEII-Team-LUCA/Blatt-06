package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

//BEARBEITET 01. Vormerkkarte zur informationserhaltung während des Vormerkvorgangs.

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
        //if (pruefeObAusleihenMoeglich(ausleiher))
        //{
        _ausleiher = ausleiher;
        entferneVormerker(ausleiher);
        //}
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
        //if (pruefeObVormerkenMoeglich(vormerker))
        //{
        _vormerker.add(vormerker);
        //}
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
    public boolean pruefeObAusleihenMoeglich(Kunde ausleiher)
    {
        //assert ausleiher != null : "Vorbedingung verletzt: null";
        return (_ausleiher == null && (holeNaechstenAusleiher() == ausleiher || holeNaechstenAusleiher() == null));
    }

    /**
     * Prüft ob überhaupt ein Vormerker existiert.
     * 
     * @return der Vormerker (darf auch null sein)
     */
    public Kunde holeNaechstenAusleiher()
    {
        if (_vormerker.size() > 0)
        {
            return _vormerker.get(0);
        }

        return null;
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

    public boolean pruefeObVormerkenMoeglich(Kunde vormerker)
    {
        //assert vormerker != null : "Vorbedingung verletzt: null";
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

    /**
     * gibt den aktuellen Ausleiher zurück.
     * 
     * @return der aktuelle Ausleiher
     */
    public Kunde gibAusleiher()
    {
        return _ausleiher;
    }

    /**
     * gibt den Vormerker an Stelle stelle zurück
     * 
     * @param stelle Stelle an der der Vormerker steht
     * @return der Vormerker an Stelle stelle
     */
    public Kunde gibVormerker(int stelle)
    {
        if (_vormerker.size() > stelle)
        {
            return _vormerker.get(stelle);
        }

        return null;

    }
    
    /**
     * gibt die Anzahl der aktuellen Vormerker zurück.
     * @return Die Anzahl der Vormerker
     */
    public int gibAnzahlVormerker()
    {
        return _vormerker.size();
    }
    
    //   public Medium getMedium()
    //   {
    //      return _medium;
    //  }
}
