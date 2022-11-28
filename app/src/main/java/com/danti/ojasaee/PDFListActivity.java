package com.danti.ojasaee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class PDFListActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    String[] listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdflist);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.textView);
        listItem = getResources().getStringArray(R.array.array_writeup_wisdom);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);
                //Toast.makeText(getApplicationContext(),value, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PDFListActivity.this, PDFActivity.class);
                intent.putExtra("index", value);
                startActivity(intent);
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Toast.makeText(getApplicationContext(), "This app is developed and maintained by Arpita Dey, Vice President, AEE Kolkata Student Chapter, IISWBM MBA-PS", Toast.LENGTH_LONG).show();


        if (id == R.id.action_item_two) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}