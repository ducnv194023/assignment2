package com.chuyennt.test_app_bar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
;
import java.util.ArrayList;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    ArrayList<DataPeople> listPeopleData;
    DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.people_view);

        ListView listView = findViewById(R.id.list_data);
        listPeopleData = new ArrayList<>();
        for(int i=0 ; i<10; i++)
            listPeopleData.add(new DataPeople(new Faker()));

        adapter = new DataAdapter(listPeopleData);
        listView.setAdapter(adapter);
    }
}