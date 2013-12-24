package data;

/*
这个类是数据库类，用于提供表的各种操作，包括增删改
作者：jzy
更新时间：2013.08.05
*/

import java.util.ArrayList;
import java.util.List;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TableManager {
	
	private Context context;
	private DataBaseHelper mDbHelper = null;  
    private SQLiteDatabase mDb = null; 
    
    
    public TableManager(Context context){
    	this.context=context;
    	mDbHelper=DataBaseHelper.getInstance(this.context);
    	mDb=mDbHelper.getWritableDatabase();
    }
    
    //创建表
    public void createPaperTable(){
    	if(!tabIsExist("paper")){
    		String NAME_TABLE_CREATE = "create table paper("  
    		        + "id VARCHAR(255) PRIMARY KEY," + "title VARCHAR(255) ,"+"author VARCHAR(255),"+"type VARCHAR(255),"+"conID VARCHAR(255),"+"is_selected VARCHAR(255));";  
    	 mDb.execSQL(NAME_TABLE_CREATE);
    	Paper item1 = new Paper("SD-1","The Challenges of Emerging Software Eco-Systems (Keynote) ","Neil G. Siegel","Keynotes","1",0);
 		Paper item2 = new Paper("SD-2","Low Ceremony Processes for Short Lifecycle Projects (Keynote) ","Anthony I. Wasserman","Keynotes","1",0);
 		Paper item3 = new Paper("SD-3","How to Treat Timing Information for Software Effort Estimation? ","Masateru Tsunoda, Sousuke Amasaki, and Chris Lokan","Estimation","1",0);
 		Paper item4 = new Paper("SD-4"," qEstimation: A Process for Estimating Size and Effort of Software Testing ","Vu Nguyen, Vu Pham, and Vu Lam","Estimation","1",0);
 		Paper item5 = new Paper("SD-5","A Model for Estimating Agile Project Process and Schedule Acceleration ","Dan Ingold, Barry Boehm, and Supannika Koolmanojwong","Estimation","1",0);
 		Paper item6 = new Paper("SD-6"," A Discipline-Spanning Development Process for Self-Adaptive Mechatronic Systems ","Christian Heinzemann, Oliver Sudmann, Wilhelm Schäfer, and Matthias Tichy","Software Process I","1",0);
 		Paper item7 = new Paper("SD-7","A Process Practice to Validate the Quality of Reused Component Documentation: A Case Study Involving Open-Source Components ","Olivier Gendreau and Pierre N. Robillard","Quality and Indicators","1",0);
 		Paper item8 = new Paper("SD-8","A Methodology to Derive Sustainability Indicators for Software Development Projects ","Giuseppe Lami, Fabrizio Fabbrini, and Mario Fusani","Quality and Indicators","1",0);
 		this.insertPaper(item1);
 		this.insertPaper(item2);
 		this.insertPaper(item3);
 		this.insertPaper(item4);
 		this.insertPaper(item5);
 		this.insertPaper(item6);
 		this.insertPaper(item7);
 		this.insertPaper(item8);
    	} 	 
    }
    
    public void createAgendaTable(){
    	if(!tabIsExist("agenda")){
    		String NAME_TABLE_CREATE = "create table agenda("  
    		        + "id VARCHAR(255) PRIMARY KEY," + "title VARCHAR(255) ,"+"time VARCHAR(255),"+"address VARCHAR(255),"+"is_selected VARCHAR(255),"+"is_title VARCHAR(255));";  
    	 mDb.execSQL(NAME_TABLE_CREATE);
    	 Agenda a=new Agenda("1","Monday,11th November","title","title",0,1);
    	 insertAgenda(a);
    	 a=new Agenda("2","Opening Ceremony","08:00-09:00","the first floor of Nanjing university dining room",0,0);
    	 insertAgenda(a);
    	 a=new Agenda("3","The Future of the Android","10:00-11:00","the second floor of Nanjing university dining room",0,0);
    	 insertAgenda(a);
    	 a=new Agenda("4","3D and Android","14:00-16:00","the ground of Nanjing university",0,0);
    	 insertAgenda(a);
    	 a=new Agenda("5","Tuesday,12th November","title","title",0,1);
    	 insertAgenda(a);
    	 a=new Agenda("6","Android Change the World","08:00-09:00","Classroom A",0,0);
    	 insertAgenda(a);
    	 a=new Agenda("7","Iphone is Better than Android?","08:00-09:00","who knows",0,0);
    	 insertAgenda(a);
    	 a=new Agenda("8","bala~bala~bala~bala","08:00-09:00","forget...",0,0);
    	 insertAgenda(a);
    	 a=new Agenda("9","bala~bala~bala~bala","08:00-09:00","the address can be long and long and long and long and long and long",0,0);
    	 insertAgenda(a);
    	 a=new Agenda("10","Wednesday,13th November","title","title",0,1);
    	 insertAgenda(a);
    	 a=new Agenda("11","Opening Ceremony","08:00-09:00","the first floor of Nanjing university dining room",0,0);
    	 insertAgenda(a);
    	} 	
    }
    public void updateAgenda(String id,String is_selected){
    	String updateAgenda_sql="update agenda set is_selected='"+is_selected+"' where id='"+id+"'";
    	mDb.execSQL(updateAgenda_sql);
    }
    //将表中的数据全部读出
    public ArrayList<Paper> queryPaper() { 
    	ArrayList<Paper> palist=new ArrayList<Paper>();
    	// 把整张表的所有数据query到cursor中  
    	Cursor cursor = mDb.query("paper", null, null, null, null, null, null);  
    	//判断cursor不为空 这个很重要  
    	if (cursor != null) {  
    	    // 循环遍历cursor  
    	    while (cursor.moveToNext()) {  
    	    	// 拿到每一行name 与hp的数值  
    	    	Paper pa=new Paper(cursor.getString(cursor.getColumnIndex("id")),
						 cursor.getString(cursor.getColumnIndex("title")), 
						 cursor.getString(cursor.getColumnIndex("author")),
						 cursor.getString(cursor.getColumnIndex("type")),
						 cursor.getString(cursor.getColumnIndex("conID")),
						 Integer.parseInt(cursor.getString(cursor.getColumnIndex("is_selected"))));
    	    	
    	    	if(pa!=null){
    	    		palist.add(pa);	    		
    	    	}
    	    }  
    	    // 关闭  
    	    cursor.close();  

    	}  

    	return palist;
    } 
    
    
    public List<Agenda> queryAgenda() { 
    	List<Agenda> agendalist=new ArrayList<Agenda>();
    	// 把整张表的所有数据query到cursor中  
    	Cursor cursor = mDb.query("agenda", null, null, null, null, null, null);  
    	//判断cursor不为空 这个很重要  
    	if (cursor != null) {  
    	    // 循环遍历cursor  
    	    while (cursor.moveToNext()) {  
    	    	// 拿到每一行name 与hp的数值  
    	    	Agenda agenda=new Agenda(cursor.getString(cursor.getColumnIndex("id")),
						 cursor.getString(cursor.getColumnIndex("title")), 
						 cursor.getString(cursor.getColumnIndex("time")),
						 cursor.getString(cursor.getColumnIndex("address")),
						 Integer.parseInt(cursor.getString(cursor.getColumnIndex("is_selected"))),
						 Integer.parseInt(cursor.getString(cursor.getColumnIndex("is_title"))));
    	    	
    	    	if(agenda!=null){
    	    		agendalist.add(agenda);	    		
    	    	}
    	    }  
    	    // 关闭  
    	    cursor.close();  

    	}  

    	return agendalist;
    } 
    
    //在表中插入一行新数据
    public void insertPaper(Paper pa) {  
        ContentValues values = new ContentValues();  
        values.put("id", pa.getMarkup()); 
        values.put("title", pa.getTitle());
        values.put("author", pa.getAuthor());
        values.put("type", pa.getType());
        values.put("conID", pa.getConID());
        values.put("is_selected", pa.getIfPrefered());
        mDb.insert("paper", null, values);  
    }
    public void insertAgenda(Agenda agenda) {  
        ContentValues values = new ContentValues();  
        values.put("id", agenda.getId()); 
        values.put("title", agenda.getTitle());
        values.put("time", agenda.getTime());
        values.put("address", agenda.getAddress());
        values.put("is_selected", agenda.isIs_selected());
        values.put("is_title", agenda.isIs_title());
        mDb.insert("agenda", null, values);  
    }
    
    //删除表
    public void deletTablePaper(){
    	mDb.execSQL("DROP TABLE paper"); 
    }
    
    public void deletTableAgenda(){
    	mDb.execSQL("DROP TABLE agenda"); 
    }
    
    //判断数据库中某张表是否已存在
    private boolean tabIsExist(String tabName){
        boolean result = false;
        if(tabName == null){
                return false;
        }
        Cursor cursor = null;
        try {
              
                String sql = "select count(*) as c from sqlite_master where type ='table' and name ='"+tabName.trim()+"' ";
				cursor = mDb.rawQuery(sql, null);
                if(cursor.moveToNext()){
                        int count = cursor.getInt(0);
                        if(count>0){
                                result = true;
                        }
                }
               
        } catch (Exception e) {
                // TODO: handle exception
        }               
        return result;
}

}
