package com.zalego2018dec.exercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by folio on 12/10/2018.
 */

public class Login extends AppCompatActivity {

    class xmlVariables{
        TextView registrer;
        Button btn_login;
    }


    // create an object that that carries the xml objects

    // global object -> this is an object that can be access by all methods
    // within the class
    xmlVariables xml = new xmlVariables();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        setTitle("Caleb's project");

        // link our TextView object with our xml TexTview element
        xml.registrer = findViewById(R.id.txt_register);
        xml.btn_login = findViewById(R.id.btn_login);

        events();
    }

    // this is responsble for all events that take place within this
    // class
    public void events(){
        xml.registrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityNavigation();
            }
        });

        xml.btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Dashboard.class);
                startActivity(intent);
            }
        });
    }

    // this method has the intent in it to help us move from one activity to
    // another
    public void activityNavigation(){
        Intent intent  = new Intent(Login.this,Registration.class);
        startActivity(intent);
    }

}
