package com.undercurrentrecs.davidhstone.donor_dough;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by davidstone on 9/8/16.
 */
public class DonorCardViewHolder extends RecyclerView.ViewHolder{

    public CardView mDonorCardView;
    public TextView mIndustryName;
    public TextView mIndustryTopDonor;
    public TextView mTotalIndustryDonations;
    public Button mDonorShareButton;

    public DonorCardViewHolder(View itemView) {
        super(itemView);

        mDonorCardView = (CardView) itemView.findViewById(R.id.district_card_view);
        mIndustryName = (TextView) itemView.findViewById(R.id.rep_name);
        mIndustryTopDonor = (TextView) itemView.findViewById(R.id.sector_top_donors);
        mTotalIndustryDonations = (TextView) itemView.findViewById(R.id.total_sector_donations);
        mDonorShareButton = (Button) itemView.findViewById(R.id.district_share_button);
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        itemView.setOnClickListener(onClickListener);
    }

    //CHANGE THE MEMBER VARIABLES AND CORRESPONDING VIEWS TO APPLICABLE DONOR DETAILS
}
