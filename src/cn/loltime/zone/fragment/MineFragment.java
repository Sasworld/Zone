package cn.loltime.zone.fragment;

import com.example.loginsuijidemo.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MineFragment extends Fragment{
	public MineFragment()
	{
		
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_mine_layout, container,false);
		
		return view;
	}
}
