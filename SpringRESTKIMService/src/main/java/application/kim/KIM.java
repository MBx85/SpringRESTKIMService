package application.kim;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class KIM {
	private String kim;
	private String vorname;
	private String nachname;
	private Date geburtstag;
	private Date saveDate; // (UpdateDateTime)
	private String email;
	private String company;
	
	
	public KIM() {
	}

	public KIM(String kim) {
		this.kim = kim;
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
