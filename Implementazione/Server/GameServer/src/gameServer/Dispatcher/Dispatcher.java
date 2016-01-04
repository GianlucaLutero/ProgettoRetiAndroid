package gameServer.Dispatcher;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import gameServer.ModelloImplementativo.Utente;
import gameServer.databaseService.DatabaseService;

@WebServlet("/GameServer")
public class Dispatcher extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		DatabaseService dbservice = new DatabaseService();
		
		dbservice.getUtente("test@test.com");
		/*
		JSONObject serviceRequest = (JSONObject)request.getAttribute("");
		JSONArray param = (JSONArray)request.getAttribute("param");
		
		String serviceName = (String)serviceRequest.get("service");
		
		if(serviceName == "login"){
			JSONObject user = (JSONObject)param.get(0);
			JSONObject pass = (JSONObject)param.get(1);
			
			//Viene richiamato l'autentication service
			//Prova
			Utente prova = dbservice.getUtente((String)user.get("user"));
			
			System.out.println(prova.getEmail());
		}
		*/
		
		response.getWriter().println("culo");
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
		
		 doGet(request,response);
	}

}
