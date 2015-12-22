package gameServer.databaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gameServer.ModelloImplementativo.Livello;
import gameServer.ModelloImplementativo.Skill;
import gameServer.ModelloImplementativo.Utente;

public class DatabaseService extends DatabaseAbstractManager{
	
	/*
	 * TO DO 
	 * 
	 *  -loginUtente
	 *  -logoutUtente
	 *  -checkinPlayer
	 *  -checkoutPlayer
	 *  -getPlayer
	 *  -getSkill
	 * */


	/**
	 * Crea un nuovo Player nel database
	 * 
	 * @param Nome identificativo del Player
	 * @param Nome della classe
	 * @param Utente associato
	 * */
	public void insertPlayer(String nome,String classe,String email){
        
		Connection connection = null;
		PreparedStatement statement = null;
		
		
		try{
			connection = databaseConnect();
			statement = connection.prepareStatement("insert into players values(?,?,?,?,?)");
			statement.setString(1,nome);
			statement.setString(2,classe);
			statement.setInt(3, 1);
			statement.setInt(4, 0);
			statement.setString(5,email);
			statement.executeUpdate();
		}catch(SQLException s){
		    databaseDisconnect(connection,statement);
		    s.printStackTrace();
		}
	}

	/**
	 * Seleziona un Player dal database e aggiorna i suoi campi
	 * 
	 * @param Player
	 * */
	public void updatePlayer(String nome,int exp,int lv){
		Connection connection = null;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
	
		try{
			connection = databaseConnect();
            statement = connection.prepareStatement("update players set esperienza = ? where nome = ?");
            statement2 = connection.prepareStatement("update players set livello = ? where nome = ?");
            statement.setInt(1, exp);
            statement.setString(2, nome);
            statement2.setInt(1, lv);
            statement2.setString(2, nome);
            statement.executeUpdate();
            statement2.executeUpdate();
		}catch(SQLException s){
			databaseDisconnect(connection, statement2);
			s.printStackTrace();
		}
	}
	
	/**
	 * Il metodo restituisce un livello dal database
	 * 
	 * @param Identificativo del livello
	 * @return Livello
	 * */
	public Livello getLivello(int level){
		Livello lv = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	    
		try{
			connection = databaseConnect();
			statement = connection.prepareStatement("SELECT * FROM livelli WHERE numero = ?;");
			statement.setInt(1, level);
			resultSet = statement.executeQuery();
		
			resultSet.next();
			
			lv = new Livello();
			lv.setNumero(level);
			lv.setAttacco(resultSet.getInt("attacco"));
			lv.setDifesa(resultSet.getInt("difesa"));
			lv.setVita(resultSet.getInt("vita"));
			lv.setExpMax(resultSet.getInt("max_xp"));
		}catch(SQLException s){
			databaseDisconnect(connection, statement, resultSet);
			s.printStackTrace();
		}
		
		return lv;
	}
	
	/**
	 * Il metodo restituisce una skill dal database
	 * 
	 * @param Nome della skill
	 * @return Skill
	 * */
	public Skill getSkill(String nome){
		Skill tmp = null;
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	    
		try{
			connection = databaseConnect();
			statement = connection.prepareStatement("SELECT * FROM skills WHERE nome = ?;");
			statement.setString(1, nome);
			resultSet = statement.executeQuery();
		
			resultSet.next();
			
			tmp = new Skill();
			
		}catch(SQLException s){
			databaseDisconnect(connection, statement, resultSet);
			s.printStackTrace();
		}
	
		return tmp;
	}
	
	

	/**
	 * Il metodo restituisce un utente dal database
	 * 
	 * @param Nome dell'utente
	 * @return Utente
	 * */
	public Utente getUtente(String nome){
		Utente tmp = null;
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	    
		try{
			connection = databaseConnect();
			statement = connection.prepareStatement("SELECT * FROM utente WHERE email = ?;");
			statement.setString(1, nome);
			resultSet = statement.executeQuery();
		
			resultSet.next();
			
			tmp = new Utente();
			
			tmp.setEmail(nome);
			
		}catch(SQLException s){
			databaseDisconnect(connection, statement, resultSet);
			s.printStackTrace();
		}
	
		return tmp;
	}

}
