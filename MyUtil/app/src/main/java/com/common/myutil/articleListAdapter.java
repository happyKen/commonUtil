package com.common.myutil;

import java.util.List;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class articleListAdapter extends ArrayAdapter<ArticleList> {
	public articleListAdapter(Context context, int resource, List<ArticleList> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub

	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);
		

		final ArticleList articleList = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView==null){
		 view = LayoutInflater.from(getContext()).inflate(R.layout.article_item, null);
		 viewHolder = new ViewHolder();
		 viewHolder.juziTitle =(TextView) view.findViewById(R.id.tv_speak_title);
		 viewHolder.juziContent =(TextView) view.findViewById(R.id.tv_speak_content);
		 viewHolder.juziTime = (TextView) view.findViewById(R.id.tv_speak_time);
		 viewHolder.movieBeginStudy = (ImageView) view.findViewById(R.id.img_speak_beginStudy);
		 view.setTag(viewHolder);
		}else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.juziTitle.setText(articleList.getTitle());
		viewHolder.juziContent.setText(articleList.getContent());
		viewHolder.juziTime.setText(articleList.getTime());
		return view;
		
	}
class ViewHolder{
	TextView juziContent;
	TextView juziTitle;
	TextView juziTime;
	ImageView movieBeginStudy;
}
}
