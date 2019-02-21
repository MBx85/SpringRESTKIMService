package application.department;

public class Department {
	private String deptid;
	private String skz;
	private String kurzbez;

	public void setDeptID(String deptid) {
		this.deptid = deptid;
	}
	
	public String getDeptID() {
		return deptid;
	}
	
	public void setSkz(String skz) {
		this.skz = skz;
	}
	
	public String getSkz() {
		return skz;
	}
	
	public void setKurzbez(String value) {
		this.kurzbez = value;
	}
	
	public String getKurzbez() {
		return kurzbez;
	}
	
}
