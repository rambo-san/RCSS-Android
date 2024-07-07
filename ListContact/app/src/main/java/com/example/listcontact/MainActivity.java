package com.example.listcontact;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView contactListView;
    private List<Contact> contactList;
    private ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactListView = findViewById(R.id.contactListView);
        contactList = new ArrayList<>();

        // Add sample contacts
        contactList.add(new Contact("Abhijith Suresh", "+918921746245"));
        contactList.add(new Contact("Shelvin Sunil", "+918765432177"));
        contactList.add(new Contact("Joyce Mathews", "+918954762458"));
        contactList.add(new Contact("Rohan Abraham", "+917452365478"));

        contactAdapter = new ContactAdapter(this, contactList);
        contactListView.setAdapter(contactAdapter);
    }
}
