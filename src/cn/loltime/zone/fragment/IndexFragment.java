package cn.loltime.zone.fragment;

import com.example.loginsuijidemo.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 * Date: 15-07-28
 * Time: 04:20 am
 */
public class IndexFragment extends Fragment {

	
	public IndexFragment() {
		
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.fragment_index_layout, container,
				false);
		
		return view;
	}

}
