package gameServer.AuthenticationService;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gameServer.ModelloImplementativo.Utente;
import gameServer.databaseService.DatabaseService;

public class AuthenticationService {
 /**
  * Classe che gestisce l'autenticazione dell'utente
  * 
  * */
	//private static ArrayList<Utente> utentiAttivi;
	private static Map<String,String> utentiAttivi;
	private static SecureRandom random;
	
	public AuthenticationService(){
		utentiAttivi = new HashMap<String,String>();
		random = new SecureRandom();
	}
	
	/**
	 * Esegue il login di un utente
	 * 
	 * @param DatabaseService db
	 * @param String email
	 * @param String password
	 * 
	 * @return true se il login è avvenuto con successo
	 *          false altrimenti
	 * 
	 * */
	public boolean logIn(DatabaseService db,String email,String password){
		
	    if(db.loginUtente(email, password)){
	    	Utente tmp = new Utente();
	    	tmp.setEmail(email);
	    	utentiAttivi.put(tmp.getEmail(), nextSessionId());
	    	//utentiAttivi.add();
	    	//Creo chiave sessione
	        System.out.println(tmp.getEmail()+" , "+utentiAttivi.get(tmp.getEmail()));
	       
	    	return true;
	    }
		
		return false;
	}
	
	/***
	 * Esegue il log out dell'utente
	 * 
	 * @param DatabaseService db
	 * @param String email
	 * 
	 * @return true se il logout è avvenuto con successo
	 *          false altrimenti
	 */
	public boolean logOut(DatabaseService db,String email){
		Utente tmp = db.getUtente(email);

		if(utentiAttivi.get(tmp.getEmail()) != null){
			utentiAttivi.remove(tmp.getEmail());
			return true;
		}

		return false;
	}
	
	private String nextSessionId(){
		return new BigInteger(130, random).toString();
	}
	
	/**
	 * Ritorna il session id di un utente
	 * 
	 * @param Utente u
	 * 
	 * @return sessionId
	 * */
	public static String getSessionId(Utente u){
		
		System.out.println("Utente attivo: "+u.getEmail());
		System.out.println("SessionID: "+utentiAttivi.get(u.getEmail()));
		
		return utentiAttivi.get(u.getEmail());
	}
	
	public static void stampaUtenti(){
		
		for(Map.Entry<String, String> entry: utentiAttivi.entrySet()){
			System.out.println(entry.getKey()+","+entry.getValue());
		}
		
	}
}
