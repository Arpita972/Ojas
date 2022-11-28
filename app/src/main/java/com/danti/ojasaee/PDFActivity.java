package com.danti.ojasaee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.shockwave.pdfium.PdfDocument;
import com.itextpdf.text.pdf.PdfReader;

import java.util.List;
import java.util.Locale;

public class PDFActivity extends Activity implements OnPageChangeListener, OnLoadCompleteListener {


    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;
    private TextToSpeech tts;
    String pdfContent = "";
    FloatingActionButton myFab;

    public String SAMPLE_FILE = "";//"android_tutorial.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("index");
        SAMPLE_FILE = message;
        //Toast.makeText(getApplicationContext(),SAMPLE_FILE,Toast.LENGTH_LONG);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        displayFromAsset(SAMPLE_FILE);

        myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            int result = tts.setLanguage(Locale.ENGLISH);
                            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                                Log.e("TTS", "This Language is not supported");
                            }
                            AsyncTaskExample asyncTask = new AsyncTaskExample();
                            asyncTask.execute();

                            //


                        } else {
                            Log.e("TTS", "Initilization Failed!");
                        }
                    }
                });

            }
        });
    }

    private class AsyncTaskExample extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {
            String parsedText = "";
            try {
                PdfReader reader = new PdfReader(getAssets().open(SAMPLE_FILE));

                int n = reader.getNumberOfPages();
                Log.e("pages", n + "");
                for (int i = 0; i < n; i++) {
                    parsedText = parsedText + PdfTextExtractor.getTextFromPage(reader, i + 1).trim(); //Extracting the content from the different pages
                    //parsedText   = parsedText+ PdfTextExtractor.getTextFromPage(reader, i+1).trim()+"\n"; //Extracting the content from the different pages
                    //Log.e("ram", parsedText);
                }
                String content=parsedText;
                reader.close();
                Log.e("ram", content);
                speak(content);


                reader.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            return parsedText;
        }

        @Override
        protected void onPostExecute(String parsedText) {
            //Log.e("shyam", parsedText);

        }
    }

    private void speak(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null,null);
        }
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(SAMPLE_FILE)
                .defaultPage(pageNumber)
                .enableSwipe(true)

                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            Log.e("ram", String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
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