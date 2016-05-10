package gameServer.ModelloImplementativo;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class JSONPlayer implements JSONAware{

	private Player p;
	
	public JSONPlayer(Player pl){
		p = new Player();
		
		p.setExp(pl.getExp());
		p.setLv(pl.getLv());
		p.setNome(pl.getNome());
		p.setVita(pl.getVita());
		p.setClasse(pl.getClasse());
		p.setCoordinate(pl.getCoordinate());
	}
	
	@Override
	public String toJSONString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		
		sb.append(JSONObject.escape("nome"));
        sb.append(":");
        sb.append("\""+JSONObject.escape(p.getNome())+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("exp"));
        sb.append(":");
        sb.append(JSONObject.escape(p.getExp().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("lv"));
        sb.append(":");
        sb.append(p.getLv());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("classe"));
        sb.append(":");
        sb.append("\""+p.getClasse()+"\"");
        
        sb.append(",");
        
        sb.append(JSONObject.escape("lat"));
        sb.append(":");
        sb.append(p.getCoordinate().getLat());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("lng"));
        sb.append(":");
        sb.append(p.getCoordinate().getLon());
        
        sb.append(",");
        
        sb.append(JSONObject.escape("vita"));
        sb.append(":");
        sb.append(p.getVita());
        
        
		sb.append("}");
		
		return sb.toString();
	}
}
