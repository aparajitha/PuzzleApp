package com.ni.letspuzzle;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class EasyLevel extends Activity {
    /** Called when the activity is first created. */
	
	private BlockEasy draw = null;
	
	MainGame mg=new MainGame();
	
	TextView tv;
	int ti=0;
	public Timer myTimer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.easy);
        draw = (BlockEasy) findViewById(R.id.draw);
        tv=(TextView)findViewById(R.id.timermain);
        
		myTimer = new Timer();
		myTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				TimerMethod();
			}

		}, 0, 1000);
        
        //timerCountDown(20);
    }
	private void TimerMethod()
	{
		//This method is called directly by the timer
		//and runs in the same thread as the timer.

		//We call the method that will work with the UI
		//through the runOnUiThread method.
		this.runOnUiThread(Timer_Tick);
	}
	private Runnable Timer_Tick = new Runnable() {
		public void run() {

		//This method runs in the same thread as the UI.    	       

		//Do something to the UI thread here
			
			tv.setText(""+ti+++"\tSecs");
			if(draw.count==1)
			{/*int dif;
			int a,b;
			a=(int)draw.endTime1;
			b=(int)mg.startTime1;
			dif=a-b;
				tost();
				Log.i("end", ""+a);
				Log.i("start", ""+b);
				Log.i("The Count1 Value is---------->>>>>>", ""+(a-b));*/
				finish();
				long diffInSeconds = (draw.endTime1-mg.startTime1 ) / 1000;

			    long diff[] = new long[] { 0, 0, 0, 0 };
			    /* sec */diff[3] = (diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
			    /* min */diff[2] = (diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds;
			    /* hours */diff[1] = (diffInSeconds = (diffInSeconds / 60)) >= 24 ? diffInSeconds % 24 : diffInSeconds;
			    System.out.println(String.format(
			            "You Have taken %d day%s, %d hour%s, %d minute%s, %d second%s to set The puzzle",
			            diff[0],
			            diff[0] > 1 ? "s" : "",
			            diff[1],
			            diff[1] > 1 ? "s" : "",
			            diff[2],
			            diff[2] > 1 ? "s" : "",
			            diff[3],
			            diff[3] > 1 ? "s" : ""));
			    tost();
				myTimer.cancel();
				tv.setText("win..."+ti);
				draw.setUpdateRunningAfterInited(true);
				//Thread.currentThread().destroy();

			}
			
			
			/*if(drawmedi.count1==1)
			{
				tost();
				m.tv1.setText("win..."+ti);
				myTimer.cancel();
				

			}*/
		}
	};
    @Override
    protected void onPause() {// 
    	draw.setUpdateRunningAfterInited(false);
    	super.onPause();
    }
    
    @Override
    protected void onResume() {
    	draw.setUpdateRunningAfterInited(true);
    	super.onResume();
    	
    }
        
            
    public void tost()
    {
    	Toast.makeText(this, "You have taken"+ti+"Seconds to set the puzzle", Toast.LENGTH_LONG).show();
    }

                  
}
