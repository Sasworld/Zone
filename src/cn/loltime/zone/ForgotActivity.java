package cn.loltime.zone;

import com.example.loginsuijidemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class ForgotActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.forgot_layout);
	}
}
