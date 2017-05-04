package com.example.innovativenetwork.truefalse.Utills;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

//import com.google.firebase.crash.FirebaseCrash;

//import static org.apache.commons.codec.binary.Base64.decodeBase64;


/**
 * Created by aftab on 07/03/2016.
 */
public class ImageBinaryConvertor {

    private final static String TAG = "ImageBinaryConverter";

    public static byte[] getByteArrayFromBitmap(Bitmap bitmap) throws UnsupportedEncodingException {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);

        return outputStream.toByteArray();
    }


    public static String getBase64StringFromBitmap(Bitmap bitmap) throws UnsupportedEncodingException {

        ByteArrayOutputStream outputStream = null;
        try {
            outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        }
        catch (Exception e){

            e.printStackTrace();
            //FirebaseCrash.report(new Exception("Where getBase64StringFromBitmap : "+"Exception: "+e+" User ID: "));

            Log.e(TAG, "--getBase64StringFromBitmap: "+e.getMessage());
        }
        return Base64.encodeToString(outputStream.toByteArray(), Base64.DEFAULT);
    }


    public static Bitmap getBitmapFromByteArray(byte [] imageByteArray) {

        return BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);

    }


    public static Bitmap getBitmapFromBase64String(String base64String) {

        byte[] decodedByteArray = null;

        try {

            decodedByteArray = Base64.decode(base64String, Base64.DEFAULT);
        }
        catch (Exception e){
            e.printStackTrace();
            //FirebaseCrash.report(new Exception("Where getBitmapFromBase64String : "+"Exception: "+e+" User ID: "));
            Log.e(TAG, "--getBitmapFromBase64String: "+e.getMessage());
        }
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.length);
    }

}
