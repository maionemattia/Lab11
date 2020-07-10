package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Lettura {
	
	private LocalDate prima;
	private LocalDate ultima;
	private double media;
	private int numMisure;
	
	/**
	 * @param date
	 * @param date2
	 * @param media
	 * @param numMisure
	 */
	public Lettura(LocalDate date, LocalDate date2, double media, int numMisure) {
		super();
		this.prima = date;
		this.ultima = date2;
		this.media = media;
		this.numMisure = numMisure;
	}
	/**
	 * @return the prima
	 */
	public LocalDate getPrima() {
		return prima;
	}
	/**
	 * @param prima the prima to set
	 */
	public void setPrima(LocalDate prima) {
		this.prima = prima;
	}
	/**
	 * @return the ultima
	 */
	public LocalDate getUltima() {
		return ultima;
	}
	/**
	 * @param ultima the ultima to set
	 */
	public void setUltima(LocalDate ultima) {
		this.ultima = ultima;
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
	/**
	 * @return the numMisure
	 */
	public int getNumMisure() {
		return numMisure;
	}
	/**
	 * @param numMisure the numMisure to set
	 */
	public void setNumMisure(int numMisure) {
		this.numMisure = numMisure;
	}
	
	

}
