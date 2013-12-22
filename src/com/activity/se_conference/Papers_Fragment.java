package com.activity.se_conference;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import com.activity.se_conference.R.color;

import myViews.ClassItem;
import myViews.ClassListAdapter;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Papers_Fragment extends Fragment{
	private ListView classItemList;
	private ClassListAdapter classListAdapter;
	private View view=null;
	ViewGroup container=null;
	LayoutInflater inflater=null;
	private Button authorbutton=null;
	private Button typebutton=null;
	private Button importantbutton=null;
	private Button searchButton=null;
	Vector<ClassItem> data = new Vector<ClassItem>();
	@Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
    		Bundle savedInstanceState) {  
		this.container=container;
		this.inflater=inflater;
		view=inflater.inflate(R.layout.papers_fragment, container, false);
		initView();
        return  view; 
    }
	private void initView() {
		// TODO Auto-generated method stub
		classItemList=(ListView) view.findViewById(R.id.classItemListView);
		classListAdapter = new ClassListAdapter(getActivity());
		classItemList.setAdapter(classListAdapter);
		authorbutton=(Button) view.findViewById(R.id.authorbutton);
		importantbutton=(Button) view.findViewById(R.id.importantbutton);
		typebutton=(Button) view.findViewById(R.id.typebutton);
		searchButton=(Button) view.findViewById(R.id.searchButton);
		
		typebutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data.removeElementAt(0);
				addAdapterItem(data);
				typebutton.setBackgroundColor(Color.rgb(135, 206, 235));
				authorbutton.setBackgroundColor(Color.WHITE);
				importantbutton.setBackgroundColor(Color.WHITE);
			}
			
		});
		importantbutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data.removeElementAt(0);
				addAdapterItem(data);
				typebutton.setBackgroundColor(Color.WHITE);
				authorbutton.setBackgroundColor(Color.WHITE);
				importantbutton.setBackgroundColor(Color.rgb(135, 206, 235));
			}
			
		});
		searchButton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data.removeElementAt(0);
				addAdapterItem(data);
				
			}
			
		});
		authorbutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data.removeElementAt(0);
				addAdapterItem(data);
				typebutton.setBackgroundColor(Color.WHITE);
				authorbutton.setBackgroundColor(Color.rgb(135, 206, 235));
				importantbutton.setBackgroundColor(Color.WHITE);
			}
			
		});
	
		ClassItem item1 = new ClassItem("SD-1","The Challenges of Emerging Software Eco-Systems (Keynote) ","Neil G. Siegel","Keynotes",1,"Keynotes");
		ClassItem item2 = new ClassItem("SD-2","Low Ceremony Processes for Short Lifecycle Projects (Keynote) ","Anthony I. Wasserman","Keynotes",1,"Keynotes");
		ClassItem item3 = new ClassItem("SD-3","How to Treat Timing Information for Software Effort Estimation? ","Masateru Tsunoda, Sousuke Amasaki, and Chris Lokan","Estimation",2,"Estimation");
		ClassItem item4 = new ClassItem("SD-8"," qEstimation: A Process for Estimating Size and Effort of Software Testing ","Vu Nguyen, Vu Pham, and Vu Lam","Estimation",2,"Estimation");
		ClassItem item5 = new ClassItem("SD-4","A Model for Estimating Agile Project Process and Schedule Acceleration ","Dan Ingold, Barry Boehm, and Supannika Koolmanojwong","Estimation",2,"Estimation");
		ClassItem item6 = new ClassItem("SD-5"," A Discipline-Spanning Development Process for Self-Adaptive Mechatronic Systems ","Christian Heinzemann, Oliver Sudmann, Wilhelm Schäfer, and Matthias Tichy","Software Process I",3,"Software Process I");
		ClassItem item7 = new ClassItem("SD-6","A Process Practice to Validate the Quality of Reused Component Documentation: A Case Study Involving Open-Source Components ","Olivier Gendreau and Pierre N. Robillard","Quality and Indicators",4,"Quality and Indicators");
		ClassItem item8 = new ClassItem("SD-7","A Methodology to Derive Sustainability Indicators for Software Development Projects ","Giuseppe Lami, Fabrizio Fabbrini, and Mario Fusani","Quality and Indicators",4,"Quality and Indicators");
	
		data.addElement(item1);
		data.addElement(item2);
		data.addElement(item3);
		data.addElement(item4);
		data.addElement(item5);
		data.addElement(item6);
		data.addElement(item7);
		data.addElement(item8);
		addAdapterItem(data);
		
		classItemList.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent intent=null;
				switch(arg2){
				
				}
				
			}
			
		});
	} 

	private void addAdapterItem(Vector<ClassItem> data){
		Vector<ClassItem> classItem = new Vector<ClassItem>();
		classItem.removeAllElements();
		
		ClassItem temp = null;
		Set<Integer> set = new HashSet<Integer>();
		if(data!=null && data.size()>0){
			for(int i=0 ; i<data.size() ; i++){
				temp = data.get(i);
				if(set.contains(temp.getPartId())){
					classItem.add(temp); 
				}else{
					temp.setIfTop(true);
					set.add(temp.getPartId());
					classItem.add(temp);
				}
			}
			classListAdapter.removeAll();
			for(ClassItem item : classItem){
				classListAdapter.addItem(item);
			}
		}
	}
}
