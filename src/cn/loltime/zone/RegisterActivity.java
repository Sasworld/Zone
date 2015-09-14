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
		userName = mUserNameEditText.getText().toString();   //��ȡEditText�����ֵ
		passWord = mPassWordEditText.getText().toString();
		passWordAgain = mPassWordEditTextAgain.getText().toString();
		
		if(userName.equals(""))    //��Բ�ͬ���������������ͬ�Ĵ���
		{
			Toast.makeText(this, "�������û���", Toast.LENGTH_SHORT).show();
		}
		else if(passWord.equals("")||passWordAgain.equals(""))
		{
			Toast.makeText(this, "����������", Toast.LENGTH_SHORT).show();
		}
		else 
		{
				if(passWord.equals(passWordAgain))
				{
					
					new Thread(new Runnable() {
						@Override
						public void run() {				
								RecSmsToPost(userName,passWord); //����EditText�����ֵ
						}
			       }).start();			
					Toast.makeText(this, "ע����ɣ�", Toast.LENGTH_SHORT).show();
					finish();    //ע��ɹ������ٵ�ǰ����Զ����ص�¼����
				}
				else
				{
					Toast.makeText(this, "�����������벻һ�£�", Toast.LENGTH_SHORT).show();
					mPassWordEditText.setText("");
					mPassWordEditTextAgain.setText("");
				}
		}
	}
	
	 private void RecSmsToPost(String strRecSmsMsg1,String strRecSmsMsg2){

	        Map<String,String> params = new HashMap<String,String>();   
	         params.put(strRecSmsMsg1,strRecSmsMsg2);

	         //����������·��     
	        String strUrlPath = "http://10.0.2.2:80/InsertToMysql/RecSms.php"; 
	        PostHttpUtils.submitPostData(strUrlPath,params, "utf-8");       
	   }
}
