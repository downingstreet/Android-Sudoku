package com.varun.sudoku;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
 
public class Splash extends Activity{
	
	MediaPlayer logoMusic;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		logoMusic = MediaPlayer.create(Splash.this, R.raw.intro);
		logoMusic.start();
		
		final ImageView spl = (ImageView) findViewById(R.id.splash);
		//spl.setOnClickListener(new OnClickListener(){
			//public void onClick(View arg0){
				Animation anim = AnimationUtils.loadAnimation(Splash.this, R.anim.animation);
				spl.startAnimation(anim);
		//	}
		//});
		
		Thread logoTimer = new Thread()
		{
			public void run()
			{
				try{
					sleep(6000); 
					Intent menuIntent = new Intent("com.varun.sudoku.MENU");
					startActivity(menuIntent);
				
				}	catch(InterruptedException e){
					e.printStackTrace();
				}
				
				finally{
					finish();
				}
			}
		};
		logoTimer.start();
		
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		logoMusic.release();
	}



	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	

}
