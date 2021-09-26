package com.mobile_computing;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;


public class downloadImage extends AsyncTask<String,Void, Bitmap> {
    ImageView imageView;

    public downloadImage(ImageView imageView){
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String urlOfImage = urls[0];
        Bitmap bitmap = null;
        try{
            URL url = new URL(urlOfImage);
            //InputStream is = new URL(urlOfImage).openStream();
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            imageView.setImageBitmap(bitmap);
        }catch(Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    protected void onPostExecute(Bitmap bitmap){
        imageView.setImageBitmap(bitmap);
    }
}
