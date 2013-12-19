package myViews;

import java.util.ArrayList;

import com.activity.se_conference.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyPopDialogForImage{
	private Dialog dialog;
	private int current_id = 0;
	private ViewPager viewpager = null;
	private ArrayList<View> TempImage = new ArrayList<View>();
	private LayoutInflater inflater = null;
	private View temp = null;
	private ArrayList<Bitmap> bitmaps_list = new ArrayList<Bitmap>();
	private int[] bitmaps_id = new int[10];
	private ImageView image = null;
	private Bitmap TempBitmap;
	
	public MyPopDialogForImage(Activity activity, int Id, ArrayList<Bitmap> Bitmaps, int[] Bitmaps_id) {
		//需要Bitmap数组以及对应的资源id数组
		dialog = new Dialog(activity, R.style.Image_Dialog);
		current_id = Id;
		bitmaps_list = Bitmaps;
		bitmaps_id = Bitmaps_id;
		RelativeLayout popView = (RelativeLayout) LayoutInflater.
				from(activity).inflate(R.layout.maps_frag_image_dialog, null);
		viewpager = (ViewPager)popView.findViewById(R.id.image_dialog_viewpager);
		
		//获取图片的大小 
		TempBitmap = bitmaps_list.get(0);
		float BitmapWidth = TempBitmap.getWidth();
		float BitmapHeight = TempBitmap.getHeight();
		float WidthtoHeight = BitmapWidth/BitmapHeight;
		float HeighttoWidth = BitmapHeight/BitmapWidth;
		System.out.println("---------------->Width is " + BitmapWidth);
		System.out.println("---------------->Height is " + BitmapHeight);
		System.out.println("---------------->WidthtoHeight is " + WidthtoHeight);
		
		//获取手机屏幕尺寸
		DisplayMetrics dm = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
		int widthPixels= dm.widthPixels;
		int heightPixels= dm.heightPixels;
		float density = dm.density;
		int screenWidth = (int) (widthPixels * density) ;
		int screenHeight = (int) (heightPixels * density) ;	
		System.out.println("ScreenWidth is " + screenWidth);
		System.out.println("ScreenHeight is " + screenHeight);
		System.out.println("Density is " + density);

		
		inflater = LayoutInflater.from(activity);
		final ArrayList<View> ImageViewList = new ArrayList<View>();
		for(int i=0; i<bitmaps_id.length; i++){
			
			temp =  inflater.inflate(R.layout.maps_imagelist_layout, null);
			image = (ImageView) temp.findViewById(R.id.ListImage);
			image.setBackgroundResource(bitmaps_id[i]);
			ImageViewList.add(temp);
		
		}

/*		TextView text = (TextView) TempImage.findViewById(R.id.list_item);
		text.setText("你麻痹啊！");*/
		
		MyPagerAdapter mPagerAdapter = new MyPagerAdapter(ImageViewList);
		viewpager.setAdapter(mPagerAdapter);
		viewpager.setCurrentItem(current_id);
		viewpager.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog.hide();
				System.out.println("---------------->点击viewpager关闭dialog");
			}
		});
	
		if(screenHeight > screenWidth){
			dialog.setContentView(popView, 
					new LinearLayout.LayoutParams(widthPixels,(int) (widthPixels*HeighttoWidth)));
		}
		else{
			dialog.setContentView(popView, 
					new LinearLayout.LayoutParams((int) (heightPixels*WidthtoHeight),heightPixels));
		}
				
		dialog.setFeatureDrawableAlpha(Window.FEATURE_OPTIONS_PANEL, 0);
	}
	
	public void show() {
		dialog.show();
	}
	
	public void hide() {
		dialog.dismiss();
	}
	

}
