package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;

public class VormerkkarteTest
{
    private Kunde _ausleiher;
    private Kunde _vormerker1;
    private Kunde _vormerker2;
    private Kunde _vormerker3;
    private Kunde _vormerker4;
    //private List<Kunde> _vormerker;
    private Vormerkkarte _karte;

    /**
     * Testklasse für Vormerkkarte
     */
    public VormerkkarteTest()
    {
        _ausleiher = new Kunde(new Kundennummer(123456), "ich", "du");
        _vormerker1 = new Kunde(new Kundennummer(234567), "er", "sie");
        _vormerker2 = new Kunde(new Kundennummer(345678), "wir", "ihr");
        _vormerker3 = new Kunde(new Kundennummer(456789), "es", "iss");
        _vormerker4 = new Kunde(new Kundennummer(567890), "Testi", "Testmann");
        //_vormerker = new LinkedList<Kunde>();
        _karte = new Vormerkkarte(null);

    }

    /**
     * Prüft ob der Ausleiher in die Vormerkkarte eingetragen wird.
     */
    @Test
    public void leiheAusTest()
    {
        _karte.leiheAus(_ausleiher);
        assertEquals(_ausleiher, _karte.gibAusleiher());
    }

    /**
     * Prüft ob die Vormerker an den richtigen Positionen stehen
     */
    @Test
    public void fuegeVormerkerAnPositionHinzuTest()
    {
        _karte.fuegeVormerkerHinzu(_vormerker1);
        _karte.fuegeVormerkerHinzu(_vormerker2);
        _karte.fuegeVormerkerHinzu(_vormerker3);
        assertEquals(_vormerker1, _karte.gibVormerker(0));
        assertEquals(_vormerker2, _karte.gibVormerker(1));
        assertEquals(_vormerker3, _karte.gibVormerker(2));
    }

    /**
     * Prüft ob nur drei Vormerker aufgenommen werden
     */
    @Test
    public void nurDreiKoennenVormerkenTest()
    {
        _karte.fuegeVormerkerHinzu(_vormerker1);
        _karte.fuegeVormerkerHinzu(_vormerker2);
        _karte.fuegeVormerkerHinzu(_vormerker3);
        _karte.fuegeVormerkerHinzu(_vormerker4);
        assertEquals(3, _karte.gibAnzahlVormerker());
        assertEquals(_vormerker3, _karte.gibVormerker(2));

    }

    /**
     * CAPSLOCK = AUTOPILOT FÜR COOL
     */
    @Test
    public void eineKrasseTestklasseTest() // := Klasse
    {

    }

    /**
     * Prüft ob der Vormerker stimmt
     */
    @Test
    public void pruefeObVormerkenMoeglichTest()
    {
        _karte.fuegeVormerkerHinzu(_vormerker1);
        assertFalse(_karte.pruefeObVormerkenMoeglich(_vormerker1));
        assertTrue(_karte.pruefeObVormerkenMoeglich(_vormerker2));
    }

    /**
     * Prüft ob Vormerker auch entfernt werden können
     */
    @Test
    public void entferneVormerkerTest()
    {
        _karte.fuegeVormerkerHinzu(_vormerker1);
        _karte.entferneVormerker(_vormerker1);
        assertEquals(0, _karte.gibAnzahlVormerker());
    }

    /**
     * Prüft ob man nur einmal vormerken kann
     */
    @Test
    public void duKannstNurEinmalVormerkenTest()
    {
        _karte.fuegeVormerkerHinzu(_vormerker1);
        _karte.fuegeVormerkerHinzu(_vormerker1);
        assertEquals(1, _karte.gibAnzahlVormerker());
    }

    /**
     * Prüft ob der Ausleiher vormerken kann
     */
    @Test
    public void ausleiherKannNichtVormerkenTest()
    {
        _karte.leiheAus(_ausleiher);
        _karte.fuegeVormerkerHinzu(_ausleiher);
        assertEquals(0, _karte.gibAnzahlVormerker());
    }

}
