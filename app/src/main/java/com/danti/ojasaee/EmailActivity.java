package com.danti.ojasaee;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class EmailActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inSubject, inBody;
    TextView txtEmailAddress;
    Button btnSendEmail;
    String possibleEmail="";
    String strDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        // API level 8+

        initViews();
    }

    private void initViews() {
        inSubject = findViewById(R.id.inSubject);
        inBody = findViewById(R.id.inBody);
        txtEmailAddress = findViewById(R.id.txtEmailAddress);
        btnSendEmail = findViewById(R.id.btnSendEmail);

        Pattern emailPattern = Patterns.EMAIL_ADDRESS;
        Account[] accounts = AccountManager.get(getApplicationContext()).getAccounts();
        for (Account account : accounts) {
            if (emailPattern.matcher(account.name).matches()) {
                possibleEmail = account.name;
                txtEmailAddress.setText(possibleEmail);
            }
        }
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        strDate = dateFormat.format(currentTime);

        if (getIntent().getStringExtra("scanned_content") != null) {
            inSubject.setText("Scanned content at: "+strDate);
            inBody.setText(getIntent().getStringExtra("scanned_content"));
        }





        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{possibleEmail});
                intent.putExtra(Intent.EXTRA_SUBJECT, strDate);
                intent.putExtra(Intent.EXTRA_TEXT, inBody.getText().toString().trim());
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSendEmail:
                startActivity(new Intent(EmailActivity.this, ScannedBarcodeActivity.class));
                break;
        }
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