package com.undercurrentrecs.davidhstone.donor_dough;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.undercurrentrecs.davidhstone.donor_dough.models.industry.IndustryPojo;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DonorDetailActivity extends AppCompatActivity implements DonorCardAdapter.ItemDismissListener, DonorCardAdapter.ItemSelectListener{

    private static String baseUrl = "http://www.opensecrets.org/";

    private RecyclerView mRecyclerView;
    private DonorCardAdapter mAdapter;
    //private RecyclerView.Adapter mAdapter123;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemTouchHelper mTouchHelper;
    ArrayList<DonorObject> mArrayList;

    int onStarted = 0;

    String candID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mArrayList = new ArrayList<>();
        mArrayList.add(new DonorObject("Pauly McPolitician (D)", "Defense", "348795", "$25,000", "83475983"));
        mArrayList.add(new DonorObject("Don Beyer (D)", "Defense", "348795", "$25,000", "83475983"));
        mArrayList.add(new DonorObject("Don Beyer (D)", "Defense", "348795", "$25,000", "83475983"));
        mArrayList.add(new DonorObject("Vermin Supreme (I)", "URANUS 5", "348795", "$25,000", "83475983"));

        ArrayList<DonorObject> donorObjects = new ArrayList<>();
        Collections.fill(donorObjects, new DonorObject());
        //mArrayList = donorObjects;

        //mAdapter = new DonorCardAdapter(this, donorObjects);
        mAdapter = new DonorCardAdapter(this, mArrayList);


        mRecyclerView = (RecyclerView) findViewById(R.id.donor_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //mRecyclerView.setAdapter(new DonorCardAdapter(this, donorObjects));
        mRecyclerView.setAdapter(mAdapter);

        //mTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallBack(mAdapter));
        mTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(mAdapter));

        mTouchHelper.attachToRecyclerView(mRecyclerView);


        String candID = "N00036018";
        getIndustryInfo(candID);


        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});

    }

    protected void getIndustryInfo(String candID) {
        Log.d("DonorDetailActivity: ", "getting opensectrets info");
        Log.d("candID: ", candID);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            OpenSecretsIndustryService service = retrofit.create(OpenSecretsIndustryService.class);

            Call<IndustryPojo> call = service.getResponse(candID);

            call.enqueue(new Callback<IndustryPojo>() {

                @Override
                public void onResponse(Call<IndustryPojo> call, Response<IndustryPojo> response) {

                    try {
                        Toast.makeText(DonorDetailActivity.this, "Your API call worked!", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<IndustryPojo> call, Throwable t) {
                }
            });

        } else {
            Toast.makeText(DonorDetailActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelectListener(int position) {
      //  Intent intent = new Intent(this, DonorDetailActivity.class);
      //  intent.putExtra(SELECTED_POSITION, position);
      //  startActivity(intent);
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
                NavUtils.navigateUpFromSameTask(this);
                return true;

        }

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

}
