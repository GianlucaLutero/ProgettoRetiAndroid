package gameServer.ModelloImplementativo;

import gameServer.ModelloInterfaccia.PosizioneInterface;

public class Posizione implements PosizioneInterface {
	Double lat;
	Double lon;
	Double alt;
	
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PosizioneInterface#getX()
	 */
	@Override
	public Double getLat() {
		return lat;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PosizioneInterface#setX(java.lang.Float)
	 */
	@Override
	public void setLat(Double lat) {
		this.lat = lat;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PosizioneInterface#getY()
	 */
	@Override
	public Double getLon() {
		return lon;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PosizioneInterface#setY(java.lang.Float)
	 */
	@Override
	public void setLon(Double lon) {
		this.lon = lon;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PosizioneInterface#getZ()
	 */
	@Override
	public Double getAlt() {
		return alt;
	}
	/* (non-Javadoc)
	 * @see ModelloImplementativo.PosizioneInterface#setZ(java.lang.Float)
	 */
	@Override
	public void setAlt(Double alt) {
		this.alt = alt;
	}
	
}
