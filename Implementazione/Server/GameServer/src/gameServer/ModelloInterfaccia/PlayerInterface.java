package gameServer.ModelloInterfaccia;

public interface PlayerInterface {

	String getNome();

	void setNome(String nome);

	Integer getVita();

	void setVita(Integer vita);

	Integer getVitalvl();

	void setVitalvl(Integer vitalvl);

	PosizioneInterface getCoordinate();

	void setCoordinate(PosizioneInterface coordinate);

	Integer getExp();

	void setExp(Integer exp);

}