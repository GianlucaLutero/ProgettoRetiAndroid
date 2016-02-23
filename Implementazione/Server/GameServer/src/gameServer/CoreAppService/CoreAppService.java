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
    		 active.setLv(lv.getNumero());
    		 active.setExp(p.getExp());
    		 active.setAttacco((int)(cl.getIndAttacco()*lv.getAttacco()));
    		 active.setDifesa((int)(cl.getIndDifesa()*lv.getDifesa()));
    		 active.setVita((int)(cl.getIndxVita()*lv.getVita()));
    		 active.setCoordinate(p.getCoordinate());

    	 }catch(Throwable t){
    		 t.printStackTrace();
    		 return false;
    	 }


    	 removePlayer(active.getNome());
    	 activePlayer.add(active);

    	 System.out.println("Player attivo nome : "+active.getNome());
    	 System.out.println("Classe : "+active.getClasse());
    	 System.out.println("Lv : "+active.getLv());
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
    			 return true;
    		 }
    		 
    	 }
    	 
    	 return false;
     }
     
     /**
      * Ritorna la lista dei player
      * */
     public ArrayList<Player> getActivePlayer(){
    	 return activePlayer;
     }
     
     
     /**
      * Esegue l'attacco su un player
      * */
     public void attackPlayer(String attack,String defend, DatabaseService db){
    	 Player attacker = new Player();
    	 Player defender = new Player();
    	 
    	 System.out.println("Inizio battaglia tra "+attack+" e "+defend);
    	 
    	 for(Player tmp:activePlayer){
    		 
    		 if(tmp.getNome().equals(attack)){
    			 attacker = tmp;
    		 }else{
    			 if(tmp.getNome().equals(defend)){
    				 defender = tmp;
    			 }
    		 }
    		 
    	 }
    	 
    	 
    	 int damage = attacker.getAttacco() - defender.getDifesa();
    	 
    	 if(damage <= 0){
    		 damage = 0;
    	 }
    	 
    	 if(defender.getVita() <= damage){
    		 removePlayer(defender.getNome());
    		 removePlayer(attacker.getNome());
    		 attacker.setExp(attacker.getExp() + 5);
             activePlayer.add(attacker);
             levelUp(attacker.getNome(), db);
             
             System.out.println(attack + " wins..... Fatality");
             
             db.updatePlayer(attacker.getNome(), attacker.getExp(), attacker.getLv());
             
    	 }else{
    		 removePlayer(defender.getNome());
    		 defender.setVita(defender.getVita()-damage);
    		 activePlayer.add(defender);
    		 System.out.println(attack + " esegue un attacco");
    		 System.out.println("Danno inflitto " + damage);
    		 System.out.println("Vita rimanente "+defender.getVita());
    	 }
    	 
    	 
     }
     
     public boolean levelUp(String nome, DatabaseService db){
       
    	 for(Player tmp:activePlayer){
    		 
    		 if(tmp.getNome().equals(nome)){
    			 Livello lv = db.getLivello(tmp.getLv());
    			 
                 if(tmp.getExp() >= lv.getExpMax()){
                	 tmp.setExp(tmp.getExp()-lv.getExpMax());
                	 if(tmp.getLv()< 5){
                	   tmp.setLv(lv.getNumero() + 1);
                	   System.out.println(nome + " level up");
                	 }
                	 return true;
                 }
    			 
    		 }
    		 
    	 }
    	 
    	 return false;
     }
	
}
