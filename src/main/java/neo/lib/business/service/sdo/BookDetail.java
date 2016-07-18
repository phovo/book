package neo.lib.business.service.sdo;


public class BookDetail extends Book {

	private static final long serialVersionUID = 3990868777961599504L;
	
	private String date_create;
	
	private String date_update;

	public String getDate_create() {
		return date_create;
	}

	public void setDate_create(String date_create) {
		this.date_create = date_create;
	}

	public String getDate_update() {
		return date_update;
	}

	public void setDate_update(String date_update) {
		this.date_update = date_update;
	}
}
