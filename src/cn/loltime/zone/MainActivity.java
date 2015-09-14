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
        mRegister.setOnClickListener(new View.OnClickListener(){     //ע��TextView �ĵ���¼�����
        	@Override
        	public void onClick(View v)
        	{
        		Intent intent = new Intent(MainActivity.this,RegisterActivity.class);   //���ת
        		startActivity(intent);
        	}
        });
        
        mForgot.setClickable(true);
        mForgot.setOnClickListener(new View.OnClickListener() {    //�޷���½TextView �ĵ���¼�����
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,ForgotActivity.class);   //���ת
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
    		Toast.makeText(this, "�������û���", Toast.LENGTH_SHORT).show();
    	}
    	else if(passWord.equals(""))
    	{
    		Toast.makeText(this, "����������", Toast.LENGTH_SHORT).show();
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
	    				Toast.makeText(this, "�������", Toast.LENGTH_SHORT).show();
	    			}
	    			break;
	    		}	    			
	    	}
	    	if(count == 0)
	    			Toast.makeText(this, "�û��������ڣ�", Toast.LENGTH_SHORT).show();
    	}
   }
}
