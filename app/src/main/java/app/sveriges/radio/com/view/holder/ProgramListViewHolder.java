package app.sveriges.radio.com.view.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.sveriges.radio.com.R;
import app.sveriges.radio.com.model.entity.Programs;
import app.sveriges.radio.com.view.component.ImageLoader;
import app.sveriges.radio.com.view.listener.OnHolderClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public class ProgramListViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.name) TextView tvName;
    @BindView(R.id.image) ImageView ivImage;

    private static final String TAG = ProgramListViewHolder.class.getSimpleName();
    private int holderPosition;

    private OnHolderClickListener clickListener;
    public static int getLayoutId() {
        return R.layout.item_program;
    }

    public ProgramListViewHolder(View v, OnHolderClickListener clickListener) {
        super(v);
        this.clickListener = clickListener;
        ButterKnife.bind(this, v);
    }

    public void render(Context context, int position, List<Programs> program) {
        //Log.d(TAG, "position: " + position + " post: " + post.toString());
        holderPosition = position;

        tvName.setText(program.get(position).getName());
        ImageLoader.loadImage(context, program.get(position).getImage(), ivImage);
    }

    @OnClick(R.id.item_main_container)
    public void onClick() {
        //Log.e(TAG, "clickListener :: holderPosition: " + holderPosition);
        if (clickListener != null) {
            clickListener.onClick(holderPosition);
        }
    }
}
