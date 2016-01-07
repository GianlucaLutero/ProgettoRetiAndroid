package gameServer.ModelloImplementativo;

import gameServer.ModelloInterfaccia.UtenteInterface;

public class Utente implements UtenteInterface {
	String email;

	/* (non-Javadoc)
	 * @see ModelloImplementativo.UtenteInterface#getEmail()
	 */
	@Override
	public String getEmail() {
		return email;
	}

	/* (non-Javadoc)
	 * @see ModelloImplementativo.UtenteInterface#setEmail(java.lang.String)
	 */
	@Override
	public void setEmail(String email) {
		this.email = email;
	}

}
