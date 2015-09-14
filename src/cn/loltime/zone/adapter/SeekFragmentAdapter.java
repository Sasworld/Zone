package cn.loltime.zone.adapter;

import java.util.List;

import com.example.loginsuijidemo.R;

import cn.loltime.zone.model.SeekModel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SeekFragmentAdapter extends ArrayAdapter<SeekModel>{
	
private int resourceId;
	
	public SeekFragmentAdapter(Context questionFragment, int textViewResourceId,
			List<SeekModel> objects) {
		super(questionFragment, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SeekModel questionModel = getItem(position); //获取QuestionModel实例
		View view;
		if (convertView == null){
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		}
		else
		{
			view = convertView;
		}
		TextView questionGridViewTitle = (TextView) view.findViewById(R.id.question_gridview_title);
		ImageView questionGridViewDesc = (ImageView) view.findViewById(R.id.question_gridview_image);
		questionGridViewTitle.setText(questionModel.getTitle());
		questionGridViewDesc.setImageResource(questionModel.getImageId());
		return view;
	}

}
