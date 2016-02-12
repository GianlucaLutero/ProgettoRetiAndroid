package gameServer.Dispatcher;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import gameServer.AuthenticationService.AuthenticationService;
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
		//dbservice.getUtente("test@test.com");
		/*
		String email = (String)request.getParameter("email");
		String password =(String)request.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);
		*/
		
		String service = (String)request.getParameter("service");
		
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
				response.getWriter().println("Errore login");
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
		default:
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
