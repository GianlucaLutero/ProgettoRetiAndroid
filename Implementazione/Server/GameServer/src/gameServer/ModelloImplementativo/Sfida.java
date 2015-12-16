package gameServer.ModelloImplementativo;

import java.sql.Time;
import java.util.Date;

import gameServer.ModelloInterfaccia.PlayerInterface;
import gameServer.ModelloInterfaccia.SfidaInterface;
// DA VEDERE BENE IL SETTAGGIO DELLA DATA
public class Sfida implements SfidaInterface {
	PlayerInterface P1;
	PlayerInterface P2;
	Date data;
	Time ora;
	PlayerInterface Winner;
	boolean turno;
	
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#getP1()
	 */
	@Override
	public PlayerInterface getP1() {
		return P1;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#setP1(ModelloInterfaccia.PlayerInterface)
	 */
	@Override
	public void setP1(PlayerInterface p1) {
		P1 = p1;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#getP2()
	 */
	@Override
	public PlayerInterface getP2() {
		return P2;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#setP2(ModelloInterfaccia.PlayerInterface)
	 */
	@Override
	public void setP2(PlayerInterface p2) {
		P2 = p2;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#getData()
	 */
	@Override
	public Date getData() {
		return data;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#setData(java.util.Date)
	 */
	@Override
	public void setData(Date data) {
		this.data = data;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#getOra()
	 */
	@Override
	public Time getOra() {
		return ora;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#setOra(java.sql.Time)
	 */
	@Override
	public void setOra(Time ora) {
		this.ora = ora;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#getWinner()
	 */
	@Override
	public PlayerInterface getWinner() {
		return Winner;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#setWinner(ModelloInterfaccia.PlayerInterface)
	 */
	@Override
	public void setWinner(PlayerInterface winner) {
		Winner = winner;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#isTurno()
	 */
	@Override
	public boolean isTurno() {
		return turno;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#setTurno(boolean)
	 */
	@Override
	public void setTurno(boolean turno) {
		this.turno = turno;
	}

}
