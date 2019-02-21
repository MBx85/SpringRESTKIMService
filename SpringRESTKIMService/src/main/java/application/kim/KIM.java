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
	private String userId;
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
	
	public void setGeburtstag(Date value) {
		this.geburtstag = value;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public void setUserId(String value) {
		this.userId = value;
	}
	
	public void setCompany (String value) {
		this.company = value;
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
	
	public Date getGeburtstag() {
		return this.geburtstag;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public String getCompany () {
		return this.company;
	}
	
	public String InitEmail() {
		if(this.email == null || this.email.equals("")) {
			return this.vorname + "."+ this.nachname + "@firma.com";
		}
		else return this.email;
	}
	
	public String InitUserId() {
		
		if(this.userId == null || this.userId.equals("")) {
			return this.vorname.substring(0, 3).toUpperCase() + this.nachname.substring(0, 3).toUpperCase();
		}
		else return this.userId;
	}
}
