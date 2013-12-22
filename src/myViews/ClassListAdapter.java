package myViews;
import java.util.Vector;
import com.activity.se_conference.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ClassListAdapter extends BaseAdapter {

	private Vector<ClassItem> items;
	private Context context;
	private LayoutInflater mInflater;
	private boolean isimportanted=false;
	private boolean isScroll=false;
	
	public ClassListAdapter(Context context) {
		this.context = context;
		mInflater = LayoutInflater.from(context);
	 	items = new Vector<ClassItem>();
	}
	
	public ClassItem getMessageByIndex(int index) {
		return items.elementAt(index);
	}

	public void addItem(ClassItem item) {
		items.add(item);
		this.notifyDataSetChanged();
	}
	public void copyItems(Vector<ClassItem> messages){
		if(messages==null){
			messages = new Vector<ClassItem>();
		}
		if(items != null && items.size() > 0){
			for(int i = 0;i < items.size();i++){
				messages.add(items.get(i));
			}
		}
	}

	public void removeAll() {
		items.clear();
		this.notifyDataSetChanged();
	}

	public int getCount() {
		return items.size();
	}

	public Object getItem(int position) {
		return items.get(position);
	}

	public long getItemId(int position) {
		return position;
	}


	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.pages_class_part_lay, null);
			holder = new ViewHolder();
			holder.partLayout = (LinearLayout)convertView.findViewById(R.id.classGroupLayout);
			holder.partId = (TextView) convertView.findViewById(R.id.class_part_id);
			holder.markup = (TextView) convertView.findViewById(R.id.markup);
			holder.partName = (TextView) convertView.findViewById(R.id.class_part_name);
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.author = (TextView) convertView.findViewById(R.id.author);
			holder.type = (TextView) convertView.findViewById(R.id.type);
			holder.important=(ImageView) convertView.findViewById(R.id.important);
			holder.important.setOnClickListener(new OnClickListener(){

				@SuppressLint("NewApi")
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					if(isimportanted){
						Drawable drawable = context.getResources().getDrawable(R.drawable.toimportant);
						holder.important.setBackground(drawable);
						isimportanted=false;
					}
					else{
						Drawable drawable = context.getResources().getDrawable(R.drawable.importanted);
						holder.important.setBackground(drawable);
						isimportanted=true;
					}
					
				}
				
			});

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		ClassItem classItem = items.get(position);
		if(classItem != null){
			if(classItem.getIfTop()){
				holder.partLayout.setVisibility(View.VISIBLE);
				holder.partName.setText(classItem.getPartName());
				holder.markup.setText(classItem.getMarkup());
				holder.title.setText(classItem.getTitle());
				holder.author.setText(classItem.getAuthor());
				holder.type.setText(classItem.getType());
			}else{
				holder.partLayout.setVisibility(View.GONE);
				holder.partName.setText(classItem.getPartName());
				holder.markup.setText(classItem.getMarkup());
				holder.title.setText(classItem.getTitle());
				holder.author.setText(classItem.getAuthor());
				holder.type.setText(classItem.getType());
			}
			
		}
		return convertView;
	}

	public class ViewHolder {
		LinearLayout partLayout;
		TextView partId;
		TextView markup;
		TextView partName;
		TextView title;
		TextView author;
		TextView type;
		ImageView important;
	}
}
