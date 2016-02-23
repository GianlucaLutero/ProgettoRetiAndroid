package gameServer.Dispatcher;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import gameServer.AuthenticationService.AuthenticationService;
import gameServer.CoreAppService.CoreAppService;
import gameServer.ModelloImplementativo.JSONPlayer;
import gameServer.ModelloImplementativo.Player;
import gameServer.ModelloImplementativo.Posizione;
import gameServer.ModelloImplementativo.Utente;
import gameServer.databaseService.DatabaseService;

@WebServlet("/GameServer")
public class Dispatcher extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DatabaseService dbservice = new DatabaseService();
	private final AuthenticationService aservice = new AuthenticationService();
	private final CoreAppService caservice = new CoreAppService();

	/**
	 *  Gestisce le richieste Http get
	 * 
	 *  Viene interpretata la richiesta e richiamato il rispettivo servizio
	 * 
	 *  @param request: richiesta del client
	 *  @param response: risposta del server
	 * */
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws IOException{

		//TO DO Gestire le richieste del client
		String email;
		String password;
		String nome;
		String classe;
		String playerAtt;
		String playerDef;
		Double lat;
		Double lon;
		
		String service = (String)request.getParameter("service");
		JSONArray players;
		int exp;
		int lv;
		
		System.out.println(service);
		
		switch (service) {
		case "signin":
			/*
			 * parametri: 
			 *        email
			 *        password
			 * */
			boolean signed;
			email = (String)request.getParameter("email");
			password =(String)request.getParameter("password");

			signed = dbservice.insertUtente(email, password);

			if(signed){
				response.getWriter().println("OK");
			}else{
				response.getWriter().println("USER ALREADY REGISTERED");

			}
			System.out.println(service);
			break;

		case "login":
			email = (String)request.getParameter("email");
			password =(String)request.getParameter("password");

			boolean logged = aservice.logIn(dbservice, email, password);

			if(logged){
				Utente u = dbservice.getUtente(email);
				System.out.println(u.getEmail());
				AuthenticationService.stampaUtenti();
				response.getWriter().println(AuthenticationService.getSessionId(u));
			}else{
				response.getWriter().print("Errore login");
			}

			break;
		case "logout":
			email = (String)request.getParameter("email");

			System.out.println("Utenti ancora attivi");
			AuthenticationService.stampaUtenti();
			
			boolean logout = aservice.logOut(dbservice, email);
			if(logout){
				response.getWriter().println("LOGOUT AVVENUTO CON SUCCESSO");
			}else{
				response.getWriter().println("ERRORE LOGOUT");
			}
			break;
		case "create":
			email = (String)request.getParameter("email");
			nome = (String)request.getParameter("nome");
			classe = (String)request.getParameter("classe");
			System.out.println("Nuovo player:"+nome+","+classe+","+email);
			dbservice.insertPlayer(nome, classe, email);
			response.getWriter().println("CREATO");
			
			break;
			
		case "get_players":
			email = (String)request.getParameter("email");
			ArrayList<Player> p = dbservice.getPlayer(email);
			players = new JSONArray();
			
			for(Player pl:p){
			   System.out.println("Trovato player per "+email+" :"+pl.getNome());
			   players.add(new JSONPlayer(pl));
			}
			response.getWriter().println(players.toString() );
			break;

		case "near_player":
			nome = (String)request.getParameter("nome");
			classe = (String)request.getParameter("classe");
		    lat = Double.valueOf(request.getParameter("lat"));
		    lon = Double.valueOf(request.getParameter("lon"));
		    exp = Integer.valueOf(request.getParameter("exp")); 
		    lv = Integer.valueOf(request.getParameter("lv"));
		    Posizione pos = new Posizione();
		    pos.setLat(lat);
		    pos.setLon(lon);
		    
		    Player pl = new Player();
		    pl.setNome(nome);
		    pl.setClasse(classe);
		    pl.setCoordinate(pos);
		    pl.setExp(exp);
		    pl.setLv(lv);
		    
		    caservice.setActivePlayer(pl, dbservice);
		    
		    ArrayList<Player> list = caservice.getActivePlayer();
            players = new JSONArray();
			
			for(Player p1:list){
			   System.out.println("Trovato player per "+nome+" :"+p1.getNome());
			   players.add(new JSONPlayer(p1));
			}
			response.getWriter().println(players.toString() );
			
			break;
		
		case "logout_player":
			nome = (String)request.getParameter("nome");
			
		    boolean logoutPlayer = caservice.removePlayer(nome);
		    
		    if(logoutPlayer){
		    	response.getWriter().println("PLAYER: "+nome+" LOGGED OUT");	
		    }else{
		    	response.getWriter().println("ERRORE LOGOUT PLAYER");
		    }
			break;
			
		case "attack":
			
			playerAtt = (String)request.getParameter("attacker");
			playerDef = (String)request.getParameter("defender");
			
		    caservice.attackPlayer(playerAtt, playerDef, dbservice);
		    
		    ArrayList<Player> updatedPlayer = caservice.getActivePlayer();
			players = new JSONArray();
			
			for(Player p1:updatedPlayer){
				   players.add(new JSONPlayer(p1));
			}
		
			response.getWriter().println(players.toString() );
			break;
			
		default:
			response.getWriter().println("Servizio non disponible o non esistente");
			break;
		}

		
	}
	
	/**
	 * Gestisce le richieste Http post
	 * 
	 * @param request: richiesta del client
	 * @param response: risposta del server
	 * */
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws IOException{

	 	 System.out.println("Richiesta post ricevuta");
		 doGet(request,response);
	}

}
