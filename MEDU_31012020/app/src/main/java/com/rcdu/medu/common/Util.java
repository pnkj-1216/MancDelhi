package com.rcdu.medu.common;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {
	Context context;
	TelephonyManager mTelephony;

	private final int REQUEST_READ_CONTACTS=0;

	public Util(Context context) {
		this.context = context;
	}

//	public String imei() {
//		TelephonyManager telephonyManager = (TelephonyManager) context
//				.getSystemService(Context.TELEPHONY_SERVICE);
//
//		return telephonyManager.getDeviceId();
//
//	}

	public String imei() {
//    TelephonyManager telephonyManager = (TelephonyManager) context
//          .getSystemService(Context.TELEPHONY_SERVICE);
//
//    return telephonyManager.getDeviceId();
		checkPermission();
		//populateAutoComplete();

		//
		mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);


		//return "352313076709477";
		return mTelephony.getDeviceId();

	}
	public boolean checkPermission() {
		int currentAPIVersion = Build.VERSION.SDK_INT;
		if (currentAPIVersion >= android.os.Build.VERSION_CODES.M) {
			if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
				if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_PHONE_STATE)) {
					AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
					alertBuilder.setCancelable(true);
					alertBuilder.setTitle("Permission necessary");
					alertBuilder.setMessage("Click allow to give permission...");
					alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
						//@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
						public void onClick(DialogInterface dialog, int which) {
							ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_CONTACTS);
						}
					});
					AlertDialog alert = alertBuilder.create();
					alert.show();
				} else {
					ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_CONTACTS);
				}
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

//
//	public int getdiff() {
//
//		String dat = "";
//		try {
//			// DataManipulate dmpluate = new DataManipulate(context);
//			DataBaseManipulate dmpluate = new DataBaseManipulate(context);
//			Cursor cursordate = dmpluate.check_status_date();
//			if (cursordate != null) {
//				if (cursordate.moveToFirst()) {
//					do {
//						dat = cursordate.getString(cursordate
//								.getColumnIndex("attn_status"));
//
//					} while (cursordate.moveToNext());
//				} else {
//					dat = Validation.getDate();
//				}
//			} else {
//				dat = Validation.getDate();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		// ////////////////////////
//		String dateStart = Validation.getDate();
//		String dateStop = dat;
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Date d1 = null;
//		Date d2 = null;
//
//		try {
//			d1 = format.parse(dateStart);
//		} catch (java.text.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		try {
//			d2 = format.parse(dateStop);
//		} catch (java.text.ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		int datediff = getDiffdate(d1, d2);
//		// ////
//		return datediff;
//	}

	public static int getDiffdate(Date first, Date last) {
		Calendar a = getCalendar(first);
		Calendar b = getCalendar(last);
		int diff = b.get(Calendar.DATE) - a.get(Calendar.DATE);
		int fistdate = a.get(Calendar.DAY_OF_YEAR);
		int seconddate = b.get(Calendar.DAY_OF_YEAR);
		if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
			diff--;

		} else {
			diff = seconddate - fistdate;
		}

		return diff;
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.US);
		cal.setTime(date);
		return cal;
	}

	public int getStringDiffDate(String currentdate1, String Date2) {
		String dateStart = currentdate1;
		String dateStop = Date2;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = format.parse(dateStart);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		try {
			d2 = format.parse(dateStop);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		int datediff = getDiffdate(d1, d2);

		return datediff;

	}

	public static int getDiffYears(Date first, Date last) {
		Calendar a = getCalendar(first);
		Calendar b = getCalendar(last);
		int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
		if (a.get(Calendar.DAY_OF_YEAR) > b.get(Calendar.DAY_OF_YEAR)) {
			diff--;
		}
		return diff;
	}
}