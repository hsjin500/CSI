package model;

public class temp_DTO {
   
   private String id;
   private String ssnum;
   private String guard;
   private String history;
   
   public temp_DTO(String id, String ssnum, String guard, String history) {
      super();
      this.id = id;
      this.ssnum = ssnum;
      this.guard = guard;
      this.history = history;
   }

   public String getId() {
      return id;
   }

   public String getSsnum() {
      return ssnum;
   }

   public String getGuard() {
      return guard;
   }

   public String getHistory() {
      return history;
   }
   

}