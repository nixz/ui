package edu.cs4730.recyclerviewdemo2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    phoneAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup data.
        final List<Phonebook> listOfPhonebook = new ArrayList<Phonebook>();
        listOfPhonebook.add(new Phonebook("Test", "9981728", "test@test.com"));
        listOfPhonebook.add(new Phonebook("Test1", "1234455", "test1@test.com"));
        listOfPhonebook.add(new Phonebook("Test2", "00000", "test2@test.com"));
        listOfPhonebook.add(new Phonebook("Test3", "00000", "test3@test.com"));
        listOfPhonebook.add(new Phonebook("Test4", "00000", "test4test.com"));
        listOfPhonebook.add(new Phonebook("Test5", "00000", "test5@test.com"));
        listOfPhonebook.add(new Phonebook("Test6", "00000", "test6@test.com"));

        //setup the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //setup the adapter, which is myAdapter, see the code.
        mAdapter = new phoneAdapter(listOfPhonebook, R.layout.phone_row, this);
        //add the adapter to the recyclerview
        mRecyclerView.setAdapter(mAdapter);
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
}
