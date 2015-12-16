package gameServer.ModelloInterfaccia;

import java.sql.Time;
import java.util.Date;

public interface SfidaInterface {

	PlayerInterface getP1();

	void setP1(PlayerInterface p1);

	PlayerInterface getP2();

	void setP2(PlayerInterface p2);

	Date getData();

	void setData(Date data);

	Time getOra();

	void setOra(Time ora);

	PlayerInterface getWinner();

	void setWinner(PlayerInterface winner);

	boolean isTurno();

	void setTurno(boolean turno);

}