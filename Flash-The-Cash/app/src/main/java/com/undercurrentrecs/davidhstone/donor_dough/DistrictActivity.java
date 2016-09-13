package com.undercurrentrecs.davidhstone.donor_dough;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DistrictActivity extends AppCompatActivity implements DistrictCardAdapter.ItemDismissListener, DistrictCardAdapter.ItemSelectListener{

    //private static String geoCoderBaseUrl = "https://usgeocoder.com/";
    //private static String geoCoderAPIKey = "bee6806f18ffe3624349d1bb1beb1cd2";
    private static final String geoCoderURL = "https://usgeocoder.com/api/get_info.php?address=3017%20Rosemary%20Ln%20&zipcode=22042&authkey=bee6806f18ffe3624349d1bb1beb1cd2";

    private static String mGeoCoderURL_ADDRESS;

    private static final String TAG = "MainActivity";
    public static final String SELECTED_POSITION = "selected_position";

    private EditText mStreetAddressEntry;
    private EditText mZipcodeEntry;

    //private DownloadTask mDistrictInfotask;

    private RecyclerView mRecyclerView;
    private DistrictCardAdapter mAdapter;
    //private RecyclerView.Adapter mAdapter123;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemTouchHelper mTouchHelper;
    ArrayList<DistrictObject> mArrayList;

    WeakReference<Context> mContextReference;

    Button mGetIndustryButton;


    int onStarted = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        String representative = getIntent().getExtras().getString("representative");

        Log.d("intent repName: ", representative);

        getNewName(representative);
       // read();

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();



        mArrayList = new ArrayList<>();
        mArrayList.add(new DistrictObject("Pauly McPolitician (D)", "District: VA08", "Top Donor Sector: XYZ", "$25,000"));
        mArrayList.add(new DistrictObject("Don Beyer (D)", "VA08", "Top Sector: Defense", "$23,500"));
        mArrayList.add(new DistrictObject("Don Beyer (D)", "VA08", "Top Sector: Public Unionse", "$21,000"));
        mArrayList.add(new DistrictObject("Vermin Supreme (I)", "US#1", "Top Sector: Ponies", "$4985745,000"));

        ArrayList<DistrictObject> districtObjects = new ArrayList<>();
        Collections.fill(districtObjects, new DistrictObject());


        //mAdapter = new DistrictCardAdapter(districtObjects);
        mAdapter = new DistrictCardAdapter(this, mArrayList);


        mRecyclerView = (RecyclerView) findViewById(R.id.district_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


       // mRecyclerView.setAdapter(new DistrictCardAdapter(districtObjects));
        mRecyclerView.setAdapter(mAdapter);

        //mTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallBack(mAdapter));
        mTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(mAdapter));

        mTouchHelper.attachToRecyclerView(mRecyclerView);


        mGetIndustryButton = (Button) findViewById(R.id.get_industry_button);
        mGetIndustryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DistrictActivity.this, IndustryActivity.class);
                startActivity(intent);
                finish();
            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(DistrictActivity.this, DistrictActivity.class);
                //startActivity(intent);
                //finish();

                mStreetAddressEntry = (EditText) findViewById(R.id.district_street_address_edittext);
                String rawAddressString = mStreetAddressEntry.getText().toString();
                rawAddressString += " ";
                String encodedAddressString = rawAddressString.replaceAll(" ", "%20");
                mZipcodeEntry = (EditText) findViewById(R.id.district_zipcode_edittext);
                String zipcodeString = mZipcodeEntry.getText().toString();

                mGeoCoderURL_ADDRESS = "https://usgeocoder.com/api/get_info.php?address=" + encodedAddressString +
                        "&zipcode=" + zipcodeString + "&authkey=" + MainActivity.geoCoderAPIKey;

                // geoCoderURLAddress = mGeoCoderURL_ADDRESS;

                Log.d("mURL_ADDRESS", mGeoCoderURL_ADDRESS);
                Log.d("URL_ADDRESS", geoCoderURL);

                //mDistrictInfotask = new MainActivity.DownloadTask();
                //mDistrictInfotask.execute(mGeoCoderURL_ADDRESS);

            }
        });

    }

    public String getNewName (String representative) {

        Log.d("starting repName: ", representative);

        String name = "Don Beyer (D)";

        int start = name.indexOf(' ');
        int end = name.lastIndexOf(' ');

        String firstName = "";
        String lastName = "";
        String partyName = "";

        if (start >= 0) {
            firstName = name.substring(0, start);
            if (end > start)
                lastName = name.substring(start + 1, end);
            partyName = name.substring(end + 1, name.length());
        }

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(partyName);

        String newName = lastName + ", " + firstName;

        System.out.println(newName);

        return newName;
    }



    //FOR NOW THIS IS FINE, BUT I WANT TO SAVE THE RESUOLTS LIKE THIS
    @Override
    public void onItemSelectListener(int position) {
        Intent intent = new Intent(this, IndustryActivity.class);
        intent.putExtra(SELECTED_POSITION, position);
        startActivity(intent);
    }

    @Override
    public void onItemDismissListener() {
       // if (YelpHelper.getInstance().getBusinesses().size() < 5) {
       //     YelpSearchTask task = new YelpSearchTask();
       //     if (!(task.getStatus() == AsyncTask.Status.RUNNING)) {
       //         task.execute();
       //     }
       // }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                onNavigateUp();
                //   NavUtils.navigateUpFromSameTask(this);
                return true;

        }

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

}
