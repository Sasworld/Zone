package cn.loltime.zone.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.OutputStream; 
import java.io.InputStream;
import java.util.Map;
import java.io.IOException;
import java.net.URLEncoder;
import java.io.ByteArrayOutputStream;

public class PostHttpUtils {

    public static String submitPostData(String strUrlPath,Map<String, String> params, String encode) {
        
        byte[] data = getRequestData(params, encode).toString().getBytes();//���������
        try {            
 
            URL url = new URL(strUrlPath);  
             
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(3000);     //�������ӳ�ʱʱ��
            httpURLConnection.setDoInput(true);                  //�����������Ա�ӷ�������ȡ����
            httpURLConnection.setDoOutput(true);                 //����������Ա���������ύ����
            httpURLConnection.setRequestMethod("POST");     //������Post��ʽ�ύ����
            httpURLConnection.setUseCaches(false);               //ʹ��Post��ʽ����ʹ�û���
            //������������������ı�����
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            //����������ĳ���
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
            //�����������������д������
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);
            
            int response = httpURLConnection.getResponseCode();            //��÷���������Ӧ��
            if(response == HttpURLConnection.HTTP_OK) {
                InputStream inptStream = httpURLConnection.getInputStream();
                return dealResponseResult(inptStream);                     //�������������Ӧ���
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "-1";
    }
    

   public static StringBuffer getRequestData(Map<String, String> params, String encode) {
      StringBuffer stringBuffer = new StringBuffer();        //�洢��װ�õ���������Ϣ
      try {
            for(Map.Entry<String, String> entry : params.entrySet()) {
                stringBuffer.append(entry.getKey())
                      .append("=")
                      .append(URLEncoder.encode(entry.getValue(), encode))
                      .append("&");
            }
           stringBuffer.deleteCharAt(stringBuffer.length() - 1);    //ɾ������һ��"&"
        } catch (Exception e) {
           e.printStackTrace();
       }
       return stringBuffer;
    }
    

   public static String dealResponseResult(InputStream inputStream) {
      String resultData = null;      //�洢������
       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] data = new byte[1024];
      int len = 0;
       try {
          while((len = inputStream.read(data)) != -1) {
             byteArrayOutputStream.write(data, 0, len);
          }
     } catch (IOException e) {
         e.printStackTrace();
         
        }
       resultData = new String(byteArrayOutputStream.toByteArray());    
       return resultData;
   }    
    
   
}