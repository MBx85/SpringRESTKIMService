package application;

import java.util.Date;

public class KIM {
	private String kim;
	private String vorname;
	private String nachname;
	private Date geburtstag;

	public KIM() {
	}

	public KIM(String kim) {
		KIM TempKimObject = KIMDataFileReader.GetKimFromFile(kim);
		this.kim = TempKimObject.getKIM();
		this.vorname = TempKimObject.getVorname();
		this.nachname = TempKimObject.getNachname();
	}

	public void setKim(String value) {
		this.kim = value;
	}

	public void setVorname(String value) {
		this.vorname = value;
	}

	public void setNachname(String value) {
		this.nachname = value;
	}

	public String getKIM() {
		return this.kim;
	}

	public String getNachname() {
		return this.nachname;
	}

	public String getVorname() {
		return this.vorname;
	}
}
