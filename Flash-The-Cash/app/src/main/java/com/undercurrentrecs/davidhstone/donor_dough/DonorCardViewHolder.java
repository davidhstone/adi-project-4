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
    public TextView mRepName;
    public TextView mTopDonorIndustry;
    public TextView mTotalIndustryDonations;
    public TextView mPACDonations;
    public TextView mIndividualDonations;
    public Button mDonorShareButton;

    public DonorCardViewHolder(View itemView) {
        super(itemView);

        mDonorCardView = (CardView) itemView.findViewById(R.id.donor_card_view);
        mRepName = (TextView) itemView.findViewById(R.id.rep_name);
        mTopDonorIndustry = (TextView) itemView.findViewById(R.id.top_donor_industry);
        mTotalIndustryDonations = (TextView) itemView.findViewById(R.id.total_industry_donations);
        mPACDonations = (TextView) itemView.findViewById(R.id.pac_donations);
        mIndividualDonations = (TextView) itemView.findViewById(R.id.individual_donations);
        mDonorShareButton = (Button) itemView.findViewById(R.id.donor_share_button);
    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        itemView.setOnClickListener(onClickListener);
    }

    //CHANGE THE MEMBER VARIABLES AND CORRESPONDING VIEWS TO APPLICABLE DONOR DETAILS
}
