package com.undercurrentrecs.davidhstone.donor_dough;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class DistrictActivity extends AppCompatActivity implements DistrictCardAdapter.ItemDismissListener, DistrictCardAdapter.ItemSelectListener{

    private static final String TAG = "MainActivity";
    public static final String SELECTED_POSITION = "selected_position";

    private RecyclerView mRecyclerView;
    private DistrictCardAdapter mAdapter;
    //private RecyclerView.Adapter mAdapter123;
    private RecyclerView.LayoutManager mLayoutManager;
    private ItemTouchHelper mTouchHelper;
    ArrayList<DistrictObject> mArrayList;

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
                Intent intent = new Intent(DistrictActivity.this, DonorDetailActivity.class);
                startActivity(intent);
                finish();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DistrictActivity.this, DistrictActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
    //FOR NOW THIS IS FINE, BUT I WANT TO SAVE THE RESUOLTS LIKE THIS
    @Override
    public void onItemSelectListener(int position) {
        Intent intent = new Intent(this, DonorDetailActivity.class);
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
