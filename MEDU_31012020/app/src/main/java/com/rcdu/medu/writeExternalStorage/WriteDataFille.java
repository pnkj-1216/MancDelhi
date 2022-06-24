package com.rcdu.medu.writeExternalStorage;

import android.os.Environment;

import com.rcdu.medu.common.Validation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WriteDataFille {
	private static String SYNC_FILE_PATH;
	static String date;
	static Date currentdate;
	public static String formattedDate = "";

	public static void writeData(String log) {
		String stackString;

		try {
			date = Validation.getDate();

			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
			formattedDate = df.format(c.getTime());

			currentdate = df.parse(String.valueOf(formattedDate));
			stackString = log;
			File mydir = new File(Environment.getExternalStorageDirectory()
					+ "/BaseProductData");
			if (!(mydir.exists())) {
				mydir.mkdir();
			}
			SYNC_FILE_PATH = Environment.getExternalStorageDirectory()
					+ "/BaseProductData/" + formattedDate + "sync.txt";
			File myFile = new File(SYNC_FILE_PATH);

			if (myFile.exists()) {

				FileWriter fileWritter = new FileWriter(myFile, true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.write(stackString);
				bufferWritter.close();

				System.out.println("done");

			} else {
				myFile.createNewFile();
				FileWriter fileWritter = new FileWriter(myFile, true);
				BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
				bufferWritter.write(stackString);
				bufferWritter.close();

				System.out.println("done");

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
