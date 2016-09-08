package com.example.davidstone.flash_the_cash;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.davidstone.flash_the_cash.R;

/**
 * Created by davidstone on 9/7/16.
 */
public class DistrictCardViewHolder extends RecyclerView.ViewHolder {

    public CardView mDistrictCardView;
    public TextView mRepName;
    public TextView mOffice;
    public TextView mSectorTopDonor;
    public TextView mTotalSectorDonations;
    public Button mDistrictShareButton;

    public DistrictCardViewHolder(View itemView) {
        super(itemView);

        mDistrictCardView = (CardView) itemView.findViewById(R.id.district_card_view);
        mRepName = (TextView) itemView.findViewById(R.id.rep_name);
        mOffice = (TextView) itemView.findViewById(R.id.office_held);
        mSectorTopDonor = (TextView) itemView.findViewById(R.id.sector_top_donors);
        mTotalSectorDonations = (TextView) itemView.findViewById(R.id.total_sector_donations);
        mDistrictShareButton = (Button) itemView.findViewById(R.id.district_share_button);

    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        itemView.setOnClickListener(onClickListener);
    }

    public TextView getmRepName() {
        return mRepName;
    }

    public TextView getmOffice() {
        return mOffice;
    }

    public TextView getmSectorTopDonor() {
        return mSectorTopDonor;
    }

    public TextView getmTotalSectorDonations() {
        return mTotalSectorDonations;
    }

    public Button getmDistrictShareButton() {
        return mDistrictShareButton;
    }
}
