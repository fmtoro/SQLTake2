package com.ftpha.sqltake2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import dbXtrs.dsKit;


public class MainActivity extends ActionBarActivity {

    private static final String LOGTAG = "ftpha - sca c r ";
    dsKit dS;
    NumberPicker nPk;
    TextView tLg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] nms = {"0","5","10","15","20","25","30","35","40"};
        //nPk.

        tLg = (TextView) findViewById(R.id.txtL);
        nPk = (NumberPicker) findViewById(R.id.nPicker);


        nPk.setMinValue(0);
        nPk.setMaxValue(8);
        //nPk.setValue(15);

        nPk.setDisplayedValues(nms);
        nPk.setWrapSelectorWheel(false);




        nPk.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub

//                String Old = "Old Value : ";
//                String New = "New Value : ";

                //tv1.setText(Old.concat(String.valueOf(oldVal)));
                tLg.setText(String.valueOf(newVal*5));
            }
        });


        dS = new dsKit(this);

        dS.Open();
        dS.createUser(
                "Cuela",
                "1 438 346 7116",
                "mariadanielaaleman@gmail.com");
        dS.createUser(
                "Nela",
                "1 438 555 1212",
                "daniela.toro.a@gmail.com");

        dS.createCat(
                "You can",
                "1",
                "3",
                "W",
                "Y",
                "Y",
                "Y",
                "Y",
                1
        );

        dS.createList(
                "Work",
                "Work will come.",
                1
        );
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

    public void onSendSMS(View view) {


        EditText etPh = (EditText) findViewById(R.id.txtPhone);
        EditText etMsg = (EditText) findViewById(R.id.txtMessage);

        try {
            SmsManager smsManager = SmsManager.getDefault();
            for (int i = 1; i < 11; i++) {
                smsManager.sendTextMessage(
                    etPh.getText().toString(),
                    null,
                    etMsg.getText().toString() + "\n" + i,
                    null,
                    null);

            }
            Toast.makeText(
                    MainActivity.this,
                    "Was sent",
                    Toast.LENGTH_LONG)
                    .show();
        } catch (Exception e) {
            Log.i(LOGTAG, e.getMessage());
            Toast.makeText(
                    MainActivity.this,
                    "No way",
                    Toast.LENGTH_LONG)
                    .show();

        }

    }

}
