package com.suo.image.adapter;

import java.util.List;
import java.util.Map;

import net.tsz.afinal.FinalBitmap;

import com.suo.demo.R;
import com.suo.image.activity.BaseActivity;
import com.suo.image.img.SimpleImageLoader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyGalleryAdapter extends BaseAdapter {

	private BaseActivity context;
//	private String[] urlList = new String[5];
	private List<Map<String, Object>> listItems;
	private FinalBitmap fb;
	
	public MyGalleryAdapter(BaseActivity context, List<Map<String, Object>> listItems, FinalBitmap fb) {
		this.context = context;
		this.listItems = listItems;
		this.fb = fb;
	}

	@Override
	public int getCount() {
		
		return listItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		
		return listItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		if(convertView == null)
		{
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.picture_list_gallery_item, null);
			viewHolder = new ViewHolder();
			viewHolder.image = (ImageView) convertView.findViewById(R.id.galleryPicView);
			convertView.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		String url = (String) listItems.get(position).get("url");
//		fb.display(viewHolder.image, url);
		SimpleImageLoader.display(context, viewHolder.image, url, R.drawable.default_image);
		
        return convertView;  
	}
	
	public final class ViewHolder
	{
		public ImageView image;
	}

}
