package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        List<String> friends = new ArrayList<String>();
        friends.add("First");
        friends.add("Second");
        friends.add("Third");
        friends.add("Fourth");
        friends.add("Five");
        friends.add("Six");
        friends.add("Seven");
        friends.add("Eight");
        friends.add("Ninth");
        friends.add("Tenth");

        ArrayAdapter<String> friendsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friends);
        listView.setAdapter(friendsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedItem = (String) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("value",selectedItem);
                startActivity(intent);
            }
        });
    }
}