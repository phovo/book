package neo.lib.business.service.sdo;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = -2184177271147541912L;

	private String id;
	
	private String title;
	
	private String author;
	
	private String description;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
