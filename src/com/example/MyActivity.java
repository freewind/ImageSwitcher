package com.example;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {
    private Bitmap image;
    private ImageView imageView;
    private Button button;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.button = (Button) findViewById(R.id.button);
        this.imageView = (ImageView) findViewById(R.id.image);


        this.image = BitmapFactory.decodeResource(getResources(), R.drawable.m0);
        this.imageView.setImageBitmap(image);

        this.button.setOnClickListener(new View.OnClickListener() {
            private int current = 0;

            @Override
            public void onClick(View view) {
                Bitmap toRemove = image;
                Matrix matrix = new Matrix();
                matrix.setRotate(30, 0.5f, 0.5f);
                image = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
                imageView.setImageBitmap(image);

                if (toRemove != null) {
                    toRemove.recycle();
                }
            }
        });
    }
}
