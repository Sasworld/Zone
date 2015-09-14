package cn.loltime.zone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginsuijidemo.R;

public class MainActivity extends BaseActivity {

	private Button mLoginButton;
	private EditText mUserName;
	private EditText mPassWord;
	private TextView mRegister;
	private TextView mForgot;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_login);
        
        mLoginButton = (Button)findViewById(R.id.login_btnlogin);
        mUserName = (EditText)findViewById(R.id.login_username);
        mPassWord = (EditText)findViewById(R.id.login_password);
        mRegister = (TextView)findViewById(R.id.registe);
        mForgot = (TextView)findViewById(R.id.forgot);
        
        mRegister.setClickable(true);
        mRegister.setOnClickListener(new View.OnClickListener(){     //注册TextView 的点击事件设置
        	@Override
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(MainActivity.this,RegisterActivity.class);   //活动跳转
        		startActivity(intent);
        	}
        });
        
        mForgot.setClickable(true);
        mForgot.setOnClickListener(new View.OnClickListener() {    //无法登陆TextView 的点击事件设置
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,ForgotActivity.class);   //活动跳转
        		startActivity(intent);
			}
		});
        
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
           	 	mLoginButton_OnClick(v);
            }
       });
    }
    
    private void mLoginButton_OnClick(View v){
		
    	String userName;
    	String passWord;
    	int count = 0;
    	
    	userName = mUserName.getText().toString();
    	passWord = mPassWord.getText().toString();
    	
    	if(userName.equals(""))
    	{
    		Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
    	}
    	else if(passWord.equals(""))
    	{
    		Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
    	}
    	else
    	{
	    	for(int i = 0; i<mUserMessageModelList.size();i++)
	    	{
	    		if(userName.equals(mUserMessageModelList.get(i).getUserId().toString()))
	    		{
	    			count++;
	    			if(passWord.equals(mUserMessageModelList.get(i).getPassWord().toString()))
	    				{
		    				Intent intent = new Intent(MainActivity.this,MasterActivity.class);
		            		startActivity(intent);
				            			mUserName.setText("");
					            		mPassWord.setText("");
	    				}
	    			else
	    			{
	    				Toast.makeText(this, "密码错误！", Toast.LENGTH_SHORT).show();
	    			}
	    			break;
	    		}	    			
	    	}
	    	if(count == 0)
	    			Toast.makeText(this, "用户名不存在！", Toast.LENGTH_SHORT).show();
    	}
   }
}
