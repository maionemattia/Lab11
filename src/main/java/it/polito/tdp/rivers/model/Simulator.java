package it.polito.tdp.rivers.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Simulator {

	private double Q; // Capacità del bacino
	private double C; // Occupazione del bacino
	private double fout_min;
	private double fout;
	private int numGiorniCritici = 0;
	PriorityQueue<Flusso> queue = new PriorityQueue<>();
	List<Double> capacity = new ArrayList<>();

	
	public void init(River river, double fattore) {
		this.Q = fattore * convertM3SecToM3Day(river.getMediaFlussi()) * 30;
		this.C = this.Q / 2;
		fout_min = convertM3DayToM3Sec(0.8*river.getMediaFlussi());
		fout = fout_min;
		queue.addAll(river.getFlussi());
	}


	public void run() {
		
		while(!queue.isEmpty()) {
			Flusso f = queue.poll();
			if(Math.random() > 0.95) {
				fout = 10*fout_min;
			}
			double fin = convertM3SecToM3Day(f.getQty());
			
			if(fin<fout_min) {
				//Non riesco a garantire la quantità minima
				numGiorniCritici++;
				C=0;
			}else {
				//Faccio uscire la quantità giornaliera
				C+=(fin-fout);
			}
			if(C > Q) {
				C = Q;
			}
			capacity.add(C);
		}
		
	}

	private double convertM3SecToM3Day(double mediaFlussi) {
		return mediaFlussi * 60 * 60 * 24;
	}
	
	private double convertM3DayToM3Sec(double mediaFlussi) {
		return mediaFlussi / 60 / 60 / 24;
	}
	
	public Simulazione getSim() {
		double avg2 = 0.0;
		for(Double d : capacity)
			avg2 += d;
		avg2/=capacity.size();
		
		return new Simulazione(numGiorniCritici,avg2);
	}
}
