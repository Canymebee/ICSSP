package data;

/*
这个类是数据库基本类，用于创建数据库
作者：jzy
更新时间：2013.08.05
*/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	
	private static DataBaseHelper mInstance = null; 
	
	/** 数据库名称 **/  
    public static final String DATABASE_NAME = "SE_Conference.db";  
  
    /** 数据库版本号 **/  
    private static final int DATABASE_VERSION = 1;  

    
	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
	
	 /**单例模式**/  
    public static synchronized DataBaseHelper getInstance(Context context) {  
    	if (mInstance == null) {  
    		mInstance = new DataBaseHelper(context);  
    	}  
    	return mInstance;  
    }

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean deleteDatabase(Context context) {  
	    return context.deleteDatabase(DATABASE_NAME);  
	}

}
