package cn.loltime.zone.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Handler;
import android.os.Message;

public class HttpUtils {
	public static  void getJSON(final String url, final Handler handler){		
		new Thread(new Runnable() {
			@Override
			public void run() {			
				HttpURLConnection conn;
				InputStream is;
				try {
					conn = (HttpURLConnection) new URL(url).openConnection();
					conn.setRequestMethod("GET");
					is = conn.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(is));
					String line = "";
					StringBuilder result = new StringBuilder();
					while ( (line = reader.readLine()) != null ){
						result.append(line);
					}
					Message msg = new Message();
					msg.obj = result.toString();
					handler.sendMessage(msg);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}).start();
	}
	
}












