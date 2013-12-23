package data;

public class Paper {
	
	private String id,title,author;	
	private boolean is_selected;
	
	public Paper(String id,String title,String author,int is_selected){
		//is_selected=0则为假，否则为真，因为数据库中没有boolean类型
		this.id=id;
		this.title=title;
		this.author=author;
		if(is_selected==0){
			this.is_selected=false;
		}else
			this.is_selected=true;
	}
	
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

	public boolean isIs_selected() {
		return is_selected;
	}

	public void setIs_selected(boolean is_selected) {
		this.is_selected = is_selected;
	}

	
}
