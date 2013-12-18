package myViews;

import java.util.List;
import java.util.Map;

import com.activity.se_conference.Pages_Details;
import com.activity.se_conference.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyAgendaListAdapter extends BaseAdapter {
	private Activity act;
	private String statics;
	private LayoutInflater mInflater;
	private List<Map<String, Object>> mData;

	public MyAgendaListAdapter(Context context, List<Map<String, Object>> mData) {
		act=(Activity)context;
		this.mInflater = LayoutInflater.from(context);
		this.mData = mData;
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
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
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
		if(mData.get(position).get("isTitle").toString()=="1"){
			holder.addBtn.setVisibility(View.GONE);
			holder.time.setVisibility(View.GONE);
			holder.address.setVisibility(View.GONE);
			holder.viewBtn.setVisibility(View.GONE);
			holder.title.setText((String) mData.get(position).get("title"));
			holder.title.setTextSize(22);
		}else{
			statics = mData.get(position).get("isSelected").toString();
			final RelativeLayout r = (RelativeLayout) convertView
					.findViewById(R.id.agenda_layout);
			if (statics == "0") {
				r.setBackgroundColor(Color.WHITE);
			} else if(statics=="1"){
				r.setBackgroundColor(Color.YELLOW);
			}else{
				r.setBackgroundColor(Color.RED);
			}

			// holder.addBtn.setBackgroundResource((Integer)mData.get(position).get("img"));
			holder.title.setText((String) mData.get(position).get("title"));
			holder.time.setText((String) mData.get(position).get("time"));
			holder.address.setText((String) mData.get(position).get("address"));
			holder.addBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// showInfo();
					if (statics == "0") {
						r.setBackgroundColor(Color.YELLOW);
						statics = "1";
					} else if(statics=="1"){
						r.setBackgroundColor(Color.WHITE);
						statics = "0";
					}
				}
			});
			holder.viewBtn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					 Intent intent=new Intent(act,Pages_Details.class);
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
