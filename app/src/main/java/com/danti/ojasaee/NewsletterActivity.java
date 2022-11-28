package com.danti.ojasaee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

public class NewsletterActivity extends Activity implements OnPageChangeListener, OnLoadCompleteListener {

    PDFView pdfView;
    Integer pageNumber = 0;
    String pdfFileName;


    public String SAMPLE_FILE = "newsletter.pdf";//"android_tutorial.pdf";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsletter);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        //Toast.makeText(getApplicationContext(),SAMPLE_FILE,Toast.LENGTH_LONG);
        displayFromAsset(SAMPLE_FILE);
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