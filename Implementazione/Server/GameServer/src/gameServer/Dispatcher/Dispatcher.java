package gameServer.Dispatcher;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
