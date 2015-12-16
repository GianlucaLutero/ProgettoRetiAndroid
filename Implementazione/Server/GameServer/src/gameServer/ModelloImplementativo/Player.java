package gameServer.ModelloImplementativo;

import gameServer.ModelloInterfaccia.PlayerInterface;
import gameServer.ModelloInterfaccia.PosizioneInterface;

public class Player implements PlayerInterface {
	String nome;
	Integer vita;
	Integer vitalvl;
	PosizioneInterface coordinate;
	Integer exp;
	
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#getNome()
	 */
	@Override
	public String getNome() {
		return nome;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#setNome(java.lang.String)
	 */
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#getVita()
	 */
	@Override
	public Integer getVita() {
		return vita;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#setVita(java.lang.Integer)
	 */
	@Override
	public void setVita(Integer vita) {
		this.vita = vita;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#getVitalvl()
	 */
	@Override
	public Integer getVitalvl() {
		return vitalvl;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#setVitalvl(java.lang.Integer)
	 */
	@Override
	public void setVitalvl(Integer vitalvl) {
		this.vitalvl = vitalvl;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#getCoordinate()
	 */
	@Override
	public PosizioneInterface getCoordinate() {
		return coordinate;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#setCoordinate(ModelloInterfaccia.PosizioneInterface)
	 */
	@Override
	public void setCoordinate(PosizioneInterface coordinate) {
		this.coordinate = coordinate;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#getExp()
	 */
	@Override
	public Integer getExp() {
		return exp;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PlayerInterface#setExp(java.lang.Integer)
	 */
	@Override
	public void setExp(Integer exp) {
		this.exp = exp;
	}
	
	

}
