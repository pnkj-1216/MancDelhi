package com.rcdu.medu.common;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;


public class MyRootActivity extends Activity
{
    private static ArrayList<Activity> activities=new ArrayList<Activity>();


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        activities.add(this);
    }
    
   /* @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	// TODO Auto-generated method stub
    	super.onConfigurationChanged(newConfig);
    	if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
    		Log.e("Sahil","Portrait mode activated");
    	}
    	if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
    	{
    		Log.e("Sahil","Landscape mode activated");
    	}
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onRestoreInstanceState(savedInstanceState);
    }
*/
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        activities.remove(this);
    }

    public static void finishAll()
    {
        for(Activity activity:activities)
           activity.finish();
    }
}