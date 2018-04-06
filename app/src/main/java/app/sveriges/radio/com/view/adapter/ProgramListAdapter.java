package app.sveriges.radio.com.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.sveriges.radio.com.model.entity.Programs;
import app.sveriges.radio.com.view.holder.ProgramListViewHolder;
import app.sveriges.radio.com.view.listener.OnHolderClickListener;
import app.sveriges.radio.com.view.listener.OnRecyclerViewClickListener;

/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public class ProgramListAdapter extends RecyclerView.Adapter<ProgramListViewHolder> implements OnHolderClickListener{

    private static final String TAG = ProgramListAdapter.class.getSimpleName();
    private Context context;
    private OnRecyclerViewClickListener clickListener;
    private List<Programs> mProgramData;

    public ProgramListAdapter(Context context, OnRecyclerViewClickListener clickListener) {
        this.context = context;
        this.clickListener = clickListener;
        //Log.i(TAG, "Inside ProgramListAdapter() constructor :: size: " + mProgramData.getmPhotos().size());
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProgramListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(ProgramListViewHolder.getLayoutId(), parent, false);
        ProgramListViewHolder vh = new ProgramListViewHolder(v, this);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ProgramListViewHolder holder, int position) {
        holder.render(context, position, mProgramData);
    }

    @Override
    public int getItemCount() {
        return mProgramData == null ? 0 : mProgramData.size();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onClick(int holderPosition) {
        clickListener.onRecyclerViewClick(mProgramData.get(holderPosition));
    }

    public void setData(List<Programs> programs) {
        this.mProgramData = programs;
        notifyDataSetChanged();
    }
}