package it.polito.tdp.rivers.model;

import java.util.List;

public class River {
	
	private int id;
	private String nome;
	private List<Flusso> flussi;
	private double mediaFlussi;
	
	/**
	 * @param id
	 * @param nome
	 */
	public River(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the flussi
	 */
	public List<Flusso> getFlussi() {
		return flussi;
	}
	/**
	 * @param flussi the flussi to set
	 */
	public void setFlussi(List<Flusso> flussi) {
		this.flussi = flussi;
	}
	
	/**
	 * @return the mediaFlussi
	 */
	public double getMediaFlussi() {
		return mediaFlussi;
	}
	/**
	 * @param mediaFlussi the mediaFlussi to set
	 */
	public void setMediaFlussi(double mediaFlussi) {
		this.mediaFlussi = mediaFlussi;
	}
	@Override
	public String toString() {
		return id + " " + nome;
	}
	
	

}
