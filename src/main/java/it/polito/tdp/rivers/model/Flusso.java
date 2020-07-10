package it.polito.tdp.rivers.model;

import java.time.LocalDate;

public class Flusso implements Comparable<Flusso>{
	
	private int id;
	private LocalDate data;
	private double qty;

	/**
	 * @param id
	 * @param data
	 * @param qty
	 * @param idRiver
	 */
	public Flusso(int id, LocalDate data, double qty) {
		super();
		this.id = id;
		this.data = data;
		this.qty = qty;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the data
	 */
	public LocalDate getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(LocalDate data) {
		this.data = data;
	}
	/**
	 * @return the qty
	 */
	public double getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(double qty) {
		this.qty = qty;
	}

	@Override
	public int compareTo(Flusso o) {
		return this.data.compareTo(o.data);
	}
	
	

}
