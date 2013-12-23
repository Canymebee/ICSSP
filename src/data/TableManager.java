package data;

/*
这个类是数据库类，用于提供表的各种操作，包括增删改
作者：jzy
更新时间：2013.08.05
*/

import java.util.ArrayList;
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
    		        + "id VARCHAR(255) PRIMARY KEY," + "title VARCHAR(255) ,"+"author VARCHAR(255),"+"is_selected VARCHAR(255));";  
    	 mDb.execSQL(NAME_TABLE_CREATE);
    	} 	 
    }
    
    public void createAgendaTable(){
    	if(!tabIsExist("agenda")){
    		String NAME_TABLE_CREATE = "create table agenda("  
    		        + "id VARCHAR(255) PRIMARY KEY," + "title VARCHAR(255) ,"+"time VARCHAR(255),"+"address VARCHAR(255),"+"is_selected VARCHAR(255));";  
    	 mDb.execSQL(NAME_TABLE_CREATE);
    	} 	
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
    
    public ArrayList<Agenda> queryAgenda() { 
    	ArrayList<Agenda> agendalist=new ArrayList<Agenda>();
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
						 Integer.parseInt(cursor.getString(cursor.getColumnIndex("is_selected"))));
    	    	
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
        values.put("id", pa.getId()); 
        values.put("title", pa.getTitle());
        values.put("author", pa.getAuthor());
        values.put("is_selected", pa.isIs_selected());
        mDb.insert("paper", null, values);  
    }
    
    public void insertAgenda(Agenda agenda) {  
        ContentValues values = new ContentValues();  
        values.put("id", agenda.getId()); 
        values.put("title", agenda.getTitle());
        values.put("time", agenda.getTime());
        values.put("address", agenda.getAddress());
        values.put("is_selected", agenda.isIs_selected());
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
