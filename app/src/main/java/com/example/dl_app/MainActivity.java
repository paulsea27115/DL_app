package com.example.dl_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent it = new Intent(this,Foreground.class);
        startService(it);
//        startForegroundService(it);
    }

    public void testbtn(View view){
        Toast.makeText(getApplication(), "test good", Toast.LENGTH_SHORT).show();
    }
}