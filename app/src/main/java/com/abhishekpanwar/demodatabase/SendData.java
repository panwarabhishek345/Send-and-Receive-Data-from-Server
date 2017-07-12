package com.abhishekpanwar.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Abhishek Panwar on 7/10/2017.
 */

public class SendData extends AppCompatActivity {

    EditText e_name,e_password,e_contact,e_country;
    Button insert;
    String name,password,contact,country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e_name = (EditText)findViewById(R.id.name);
        e_password = (EditText)findViewById(R.id.password);
        e_contact = (EditText)findViewById(R.id.contact);
        e_country = (EditText)findViewById(R.id.country);

        insert = (Button)findViewById(R.id.insert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = e_name.getText().toString();
                password = e_password.getText().toString();
                contact = e_contact.getText().toString();
                country = e_country.getText().toString();

                BackgroundTaskSend backgroundTask = new BackgroundTaskSend(view.getContext());
                backgroundTask.execute(name,password,contact,country); // Passing of the Data to the Asyntask
                finish();
            }
        });


    }

}
