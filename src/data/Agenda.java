package data;

public class Agenda {
	
	private String id,title,time,address;
	private boolean is_selected;
	private boolean is_title;
	
	public boolean isIs_title() {
		return is_title;
	}

	public void setIs_title(boolean is_title) {
		this.is_title = is_title;
	}

	public Agenda(String id,String title,String time,String address,int is_selected,int is_title){
		//is_selected=0则为假，否则为真，因为数据库中没有boolean类型
		this.id=id;
		this.title=title;
		this.time=time;
		this.address=address;
		if(is_selected==0){
			this.is_selected=false;
		}else{
			this.is_selected=true;
		}
		if(is_title==0){
			this.is_title=false;
		}else{
			this.is_title=true;
		}
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isIs_selected() {
		return is_selected;
	}
	public void setIs_selected(boolean is_selected) {
		this.is_selected = is_selected;
	}
}
