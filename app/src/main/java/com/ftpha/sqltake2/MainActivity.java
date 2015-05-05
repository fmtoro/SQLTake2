package com.ftpha.sqltake2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import dbXtrs.dsKit;
import model.Cat;
import model.User;
import model.ftList;


public class MainActivity extends ActionBarActivity {

    private static final String LOGTAG = "ftpha - sca c r ";
    dsKit dS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dS = new dsKit(this);

        dS.Open();
        createUser(
                "Cuela",
                "1 438 346 7116",
                "mariadanielaaleman@gmail.com");
        createUser(
                "Nela",
                "1 438 555 1212",
                "daniela.toro.a@gmail.com");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();

        dS.Open();
    }

    @Override
    protected void onPause() {
        super.onPause();

        dS.Close();
    }

    private void createUser(String nom,
                            String phone,
                            String email){
        User user = new User();
        user.setUName(nom);
        user.setUPhone(phone);
        user.setUEmail(email);
        user = dS.createUser(user);
        Log.i(LOGTAG, "User created with Id: " + user.getUId());
    }

    private void createCat(String nom,
                           String cFrom,
                           String cTo,
                           String cUnit,
                           String cSMS,
                           String cEmail,
                           boolean cJustMF,
                           boolean cActive,
                           long uId){
        Cat cat = new Cat();
        cat.setCName(nom);
        cat.setCFrom(cFrom);
        cat.setCTo(cTo);
        cat.setCUnit(cUnit);
        cat.setCSMS(cSMS);
        cat.setCEmail(cEmail);
        cat.setCJustMF(cJustMF);
        cat.setCActive(cActive);
        cat.setUId(uId);
        cat = dS.createCat(cat);
        Log.i(LOGTAG, "Category created with Id: " + cat.getCId());
    }

    private void createList(
            String nom,
            String lText,
            long cId){

        ftList fTList = new ftList();
        fTList.setLName(nom);
        fTList.setLText(lText);
        fTList.setCId(cId);
        fTList = dS.createList(fTList);
        Log.i(LOGTAG, "List created with Id: " + fTList.getCId());
    }
}
