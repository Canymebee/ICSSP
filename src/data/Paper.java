package data;

public class Paper {
	
	public String getConID() {
		return conID;
	}

	public void setConID(String conID) {
		this.conID = conID;
	}

	public int getIfPrefered() {
		return ifPrefered;
	}

	public void setIfPrefered(int ifPrefered) {
		this.ifPrefered = ifPrefered;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getMarkup() {
		return markup;
	}

	public void setMarkup(String markup) {
		this.markup = markup;
	}
	private static final long serialVersionUID = 1L;
	private String markup = "";
	private String title = "";
	private String author = "";
	private String type = "";
	private String conID = "";
	private int ifPrefered = 0;
	
	
	public Paper() {
		super();
	}
	
	public Paper(String markup,String title,String author,String type, String conID,int ifPrefered) {
		super();
		this.markup=markup;
		this.title = title;
		this.author=author;
		this.type=type;
		this.conID=conID;
		this.ifPrefered=ifPrefered;
	}
	
	
}
