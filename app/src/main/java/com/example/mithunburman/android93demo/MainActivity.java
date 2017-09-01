package com.example.mithunburman.android93demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener
{

    // declaring variables
    ListView myView;
    MyListAdapter ListAdap;
    int index = 0;

    //creating arrays for name and numbers
    public static String[] name = {"George", "Marc", "Clint", "Paul",
            "Esha", "Raunak", "Eric", "D'souza"};
    public static String[] number = {"9999966666", "9999777444", "9999992222", "9999988880",
            "9999333300", "9999912120", "9999994444", "99999955555"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // casting variable
        myView = (ListView) findViewById(R.id.listViewId);
        // creating MyListAdapter and passing context and arrays
        ListAdap = new MyListAdapter(this, name, number);
        myView.setAdapter(ListAdap);
        myView.setOnItemClickListener(this);
        /**
         in here registering the View to which the context menu should be associated by calling
         registerForContextMenu() and pass it the View.
         */
        registerForContextMenu(myView);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this, "Long press to Call /SMS ", Toast.LENGTH_SHORT).show();
    }
    /**
     * Here by trying to implement onCreateContextMenu() method
     * This is where you define the menu items, usually by inflating a menu resource
     * @param menu
     * @param v
     * @param menuInfo
     */

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
         /*
            MenuInflater allows you to inflate the context menu from a menu resource..
        */
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout, menu);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        index = info.position;
    }

    // crating call method to pass intent..
    private void Call()
    {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:" + number[index]));
        startActivity(i);
        Toast.makeText(this, "Option call Chosen...", Toast.LENGTH_LONG).show();
    }

    //creating SendSms method to pass intent..
    private void SendSms()
    {
        try {
            Intent i = new Intent();
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + number[index])));
            startActivity(i);
            Toast.makeText(this, "Option sms Chosen...", Toast.LENGTH_LONG).show();
        } catch (Exception e) {

        }
    }

    /**
     * Handling click events
     * This method passes the MenuItem selected. You can identify the item by calling getItemId(),
     * which returns the unique ID for the menu item..
     */

    public boolean onContextItemSelected(MenuItem item)
    {
        //find out which menu item was pressed
        switch (item.getItemId())
        {
            //calling Call method
            case R.id.option1:
                Call();
                return true;
            //calling SendSms method
            case R.id.option2:
                SendSms();
                return true;
            default:
                return false;
        }
    }
}