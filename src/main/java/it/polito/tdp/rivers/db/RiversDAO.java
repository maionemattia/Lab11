package it.polito.tdp.rivers.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.rivers.model.Flusso;
import it.polito.tdp.rivers.model.Lettura;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public void getAllRivers(List<River> listaRiver) {
		
		final String sql = "SELECT id, name FROM river";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				listaRiver.add(new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
	}
	
public void getFlow(River river) {
	
		List<Flusso> flussi = new ArrayList<>();
		
		final String sql = "SELECT id, day, flow " + 
				"FROM flow " + 
				"WHERE river = ?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());
			ResultSet res = st.executeQuery();

			while (res.next()) {
				flussi.add(new Flusso(res.getInt("id"),res.getDate("day").toLocalDate(),res.getDouble("flow")));
			}

			conn.close();
			Collections.sort(flussi);
			river.setFlussi(flussi);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
	}
	
public Lettura getFinalInfoRiver(List<Lettura> letture, River river) {
		
		final String sql = "SELECT river, MIN(day) as min, MAX(day) as max, AVG(flow) AS avg, COUNT(*) AS n " + 
				"FROM flow " + 
				"WHERE river = ?";

		Lettura lettura = null;
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, river.getId());
			ResultSet res = st.executeQuery();

			res.next();
			lettura = new Lettura(res.getDate("min").toLocalDate(),res.getDate("max").toLocalDate(),res.getDouble("avg"),res.getInt("n"));
			letture.add(lettura);

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
		return lettura;
	}
}
