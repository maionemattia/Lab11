package it.polito.tdp.rivers.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.db.RiversDAO;

public class Model {
	
	private List<River> listaRiver;
	private List<Lettura> letture;
	private RiversDAO dao;
	Simulator sim;
	
	
	public Model(){
		this.listaRiver = new ArrayList<>();
		this.letture = new ArrayList<>();
		this.dao = new RiversDAO();
		dao.getAllRivers(listaRiver);
		for(River r : listaRiver)
			dao.getFlow(r);
		
	}
	
	public List<River> getNomiFiumi(){
		return listaRiver;
	}
	
	public Lettura getLettura(River river) {
		return dao.getFinalInfoRiver(letture,river);
	}
	
	public LocalDate getStartDate(River river) {
		if(!river.getFlussi().isEmpty())
			return river.getFlussi().get(0).getData();
		return null;
	}
	
	public LocalDate getEndDate(River river) {
		if(!river.getFlussi().isEmpty())
			return river.getFlussi().get(river.getFlussi().size()-1).getData();
		return null;
	}
	
	public int getNumMisurazioni(River river) {
		return river.getFlussi().size();
	}
	
	public double getMedia(River river) {
		double avg = 0.0;
		for(Flusso f : river.getFlussi())
			avg += f.getQty();
		avg /= river.getFlussi().size();
		river.setMediaFlussi(avg);
		return avg;
	}
	
	public void Simulazione(River r, double k) {
		sim = new Simulator();
		sim.init(r, k);
		sim.run();
		
	}
	
	public Simulazione getSim() {
		if(sim.getSim()!=null) {
			return sim.getSim();
		}else {
			System.out.println("Simulazione non avvenuta");
			return null;
		}
	}

}
