package com.undercurrentrecs.davidhstone.donor_dough;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by davidhstone on 9/7/16.
 */
public class DistrictCardAdapter extends RecyclerView.Adapter<DistrictCardViewHolder>
        implements ItemTouchHelperCallback.ItemTouchHelperAdapter {

    private Context context;

    private static final String TAG = "DistrictCardAdapter";

    private ArrayList<DistrictObject> mDistrictObjectsList;

    private ItemSelectListener mItemSelectListener;
    private ItemDismissListener mItemDismissListener;


    public DistrictCardAdapter(Context c, ArrayList<DistrictObject> districtObjectList){
        context = c;
        mDistrictObjectsList = districtObjectList;
    }

    @Override
    public DistrictCardViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        mItemSelectListener = (ItemSelectListener) parent.getContext();
        mItemDismissListener = (ItemDismissListener) parent.getContext();

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.district_card_view, parent, false);
        DistrictCardViewHolder districtViewHolder = new DistrictCardViewHolder(itemView);
        return districtViewHolder;


    }

    @Override
    public void onBindViewHolder(DistrictCardViewHolder holder, final int position) {

        holder.mRepName.setText(mDistrictObjectsList.get(position).mRepresentative);
        holder.mOffice.setText(mDistrictObjectsList.get(position).mOffice);
        holder.mSectorTopDonor.setText(mDistrictObjectsList.get(position).mTopDonorSector);
        holder.mTotalSectorDonations.setText(mDistrictObjectsList.get(position).mTotalSectorDonations);

        holder.mDistrictShareButton.setOnClickListener(new View.OnClickListener() {
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

   // @Override
   // public void onAttachedToRecyclerView(RecyclerView recyclerView) {
   //     super.onAttachedToRecyclerView(recyclerView);
   // }

    @Override
    public int getItemCount() {
        return mDistrictObjectsList.size();
    }

    @Override
    public void onItemDismiss(int position) {
        mDistrictObjectsList.remove(position);
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
