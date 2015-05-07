package com.ftpha.sqltake2;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds.Email;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import dbXtrs.dsKit;
import model.User;

import static android.provider.ContactsContract.CommonDataKinds.*;
//import model.Users;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private static final int CONTACT_PICKER_RESULT = 1001;

    private static final String LOGTAG = "ftpha - sca c r ";


    dsKit dS;
    NumberPicker nPk;
    TextView tLg;

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] nms = {"0", "1","5","10","15","20","25","30","35","40"};
        //nPk.

        tLg = (TextView) findViewById(R.id.txtL);
        nPk = (NumberPicker) findViewById(R.id.nPicker);


        nPk.setMinValue(0);
        nPk.setMaxValue(8);
        nPk.setValue(1);

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

        List<User> users = dS.findAllUsers();
        if (users.size() == 0) {

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
            users = dS.findAllUsers();
        }

        ListView lv = (ListView) findViewById(R.id.listView);

        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
                android.R.layout.simple_expandable_list_item_1, users);
        lv.setAdapter(adapter);

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

        int elNo = Integer.parseInt(tLg.getText().toString());

        try {
            SmsManager smsManager = SmsManager.getDefault();
            for (int i = 1; i < (2); i++) {
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


        try {
            GMailSender sender = new GMailSender("username@gmail.com", "password");
            sender.sendMail("This is Subject",
                    "This is Body",
                    "user@gmail.com",
                    "user@yahoo.com");
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CONTACT_PICKER_RESULT:
                    Cursor cursor = null;
                    Cursor cursorEm = null;
                    String email = "";
                    String phoneNumber = "";
                    List<String> allNumbers = new ArrayList<String>();
                    try {
                        Uri result = data.getData();
                        Log.i(LOGTAG, "Got a contact result: "
                                + result.toString());

                        // get the contact id from the Uri
                        String id = result.getLastPathSegment();

                        cursor = getContentResolver().query(
                                Phone.CONTENT_URI,
                                null,
                                Phone.CONTACT_ID + "=?",
                                new String[] { id },
                                null);


                        int phoneIdx = cursor.getColumnIndex(Phone.DATA);

                        // let's just get the first phone
                            if (cursor.moveToFirst()) {
                                while (cursor.isAfterLast() == false) {
                                    phoneNumber = cursor.getString(phoneIdx);
                                    allNumbers.add(phoneNumber);
                                    cursor.moveToNext();
                                }
                            } else {

                        }


                        cursorEm = getContentResolver().query(Email.CONTENT_URI,
                                null, Email.CONTACT_ID + "=?", new String[] { id },
                                null);

                        int emailIdx = cursor.getColumnIndex(Email.DATA);

                        // let's just get the first email
                        if (cursorEm.moveToFirst()) {
                            email = cursorEm.getString(emailIdx);
                            Toast.makeText(MainActivity.this, "Got email: " + email,Toast.LENGTH_LONG).show();
                        } else {
                            Log.i(LOGTAG, "No results");
                        }

                    } catch (Exception e) {
                        Log.e(LOGTAG, "Failed to get phone data", e);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                        EditText phoneEntry = (EditText) findViewById(R.id.txtPhone);
                        phoneEntry.setText(phoneNumber);
                        if (phoneNumber.length() == 0) {
                            Toast.makeText(this, "No phone found for contact.",
                                    Toast.LENGTH_LONG).show();
                        }

                    }

                    break;
            }

        } else {
            Log.i(LOGTAG, "Warning: activity result not ok");
        }
    }

    public void onGetNewContact(View view) {


            Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
                    Contacts.CONTENT_URI);
            startActivityForResult(contactPickerIntent, CONTACT_PICKER_RESULT);



    }
}
