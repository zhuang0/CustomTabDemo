package com.genius.demo;

import com.genius.demo.Constant.ConValue;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.AdapterView.OnItemClickListener;

public class CustomTabActivity3 extends ActivityGroup{

	
	private final static int INIT_EVENT = 0X100;
	
	private GridView mBottomGridView;  
	
	private GridViewAdapter mBottomGridViewAdapter;  
	
	private LinearLayout container;						// װ��sub Activity������  
	    
	private int mCurTab;
	    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_tab_layout3);
        
   
        
        init();
    }
	  
	private void init()
	{
		container = (LinearLayout) findViewById(R.id.Container);
		mBottomGridView = (GridView) findViewById(R.id.bottom_tab);
   
		mBottomGridViewAdapter = new GridViewAdapter(this, ConValue.mImageViewArray, ConValue.mTextviewArray);
		mBottomGridView.setAdapter(mBottomGridViewAdapter);
		mBottomGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				switchActivity(position);
			}
		});
		

		
		Handler mHandler = new Handler()
		{

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				switch(msg.what)
				{
				case INIT_EVENT:
					switchActivity(0);
					break;
				}
			}
			
		};
		
		mCurTab = -1;
		mHandler.sendEmptyMessageDelayed(INIT_EVENT, 100);
	}
	
	
	

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		
		if (this.getResources().getConfiguration().orientation  
				== Configuration.ORIENTATION_LANDSCAPE) { 
			//��ǰΪ������ �ڴ˴���Ӷ���Ĵ������ 
			
			for(int i = 0; i < ConValue.mTabClassArray.length; i++)
			{
				mBottomGridView.getChildAt(i).setBackgroundDrawable(null);
			}

			mBottomGridView.getChildAt(ConValue.mTabClassArray.length - 1 - mCurTab).setBackgroundResource(R.drawable.tab_item_d);
		} 
		else if (this.getResources().getConfiguration().orientation  
				== Configuration.ORIENTATION_PORTRAIT) { 
			//��ǰΪ������ �ڴ˴���Ӷ���Ĵ������ 
			
			for(int i = 0; i < ConValue.mTabClassArray.length; i++)
			{
				mBottomGridView.getChildAt(i).setBackgroundDrawable(null);
			}

			mBottomGridView.getChildAt(ConValue.mTabClassArray.length - 1 - mCurTab).setBackgroundResource(R.drawable.tab_item_d);
		} 

		
	}

	private void switchActivity(int index)
	{
		if (index < 0 || index >= ConValue.mTabClassArray.length)
		{
			return ;
		}
		
		if (mCurTab == index)
		{
			return ;
		}


		if (mCurTab != -1)
		{
			mBottomGridView.getChildAt(mCurTab).setBackgroundDrawable(null);
		}		
		mBottomGridView.getChildAt(index).setBackgroundResource(R.drawable.tab_item_d);
		mCurTab = index;

        container.removeAllViews();			  
        Intent intent = new Intent(this, ConValue.mTabClassArray[index]);
        
        String name = index + " subactivity";
        //Activity תΪ View  
        Window subActivity = getLocalActivityManager().startActivity(name, intent);
        
        //�������View  
        container.addView(subActivity.getDecorView());  
	}
	
}
