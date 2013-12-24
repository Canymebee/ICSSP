package myViews;

import java.util.List;
import java.util.Map;

import com.activity.se_conference.Agenda_Detial;
import com.activity.se_conference.Pages_Details;
import com.activity.se_conference.R;

import data.Agenda;
import data.TableManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MyAgendaListAdapter extends BaseAdapter {
	private Activity act;
	private Context c;
	private LayoutInflater mInflater;
	TableManager t;
    private boolean statics;
	private List<Agenda> mData;
	
		public MyAgendaListAdapter(Context context) {
		c=context;
		act=(Activity)context;
		this.mInflater = LayoutInflater.from(context);
		t=new TableManager(context);
		t.createAgendaTable();
		mData=t.queryAgenda();
//		t.deletTableAgenda();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

//	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final String id;
		t=new TableManager(c);
		t.createAgendaTable();
		mData=t.queryAgenda();
		
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if (convertView == null) {

			holder = new ViewHolder();

			convertView = mInflater.inflate(R.layout.agenda_list, null);
			holder.addBtn = (Button) convertView
					.findViewById(R.id.agenda_notice);
			holder.title = (TextView) convertView
					.findViewById(R.id.agenda_title);
			holder.time = (TextView) convertView.findViewById(R.id.agenda_time);
			holder.address = (TextView) convertView.findViewById(R.id.agenda_address);
			holder.viewBtn = (Button) convertView
					.findViewById(R.id.agenda_view_btn);
			convertView.setTag(holder);

		} else {

			holder = (ViewHolder) convertView.getTag();
		}
		if(mData.get(position).isIs_title()==true){
			id=mData.get(position).getId();
//			RelativeLayout r = (RelativeLayout) convertView
//					.findViewById(R.id.agenda_layout);
//			Drawable drawable = act.getResources().getDrawable(R.drawable.img01);
//			r.setBackground(drawable);
			convertView.setBackgroundColor(c.getResources().getColor(R.color.Blue_Color));
			holder.addBtn.setVisibility(View.GONE);
			holder.time.setVisibility(View.GONE);
			holder.address.setVisibility(View.GONE);
			holder.viewBtn.setVisibility(View.GONE);
			holder.title.setText((String) mData.get(position).getTitle());
			holder.title.setTextColor(c.getResources().getColor(R.color.my_dark));
		    TextPaint tp = holder.title.getPaint();   
		    tp.setFakeBoldText(false); 
//			holder.title.setText;
			holder.title.setTextSize(20);
		}else{
//			RelativeLayout r = (RelativeLayout) convertView
//					.findViewById(R.id.agenda_layout);
			id=mData.get(position).getId();
//			convertView.setBackgroundColor(Color.WHITE);
			convertView.setBackgroundColor(c.getResources().getColor(R.color.Light_Grey));
		    holder.addBtn.setVisibility(View.VISIBLE);
			holder.time.setVisibility(View.VISIBLE);
			holder.address.setVisibility(View.VISIBLE);
			holder.viewBtn.setVisibility(View.VISIBLE);
			holder.title.setTextSize(15);
			holder.title.setTextColor(c.getResources().getColor(R.color.my_grey));
			TextPaint tp = holder.title.getPaint();   
		    tp.setFakeBoldText(true); 
			statics = mData.get(position).isIs_selected();
			if (!statics) {
				Drawable drawable = convertView.getResources().getDrawable(R.drawable.toimportant);
				holder.addBtn.setBackgroundDrawable(drawable);
				
			} else {
				Drawable drawable = c.getResources().getDrawable(R.drawable.importanted);
				holder.addBtn.setBackgroundDrawable(drawable);
			}

			holder.title.setText((String) mData.get(position).getTitle());
			holder.time.setText((String) mData.get(position).getTime());
			holder.address.setText((String) mData.get(position).getAddress());
			holder.addBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
//					Toast.makeText(c,   
//	                        id,   
//	                        Toast.LENGTH_SHORT).show();  
	           
					if (!statics) {
						Drawable drawable = c.getResources().getDrawable(R.drawable.importanted);
//						holder.addBtn.setBackground(drawable);
						holder.addBtn.setBackgroundDrawable(drawable);
						statics = true;
						t.updateAgenda(id, "1");
					} else {
						Drawable drawable = c.getResources().getDrawable(R.drawable.toimportant);
//						holder.addBtn.setBackground(drawable);
						holder.addBtn.setBackgroundDrawable(drawable);
						statics = false;
						t.updateAgenda(id, "0");
					}
				}
			});
			holder.viewBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					 Intent intent=new Intent(act,Agenda_Detial.class);
					 intent.putExtra("id", id);
					act.startActivity(intent);
				}
			});
		}
		return convertView;
	}

	public final class ViewHolder {
		public Button addBtn;
		public TextView title;
		public TextView time;
		public TextView address;
		public Button viewBtn;
	}
}
