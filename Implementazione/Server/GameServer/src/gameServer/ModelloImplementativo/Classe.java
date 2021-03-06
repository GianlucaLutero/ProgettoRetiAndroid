package gameServer.ModelloImplementativo;

import gameServer.ModelloInterfaccia.ClasseInterface;

public class Classe implements ClasseInterface {
	String nome;
	Float indxVita;
	Float IndAttacco;
	Float IndDifesa;
	
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#getNome()
	 */
	@Override
	public String getNome() {
		return nome;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#setNome(java.lang.String)
	 */
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#getIndxVita()
	 */
	@Override
	public Float getIndxVita() {
		return indxVita;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#setIndxVita(java.lang.Float)
	 */
	@Override
	public void setIndxVita(Float indxVita) {
		this.indxVita = indxVita;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#getIndAttacco()
	 */
	@Override
	public Float getIndAttacco() {
		return IndAttacco;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#setIndAttacco(java.lang.Float)
	 */
	@Override
	public void setIndAttacco(Float indAttacco) {
		IndAttacco = indAttacco;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#getIndDifesa()
	 */
	@Override
	public Float getIndDifesa() {
		return IndDifesa;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.ClasseInterface#setIndDifesa(java.lang.Float)
	 */
	@Override
	public void setIndDifesa(Float indDifesa) {
		IndDifesa = indDifesa;
	}

}
