package com.undercurrentrecs.davidhstone.donor_dough;

import java.util.ArrayList;

/**
 * Created by davidstone on 9/8/16.
 */
public class DonorObject {

    String mIndustry;
    String mTopDonorIndustry;
    String mTotalIndustryDonations;

    public DonorObject(){

        mIndustry = "Industry Name";
        mTopDonorIndustry = "Top Donor Industry";
        mTotalIndustryDonations = "Total Industry Donations";
    }

    public DonorObject(String industry, String topDonorIndustry, String totalIndustryDonations) {

        mIndustry = industry;
        mTopDonorIndustry = topDonorIndustry;
        mTotalIndustryDonations = totalIndustryDonations;
    }

    private ArrayList<DonorObject> donorObjects;

    private void initializeDonor() {

        donorObjects = new ArrayList<>();
        donorObjects.add(new DonorObject("A", "test", "damnit"));
        donorObjects.add(new DonorObject("B", "test", "jfhb"));
    }

    public String getmIndustry() {
        return mIndustry;
    }

    public void setmIndustry(String mIndustry) {
        this.mIndustry = mIndustry;
    }

    public String getmTopDonorIndustry() {
        return mTopDonorIndustry;
    }

    public void setmTopDonorIndustry(String mTopDonorIndustry) {
        this.mTopDonorIndustry = mTopDonorIndustry;
    }

    public String getmTotalIndustryDonations() {
        return mTotalIndustryDonations;
    }

    public void setmTotalIndustryDonations(String mTotalIndustryDonations) {
        this.mTotalIndustryDonations = mTotalIndustryDonations;
    }
}
