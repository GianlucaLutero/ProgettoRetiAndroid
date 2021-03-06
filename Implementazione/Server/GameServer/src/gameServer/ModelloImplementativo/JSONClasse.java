package gameServer.ModelloImplementativo;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class JSONClasse implements JSONAware{

	private Classe c;
	
	public JSONClasse(Classe a) {
	
		c = new Classe();
		
		c.setIndAttacco(a.getIndAttacco());
		c.setIndDifesa(a.getIndDifesa());
		c.setIndxVita(a.getIndxVita());
		c.setNome(a.getNome());
	}
	
	
	/**
	 * Questo metodo converte l'oggetto JSONClasse in una stringa JSON
	 * 
	 * @return Stringa JSON
	 * */
	@Override
	public String toJSONString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("{");
		
		sb.append(JSONObject.escape("indAttacco"));
        sb.append(":");
        sb.append(JSONObject.escape(c.getIndAttacco().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("indDifesa"));
        sb.append(":");
        sb.append(JSONObject.escape(c.getIndDifesa().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("indVita"));
        sb.append(":");
        sb.append(JSONObject.escape(c.getIndxVita().toString()));
        
        sb.append(",");
        
        sb.append(JSONObject.escape("nome"));
        sb.append(":");
        sb.append(JSONObject.escape(c.getNome()));
        
		sb.append("}");
		
		return sb.toString();
	}

}
