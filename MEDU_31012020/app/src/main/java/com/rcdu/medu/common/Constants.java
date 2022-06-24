package com.rcdu.medu.common;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.format.Time;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.rcdu.medu.R;
import com.rcdu.medu.connectivity.NetworkUtils;
import com.rcdu.medu.writeExternalStorage.WriteDataFille;
import com.google.android.material.snackbar.Snackbar;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Constants {
    public static final String KEY = "order_key";
    public static final String TAG = "demo";




    private static Dialog dialog = null;
    public static String finish_call_server = "/webservice/WebService.php/FinishedCallServer";
    public static final String MyPREFERENCES = "MyPrefs";
    private static final String DATABASE_NAME = "baseProduct.sqlite";
    private static final String DATABASE_NAME12 = "Attandence_Managment_System.db";
    public static final String CHECK_INTERNET = "Please check your Internet";
    public static final String NO_DATA_FOUND = "No Data Found !";
    public static final String SOMETHING_WENT_WRONG = "Something went wrong !";
    public static final String RETAILER_ID = "retailer_id";
    private static final String TITLE_INFO = "Info !";
    private static final String TITLE_ALERT = "Alert !";
    private static final String MESSAGE_NO_INTERNET = "No internet connection found !";

    public static final String MTP_SYNC_SUCCESS = "Data Sync Successfully !";
    public static final String YES = "Y";
    public static final String ERROR_RESPONSE = "Error Response";
    public static final String HEADER_ACCEPT = "application/json";

    public static void setPrefrence(Context context, String key, String value) {
        SharedPreferences prefrence = context.getSharedPreferences(
                MyPREFERENCES, 0);
        Editor editor = prefrence.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPrefrence(Context context, String key) {
        SharedPreferences prefrence = context.getSharedPreferences(
                MyPREFERENCES, 0);
        return prefrence.getString(key, "");
    }

    public static void clearpreference(Context context, String key) {
        SharedPreferences prefrence = context.getSharedPreferences(MyPREFERENCES, 0);
        prefrence.edit().remove(key).commit();

    }

    public static boolean isMyServiceRunning(Context mContext, Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }


    // Image rotation
    public static Bitmap handleRotationBitmap(Context context, Uri selectedImage)
            throws IOException {
        int MAX_HEIGHT = 1024;
        int MAX_WIDTH = 1024;

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream imageStream = context.getContentResolver().openInputStream(selectedImage);
        BitmapFactory.decodeStream(imageStream, null, options);
        imageStream.close();

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, MAX_WIDTH, MAX_HEIGHT);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        imageStream = context.getContentResolver().openInputStream(selectedImage);
        Bitmap img = BitmapFactory.decodeStream(imageStream, null, options);

        img = rotateImageIfRequired(img, selectedImage);
        return img;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options,
                                             int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and width
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;

            final float totalPixels = width * height;

            // Anything more than 2x the requested pixels we'll sample down further
            final float totalReqPixelsCap = reqWidth * reqHeight * 2;

            while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {
                inSampleSize++;
            }
        }
        return inSampleSize;
    }


    private static Bitmap rotateImageIfRequired(Bitmap img, Uri selectedImage) throws IOException {

        ExifInterface ei = new ExifInterface(selectedImage.getPath());
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        switch (orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                return rotateImage(img, 90);
            case ExifInterface.ORIENTATION_ROTATE_180:
                return rotateImage(img, 180);
            case ExifInterface.ORIENTATION_ROTATE_270:
                return rotateImage(img, 270);
            default:
                return img;
        }
    }

    public static Bitmap rotateImage(Bitmap img, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, img.getWidth(), img.getHeight(), matrix, true);
        img.recycle();
        return rotatedImg;
    }
