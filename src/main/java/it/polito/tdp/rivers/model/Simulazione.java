package it.polito.tdp.rivers.model;

public class Simulazione {

	private int numGiorni;
	private double media;
	/**
	 * @param numGiorni
	 * @param media
	 */
	public Simulazione(int numGiorni, double media) {
		super();
		this.numGiorni = numGiorni;
		this.media = media;
	}
	/**
	 * @return the numGiorni
	 */
	public int getNumGiorni() {
		return numGiorni;
	}
	/**
	 * @param numGiorni the numGiorni to set
	 */
	public void setNumGiorni(int numGiorni) {
		this.numGiorni = numGiorni;
	}
	/**
	 * @return the media
	 */
	public double getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(double media) {
		this.media = media;
	}
	@Override
	public String toString() {
		return "Simulazione [numGiorni=" + numGiorni + ", media=" + media + "]";
	}
	
	
	
}
