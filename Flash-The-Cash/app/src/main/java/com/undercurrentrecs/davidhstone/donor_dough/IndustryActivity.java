package com.undercurrentrecs.davidhstone.donor_dough;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.undercurrentrecs.davidhstone.donor_dough.models.industry.IndustryPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IndustryActivity extends AppCompatActivity implements DonorCardAdapter.ItemDismissListener, DonorCardAdapter.ItemSelectListener{


    private static String baseUrl = "http://www.opensecrets.org/";
    private static String openSecAPIKey = "2f3829405045a4eb46786856f65dee7d";

    private RecyclerView mRecyclerView;
    private DonorCardAdapter mAdapter;
    //private RecyclerView.Adapter mAdapter123;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemTouchHelper mTouchHelper;
    private ArrayList<DonorObject> mIndustryList;
    private String mCid;

    int onStarted = 0;

    //String cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

       // mArrayList = new ArrayList<>();
       // mArrayList.add(new DonorObject("Pauly McPolitician (D)", "Defense", "348795", "$25,000", "83475983"));
       // mArrayList.add(new DonorObject("Don Beyer (D)", "Defense", "348795", "$25,000", "83475983"));
       // mArrayList.add(new DonorObject("Don Beyer (D)", "Defense", "348795", "$25,000", "83475983"));
       // mArrayList.add(new DonorObject("Vermin Supreme (I)", "URANUS 5", "348795", "$25,000", "83475983"));

       // ArrayList<DonorObject> donorObjects = new ArrayList<>();
       // Collections.fill(donorObjects, new DonorObject());
        //mArrayList = donorObjects;

        //mAdapter = new DonorCardAdapter(this, donorObjects);
        //mAdapter = new DonorCardAdapter(this, mArrayList);

        mRecyclerView = (RecyclerView) findViewById(R.id.donor_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(IndustryActivity.this));

        mIndustryList = new ArrayList<DonorObject>();
        //mAdapter = new DonorCardAdapter(this, mDonorList);

        //mRecyclerView.setAdapter(mAdapter);

        //mRecyclerView.setAdapter(new DonorCardAdapter(this, donorObjects));

        //mTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallBack(mAdapter));
        mTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback(mAdapter));

        mTouchHelper.attachToRecyclerView(mRecyclerView);


        mCid = "N00036018";
        getIndustryInfo(mCid);


        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //                .setAction("Action", null).show();
        //    }
        //});

    }

    protected void getIndustryInfo(final String mCid) {
        Log.d("IndustryActivity: ", "getting opensectrets info");
        Log.d("cid: ", mCid);

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            OpenSecretsIndustryService service = retrofit.create(OpenSecretsIndustryService.class);

            Call<IndustryPojo> call = service.getResponse(mCid);

            call.enqueue(new Callback<IndustryPojo>() {

                @Override
                public void onResponse(Call<IndustryPojo> call, Response<IndustryPojo> response) {

                    Log.d("call: ", call.request().toString());
                    Log.d("onResponse cid: ", mCid);
                    Log.d("donorObject: ", response.body().getResponse().getIndustries().toString());



                    try {

                       // Toast.makeText(IndustryActivity.this, "Your API call worked!", Toast.LENGTH_LONG).show();

                        String representative = response.body().getResponse().getIndustries().getAttributes().getCandName();

                      //  List = response.body().getResponse().getIndustries().getIndustry();

                        //for(Industry industry : response.body().getResponse().getIndustries().getIndustry().get().getAttributes()) {
                        //    mIndustryList.add(industry);
                        //}

                        for (int i = 0; i <= 9; i++) {

                            String industry = response.body().getResponse().getIndustries().getIndustry().get(i).getAttributes().getIndustryName();
                            String totalDonations = response.body().getResponse().getIndustries().getIndustry().get(i).getAttributes().getTotal();
                            String pACDonations = response.body().getResponse().getIndustries().getIndustry().get(i).getAttributes().getPacs();
                            String individualDonations = response.body().getResponse().getIndustries().getIndustry().get(i).getAttributes().getIndivs();

                            DonorObject donorObject = new DonorObject();
                            donorObject.setmRepresentative(representative);
                            donorObject.setmTopDonorIndustry(industry);
                            donorObject.setmTotalIndustryDonations(totalDonations);
                            donorObject.setmPACDonations(pACDonations);
                            donorObject.setmIndividualDonations(individualDonations);


                            Log.d("donor mRep: ", representative);
                            Log.d("donor industry: ", industry);
                            Log.d("total donations: ", totalDonations);
                            Log.d("PAC donations: ", pACDonations);
                            Log.d("individual donations: ", individualDonations);
                            //Log.v(ArrayList.toString(mDonorList));


                            mIndustryList.add(donorObject);

                            mAdapter = new DonorCardAdapter(IndustryActivity.this, mIndustryList);

                            mRecyclerView.setAdapter(mAdapter);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(Call<IndustryPojo> call, Throwable t) {
                }
            });

        } else {
            Toast.makeText(IndustryActivity.this, "No network connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelectListener(int position) {
      //  Intent intent = new Intent(this, IndustryActivity.class);
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
