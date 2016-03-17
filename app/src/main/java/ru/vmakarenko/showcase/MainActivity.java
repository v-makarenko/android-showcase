package ru.vmakarenko.showcase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lv = (ListView) findViewById(R.id.MainListView);
        lv.setAdapter(ArrayAdapter.createFromResource(this, R.array.lab_list, android.R.layout.simple_list_item_1));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent textDupIntent = new Intent(MainActivity.this, TextDuplicatorActivity.class);
                        startActivity(textDupIntent);
                    case 1:
                        Intent calcIntent = new Intent(MainActivity.this, CalcActivity.class);
                        startActivity(calcIntent);
                }
            }
        });


    }
}
