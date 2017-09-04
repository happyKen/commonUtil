package com.common.myutil;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class articleListAdapter extends ArrayAdapter<ActivityList> {
	public articleListAdapter(Context context, int resource, List<ActivityList> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub

	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//return super.getView(position, convertView, parent);
		

		final ActivityList activityList = getItem(position);
		View view;
		ViewHolder viewHolder;
		if(convertView==null){
		 view = LayoutInflater.from(getContext()).inflate(R.layout.article_item, null);
		 viewHolder = new ViewHolder();
		 viewHolder.juziTitle =(TextView) view.findViewById(R.id.tv_speak_title);
		 viewHolder.juziContent =(TextView) view.findViewById(R.id.tv_speak_content);
		 view.setTag(viewHolder);
		}else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.juziTitle.setText(activityList.getTitle());
		viewHolder.juziContent.setText(activityList.getContent());
		view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getContext(),activityList.getActivityClass());
				getContext().startActivity(intent);
			}
		});
		return view;
		
	}
class ViewHolder{
	TextView juziContent;
	TextView juziTitle;
}

}
