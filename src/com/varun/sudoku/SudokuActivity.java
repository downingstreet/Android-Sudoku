package com.varun.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;



public class SudokuActivity extends Activity implements OnClickListener {
	private static final String TAG = "Sudoku";
	MediaPlayer logoMusic;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //click listeners for the buttons
        
        View continueButton = findViewById(R.id.continue_button);
        continueButton.setOnClickListener(this);
        
        View newButton = findViewById(R.id.new_button);
        newButton.setOnClickListener(this);
        
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
        
        View exitButton = findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
        
        
    
    }
    
    @Override
    protected void onResume() {
       super.onResume();
       Music.play(this, R.raw.menu);
    }

    @Override
    protected void onPause() {
       super.onPause();
       Music.stop(this);
    }
    

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			
		case R.id.continue_button:
			startGame(Game.DIFFICULTY_CONTINUE);
			break;
			
			case R.id.about_button:
							startActivity(new Intent(this,About.class));
							break;
			case R.id.new_button:
							openNewGameDialog();
							break;
			case R.id.exit_button:
		         finish();
		         break;
		}
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		
		case R.id.settings:
							startActivity(new Intent(this, Prefs.class));
								return true;
		}
		
		return false;
	}

	
	//choose difficulty level
	private void openNewGameDialog() {
	      new AlertDialog.Builder(this)
	           .setTitle(R.string.new_game_title)
	           .setItems(R.array.difficulty,
	            new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialoginterface,
	                     int i) {
	                  startGame(i);
	               }
	            })
	           .show();
	   }
		
	private void startGame(int i){
		Log.d(TAG,"clicked on" + i);
		Intent intent = new Intent(SudokuActivity.this,Game.class);
		intent.putExtra(Game.KEY_DIFFICULTY, i);
		startActivity(intent);
	}
			
}
	

