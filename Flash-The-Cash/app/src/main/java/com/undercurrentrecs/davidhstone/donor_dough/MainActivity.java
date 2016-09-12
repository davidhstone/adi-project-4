package com.undercurrentrecs.davidhstone.donor_dough;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String geoCoderBaseUrl = "https://usgeocoder.com/";
    private static String geoCoderAPIKey = "bee6806f18ffe3624349d1bb1beb1cd2";
    private static final String geoCoderURL = "https://usgeocoder.com/api/get_info.php?address=3017%20Rosemary%20Ln%20&zipcode=22042&authkey=bee6806f18ffe3624349d1bb1beb1cd2";

    private static String mGeoCoderURL_ADDRESS;

    private EditText mStreetAddressEntry;
    private EditText mZipcodeEntry;

    private DownloadTask mDistrictInfotask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mStreetAddressEntry = (EditText) findViewById(R.id.street_address_edittext);
        mZipcodeEntry = (EditText) findViewById(R.id.zipcode_edittext);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    // String geoCoderURLAddress = "";

                    mStreetAddressEntry = (EditText) findViewById(R.id.street_address_edittext);
                    String rawAddressString = mStreetAddressEntry.getText().toString();
                    rawAddressString += " ";
                    String encodedAddressString = rawAddressString.replaceAll(" ", "%20");
                    mZipcodeEntry = (EditText) findViewById(R.id.zipcode_edittext);
                    String zipcodeString = mZipcodeEntry.getText().toString();

                    mGeoCoderURL_ADDRESS = "https://usgeocoder.com/api/get_info.php?address=" + encodedAddressString +
                            "&zipcode=" + zipcodeString + "&authkey=" + geoCoderAPIKey;

                   // geoCoderURLAddress = mGeoCoderURL_ADDRESS;

                    Log.d("mURL_ADDRESS", mGeoCoderURL_ADDRESS);
                    Log.d("URL_ADDRESS", geoCoderURL);

                mDistrictInfotask = new DownloadTask();
                //mDistrictInfotask.execute(mGeoCoderURL_ADDRESS);
                mDistrictInfotask.execute(geoCoderURL);

            }
        });
    }

    private String downloadUrl(String myUrl) throws IOException, JSONException {
        InputStream is = null;
        try {
            URL url = new URL(myUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // Starts the query
            conn.connect();
            is = conn.getInputStream();
            //Convert the InputStream into a string
            String xmlContentAsString = readIt(is);
            //convert xml input to json
            JSONObject jsonObject = null;

            jsonObject = XML.toJSONObject(xmlContentAsString);

            //convert json to string
            String jsonObjectAsString = jsonObject.toString();

            Log.d("XML", xmlContentAsString);

            Log.d("JSON", jsonObject.toString());

            return parseJson(jsonObjectAsString);
            // Makes sure that the InputStream is closed after the app is
            // finished using it.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private String parseJson(String jsonObjectAsString) throws JSONException {
        List<String> items = new ArrayList<>();

        JSONObject root = new JSONObject(jsonObjectAsString);

        JSONObject usgeo = root.getJSONObject("usgeocoder");
        JSONObject juris_info = usgeo.getJSONObject("jurisdictions_info");
        JSONObject legislators = juris_info.getJSONObject("congressional_legislators");
        JSONObject house = legislators.getJSONObject("house_of_representative");

        String representativeName = house.getString("representative_1");

        // itemList += itemName + "\n";

        Log.d("representative_1", representativeName);

        return representativeName;
    }

    public String readIt(InputStream stream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String read;

        while ((read = br.readLine()) != null) {
            sb.append(read);
        }
        return sb.toString();
    }

    private class DownloadTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String representativeName = "";

            try {
                representativeName = downloadUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return representativeName;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String representativeName) {
            //mItems.clear();
            //mItems.addAll(items);
            //mAdapter.notifyDataSetChanged();

           // mRepNameTextView.setText(representativeName);
            Log.d("representative_1", representativeName);

            Intent intent = new Intent(MainActivity.this, DistrictActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("representative", representativeName);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

//        switch (item.getItemId()) {
//
//            case android.R.id.home:
//                onNavigateUp();
//             //   NavUtils.navigateUpFromSameTask(this);
//                return true;
//
//        }

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }
}
