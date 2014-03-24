package com.genius.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CustomTabDemoActivity extends Activity {
    /** Called when the activity is first created. */
    

	private Button btn1;
	
	private Button btn2;
	
	private Button btn3;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        init();
    }
    
    private void init()
    {
    	btn1 = (Button) findViewById(R.id.button1);
    	btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CustomTabDemoActivity.this, CustomTabActivity1.class);
			
				startActivity(intent);
				//overridePendingTransition(R.anim.translucent_enter, R.anim.translucent_exit);
			}
		});
    	
    	btn2 = (Button) findViewById(R.id.button2);
    	btn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CustomTabDemoActivity.this, CustomTabActivity2.class);
				startActivity(intent);
				overridePendingTransition(R.anim.translucent_enter, R.anim.translucent_exit);
			}
		});
    	
    	btn3 = (Button) findViewById(R.id.button3);
    	btn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(CustomTabDemoActivity.this, CustomTabActivity3.class);
				startActivity(intent);
				overridePendingTransition(R.anim.translucent_enter, R.anim.translucent_exit);
			}
		});
    }
    
}