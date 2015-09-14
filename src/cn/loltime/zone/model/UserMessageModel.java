package cn.loltime.zone.model;

public class UserMessageModel {
	private String mUserIdString;
	private String mPassWordString;
	
	public UserMessageModel(String userid, String password){
		setUserId(userid);
		setPassWord(password);
	}
	public void setUserId(String userid)
	{
		this.mUserIdString = userid;
	}
	
	public void setPassWord(String password)
	{
		this.mPassWordString = password;
	}
	
	public String getUserId()
	{
		return this.mUserIdString;
	}
	
	public String getPassWord(){
		return this.mPassWordString;
	}
}
/*MianActivity
 * 
 * String title = xxoo;
 * String content = xxx;
 * IndexModel indexModel = new IndexModel(title, content);
 * list.add(indexModel);
 * 
 * 
 * */
