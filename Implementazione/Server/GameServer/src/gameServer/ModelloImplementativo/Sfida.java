package gameServer.ModelloImplementativo;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import gameServer.ModelloInterfaccia.PlayerInterface;
import gameServer.ModelloInterfaccia.SfidaInterface;
// DA VEDERE BENE IL SETTAGGIO DELLA DATA
public class Sfida implements SfidaInterface {
	PlayerInterface P1;
	PlayerInterface P2;
	String dataTime;
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
	public String getDataTime(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.SfidaInterface#getWinner()
	 */
	@Override
	public void setDataTime(String data)
	{
		dataTime = data;
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
