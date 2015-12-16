package gameServer.ModelloImplementativo;

import gameServer.ModelloInterfaccia.LivelloInterface;

public class Livello implements LivelloInterface {
	Integer numero;
	Integer vita;
	Integer attacco;
	Integer difesa;
	Integer expMax;
	
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#getNumero()
	 */
	@Override
	public Integer getNumero() {
		return numero;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#setNumero(java.lang.Integer)
	 */
	@Override
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#getVita()
	 */
	@Override
	public Integer getVita() {
		return vita;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#setVita(java.lang.Integer)
	 */
	@Override
	public void setVita(Integer vita) {
		this.vita = vita;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#getAttacco()
	 */
	@Override
	public Integer getAttacco() {
		return attacco;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#setAttacco(java.lang.Integer)
	 */
	@Override
	public void setAttacco(Integer attacco) {
		this.attacco = attacco;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#getDifesa()
	 */
	@Override
	public Integer getDifesa() {
		return difesa;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#setDifesa(java.lang.Integer)
	 */
	@Override
	public void setDifesa(Integer difesa) {
		this.difesa = difesa;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#getExpMax()
	 */
	@Override
	public Integer getExpMax() {
		return expMax;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.LivelloInterface#setExpMax(java.lang.Integer)
	 */
	@Override
	public void setExpMax(Integer expMax) {
		this.expMax = expMax;
	}

}
