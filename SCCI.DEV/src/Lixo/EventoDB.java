package Lixo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import ConexaoDB.ConexaoDB;
import DTO.EventoDTO;

import java.sql.Connection;

public class EventoDB {
	
	Connection con;
	
	public ResultSet registodeEventos(EventoDTO objeventoDTO) {
		con = new ConexaoDB().conectaBD();
		
		try {
					
			String sql = "insert into eventos(tema_evento,local_evento,nome_palestrante,numMax_participantes,tipo_evento,data_evento,descricao_evento) values(?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, objeventoDTO.getTemaEvento());
			ps.setString(2, objeventoDTO.getLocalEvento());
			ps.setString(3, objeventoDTO.getNomePalestrante());
			ps.setLong(4, objeventoDTO.getNumMaxParticipante());
			ps.setString(5, objeventoDTO.getTipoEvento());
			ps.setString(6, objeventoDTO.getDataEvento());
			ps.setString(6, objeventoDTO.getDescricaoEvento());
			
			ResultSet rs = ps.executeQuery();
			return rs;
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "EventoDB: " + erro);
			return null;
		}
		
		
	}

}
