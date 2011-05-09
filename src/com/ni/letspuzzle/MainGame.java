package com.ni.letspuzzle;

import java.sql.Date;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainGame extends Activity {
	AnimationDrawable animation;
	Button easy,medium,hard,exit;
	public static long startTime1,startTime2,startTime3;
	public Date d1,d2,d3;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
     
        easy=(Button)findViewById(R.id.Easy);
        medium=(Button)findViewById(R.id.Medium);
        hard=(Button)findViewById(R.id.Hard);
        exit=(Button)findViewById(R.id.Exit);
        
        Handler mHandler = new Handler();
      easy.setOnClickListener(new OnClickListener() {
			
			public void onClick(final View v) {
				 
				    	   startAnimation();
				           //LAUNCH NEW ACTIVITY HERE
				          Intent intent = new Intent(v.getContext(),EasyLevel.class);
							startActivity(intent);
							d1= new Date(0);
							startTime1=d1.getTime();
							
							Log.i("Start Time---------->>>>>>>.", ""+startTime1);
				       }	    
				 });
				/*//Intent		
				Intent intent = new Intent(v.getContext(),EasyLevel.class);
				startActivity(intent);
				d1= new Date(0);
				startTime1=d1.getTime();
				
				Log.i("Start Time---------->>>>>>>.", ""+startTime1);*/
			
		
        medium.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				
				startAnimation1();
				//Intent  
				Intent intent = new Intent(v.getContext(),MediumLevel.class);
				startActivity(intent);
				d2= new Date(0);
				startTime2=d2.getTime();
				Log.i("Start Time of Medium level---------->>>>>>>.", ""+startTime2);
			}
		});
       
        hard.setOnClickListener(new OnClickListener() {
			
            public void onClick(View v) {
            	startAnimation2();
				//Intent  
				Intent intent = new Intent(v.getContext(),HardLevel.class);
				startActivity(intent);
				d3= new Date(0);
				startTime3=d3.getTime();
				Log.i("Start Time of hard---------->>>>>>>.", ""+startTime3);
			}
		});
        exit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				tost();
				finish();
			}
		});
	}
public void tost()
{
	Toast.makeText(this, "Your application has been closing...", Toast.LENGTH_LONG).show();
}
class Starter implements Runnable {
    // UI Runnable
    public void run() {
        animation.start();
        
    }
}
private void startAnimation() 
{
  
    animation = new AnimationDrawable();
    
    animation.addFrame(getResources().getDrawable(R.drawable.easss),200);
    animation.addFrame(getResources().getDrawable(R.drawable.easy2),200);
    animation.addFrame(getResources().getDrawable(R.drawable.easss),200);
    animation.addFrame(getResources().getDrawable(R.drawable.easy3),200);
    animation.addFrame(getResources().getDrawable(R.drawable.easss),200);
    animation.addFrame(getResources().getDrawable(R.drawable.easy2),200);
    animation.addFrame(getResources().getDrawable(R.drawable.easss),200);
    animation.addFrame(getResources().getDrawable(R.drawable.easy3),200);
    
    
    // 
    animation.setOneShot(false); 
    
    easy=(Button)findViewById(R.id.Easy);
    
    
    easy.setBackgroundDrawable(animation);
   
    
    // UI thread
    easy.post(new Starter());
    
}
private void startAnimation1() 
{
  
    animation = new AnimationDrawable();
    
    animation.addFrame(getResources().getDrawable(R.drawable.mediu), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.med2),150);
    animation.addFrame(getResources().getDrawable(R.drawable.mediu), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.med3), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.mediu), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.med2),150);
    animation.addFrame(getResources().getDrawable(R.drawable.mediu), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.med3), 150);
    
    
    // 
    animation.setOneShot(false); 
    
    medium=(Button)findViewById(R.id.Medium);
    
    
    medium.setBackgroundDrawable(animation);
   
    
    // UI thread
    medium.post(new Starter());
    
}
private void startAnimation2() 
{
  
    animation = new AnimationDrawable();
    
    animation.addFrame(getResources().getDrawable(R.drawable.hard2), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.hard11),150);
    animation.addFrame(getResources().getDrawable(R.drawable.hard2), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.hard3), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.hard2), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.hard11),150);
    animation.addFrame(getResources().getDrawable(R.drawable.hard2), 150);
    animation.addFrame(getResources().getDrawable(R.drawable.hard3), 150);
    
    
    // 
    animation.setOneShot(false); 
    
    hard=(Button)findViewById(R.id.Hard);
    
    
    hard.setBackgroundDrawable(animation);
   
    
    // UI thread
    hard.post(new Starter());
    
}

}


