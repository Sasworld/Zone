package cn.loltime.zone;


import com.example.loginsuijidemo.R;
import cn.loltime.zone.adapter.SeekFragmentAdapter;
import cn.loltime.zone.fragment.IndexFragment;
import cn.loltime.zone.fragment.MineFragment;
import cn.loltime.zone.fragment.SeekFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class MasterActivity extends BaseActivity implements OnClickListener{
	//define fragment
	private IndexFragment mIndexFragment;   //主页面
	private SeekFragment  mSeekFragment;      //发现页面
	private MineFragment  mMineFragment; //个人中心页面
	
	private SeekFragmentAdapter mSeekFragmentAdapter;
	
	//define fragment view
	private View mIndexLayout;
	private View mSeekLayout;
	private View mMineLayout;
	 
	private FragmentManager mFragmentManager; //管理器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.master_layout);
        
        initViews();
        mFragmentManager = getFragmentManager();
        mSeekFragmentAdapter = new SeekFragmentAdapter(this,R.layout.seek_gridview_item,mSeekModelGridViewList);
		setTabSelection(0);
    }
    
    
    //加载布局 以及 控件的初始化
    public void initViews(){
    	mIndexLayout = findViewById(R.id.menu_item_index_layout);
    	mSeekLayout = findViewById(R.id.menu_item_seek_layout);
    	mMineLayout = findViewById(R.id.menu_item_mine_layout);
    
    	//设置监听事件
    	mIndexLayout.setOnClickListener(this);
    	mSeekLayout.setOnClickListener(this);
    	mMineLayout.setOnClickListener(this);
    }

    
    private void setTabSelection(int index) {  
   	  
       FragmentTransaction transaction = mFragmentManager.beginTransaction();  
       
       hideFragments(transaction);  
       switch (index) {  
       case 0:  
    	   if(mIndexFragment == null){	   	
    		mIndexFragment = new IndexFragment();
           	transaction.add(R.id.content, mIndexFragment);
           } else { 
               transaction.show(mIndexFragment);  
           }  
           break;
       case 1: 
           if (mSeekFragment == null) {  
               
        	   mSeekFragment = new SeekFragment();  
        	   mSeekFragment.getSeekFragmentAdapter(mSeekFragmentAdapter);
               transaction.add(R.id.content, mSeekFragment);  
           } else {  
               transaction.show(mSeekFragment);  
           }  
           break;  
       case 2:    
           if (mMineFragment == null) {  
        	   mMineFragment = new MineFragment();
               transaction.add(R.id.content, mMineFragment);  
           } else {  
               transaction.show(mMineFragment);  
           }  
           break;  
       default:
           	break;
       }  
       transaction.commit();  
   }

    private void hideFragments(FragmentTransaction transaction) {  
        if (mIndexFragment != null) {  
            transaction.hide(mIndexFragment);  
        } 
        if (mMineFragment != null) {  
            transaction.hide(mMineFragment);  
        }
        if (mSeekFragment != null) {  
            transaction.hide(mSeekFragment);  
        } 
        
    }
 
	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.menu_item_index_layout:
			setTabSelection(0);
			break;
		case R.id.menu_item_seek_layout:
			setTabSelection(1);
			break;
		case R.id.menu_item_mine_layout:
			setTabSelection(2);
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
	}

}
