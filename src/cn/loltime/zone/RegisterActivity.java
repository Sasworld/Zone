package cn.loltime.zone;

import java.util.HashMap;
import java.util.Map;

import com.example.loginsuijidemo.R;
import cn.loltime.zone.utils.PostHttpUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	
	private String userName;
	private String passWord;
	private String passWordAgain;	
	private Button mRegisteButton;
	private EditText mUserNameEditText;
	private EditText mPassWordEditText;
	private EditText mPassWordEditTextAgain;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.registe_layout);
		
		mRegisteButton = (Button)findViewById(R.id.registe_button);
		mUserNameEditText = (EditText)findViewById(R.id.registe_username);
		mPassWordEditText = (EditText)findViewById(R.id.registe_password);
		mPassWordEditTextAgain = (EditText)findViewById(R.id.registe_password_again);
		
		mRegisteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	mRegisteButton_onClick(v);
            	
            }
       });
	}
	
	private void mRegisteButton_onClick(View v)
	{
		userName = mUserNameEditText.getText().toString();   //获取EditText输入的值
		passWord = mPassWordEditText.getText().toString();
		passWordAgain = mPassWordEditTextAgain.getText().toString();
		
		if(userName.equals(""))    //针对不同的输入情况做出不同的处理
		{
			Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
		}
		else if(passWord.equals("")||passWordAgain.equals(""))
		{
			Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
		}
		else 
		{
				if(passWord.equals(passWordAgain))
				{
					
					new Thread(new Runnable() {
						@Override
						public void run() {				
								RecSmsToPost(userName,passWord); //传递EditText输入的值
						}
			       }).start();			
					Toast.makeText(this, "注册完成！", Toast.LENGTH_SHORT).show();
					finish();    //注册成功后销毁当前活动，自动返回登录界面
				}
				else
				{
					Toast.makeText(this, "两次密码输入不一致！", Toast.LENGTH_SHORT).show();
					mPassWordEditText.setText("");
					mPassWordEditTextAgain.setText("");
				}
		}
	}
	
	 private void RecSmsToPost(String strRecSmsMsg1,String strRecSmsMsg2){

	        Map<String,String> params = new HashMap<String,String>();   
	         params.put(strRecSmsMsg1,strRecSmsMsg2);

	         //服务器请求路径     
	        String strUrlPath = "http://10.0.2.2:80/InsertToMysql/RecSms.php"; 
	        PostHttpUtils.submitPostData(strUrlPath,params, "utf-8");       
	   }
}
