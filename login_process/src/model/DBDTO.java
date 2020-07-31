package model;

public class DBDTO {

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String ssnum;
	private String guard;
	private String manager;
	
	public DBDTO() {
		
	}
	
	public void setId(String id) {
		this.id = id;
	}


	public DBDTO(String id, String pw, String name, String phone, String email, String ssnum, String guard,
			String manager) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.ssnum = ssnum;
		this.guard = guard;
		this.manager = manager;
	}
	

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getSsnum() {
		return ssnum;
	}

	public String getGuard() {
		return guard;
	}

	public String getManager() {
		return manager;
	}
	
	
	
}
