package cn.loltime.zone.model;

public class SeekModel {
	
	private String mTitleString;
	private int mImageId;

	public SeekModel(String title,int imageId)
	{
		super();
		this.mTitleString = title;
		this.mImageId = imageId;
	}
	
	public void setTitle(String title)
	{
		this.mTitleString = title;
	}
	
	public String getTitle()
	{
		return mTitleString;
	}
	
	public int getImageId()
	{
		return mImageId;
	}
	
	public void setImageId(int imageId)
	{
		this.mImageId = imageId;
	}

}
