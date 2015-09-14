package cn.loltime.zone.fragment;

import java.util.List;
import cn.loltime.zone.adapter.SeekFragmentAdapter;
import cn.loltime.zone.model.SeekModel;
import com.example.loginsuijidemo.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class SeekFragment extends Fragment{
	private GridView mGridView;
	private List<SeekModel> mSeekModelGridViewList;
	private SeekFragmentAdapter mSeekFragmentAdapter;
		
	public void getSeekFragmentAdapter(SeekFragmentAdapter seekFragmentAdapter)  
	{
		mSeekFragmentAdapter = seekFragmentAdapter;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_seek_layout, container, false);
		mGridView = (GridView) view.findViewById(R.id.question_gridview);
		initViews();		
		return view;
	}
	
	
	private void initViews(){
        mGridView.setAdapter(mSeekFragmentAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Clicked item!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
