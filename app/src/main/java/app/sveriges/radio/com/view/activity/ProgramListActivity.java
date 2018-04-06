package app.sveriges.radio.com.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

import app.sveriges.radio.com.R;
import app.sveriges.radio.com.contract.ProgramListContract;
import app.sveriges.radio.com.model.entity.Programs;
import app.sveriges.radio.com.presenter.ProgramListPresenter;
import app.sveriges.radio.com.view.adapter.ProgramListAdapter;
import app.sveriges.radio.com.view.component.SimpleDividerItemDecoration;
import app.sveriges.radio.com.view.component.UIMessage;
import app.sveriges.radio.com.view.listener.OnRecyclerViewClickListener;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgramListActivity extends AppCompatActivity implements OnRecyclerViewClickListener, ProgramListContract.View{

    @BindView(R.id.activity_program_list_cl) CoordinatorLayout coordinatorLayout;
    @BindView(R.id.activity_progress_bar) ProgressBar progressBar;
    @BindView(R.id.activity_list_btn_retry) Button btRetry;
    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
    @BindView(R.id.toolbar) Toolbar toolbar;

    private static final String TAG = ProgramListActivity.class.getSimpleName();
    private ProgramListPresenter presenter;
    private ProgramListAdapter mProgramListAdapter;
    private LinearLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_list);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        // use a linear layout manager
        mRecyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // specify an adapter
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.line_divider)));
        mProgramListAdapter = new ProgramListAdapter(getApplicationContext(), this);
        mRecyclerView.setAdapter(mProgramListAdapter);

        // Creates presenter
        if (presenter == null) {
            presenter = new ProgramListPresenter(this);
        }

        presenter.initialize();
    }

    @OnClick(R.id.activity_list_btn_retry)
    public void onClick(View v) {
        presenter.initialize();
    }

    @Override
    public void onRecyclerViewClick(Programs clickedProgramObj) {
        //Log.e(TAG, "Inside onRecyclerViewClick()" + clickedProgramObj.getUrl());
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(clickedProgramObj.getUrl()));
        startActivity(browserIntent);
    }

    // =============================================================================
    // VIEW IMPLEMENTATION
    // =============================================================================

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showRetry() {
        btRetry.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetry() {
        btRetry.setVisibility(View.GONE);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void showTemporaryMessage(String message) {
        UIMessage.showMessage(coordinatorLayout, message);
    }

    @Override
    public void renderProgramList(final List<Programs> programs) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(programs != null){
                    mProgramListAdapter.setData(programs);
                }
            }
        }, 0);
    }
}
