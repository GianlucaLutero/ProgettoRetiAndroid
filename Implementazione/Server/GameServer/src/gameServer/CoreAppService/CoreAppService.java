package gameServer.CoreAppService;

import java.util.ArrayList;

import gameServer.ModelloImplementativo.Classe;
import gameServer.ModelloImplementativo.Livello;
import gameServer.ModelloImplementativo.Player;
import gameServer.databaseService.DatabaseService;

public class CoreAppService {

     private ArrayList<Player> activePlayer;
     
     
     public CoreAppService(){
    	 activePlayer = new ArrayList<>();
     }
     
     
     /**
      * Aggiunge un player alla lista dei player attivi
      * */
     public boolean setActivePlayer(Player p,DatabaseService db){
    	 Player active = new Player();

    	 try{
    		 Classe cl = db.getClass(p.getClasse());
    		 Livello lv = db.getLivello(p.getLv());

    		 active.setNome(p.getNome());
    		 active.setClasse(cl.getNome());
    		 active.setExp(p.getExp());
    		 active.setAttacco((int)(cl.getIndAttacco()*lv.getAttacco()));
    		 active.setDifesa((int)(cl.getIndDifesa()*lv.getDifesa()));
    		 active.setVita((int)(cl.getIndxVita()*lv.getVita()));
    		 active.setCoordinate(p.getCoordinate());

    	 }catch(Throwable t){
    		 t.printStackTrace();
    		 return false;
    	 }

    	 activePlayer.add(active);
    	 System.out.println("Player attivo nome : "+active.getNome());
    	 System.out.println("Classe : "+active.getClasse());
    	 System.out.println("Exp : "+active.getExp());
    	 System.out.println("Attacco : "+active.getAttacco());
    	 System.out.println("Difesa : "+active.getDifesa());
    	 System.out.println("Vita : "+active.getVita());
    	 System.out.println("Coordinate : "+active.getCoordinate().getLat()+","+active.getCoordinate().getLon());
    	 return true;
     }
     
     /**
      * Rimuove un player dal gioco
      * */
     public boolean removePlayer(String nome){
    	 
    	 for(Player p:activePlayer){
    		 
    		 if(p.getNome().equals(nome)){
    			 activePlayer.remove(p);
    			 System.out.println("Player rimosso:"+p.getNome());
    		 }
    		 
    	 }
    	 
    	 return true;
     }
     
     /**
      * Ritorna la lista dei player
      * */
     public ArrayList<Player> getActivePlayer(){
    	 return activePlayer;
     }
     
	
}
