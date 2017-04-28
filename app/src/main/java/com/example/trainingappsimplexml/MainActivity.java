package com.example.trainingappsimplexml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get data from XML
        String xmlData = getDataFromAssets();

        // Parse data using SimpleXML
        Serializer serializer = new Persister();
        Reader reader = new StringReader(xmlData);

        try {
            Cinema cinema = serializer.read(Cinema.class,reader,false);
            Log.d(TAG,cinema.name);
            for(Movie m:cinema.movies) {
                Log.d(TAG,m.title);
                Log.d(TAG,Integer.toString(m.year));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getDataFromAssets() {
        StringBuilder buf = null;

        try {
            buf=new StringBuilder();

            InputStream is = getAssets().open("xmltest.xml");
            BufferedReader in= new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String str;

            while ((str=in.readLine()) != null) {
                buf.append(str);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buf.toString();
    }
}
