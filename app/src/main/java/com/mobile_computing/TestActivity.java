package com.mobile_computing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Intent intent = getIntent();

        String img_message = intent.getStringExtra(APISearchActivity.IMAGE_MESSAGE);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        new downloadImage(imageView).execute(img_message);

        String text_message = intent.getStringExtra(APISearchActivity.TEXT_MESSAGE);
        TextView tvResults1 = findViewById(R.id.tvResults1);
        tvResults1.setMovementMethod(new ScrollingMovementMethod());
        tvResults1.setText(text_message);

        String title_message = intent.getStringExtra(APISearchActivity.TITLE_MESSAGE);
        TextView tvResults = findViewById(R.id.tvResults);
        tvResults.setMovementMethod(new ScrollingMovementMethod());
        tvResults.setText(title_message);

        this.setTitle(title_message);

        String date_message = intent.getStringExtra(APISearchActivity.DATE_MESSAGE);
        TextView tvResults2 = findViewById(R.id.tvResults2);
        tvResults2.setMovementMethod(new ScrollingMovementMethod());
        tvResults2.setText(date_message);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }
}