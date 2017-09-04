package com.example.debarghya.splashing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.about:
                setContentView(R.layout.about);
                ImageView imageView=(ImageView)findViewById(R.id.eagle);
                imageView.setAlpha(0.4f);
        }
        return true;
    }

    Button b1;
    public void addListenerOnButton(){
        //2
        // work area ......................................
        b1=(Button)findViewById(R.id.button);//time table
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.timetable);
                expandableListView=(ExpandableListView)findViewById(R.id.expandable);
                ExpandableListViewAdapter adapter=new ExpandableListViewAdapter(MainActivity.this);
                expandableListView.setAdapter(adapter);

                Button x;
                x=(Button)findViewById(R.id.button8);
                x.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });

        //5
        b1=(Button)findViewById(R.id.button5);//reminder
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ReminderActivity.class);
                startActivity(intent);
            }
        });

        //6
        b1=(Button)findViewById(R.id.button7);//sa course
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.sacourse);
                Button button;
                button=(Button)findViewById(R.id.button4);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });





            }
        });
    }

    public void Webmail(View view){
            gotoUrl("https://webmail.iitg.ernet.in/");

    }

    public void Moodle(View view){
        gotoUrl("https://intranet.iitg.ernet.in/moodle/login/index.php");

    }

    public void Intranet(View view)
    {
        gotoUrl("http://intranet.iitg.ernet.in/");
            }

    private  void   gotoUrl(String url){
        Uri uriUrl=Uri.parse(url);
        Intent launchBrowser=new Intent(Intent.ACTION_VIEW,uriUrl);
        startActivity(launchBrowser);
    }


}
