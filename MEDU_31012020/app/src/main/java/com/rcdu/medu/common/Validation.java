package com.rcdu.medu.common;

import android.content.Context;
import android.text.format.Time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Validation   {

    static Context con;
    private static final Validation ourInstance = new Validation();

    public static Validation getInstance() {
        return ourInstance;
    }


    public static String getDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        return formattedDate;

    }

    public static String getDate4() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String formattedDate = df.format(c.getTime());
        return formattedDate;

    }

    public static String getDate1() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = df.format(c.getTime());
        return formattedDate;

    }

    //	public static String balance_ki_date()
//	{
//		Calendar c = Calendar.getInstance();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String Balance_ki_date = df.format(c.getTime());
//		return Balance_ki_date;
//	
//		
//	}
    public static String getDate_deleteRecord() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;

    }

    public static String orderId() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static String timeUniqueId() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MMddhhmmss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static String timeStampUniqueID() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static String getCode() {
        Random random = new Random(System.nanoTime());
        int randomInt = random.nextInt(1000000000);
        String tini = "" + randomInt;
        // String tini=ini.substring(0,4);
        System.out.println("REC" + tini);
        return "Order" + tini;
    }

    public static String dateFormatmmyy1(int month, int year) {
        int month1 = month + 1;
        String monthstr = null;
        if (month1 < 10) {
            monthstr = "0" + "" + month1;
        } else {
            monthstr = "" + month1;
        }

        String date_format = monthstr + year;
        return date_format;
    }

    public static String getTime() {
        Time time = new Time(Time.getCurrentTimezone());
        time.setToNow();
        String attn_time = time.format("%k:%M:%S");
        return attn_time;
    }

    public static String dateFormat(int month, int day, int year) {
        int month1 = month + 1;
        String monthstr = null;
        if (month1 < 10) {
            monthstr = "0" + "" + month1;
        } else {
            monthstr = "" + month1;
        }
        String daystr = null;
        if (day < 10) {
            daystr = "0" + "" + day;
        } else {
            daystr = "" + day;
        }
        String date_format = year + "-" + monthstr + "-" + daystr;
        return date_format;
    }

    public static String dateFormatDdMmYy(int month, int day, int year) {
        int month1 = month + 1;
        String monthstr = null;
        if (month1 < 10) {
            monthstr = "0" + "" + month1;
        } else {
            monthstr = "" + month1;
        }
        String daystr = null;
        if (day < 10) {
            daystr = "0" + "" + day;
        } else {
            daystr = "" + day;
        }
        String date_format = daystr + "-" + monthstr + "-" + year;
        return date_format;
    }

    public static String dateFormatmmyy(int month, int year) {
        int month1 = month + 1;
        String monthstr = null;
        if (month1 < 10) {
            monthstr = "0" + "" + month1;
        } else {
            monthstr = "" + month1;
        }

        String date_format = monthstr + "-" + year;
        return date_format;
    }

    public static long getDays(Date mtp_date, Date curr_date){
        long diff = mtp_date.getTime() - curr_date.getTime();
        long days = diff / (24 * 60 * 60 * 1000);
        return days;
    }

    public static String getFirstDay(Date d) throws Exception
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date dddd = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        return sdf1.format(dddd);
    }

    public static String getLastDay(Date d) throws Exception
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date dddd = calendar.getTime();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        return sdf1.format(dddd);
    }

/*    public void showGPSDisabledAlertToUser(final Activity con) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(con);
        alertDialogBuilder.setMessage("GPS is disabled, for better performance please enable it !!!")
                .setCancelable(false)
                .setPositiveButton("Enable GPS",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent callGPSSettingIntent = new Intent(
                                        android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                con.startActivityForResult(callGPSSettingIntent, 1);
                            }
                        });

        alertDialogBuilder.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        con.finish();
                        dialog.cancel();
                    }
                });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }*/

    public static long getDiffernceMinute(String mtp_date, String curr_date){
        Date date1=null,date2=null;
        long days,hours,min;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        try {
            date1 = simpleDateFormat.parse(mtp_date );
            date2 = simpleDateFormat.parse( curr_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        long difference = date2.getTime() - date1.getTime();
        days = (int) (difference / (1000*60*60*24));
        hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
        min = (int) ((difference - (1000*60*60*24*days)) / (1000*60));
        hours = (hours < 0 ? -hours : hours);
//        long diff = mtp_date.getTime() - curr_date.getTime();
//        long days = diff / (24 * 60 * 60 * 1000);
        return min;
    }
    public static Date yesterdaydate() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    public static String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(yesterdaydate());
    }
}