// End code image rotation

    public static Bitmap setPic(String mCurrentPhotoPath) {
        // Get the dimensions of the View
        int targetW = 200;
        int targetH = 250;

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

        return BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
    }

    public static double distFrom(double lat1, double lng1, double lat2,
                                  double lng2) {
        double earthRadius = 6371;// 3958.75 miles;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLng = Math.toRadians(lng2 - lng1);
        double lat1R = Math.toRadians(lat1);
        double lat2R = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLng / 2)
                * Math.sin(dLng / 2) * Math.cos(lat1R) * Math.cos(lat2R);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = earthRadius * c;

        double meterConversion = 1000.0;
        double result = dist * meterConversion;
        return result;
    }

    public static String msToString(long ms) {
        long totalSecs = ms / 1000;
        long hours = (totalSecs / 3600);
        long mins = (totalSecs / 60) % 60;
        long secs = totalSecs % 60;
        String minsString = (mins == 0) ? "00" : ((mins < 10) ? "0" + mins : ""
                + mins);
        String secsString = (secs == 0) ? "00" : ((secs < 10) ? "0" + secs : ""
                + secs);
        if (hours > 0)
            return hours + ":" + minsString + ":" + secsString;
        else if (mins > 0)
            return mins + ":" + secsString;

        return ":" + secsString;
    }

    public static ArrayList<HashMap<String, String>> getArrayList(Cursor cursor) {
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String, String>>();
        if (cursor != null) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                for (int j = 0; j < cursor.getColumnCount(); j++) {
                    String name = cursor.getColumnName(j);
                    String value = cursor.getString(j);
                    hashMap.put(name, value);
                }
                arrayList.add(hashMap);
                cursor.moveToNext();
            }
            // write(arrayList.toString());
        } else {
            System.out.println("Null cursor found");
        }
        return arrayList;
    }

    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static void write(String message) {
        try {
            System.out.println(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            if (activity != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) activity
                        .getSystemService(Activity.INPUT_METHOD_SERVICE);
                View v = activity.getCurrentFocus();
                if (v != null) {
                    IBinder binder = activity.getCurrentFocus()
                            .getWindowToken();
                    if (binder != null) {
                        inputMethodManager.hideSoftInputFromWindow(binder, 0);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showSoftKeyboard(Context mContext) {
        InputMethodManager imm = (InputMethodManager) mContext
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    // For Posting File to Server
    public static String postFile(String TAG, String IMEI) {
        String result = "";
        try {

            String textFile = Environment.getExternalStorageDirectory()
                    + "/BaseProductData/sync.txt";
            String postReceiverUrl = Variables.main_url + "sync.php?imei="
                    + IMEI;

            HttpClient httpClient = new DefaultHttpClient();

            // post header
            HttpPost httpPost = new HttpPost(postReceiverUrl);

            File file = new File(textFile);
            file.setReadable(true);
            file.setWritable(true);

            MultipartEntity reqEntity = new MultipartEntity(
                    HttpMultipartMode.BROWSER_COMPATIBLE);
            reqEntity.addPart("syncfile", new FileBody(file, "text/plain"));
            httpPost.setEntity(reqEntity);

            // execute HTTP post request
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();

            if (resEntity != null) {

                String responseStr = EntityUtils.toString(resEntity).trim();
                result = responseStr;

                Log.i(TAG, "Response: " + responseStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getMcc_Mnc_Lac_CellId(Context context) {
        String result = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            String networkOperator = telephonyManager.getNetworkOperator();
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return result;
            }
            GsmCellLocation cellLocation = (GsmCellLocation) telephonyManager
                    .getCellLocation();

            if (cellLocation != null) {
                int cellid = cellLocation.getCid();
                int lac = cellLocation.getLac();
                int mcc = Integer.parseInt(networkOperator.substring(0, 3));
                int mnc = Integer.parseInt(networkOperator.substring(3));

                result = "" + mcc + ":" + mnc + ":" + lac + ":" + cellid;
            } else {
                result = "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "false";
        }
        return result;
    }

//    public static void exportDB(Context mContext) {
//        if (Build.VERSION.SDK_INT >= 23) {
//            if (ContextCompat.checkSelfPermission(mContext,
//                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                    == PackageManager.PERMISSION_GRANTED) {
//                File sd = new File(Environment.getExternalStoragePublicDirectory("") +
//                        File.separator + "DSSpiceCo_Backup" +
//                        File.separator);
//
//                boolean success = true;
//                if (!sd.exists()) {
//                    success = sd.mkdir();
//                }
//
//                if (success) {
//                    File data = Environment.getDataDirectory();
//                    FileChannel source;
//                    FileChannel destination;
//                    String currentDBPath = "/data/" + mContext.getPackageName() + "/databases/" + DATABASE_NAME12;
//                    File currentDB = new File(data, currentDBPath);
//                    File backupDB = new File(sd, DATABASE_NAME12);
//                    try {
//                        source = new FileInputStream(currentDB).getChannel();
//                        destination = new FileOutputStream(backupDB).getChannel();
//                        destination.transferFrom(source, 0, source.size());
//                        source.close();
//                        destination.close();
//                        Toast.makeText(mContext, "Backup Database Successful", Toast.LENGTH_SHORT).show();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            } else {
//                ActivityCompat.requestPermissions((Activity) mContext,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 9011);
//            }
//        } else { //permission is automatically granted on sdk<23 upon installation
//            File sd = new File(Environment.getExternalStoragePublicDirectory("") +
//                    File.separator + "DSSpiceCo_Backup" +
//                    File.separator);
//
//            boolean success = true;
//            if (!sd.exists()) {
//                success = sd.mkdir();
//            }
//
//            if (success) {
//                File data = Environment.getDataDirectory();
//                FileChannel source;
//                FileChannel destination;
//                String currentDBPath = "/data/" + mContext.getPackageName() + "/databases/" + DATABASE_NAME12;
//                File currentDB = new File(data, currentDBPath);
//                File backupDB = new File(sd, DATABASE_NAME12);
//                try {
//                    source = new FileInputStream(currentDB).getChannel();
//                    destination = new FileOutputStream(backupDB).getChannel();
//                    destination.transferFrom(source, 0, source.size());
//                    source.close();
//                    destination.close();
//                    Toast.makeText(mContext, "Backup Database Successful", Toast.LENGTH_SHORT).show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public static void exportDB(Context mContext) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(mContext,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                File sd = new File(Environment.getExternalStorageDirectory() +
                        File.separator + "msell", "BackupDatabase");

                boolean success = true;
                if (!sd.exists()) {
                    success = sd.mkdirs();
                }

                if (success) {
                    File data = Environment.getDataDirectory();
                    FileChannel source;
                    FileChannel destination;
                    String currentDBPath = "/data/" + mContext.getPackageName() + "/databases/" + DATABASE_NAME;
                    File currentDB = new File(data, currentDBPath);
                    File backupDB = new File(sd, DATABASE_NAME);
                    try {
                        source = new FileInputStream(currentDB).getChannel();
                        destination = new FileOutputStream(backupDB).getChannel();
                        destination.transferFrom(source, 0, source.size());
                        source.close();
                        destination.close();
                        Toast.makeText(mContext, "Backup Database Successful", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(mContext, "Something went wrong !!!", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                ActivityCompat.requestPermissions((Activity) mContext,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 9011);
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            File sd = new File(Environment.getExternalStorageDirectory() +
                    File.separator + "msell", "BackupDatabase");

            boolean success = true;
            if (!sd.exists()) {
                success = sd.mkdir();
            }

            if (success) {
                File data = Environment.getDataDirectory();
                FileChannel source;
                FileChannel destination;
                String currentDBPath = "/data/" + mContext.getPackageName() + "/databases/" + DATABASE_NAME;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, DATABASE_NAME);
                try {
                    source = new FileInputStream(currentDB).getChannel();
                    destination = new FileOutputStream(backupDB).getChannel();
                    destination.transferFrom(source, 0, source.size());
                    source.close();
                    destination.close();
                    Toast.makeText(mContext, "Backup Database Successful", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void exportDB1(Context mContext) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ContextCompat.checkSelfPermission(mContext,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                File sd = new File(Environment.getExternalStorageDirectory() +
                        File.separator + "msell", "BackupDatabase");

                boolean success = true;
                if (!sd.exists()) {
                    success = sd.mkdirs();
                }

                if (success) {
                    File data = Environment.getDataDirectory();
                    FileChannel source;
                    FileChannel destination;
                    String currentDBPath = "/data/" + mContext.getPackageName() + "/databases/" + DATABASE_NAME;
                    File currentDB = new File(data, currentDBPath);
                    File backupDB = new File(sd, DATABASE_NAME);
                    try {
                        source = new FileInputStream(currentDB).getChannel();
                        destination = new FileOutputStream(backupDB).getChannel();
                        destination.transferFrom(source, 0, source.size());
                        source.close();
                        destination.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                ActivityCompat.requestPermissions((Activity) mContext,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 9011);
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            File sd = new File(Environment.getExternalStorageDirectory() +
                    File.separator + "msell", "BackupDatabase");

            boolean success = true;
            if (!sd.exists()) {
                success = sd.mkdir();
            }

            if (success) {
                File data = Environment.getDataDirectory();
                FileChannel source;
                FileChannel destination;
                String currentDBPath = "/data/" + mContext.getPackageName() + "/databases/" + DATABASE_NAME;
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, DATABASE_NAME);
                try {
                    source = new FileInputStream(currentDB).getChannel();
                    destination = new FileOutputStream(backupDB).getChannel();
                    destination.transferFrom(source, 0, source.size());
                    source.close();
                    destination.close();
                    Toast.makeText(mContext, "Backup Database Successful", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void importDB(Context mContext) {
        File sd = new File(Environment.getExternalStorageDirectory() +
                File.separator + "msell", "BackupDatabase");
        File data = Environment.getDataDirectory();
        FileChannel source;
        FileChannel destination;
        String backupDBPath = "/data/" + mContext.getPackageName() + "/databases/" + DATABASE_NAME;
        File currentDB = new File(sd, DATABASE_NAME);
        File backupDB = new File(data, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
            Toast.makeText(mContext, "Import Database Successful", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // New Methods
    public static String backupDatabase() {
        String result = "false";
        try {
            File sd = Environment.getExternalStorageDirectory();

            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//manacle.msell//databases//baseProduct.sqlite";
                String backupDBPath = "baseProduct.sqlite";

                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);
                boolean a = currentDB.exists();
                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB)
                            .getChannel();
                    FileChannel dst = new FileOutputStream(backupDB)
                            .getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                    result = "true";

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "false";
        }
        return result;
    }

    public static String importDatabase() {
        String result = "false";
        try {
            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = "//data//manacle.msell//databases//baseProduct.sqlite";
                String backupDBPath = "baseProduct.sqlite";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(backupDB)
                            .getChannel();

                    FileChannel dst = new FileOutputStream(currentDB)
                            .getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();

                    File file = new File(sd, backupDBPath);
                    file.delete();
                    result = "true";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "false";
        }
        return result;
    }


    public static void DataConnectionOn(Context context, boolean enabled) {
        int androidSDKVersion = Build.VERSION.SDK_INT;
        try {
            if (androidSDKVersion == Build.VERSION_CODES.FROYO) {
                Method dataConnSwitchmethod;
                Class<?> telephonyManagerClass;
                Object ITelephonyStub;
                Class<?> ITelephonyClass;

                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                telephonyManagerClass = Class.forName(telephonyManager.getClass().getName());
                Method getITelephonyMethod = telephonyManagerClass.getDeclaredMethod("getITelephony");
                getITelephonyMethod.setAccessible(true);
                ITelephonyStub = getITelephonyMethod.invoke(telephonyManager);
                ITelephonyClass = Class.forName(ITelephonyStub.getClass().getName());

                if (enabled) {
                    dataConnSwitchmethod = ITelephonyClass.getDeclaredMethod("enableDataConnectivity");
                } else {
                    dataConnSwitchmethod = ITelephonyClass.getDeclaredMethod("disableDataConnectivity");
                }

                Log.e("In Second If", "in first if");
                dataConnSwitchmethod.setAccessible(true);
                dataConnSwitchmethod.invoke(ITelephonyStub);
            } else if (androidSDKVersion == Build.VERSION_CODES.JELLY_BEAN) {
                // For android version 4.1.2 Api level 16
                final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                final Class<?> conmanClass = Class.forName(conman.getClass().getName());
                Log.e("In Second If", "in second if");
                final Method setMobileDataEnabledMethod = conmanClass.getMethod("setMobileDataEnabled", Boolean.TYPE);
                setMobileDataEnabledMethod.setAccessible(true);
                setMobileDataEnabledMethod.invoke(conman, enabled);
            } else {
                // App running on Ginger bread+");
                final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                final Class<?> conmanClass = Class.forName(conman.getClass().getName());
                final Field iConnectivityManagerField = conmanClass.getDeclaredField("mService");
                iConnectivityManagerField.setAccessible(true);
                Log.e("In Second If", "in third if");

                final Object iConnectivityManager = iConnectivityManagerField.get(conman);

                final Class<?> iConnectivityManagerClass = Class.forName(iConnectivityManager.getClass().getName());
                final Method setMobileDataEnabledMethod = iConnectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);

                setMobileDataEnabledMethod.setAccessible(true);
                setMobileDataEnabledMethod.invoke(iConnectivityManager, enabled);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void setMobileDataEnabled(Context context, boolean enabled) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final ConnectivityManager conman = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final Class conmanClass = Class.forName(conman.getClass().getName());
        final Field connectivityManagerField = conmanClass.getDeclaredField("mService");
        connectivityManagerField.setAccessible(true);
        Log.e("In new if", "In new if");
        final Object connectivityManager = connectivityManagerField.get(conman);
        final Class connectivityManagerClass = Class.forName(connectivityManager.getClass().getName());
        final Method setMobileDataEnabledMethod = connectivityManagerClass.getDeclaredMethod("setMobileDataEnabled", Boolean.TYPE);
        setMobileDataEnabledMethod.setAccessible(true);
        setMobileDataEnabledMethod.invoke(connectivityManager, enabled);
    }

    //Show location Method for Location :-
    public static String showLocationString(double latitude, double longitude,
                                            Context mContext) {
        String result = "N/A";
        String addessline = "", addesslocal = "", postal = "", countryname = "";
        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());

            List<Address> addresses = geocoder.getFromLocation(latitude,
                    longitude, 1);

            if (addresses != null && addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();

                result = address + "," + city + "," + state + "," + country + "," + postalCode;
                result = result.replaceAll("\"", " ");
                result = result.replaceAll("[^a-zA-Z0-9 ,]", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = "N/A";

        }
        return result;
    }

    //result = sb.toString();
/*
    public static String showLocationString(double latitude, double longitude,
                                            Context mContext) {
        String result = "$$";
        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());

            List<Address> addressList = geocoder.getFromLocation(latitude,
                    longitude, 1);
            if (addressList != null && addressList.size() > 0) {
                Address address = addressList.get(0);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
                    sb.append(address.getAddressLine(i)).append(",");
                }
                sb.append(address.getLocality()).append(",");
                // sb.append(address.getPostalCode()).append("\n");
                sb.append(address.getCountryName());
                result = sb.toString();

                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = "$$";
        }
        return result;
    }*/

    public static void showSettingsAlert(final Context mContext) {
        dialog = new Dialog(mContext, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.setCancelable(false);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;

        dialog.getWindow().setAttributes(layoutParams);

        ImageView titleImage = (ImageView) dialog.findViewById(R.id.title_icon);
        TextView txtTitle = (TextView) dialog
                .findViewById(R.id.txt_dialog_title);
        TextView txtMessage = (TextView) dialog.findViewById(R.id.text_dialog);
        Button left, right;
        left = (Button) dialog.findViewById(R.id.btn_cancel);
        right = (Button) dialog.findViewById(R.id.Ok_btn);
        titleImage.setImageDrawable(mContext.getResources().getDrawable(
                android.R.drawable.ic_dialog_alert));
        txtTitle.setText("GPS Enable");
        txtMessage
                .setText("Please turn your GPS on to detect your exact location !!");
        left.setVisibility(View.GONE);
        // left.setText("No");
        right.setText("Setting");

        right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                mContext.startActivity(intent);
            }
        });

        dialog.show();
    }

    public static void DismissSettingsAlert() {
        try {
            dialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("deprecation")
    @SuppressLint("InlinedApi")
    public static void turnGPSOn(Context mContext) {

        String provider = "";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            provider = Settings.Secure.getString(
                    mContext.getContentResolver(),
                    Settings.Secure.LOCATION_MODE);
        } else {
            provider = Settings.Secure.getString(
                    mContext.getContentResolver(),
                    Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        }


        if (!provider.contains("gps")) { // if gps is disabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings",
                    "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            mContext.sendBroadcast(poke);
        }
    }

    public static void turnGPSOff(Context mContext) {
        String provider = Settings.Secure.getString(
                mContext.getContentResolver(),
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED);

        if (provider.contains("gps")) { // if gps is enabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings",
                    "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            mContext.sendBroadcast(poke);
        }
    }

    public static String sendByPOSTJson(String url, String json) {

        InputStream is;
        StringBuilder sb;
        String result = "";
        try {

            String data = json.toString().replace("null", " ");
            data = data.replace("'", "");
            HttpClient httpclient = new DefaultHttpClient();
            WriteDataFille.writeData(data);
            final HttpParams httpParams = httpclient.getParams();
            HttpConnectionParams.setConnectionTimeout(httpParams, 60000);
            HttpConnectionParams.setSoTimeout(httpParams, 60000);

            HttpPost httppost = new HttpPost(url);
            List<NameValuePair> nVP = new ArrayList<NameValuePair>(2);
            nVP.add(new BasicNameValuePair("result", data));
            // Hand the NVP to the POST
            httppost.setEntity(new UrlEncodedFormEntity(nVP));

            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();

            is = entity.getContent();

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 20);

            sb = new StringBuilder();
            sb.append(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);

            }
            is.close();
            result = sb.toString();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return result;

    }

    public static void customToast(Context context, String message, int type) {
        View _mView = LayoutInflater.from(context).inflate(R.layout.new_custom_toast, null);

        CardView cardView = _mView.findViewById(R.id.cardView);
        ImageView iv_custom_toast = _mView.findViewById(R.id.iv_custom_toast);
        TextView tv_custom_toast = _mView.findViewById(R.id.tv_custom_toast);


        //Parsing Color for Cardview Background:-
        int greenColor = Color.parseColor("#008000");
        int blueColor = Color.parseColor("#3F51B5");
        int redColor = Color.parseColor("#FF0000");
        int whiteColor = Color.parseColor("#FFFFFF");
        int blackColor = Color.parseColor("#000000");

        switch (type) {
            case 0:
                cardView.setCardBackgroundColor(greenColor);
                iv_custom_toast.setImageResource(R.drawable.right_icon);
                tv_custom_toast.setText(message);
                tv_custom_toast.setTextColor(whiteColor);
                break;

            case 1:
                cardView.setCardBackgroundColor(redColor);
                iv_custom_toast.setImageResource(R.drawable.error_icon);
                tv_custom_toast.setText(message);
                tv_custom_toast.setTextColor(whiteColor);
                break;

            case 2:
                cardView.setCardBackgroundColor(blueColor);
                iv_custom_toast.setImageResource(R.drawable.info_icon);
                tv_custom_toast.setText(message);
                tv_custom_toast.setTextColor(whiteColor);
                break;

            default:
                cardView.setCardBackgroundColor(blackColor);
                tv_custom_toast.setText(message);
                tv_custom_toast.setTextColor(whiteColor);


        }

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(_mView);
        toast.show();
    }

    public static String getDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = df.format(c.getTime());
        return formattedDate;

    }

    public static String getTime() {
        Time time = new Time(Time.getCurrentTimezone());
        time.setToNow();
        String attn_time = time.format("%k:%M:%S");
        return attn_time;
    }

    public static String orderId() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }


    public static void cancel_Dialog(final Context currentCtx, final Class targetActivity) {
        final Dialog dialog = new Dialog(currentCtx, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(layoutParams);

        ImageView titleImage = dialog
                .findViewById(R.id.title_icon);
        TextView txtTitle = dialog
                .findViewById(R.id.txt_dialog_title);
        TextView txtMessage = dialog
                .findViewById(R.id.text_dialog);
        Button left, right;
        left = dialog.findViewById(R.id.btn_cancel);
        right = dialog.findViewById(R.id.Ok_btn);
        titleImage.setImageResource(android.R.drawable.ic_dialog_alert);

        txtTitle.setText("Cancel");
        txtMessage.setText("Do you want to cancel ?");
        left.setText("No");
        right.setText("Yes");

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(currentCtx, targetActivity);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                dialog.dismiss();
                currentCtx.startActivity(intent);
                ((Activity) currentCtx).overridePendingTransition(R.anim.exit_animation_enter_from_right, R.anim.exit_animation_leave_to_right);

            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public static String getGeoLocationAddress(Context mContext, double latitude, double longitude) {
        String result = "NA";
        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);

            if (addresses != null && addresses.size() > 0) {
                /* String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();*/
                result = addresses.get(0).getAddressLine(0).replace("/", "-");
                result = result.replaceAll("\"", " ");
                result = result.replaceAll("[^a-zA-Z0-9 ,]", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
            result = "NA";
        }
        return result;
    }

    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static boolean time_difference(String start_time, String end_time) {
        boolean isdifference = false;
        if (!start_time.equals("") && !end_time.equals("")) {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date start = null;
            Date end = null;
            try {
                start = format.parse(start_time);
                end = format.parse(end_time);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            long diff = end.getTime() - start.getTime();
            long diffSeconds = diff / 1000;
            long diffMinutes = diff / (60 * 1000);

            if (diffMinutes > 0)
                isdifference = true;
        }

        return isdifference;
    }

    public static boolean isTimeAutomatic(Context c) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return Settings.Global.getInt(c.getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1
                    && Settings.Global.getInt(c.getContentResolver(), Settings.Global.AUTO_TIME_ZONE, 0) == 1;
        } else {
            return true;
        }
    }

    public static void autoTimePopUpSetting(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.DialogSlideAnim);
        builder.setMessage("Looks like your Device time is not correct , Please Correct your device time first !")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        context.startActivity(new Intent(android.provider.Settings.ACTION_DATE_SETTINGS));
                        dialog.dismiss();
                    }
                }).show();
    }

    /*Show Internet Alert Notification*/
    public static void showSnack(CoordinatorLayout coordinatorLayout, Context context, int connectStatus) {
        if (connectStatus == NetworkUtils.TYPE_WIFI) {
            Constants.showAlert(coordinatorLayout, context, false, Constants.TITLE_INFO, "WiFi");
        } else if (connectStatus == NetworkUtils.TYPE_MOBILE) {
            Constants.showAlert(coordinatorLayout, context, false, Constants.TITLE_INFO, "Mobile Data");
        } else if (connectStatus == NetworkUtils.TYPE_NOT_CONNECTED) {
            Constants.showAlert(coordinatorLayout, context, true, Constants.TITLE_ALERT, MESSAGE_NO_INTERNET);

        }
    }

    /*Show success or error notification Alert*/
    public static void showAlert(CoordinatorLayout cl, Context context, boolean isError, String title, String message) {
        Snackbar snackbar = Snackbar.make(cl, "", Snackbar.LENGTH_SHORT);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        TextView textView = layout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);

        // Inflate our custom view
        View snackView = LayoutInflater.from(context).inflate(R.layout.custom_alert, null);
        // Configure the view
//        LinearLayout parentLinear = snackView.findViewById(R.id.parent_linear);
        ImageView icon = snackView.findViewById(R.id.icon);
        TextView messageTitle = snackView.findViewById(R.id.messagetitle);
        TextView message_tv = snackView.findViewById(R.id.message);
        if (isError) {
            icon.setImageResource(R.drawable.ic_info);
            layout.setBackgroundColor(ContextCompat.getColor(context, R.color.red));
        } else {
            layout.setBackgroundColor(ContextCompat.getColor(context, R.color.darkgreen));
            icon.setImageResource(R.drawable.ic_tick);
        }

        messageTitle.setText(title);
        message_tv.setText(message);

        // Add the view to the Snackbar's layout
        layout.addView(snackView, 0);

        // Show the Snackbar
        snackbar.show();
    }

    public static int getBatteryPercentage(Context context) {

        IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = context.registerReceiver(null, iFilter);

        int level = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) : -1;
        int scale = batteryStatus != null ? batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1) : -1;

        float batteryPct = level / (float) scale;

        return (int) (batteryPct * 100);
    }

    public static void showNetworkAlert(Context context) {
        final Dialog dialog = new Dialog(context, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_RIGHT_ICON);
        dialog.setContentView(R.layout.dialog);
        dialog.setCanceledOnTouchOutside(false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(layoutParams);

        ImageView titleImage = dialog.findViewById(R.id.title_icon);
        TextView txtTitle = dialog
                .findViewById(R.id.txt_dialog_title);
        TextView txtMessage = dialog.findViewById(R.id.text_dialog);
        Button left, right;
        left = dialog.findViewById(R.id.btn_cancel);
        right = dialog.findViewById(R.id.Ok_btn);
        titleImage.setImageDrawable(context.getResources().getDrawable(
                R.drawable.internetalert));
        txtTitle.setText("Alert");
        txtMessage
                .setText("No Internet Connection !!");

        left.setVisibility(View.GONE);
        right.setText("OK");

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }


    public static String currentDateAndTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(c.getTime());
    }

    public static String showLocatonString(double latitude, double longitude,
                                           Context mContext) {
        String result = "N/A";
        String addessline = "",addesslocal = "",postal="",countryname="";
        try {
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());

            List<Address> addresses = geocoder.getFromLocation(latitude,
                    longitude, 1);
			/*if (addressList != null && addressList.size() > 0) {
				Address address = addressList.get(0);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < address.getMaxAddressLineIndex(); i++) {
					addessline = String.valueOf(sb.append(address.getAddressLine(i)));

					addesslocal = String.valueOf(sb.append(address.getLocality()));
					postal = String.valueOf(sb.append(address.getPostalCode()));
					countryname = String.valueOf(sb.append(address.getCountryName()));
				}*/


            if (addresses != null && addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();

                result = address+","+city+","+state+","+country+","+postalCode;
                result= result.replaceAll("\"", " ");
                result = result.replaceAll("[^a-zA-Z0-9 ,]", "");
            }

            //result = sb.toString();


        } catch (IOException e) {
            e.printStackTrace();
            result = "N/A";
        }
        return result;
    }

    public static boolean compareDate(String fromDateStr, String toDateStr) {
        boolean isGreater = false;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date formattedFromDate;
        Date formattedToDate;
        try {
            formattedFromDate = formatter.parse(fromDateStr);
            formattedToDate = formatter.parse(toDateStr);
            if (formattedToDate.after(formattedFromDate)) {
                System.out.println("To-Date is Greater than From-Date");
                isGreater = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isGreater;
    }

    public static String currentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(c.getTime());
    }

    public static void timeShow(Context context, final EditText editText) {
        TimePickerDialog mTimePicker;

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        mTimePicker = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {


                String time = selectedHour + ":" + selectedMinute;

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
                Date date = null;
                try {
                    date = fmt.parse(time);
                } catch (ParseException e) {

                    e.printStackTrace();
                }

                editText.setText(fmt.format(date));
            }
        }, hour, minute, true);//No 24 hour time
        mTimePicker.show();
    }


    public static boolean compareTime(String fromTime, String toTime) {
        boolean isGreater = false;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date formattedFromTime;
        Date formattedToTime;
        try {
            formattedFromTime = formatter.parse(fromTime);
            formattedToTime = formatter.parse(toTime);
            if (formattedToTime.before(formattedFromTime)) {
                System.out.println("To-Date is Greater than From-Date");
                isGreater = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isGreater;
    }
}
