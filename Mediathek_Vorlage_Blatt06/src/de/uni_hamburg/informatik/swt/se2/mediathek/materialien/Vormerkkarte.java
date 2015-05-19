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
     * 
     * @param ausleiher
     * 
     * @require ausleiher != null
     */
    public void wurdeAusgeliehen(Kunde ausleiher)
    {
        assert ausleiher != null : "Vorbedingung verletzt: null";
        _ausleiher = ausleiher;
    }

    /**
     * 
     * @param vormerker
     * 
     * @require vormerker != null
     */
    public void fuegeVormerkerHinzu(Kunde vormerker)
    {
        assert vormerker != null : "Vorbedingung verletzt: null";
        if (_vormerker.size() < 3)
        {
            _vormerker.add(vormerker);
        }
    }

    /**
     * 
     * @param ausleiher
     * @return ob Ausleihen moeglich ist
     * 
     * @require ausleiher != null
     */
    public boolean pruefeObAusleihenMoeglich(Kunde ausleiher)
    {
        assert ausleiher != null : "Vorbedingung verletzt: null";
        return (_ausleiher == null && (_vormerker.get(0) == ausleiher || _vormerker.get(0) == null));
    }
    
    /**
     * Neue Methode: Vormerkprüfung
     * 
     * @param ausleiher
     * @return ob Vormerken moeglich ist
     */
    
    public boolean pruefeObVormerkenMoeglich(Kunde ausleiher)
    {
        //ToDo Hier müssen noch die ganzen Vormerkbedingungen verarbeitet werden
        return true;
    }

    /**
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

    public void wurdeZurueckgegeben()
    {
        _ausleiher = null;
    }

 //   public Medium getMedium()
 //   {
  //      return _medium;
  //  }
}
