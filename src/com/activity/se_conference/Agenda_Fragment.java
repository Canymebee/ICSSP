package com.activity.se_conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import myViews.MyAgendaListAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Agenda_Fragment extends Fragment {

	private TextView MondayTextView;
	private TextView TuesdayTextView;
	private ListView agendaList;
//	private ListView agendaList2;
//	private boolean isMondayVisible = true;
//	private boolean isTuesdayVisible = true;
	// private boolean isTuesdayVisble = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater
				.inflate(R.layout.agenda_fragment, container, false);
//		MondayTextView = (TextView) view.findViewById(R.id.agenda_Mon);
		agendaList = (ListView) view.findViewById(R.id.agenda_List);
		agendaList.setAdapter(new MyAgendaListAdapter(getActivity(), getData()));

//		MondayTextView.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				if (isMondayVisible) {
//					agendaList1.setVisibility(View.GONE);
//					isMondayVisible = false;
//				} else if (!isMondayVisible) {
//					agendaList1.setVisibility(View.VISIBLE);
//					isMondayVisible = true;
//				}
//			}
//		});
		
		
		
//		TuesdayTextView = (TextView) view.findViewById(R.id.agenda_Tues);
//		agendaList2 = (ListView) view.findViewById(R.id.agenda_List2);
//		agendaList2.setAdapter(new MyAgendaListAdapter(getActivity(), getData2()));

//		TuesdayTextView.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				if (isTuesdayVisible) {
//					agendaList2.setVisibility(View.GONE);
//					isTuesdayVisible = false;
//				} else if (!isTuesdayVisible) {
//					agendaList2.setVisibility(View.VISIBLE);
//					isTuesdayVisible = true;
//				}
//			}
//		});

		return view;
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isTitle", "1");
		map.put("title", "Monday,11th November");
		map.put("time", "title");
		map.put("address", "title");
		map.put("isSelected", "3");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "Opening Ceremony");
		map.put("time", "08:00-09:00");
		map.put("address", "the first floor of Nanjing university dining room");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "The Future of the Android");
		map.put("time", "10:00-11:00");
		map.put("address", "the second floor of Nanjing university dining room");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "3D and Android");
		map.put("time", "14:00-16:00");
		map.put("address", "the ground of Nanjing university");
		map.put("isSelected", "0");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("isTitle", "1");
		map.put("title", "Tuesday,12th November");
		map.put("time", "title");
		map.put("address", "title");
		map.put("isSelected", "3");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "Android Change the World");
		map.put("time", "08:00-09:00");
		map.put("address", "Classroom A");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "Iphone is Better than Android?");
		map.put("time", "10:00-11:00");
		map.put("address", "who knows");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "bala~bala~bala~bala");
		map.put("time", "14:00-16:00");
		map.put("address", "forget...");
		map.put("isSelected", "0");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "bala~bala~bala~bala");
		map.put("time", "14:00-16:00");
		map.put("address", "the address can be long and long and long and long and long and long ");
		map.put("isSelected", "0");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("isTitle", "1");
		map.put("title", "Wednesday,13th November");
		map.put("time", "title");
		map.put("address", "title");
		map.put("isSelected", "3");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "开幕式");
		map.put("time", "08:00-09:00");
		map.put("address", "南京大学食堂1楼");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "会议1");
		map.put("time", "10:00-11:00");
		map.put("address", "南京大学食堂2楼");
		map.put("isSelected", "0");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("isTitle", "0");
		map.put("title", "会议2");
		map.put("time", "14:00-16:00");
		map.put("address", "南京大学食堂3楼");
		map.put("isSelected", "0");
		list.add(map);

		return list;
	}
}