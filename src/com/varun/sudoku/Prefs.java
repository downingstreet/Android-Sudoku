package com.varun.sudoku;

import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.content.Context;
import android.os.Bundle;
public class Prefs extends PreferenceActivity{
	
	private static final String OPT_MUSIC = "music" ;
	private static final boolean OPT_MUSIC_DEF = true;
	private static final String OPT_HINTS = "hints" ;
	private static final boolean OPT_HINTS_DEF = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}
	
	//current value of music
	public static boolean getMusic(Context context){
		return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(OPT_MUSIC, OPT_MUSIC_DEF);
	}
	//current value of hints
	public static boolean getHints(Context context){
		return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(OPT_HINTS, OPT_HINTS_DEF);
		
	}
	
}
