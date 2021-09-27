package com.mobile_computing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;



public class downloadImage extends AsyncTask<String,Void, Bitmap> {
    ImageView imageView;

    private static final String TAG = "downloadImage";

    public downloadImage(ImageView imageView){
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String urlOfImage = urls[0];
        Log.i(TAG, urlOfImage);
        Bitmap bitmap = null;
        try{
            URL url = new URL(urlOfImage); //TODO dead code?
            //HTTPURLConnection.setFollowRedirects(true);
            //URLConnection insecureConn = url.openConnection();
            //insecureConn.connect();
            URLConnection conn = url.openConnection();
            conn.connect();
            //HTTP 301 redirect may occur here
            //Log.i(TAG, "attempting redirect");
            //InputStream is = insecureConn.getInputStream();
            //URL redirUrl = insecureConn.getURL();
            //is.close();
            //URLConnection redirectConn = redirUrl.openConnection();
            //redirectConn.connect();
            //is = redirectConn.getInputStream();

            bitmap = BitmapFactory.decodeStream(conn.getInputStream());

            //imageView.setImageBitmap(bitmap);
            //is.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }
}
