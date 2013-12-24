package com.activity.se_conference;


import java.util.Vector;





import myViews.ClassItem;
import myViews.ClassListAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Agenda_Detial extends Activity {
	private ClassListAdapter classListAdapter;
	Vector<ClassItem> data = new Vector<ClassItem>();
	TextView agenda_detial_title;
	TextView agenda_detial_presenter;
	ListView agenda_detial_paperList;
	String id;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agenda_detial);

		Bundle extras=getIntent().getExtras();
		id=extras.getString("id");
		findViews();
		setLIsteners();
		classListAdapter = new ClassListAdapter(this);
		if(id.equals("2")){
			ClassItem item1 = new ClassItem("SD-1","The Challenges of Emerging Software Eco-Systems (Keynote) ","Neil G. Siegel","Keynotes","1",1,"Keynotes",true);
			ClassItem item2 = new ClassItem("SD-2","Low Ceremony Processes for Short Lifecycle Projects (Keynote) ","Anthony I. Wasserman","Keynotes","1",1,"Keynotes",true);
			ClassItem item3 = new ClassItem("SD-3","How to Treat Timing Information for Software Effort Estimation? ","Masateru Tsunoda, Sousuke Amasaki, and Chris Lokan","Estimation","1",2,"Estimation",true);
			ClassItem item4 = new ClassItem("SD-8"," qEstimation: A Process for Estimating Size and Effort of Software Testing ","Vu Nguyen, Vu Pham, and Vu Lam","Estimation","1",2,"Estimation",true);
			classListAdapter.addItem(item1);
			classListAdapter.addItem(item2);
			classListAdapter.addItem(item3);
			classListAdapter.addItem(item4);
			
		}
		if(id.equals("3")){
			ClassItem item5 = new ClassItem("SD-4","A Model for Estimating Agile Project Process and Schedule Acceleration ","Dan Ingold, Barry Boehm, and Supannika Koolmanojwong","Estimation","1",2,"Estimation",true);
			   classListAdapter.addItem(item5);
				
		}
		if(id.equals("4")){
		ClassItem item6 = new ClassItem("SD-5"," A Discipline-Spanning Development Process for Self-Adaptive Mechatronic Systems ","Christian Heinzemann, Oliver Sudmann, Wilhelm Schäfer, and Matthias Tichy","Software Process I","1",3,"Software Process I",true);
		ClassItem item7 = new ClassItem("SD-6","A Process Practice to Validate the Quality of Reused Component Documentation: A Case Study Involving Open-Source Components ","Olivier Gendreau and Pierre N. Robillard","Quality and Indicators","1",4,"Quality and Indicators",true);
		ClassItem item8 = new ClassItem("SD-7","A Methodology to Derive Sustainability Indicators for Software Development Projects ","Giuseppe Lami, Fabrizio Fabbrini, and Mario Fusani","Quality and Indicators","1",4,"Quality and Indicators",true);
	 	classListAdapter.addItem(item6);
		classListAdapter.addItem(item7);
		classListAdapter.addItem(item8);
		}
		agenda_detial_paperList.setAdapter(classListAdapter);
	//	mData = getData();
	//	MyAdapter adapter = new MyAdapter(this);
	//	setListAdapter(adapter);
	}
	private void setLIsteners() {
		// TODO Auto-generated method stub
		
	}
	private void findViews() {
		// TODO Auto-generated method stub
		agenda_detial_title=(TextView)findViewById(R.id.agenda_detial_title);
		agenda_detial_presenter=(TextView)findViewById(R.id.agenda_detial_presenter);
		agenda_detial_paperList=(ListView)findViewById(R.id.agenda_detial_paperList);
	}
}
