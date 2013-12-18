package myViews;

import java.io.Serializable;

public class ClassItem implements Serializable{
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
	private static final long serialVersionUID = 1L;
	
	private String title = "";
	private int partId = 0;
	private String partName = "";
	private String author = "";
	private String type = "";
	private boolean ifTop = false;
	
	public ClassItem() {
		super();
	}
	
	public ClassItem(String title,String author,String type, int partId,String partName) {
		super();
		this.title = title;
		this.partId = partId;
		this.author=author;
		this.type=type;
		this.partName = partName;
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