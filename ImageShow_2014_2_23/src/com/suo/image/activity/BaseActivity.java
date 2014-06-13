package com.suo.image.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class BaseActivity extends Activity {

	public SharedPreferences mShared;
	public SharedPreferences.Editor mEditor;
	public String yoyoShare;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		mShared = this.getSharedPreferences(yoyoShare, 0);
		mEditor = mShared.edit();
	}

	public boolean putString(final String entry, String value, boolean commit) {
        if(mEditor == null){
            return false;
        }
        mEditor.putString(entry.toString(), value);
        if(commit){
            return mEditor.commit();
        }
        return true;
    }
	
	public String getString(final String entry, String defaultValue) {
        if(mEditor == null){
            return defaultValue;
        }
        try{
            return mShared.getString(entry.toString(), defaultValue);
        }
        catch(Exception e){
            e.printStackTrace();
            return defaultValue;
        }
    }
	
	public boolean putInt(final String entry, int value, boolean commit) {
        if(mEditor == null){
            return false;
        }
        mEditor.putInt(entry.toString(), value);
        if(commit){
            return mEditor.commit();
        }
        return true;
    }
	
	public int getInt(final String entry, int defaultValue) {
        if(mEditor == null){
            return defaultValue;
        }
        try{
            return mShared.getInt(entry.toString(), defaultValue);
        }
        catch(Exception e){
            e.printStackTrace();
            return defaultValue;
        }
    }
	
	public void showToast(String msg)
	{
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
	
	public void showToast(int msg)
	{
		Toast.makeText(this, getString(msg), Toast.LENGTH_SHORT).show();
	}
	
	public void showLog(String msg)
	{
		Log.e("suo", "" + msg);
	}
}
