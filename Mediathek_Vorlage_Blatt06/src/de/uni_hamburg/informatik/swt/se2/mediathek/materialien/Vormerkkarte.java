package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * @author Aurora
 *
 */
public class Vormerkkarte {
	private Kunde _ausleiher;
	private List<Kunde> _vormerker;
	private final Medium _medium;

	public Vormerkkarte(Kunde ausleiher, Medium medium) {
		_ausleiher = ausleiher;
		_vormerker = new LinkedList<Kunde>();
		_medium = medium;
	}

	public void fuegeVormerkerHinzu(Kunde vormerker) {
		if (_vormerker.size() < 3) {
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
	public boolean pruefeObAusleihenMoeglich(Kunde ausleiher) {
		return (_ausleiher == null && (_vormerker.get(0) == ausleiher || _vormerker.get(0) == null));
	}

	public void entferneVormerker(Kunde vormerker) {
		if (_vormerker.contains(vormerker)) {
			_vormerker.remove(_vormerker.indexOf(vormerker));
		}
	}
	
	public void wurdeZurueckgegeben()
	{
		_ausleiher = null;
	}
	
	public Medium getMedium()
	{
		return _medium;
	}
}
