package gameServer.ModelloImplementativo;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class JSONLivello implements JSONAware{

	private Livello l;
	
	public JSONLivello(Livello lv) {

	     l = new Livello();
	     
	     l.setAttacco(lv.getAttacco());
	     l.setDifesa(lv.getDifesa());
	     l.setExpMax(lv.getExpMax());
	     l.setNumero(lv.getNumero());
	     l.setVita(lv.getVita());
	}
	
	
	/**
	 * Questo metodo converte l'oggetto JSONLivello in una stringa JSON
	 * 
	 * @return Stringa JSON
	 * */
	@Override
	public String toJSONString() {
StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		
		sb.append(JSONObject.escape("attacco"));
        sb.append(":");
        sb.append(JSONObject.escape(l.getAttacco().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("difesa"));
        sb.append(":");
        sb.append(JSONObject.escape(l.getDifesa().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("expMax"));
        sb.append(":");
        sb.append(JSONObject.escape(l.getExpMax().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("numero"));
        sb.append(":");
        sb.append(JSONObject.escape(l.getNumero().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("vita"));
        sb.append(":");
        sb.append(JSONObject.escape(l.getVita().toString()));
        
		sb.append("}");
		
		return sb.toString();
	}

}
