package model;

public class mia_DTO {

	   private String id ;
	   private String location ;
	   private String time ;
	   private String date ;
	   private String info ;
	   private String photo ;
	   private String upload_date ;
	   private String condition ;
	   
	   public mia_DTO(String id, String location, String time, String date, String info, String photo, String upload_date,
	         String condition) {
	      super();
	      this.id = id;
	      this.location = location;
	      this.time = time;
	      this.date = date;
	      this.info = info;
	      this.photo = photo;
	      this.upload_date = upload_date;
	      this.condition = condition;
	   }

	   public String getId() {
	      return id;
	   }

	   public String getLocation() {
	      return location;
	   }

	   public String getTime() {
	      return time;
	   }

	   public String getDate() {
	      return date;
	   }

	   public String getInfo() {
	      return info;
	   }

	   public String getPhoto() {
	      return photo;
	   }

	   public String getUpload_date() {
	      return upload_date;
	   }

	   public String getCondition() {
	      return condition;
	   }
	   
	   
	}
