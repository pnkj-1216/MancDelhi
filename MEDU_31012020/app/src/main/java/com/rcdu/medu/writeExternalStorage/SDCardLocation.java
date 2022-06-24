package com.rcdu.medu.writeExternalStorage;

import android.app.Activity;
import android.text.format.Time;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class SDCardLocation extends Activity {
	private static String stackString;

	public static String SD(Exception e) {
		try {
			Time today = new Time(Time.getCurrentTimezone());
			today.setToNow();
			String msg = today.format("%k-%M-%S");

			File mydir = new File("/sdcard/DS_Errors");
			mydir.mkdir();
			String str = "/sdcard/DS_Errors/" + msg + ".txt";

			stackString = Log.getStackTraceString(e);
			File myFile = new File(str);

			myFile.createNewFile();

			FileOutputStream fOut = new FileOutputStream(myFile);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			myOutWriter.append(stackString);
			myOutWriter.close();
			fOut.close();
		} catch (Exception ex)
		{

		}
		return stackString;

	}

}
