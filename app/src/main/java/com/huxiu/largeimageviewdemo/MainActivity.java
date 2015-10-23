package com.huxiu.largeimageviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.io.InputStream;

import view.LargeImageView;

public class MainActivity extends AppCompatActivity {
    private LargeImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (LargeImageView)findViewById(R.id.large_imageview);
        try
        {
            InputStream inputStream = getAssets().open("world.jpg");
            mImageView.setInputStream(inputStream);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
