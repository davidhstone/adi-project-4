package com.undercurrentrecs.davidhstone.donor_dough;

import java.util.ArrayList;

/**
 * Created by davidstone on 9/8/16.
 */
public class DonorObject {

    String mRepresentative;
    String mTopDonorIndustry;
    String mTotalIndustryDonations;
    String mPACDonations;
    String mIndividualDonations;

    public DonorObject(){

        mRepresentative = "Rep Name and Party";
        mTopDonorIndustry = "Top Donor Industry";
        mTotalIndustryDonations = "Total Industry Donations";
        mPACDonations = "Total PAC Donations";
        mIndividualDonations = "Total Individual Donations";
    }

    public DonorObject(String representative, String topDonorIndustry, String totalIndustryDonations,
                       String pACDonations, String individualDonations) {

        mRepresentative = representative;
        mTopDonorIndustry = topDonorIndustry;
        mTotalIndustryDonations = totalIndustryDonations;
        mPACDonations = pACDonations;
        mIndividualDonations = individualDonations;
    }

   // private ArrayList<DonorObject> donorObjects;
//
   // private void initializeDonor() {
//
   //     donorObjects = new ArrayList<>();
   //     donorObjects.add(new DonorObject("A", "B", "98745", "943875", "987435"));
   //     donorObjects.add(new DonorObject("B", "C", "98745", "943875", "987435"));
   // }

    public String getmRepresentative() {
        return mRepresentative;
    }

    public void setmRepresentative(String mRepresentative) {
        this.mRepresentative = mRepresentative;
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

    public String getmPACDonations() {
        return mPACDonations;
    }

    public void setmPACDonations(String mPACDonations) {
        this.mPACDonations = mPACDonations;
    }

    public String getmIndividualDonations() {
        return mIndividualDonations;
    }

    public void setmIndividualDonations(String mIndividualDonations) {
        this.mIndividualDonations = mIndividualDonations;
    }

  //  public ArrayList<DonorObject> getDonorObjects() {
  //      return donorObjects;
  //  }
//
  //  public void setDonorObjects(ArrayList<DonorObject> donorObjects) {
  //      this.donorObjects = donorObjects;
  //  }
}
