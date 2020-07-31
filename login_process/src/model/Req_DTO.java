package model;

public class Req_DTO {

	private String id;
	private String locatino;
	private String time;
	private String date;
	private String ask;
	private String upload_date;
	
	public Req_DTO(String id, String locatino, String time, String date, String ask, String upload_date) {
		super();
		this.id = id;
		this.locatino = locatino;
		this.time = time;
		this.date = date;
		this.ask = ask;
		this.upload_date = upload_date;
	}

	public String getId() {
		return id;
	}

	public String getLocatino() {
		return locatino;
	}

	public String getTime() {
		return time;
	}

	public String getDate() {
		return date;
	}

	public String getAsk() {
		return ask;
	}

	public String getUpload_date() {
		return upload_date;
	}
	
	
}
