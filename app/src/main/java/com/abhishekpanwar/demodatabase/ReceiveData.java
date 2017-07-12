package com.abhishekpanwar.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Abhishek Panwar on 7/10/2017.
 */

public class ReceiveData extends AppCompatActivity {

    public static TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);

        data = (TextView)findViewById(R.id.jsondata);

        BackgroundTaskReceive backgroundTaskReceive = new BackgroundTaskReceive(this);
        backgroundTaskReceive.execute();

    }



}
