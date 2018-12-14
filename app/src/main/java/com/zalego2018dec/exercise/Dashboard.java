package com.zalego2018dec.exercise;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.GridView;

import com.zalego2018dec.exercise.adapters.DashboardGridViewAdapter;
import com.zalego2018dec.exercise.objects.DashboardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by folio on 12/13/2018.
 */

public class Dashboard extends AppCompatActivity {

    class storedVariables{
        List<DashboardItem> list;

    }

    class xmlVariables{
        GridView gridView;
        DrawerLayout drawer;
    }

    storedVariables store = new storedVariables();
    xmlVariables xml = new xmlVariables();
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        xml.gridView=findViewById(R.id.dashboard_gridview);
        addDashboardData();

        // set up our Adapter class
        DashboardGridViewAdapter adapter =new DashboardGridViewAdapter(Dashboard.this,store.list);

        // adding our adapter to our gridview
        xml.gridView.setAdapter(adapter);
    }

    // create a method to add data to our list
    public void addDashboardData(){
        store.list = new ArrayList<>();
        // creating objects for our list i.e DashboardItem objects
        DashboardItem data1 = new DashboardItem();
        data1.setIcon(R.mipmap.my_muisic);
        data1.setText("My music");
        // add
        store.list.add(data1);

        DashboardItem data2 = new DashboardItem();
        data2.setIcon(R.mipmap.top_hits);
        data2.setText("Top hits");
        store.list.add(data2);

        DashboardItem data3 = new DashboardItem();
        data3.setIcon(R.mipmap.new_release);
        data3.setText("Recent Release");
        // add
        store.list.add(data3);

        DashboardItem data4 = new DashboardItem();
        data4.setIcon(R.mipmap.station);
        data4.setText("Stations");
        store.list.add(data4);

        DashboardItem data5 = new DashboardItem();
        data5.setIcon(R.mipmap.videos);
        data5.setText("Videos");
        // add
        store.list.add(data5);

        DashboardItem data6 = new DashboardItem();
        data6.setIcon(R.mipmap.settings);
        data6.setText("Settings");
        store.list.add(data6);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard,menu);
        return true;
    }
}
