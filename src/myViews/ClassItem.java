package myViews;

import java.io.Serializable;

public class ClassItem implements Serializable{
	public String getConID() {
		return conID;
	}

	public void setConID(String conID) {
		this.conID = conID;
	}

	public boolean isIfPrefered() {
		return ifPrefered;
	}

	public void setIfPrefered(boolean ifPrefered) {
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
	private int partId = 0;
	private String partName = "";
	private boolean ifPrefered = false;
	private boolean ifTop = false;
	
	public ClassItem() {
		super();
	}
	
	public ClassItem(String markup,String title,String author,String type,String conID, int partId,String partName,boolean ifPrefered) {
		super();
		this.markup=markup;
		this.title = title;
		this.partId = partId;
		this.author=author;
		this.type=type;
		this.conID=conID;
		this.partName = partName;
		this.ifPrefered=ifPrefered;
	}
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public void setIfTop(boolean iftop){
		this.ifTop=iftop;
	}
	public boolean getIfTop(){
		return ifTop;
	}
	@Override
	public String toString() {
		return "ifTop:::" + ifTop + ":::title:::" + title + ":::partName:::" + partName;
	}
}
