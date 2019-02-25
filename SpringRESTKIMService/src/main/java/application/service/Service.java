package application.service;

public class Service {
	/** Includes all necessary metadata for a REST Service.
	*/
	private String id;
	private String name;
	private String version;
	private String endpoint;
	/*private Scope[] scopes;
	private Fields[] fields;
	private Fields[] queryParameters;
	private User[] users;*/

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	public void setVersion(String value) {
		this.version = value;
	}

	public String getVersion() {
		return this.version;
	}

	public void setEndpoint(String value) {
		this.endpoint = value;
	}

	public String getEndpoint() {
		return this.endpoint;
	}
/*	
	public void setScope(Scope scope) {
		this.scope=scope;
	}*/
}
