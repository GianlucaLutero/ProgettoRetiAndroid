package gameServer.databaseService;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gameServer.ModelloImplementativo.Livello;
import gameServer.ModelloImplementativo.Player;
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
			statement = connection.prepareStatement("SELECT * FROM utenti WHERE email = ?;");
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
	
	/**
	 * Inserisce un nuovo utente nel database 
	 * */
	public boolean insertUtente(String email,String password){
	      
			Connection connection = null;
			PreparedStatement statement = null;
			
			//Criptare password
			
			try{
				connection = databaseConnect();
				statement = connection.prepareStatement("insert into utenti values(?,sha1(?))");
				statement.setString(1,email);
				statement.setString(2,password);
				statement.executeUpdate();
			}catch(SQLException s){
			    databaseDisconnect(connection,statement);
			    s.printStackTrace();
			    return false;
			}
			
			return true;
	}
	
	public boolean loginUtente(String email,String password){
		
		String control = null;
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	    
		try{
			connection = databaseConnect();
			statement = connection.prepareStatement("SELECT * FROM utenti WHERE email = ?;");
			statement.setString(1, email);
			resultSet = statement.executeQuery();
		
			resultSet.next();
			
			control = resultSet.getString("pass");			
			
			System.out.println("DB:"+control);
			System.out.println("USER:"+cripta(password));
			
			if(control.equals(cripta(password))){
				return true;
			}
			
		}catch(SQLException s){
			databaseDisconnect(connection, statement, resultSet);
			s.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	    }	
		
		return false;	
	
	}
	
	public ArrayList<Player> getPlayer(String email){
		Player tmp = null;
		ArrayList<Player> plist = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
	    
		try{
			connection = databaseConnect();
			statement = connection.prepareStatement("SELECT * FROM players WHERE email = ?;");
			statement.setString(1, email);
			resultSet = statement.executeQuery();
		
			while(resultSet.next()){
				tmp = new Player();

				tmp.setNome(resultSet.getString("nome"));
				tmp.setExp(resultSet.getInt("esperienza"));
				tmp.setLv(resultSet.getInt("livello"));
                tmp.setClasse(resultSet.getString("nome_classe"));
				plist.add(tmp);
			}
		}catch(SQLException s){
			databaseDisconnect(connection, statement, resultSet);
			s.printStackTrace();
		}
	
		return plist;
	}
	
	/**
	 * Metodo per criptare stringhe con algoritmo sha-1
	 * 
	 * @param Stringa s da criptare
	 * */
	private String cripta(String s) throws NoSuchAlgorithmException{
		  MessageDigest mess = null;
		    mess = MessageDigest.getInstance("SHA-1");
		    mess.reset();
		    try {
				mess.update(s.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		    
		    byte[] dig = mess.digest();
		    
		    StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < dig.length; i++) {
	          sb.append(Integer.toString((dig[i] & 0xff) + 0x100, 16).substring(1));
	        }
		    
		    System.out.println(sb.toString());
		    
		    return sb.toString();
	}
	

}
