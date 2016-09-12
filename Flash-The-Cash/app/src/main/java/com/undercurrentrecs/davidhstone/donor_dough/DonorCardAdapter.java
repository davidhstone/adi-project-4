package com.undercurrentrecs.davidhstone.donor_dough;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by davidstone on 9/8/16.
 */
public class DonorCardAdapter extends RecyclerView.Adapter<DonorCardViewHolder>
        implements ItemTouchHelperCallback.ItemTouchHelperAdapter{

    private Context context;

    private static final String TAG = "DonorCardAdapter";

    private ArrayList<DonorObject> mDonorObjectsList;

    private ItemSelectListener mItemSelectListener;
    private ItemDismissListener mItemDismissListener;

    public DonorCardAdapter(Context c, ArrayList<DonorObject> industryList){
        context = c;
        mDonorObjectsList = industryList;
    }

    @Override
    public DonorCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mItemSelectListener = (ItemSelectListener) parent.getContext();
        mItemDismissListener = (ItemDismissListener) parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.donor_detail_card_view, parent, false);
        DonorCardViewHolder donorViewHolder = new DonorCardViewHolder(itemView);
        return donorViewHolder;

    }

    @Override
    public void onBindViewHolder(DonorCardViewHolder holder, final int position) {

        holder.mRepName.setText(mDonorObjectsList.get(position).mRepresentative);
        holder.mTopDonorIndustry.setText("Industry: " + mDonorObjectsList.get(position).mTopDonorIndustry);
        holder.mTotalIndustryDonations.setText("Total Donations: $" + mDonorObjectsList.get(position).mTotalIndustryDonations);
        holder.mPACDonations.setText("PAC Donations: $" + mDonorObjectsList.get(position).mPACDonations);
        holder.mIndividualDonations.setText("Indiv. Donations" + mDonorObjectsList.get(position).mIndividualDonations);


        holder.mDonorShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "TEST SHARE");
                //sendIntent.putExtra(Intent.EXTRA_TEXT, mBusiness.url());
                context.startActivity(Intent.createChooser(sendIntent, "How do you want to share?"));
            }
        });

    }


    @Override
    public int getItemCount() {
        return mDonorObjectsList.size();
    }

    @Override
    public void onItemDismiss(int position) {
        mDonorObjectsList.remove(position);
        notifyItemRemoved(position);
        mItemDismissListener.onItemDismissListener();
    }


    @Override
    public void onItemSelect(int position) {
        mItemSelectListener.onItemSelectListener(position);
    }

    public interface ItemSelectListener {
        void onItemSelectListener(int position);
    }

    public interface ItemDismissListener {
        void onItemDismissListener();
    }
}
