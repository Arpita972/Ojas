package com.danti.ojasaee;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class AboutUsActivity extends AppCompatActivity {
    TextView txtview;
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        txtview = findViewById(R.id.abtUs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            txtview.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        }
        txtview.setMovementMethod(new ScrollingMovementMethod());

        String text = "<h1>About AEE Kolkata students chapter:</h1>\n" +
                "  <div>\n" +
                "    <ol>\n" +
                "      <li>The AEE India Chapter at IISWBM is boasting of securing the international award in the various categories in each of the last six years i.e. since the year of its inception in 2003. In 2014 the chapter was adjudged for best International Chapter in four categories viz. New AEE Members, Community Service, Student Chapter, and Overall performance. </li>\n" +
                "      <li>College students can join a local student chapter. Student chapters promote AEE's goals and programs on the local level while establishing themselves in their various campuses and communities as the \"go-to\" organization for all energy-related matters.\n" +
                "        Equally important, student chapter members create a communication network around the world of energy professionals sharing information, experience, and objectives.\n" +
                "      </li>\n" +
                "      <li>This year Kolkata students have developed an app to leverage the idea of digitization and information on the go for the budding as well as professional energy managers/enthusiastic(s).\n" +
                "      </li>\n" +
                "    </ol>\n" +
                "\n" +
                "  </div>\n" +
                "  <h3>\n" +
                "    Members of executive committee/office bearers of AEE Kolkata chapter for the year 2020-21\n" +
                "  </h3>\n" +
                "  <ul>\n" +
                "    <li>Mr. Dipankar Das Gupta, President</li>\n" +
                "    <li>Mr. Swapan K.Dutta, Vice-President</li>\n" +
                "    <li>Dr. Krishna Murari Agarwal, Vice-President </li>\n" +
                "    <li>Dr. Binoy Krishna chowdhury, Vice-President </li>\n" +
                "    <li>Mr. Prasun Chakrabarty, Vice-President </li>\n" +
                "    <li>Dr. Arindam Dutta, Secretary</li>\n" +
                "    <li>Mr. Soumen Achar, Asstt.Secretary </li>\n" +
                "    <li>Ms. Piyali Sengupta,Treasurer </li>\n" +
                "  </ul>\n" +
                "  <h4>\n" +
                "    AEE Kolkata Student chapter for the year 2020-21\n" +
                "  </h4>\n" +
                "  <ul>\n" +
                "    <li>Arijit Das, President</li>\n" +
                "    <li>Arpita Dey, Vice-President</li>\n" +
                "    <li>Joydeep Datta, Secretary </li>\n" +
                "    <li>Arijit Chattopadhyay , Treasurer </li>\n" +
                "\n" +
                "  </ul>";
        txtview.setText(Html.fromHtml(text));
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