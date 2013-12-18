package com.activity.se_conference;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import myViews.ClassItem;
import myViews.ClassListAdapter;
import android.content.Intent;
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
		typebutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data.removeElementAt(4);
				addAdapterItem(data);
			}
			
		});
		importantbutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data.removeElementAt(4);
				addAdapterItem(data);
			}
			
		});
		authorbutton.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				data.removeElementAt(4);
				addAdapterItem(data);
			}
			
		});
	
		ClassItem item1 = new ClassItem("paper1","auther1","type1",1,"type1");
		ClassItem item2 = new ClassItem("paper2","auther2","type2",2,"type2");
		ClassItem item3 = new ClassItem("paper3","auther3","type2",2,"type2");
		ClassItem item4 = new ClassItem("paper4","auther1","type3",3,"type3");
		ClassItem item5 = new ClassItem("paper5","auther5","type3",3,"type3");
		ClassItem item6 = new ClassItem("paper6","auther6","type3",3,"type3");
		ClassItem item7 = new ClassItem("paper7","auther7","type4",4,"type4");
		ClassItem item8 = new ClassItem("paper8","auther8","type4",4,"type4");
		
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
