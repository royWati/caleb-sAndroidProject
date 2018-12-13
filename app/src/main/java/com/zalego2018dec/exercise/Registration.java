package com.zalego2018dec.exercise;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.zalego2018dec.exercise.databases.table_users;
import com.zalego2018dec.exercise.objects.Person;

/**
 * Created by folio on 12/11/2018.
 */

public class Registration extends AppCompatActivity {

    class xmlVariable{
        EditText ed_name,ed_phone_number,ed_password,ed_email;
        Button btn_register;
        RadioGroup grp_gender;
        RadioButton radio_female,radio_male;
    }

    class data{
        String name,email,phoneNumber,password,gender;
    }

    xmlVariable xml = new xmlVariable();
    data d = new data();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        xml.btn_register=findViewById(R.id.btn_registration);
        xml.ed_email= findViewById(R.id.ed_email);
        xml.ed_phone_number= findViewById(R.id.ed_phone);
        xml.ed_password= findViewById(R.id.ed_password);
        xml.ed_name= findViewById(R.id.ed_name);
        xml.grp_gender= findViewById(R.id.group_gender);
        xml.radio_female= findViewById(R.id.radio_female);
        xml.radio_male= findViewById(R.id.radio_male);

        events();
    }

    public void events(){
        xml.grp_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(xml.radio_male.isChecked()){
                    d.gender = "male";
                }else if(xml.radio_female.isChecked()){
                    d.gender="female";
                }else{
                    d.gender="not specified";
                }
            }
        });

        xml.btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.name=xml.ed_name.getText().toString();
                d.phoneNumber=xml.ed_name.getText().toString();
                d.email=xml.ed_email.getText().toString();
                d.password=xml.ed_password.getText().toString();

                // create an object of person in order to store our information
                Person person=new Person();
                person.setEmail(d.email);
                person.setPassword(d.password);
                person.setName(d.name);
                person.setPhoneNumber(Long.parseLong(d.phoneNumber));

                table_users tb = new table_users(Registration.this);
                tb.registerUser(person);

                Toast.makeText(getApplicationContext(),"user registered succe" +
                        "ssfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
