package cn.loltime.zone;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

import com.example.loginsuijidemo.R;

import cn.loltime.zone.model.SeekModel;
import cn.loltime.zone.model.UserMessageModel;
import cn.loltime.zone.utils.HttpUtils;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class BaseActivity extends Activity {
	
	public static final String GET_JSON_URL_INDEX = "http://10.0.2.2/LoginDemo/index.php";
	protected  List<UserMessageModel> mUserMessageModelList = new ArrayList<UserMessageModel>();
	protected  List<SeekModel> mSeekModelGridViewList = new ArrayList<SeekModel>();
	
	protected Handler getJSONHandlerUserMessage = new Handler(){
		public void handleMessage(android.os.Message msg){		
			String jsonString = (String) msg.obj;
			try {
					JSONArray dataJson = new JSONArray(jsonString);					
					for(int i = 0; i< dataJson.length(); ++i){
						String userid = dataJson.getJSONObject(i).getString("userid");
						String password = dataJson.getJSONObject(i).getString("password");
						UserMessageModel userMessageModel = new UserMessageModel(userid,password);
						mUserMessageModelList.add(userMessageModel);						
					}								
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	};

	private String[] titles = new String[]
			{ "pic1", "pic2", "pic3", "pic4", "pic5", "pic6", "pic7", "pic8", "pic9"};

	private int[] images = new int[]{
			R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,
			R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,
			R.drawable.pic7,R.drawable.pic8,R.drawable.pic9
	};
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);		
			for(int i = 0; i<images.length;i++)
			{
				SeekModel questionModel = new SeekModel(titles[i],images[i]);
				mSeekModelGridViewList.add(questionModel);
			}
			HttpUtils.getJSON(GET_JSON_URL_INDEX,getJSONHandlerUserMessage); 	
	}
}
