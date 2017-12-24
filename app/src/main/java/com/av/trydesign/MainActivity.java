package com.av.trydesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    RelativeLayout myProfilePage;
    RelativeLayout settingsPage;
    RelativeLayout myAdPage;
    RelativeLayout myAlertPage;
    RelativeLayout messagePage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // set My custom toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);// Display title name

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);// to access any item on navigation view


        myProfilePage = (RelativeLayout) findViewById(R.id.nav_my_page);
        settingsPage  = (RelativeLayout) findViewById(R.id.nav_settings);
        myAdPage      = (RelativeLayout) findViewById(R.id.nav_my_ad);
        myAlertPage   = (RelativeLayout) findViewById(R.id.nav_my_alert);
        messagePage   = (RelativeLayout) findViewById(R.id.nav_message);

        myProfilePage.setOnClickListener(this);
        settingsPage.setOnClickListener(this);
        myAdPage.setOnClickListener(this);
        myAlertPage.setOnClickListener(this);
        messagePage.setOnClickListener(this);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }


    public  void openDrawer(View v){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerVisible(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            drawer.openDrawer(GravityCompat.START);

        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

       /* //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_my_page) {
            Toast.makeText(this,"My Page",Toast.LENGTH_LONG).show();
            // Handle the camera action
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

       if(view == myProfilePage){
            Toast.makeText(this,"صفحتى",Toast.LENGTH_LONG).show();
             onBackPressed();
              startActivity(new Intent(this,BottomTapActivity.class));

        }else if(view==settingsPage){
           Toast.makeText(this,"الاعدادات",Toast.LENGTH_LONG).show();

       }else if(view == myAdPage){
           Toast.makeText(this,"اعلاناتى",Toast.LENGTH_LONG).show();

       }else if(view == myAlertPage){
           Toast.makeText(this,"تنبيهاتى",Toast.LENGTH_LONG).show();

       }else if( view==messagePage){
           Toast.makeText(this,"رسائل ",Toast.LENGTH_LONG).show();

       }


    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
               //     mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                  //  mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                  //  mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_favorite:
                 //   mTextMessage.setText("favorite");
                    return true;
            }
            return false;
        }

    };
}
