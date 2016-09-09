package com.undercurrentrecs.davidhstone.donor_dough;

import java.util.ArrayList;

/**
 * Created by davidhstone on 9/7/16.
 */
public class DistrictObject {

    String mRepresentative;
    String mOffice;
    String mTopDonorSector;
    String mTotalSectorDonations;

    public DistrictObject(){
        mRepresentative = "Rep Name and Party";
        mOffice = "Office";
        mTopDonorSector = "Top Donor Sector";
        mTotalSectorDonations = "Total Sector Donations";
    }

    public DistrictObject(String representative, String office, String topDonorSector, String totalSectorDonations) {
        mRepresentative = representative;
        mOffice = office;
        mTopDonorSector = topDonorSector;
        mTotalSectorDonations = totalSectorDonations;
    }

    private ArrayList<DistrictObject> districtObjects;

    private void initializeDistrict() {
        districtObjects = new ArrayList<>();
        districtObjects.add(new DistrictObject("A", "Rep", "test", "damnit"));
        districtObjects.add(new DistrictObject("B", "Rep", "test", "jfhb"));
    }

    public String getmRepresentative() {
        return mRepresentative;
    }

    public void setmRepresentative(String mRepresentative) {
        this.mRepresentative = mRepresentative;
    }

    public String getmOffice() {
        return mOffice;
    }

    public void setmOffice(String mOffice) {
        this.mOffice = mOffice;
    }

    public String getmTopDonorSector() {
        return mTopDonorSector;
    }

    public void setmTopDonorSector(String mTopDonorSector) {
        this.mTopDonorSector = mTopDonorSector;
    }

    public String getmTotalSectorDonations() {
        return mTotalSectorDonations;
    }

    public void setmTotalSectorDonations(String mTotalSectorDonations) {
        this.mTotalSectorDonations = mTotalSectorDonations;
    }
}
