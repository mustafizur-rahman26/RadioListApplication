package app.sveriges.radio.com.presenter;


import android.util.Log;

import java.util.List;

import app.sveriges.radio.com.contract.ProgramListContract;
import app.sveriges.radio.com.model.entity.Programs;
import app.sveriges.radio.com.model.program.ProgramRepository;

/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public class ProgramListPresenter implements ProgramListContract.Presenter, ProgramRepository.ProgramListListener {

    private static final String TAG = ProgramListPresenter.class.getSimpleName();
    private ProgramListContract.View view;
    private ProgramRepository programRepository;

    public ProgramListPresenter(ProgramListContract.View view) {
        this.view = view;
        this.programRepository = new ProgramRepository(view.getContext());
    }

    // =====================================================================
    // PRESENTER
    // =====================================================================

    @Override
    public void initialize() {
        view.showLoading();
        view.hideRetry();
        programRepository.getProgramList(this);
    }

    @Override
    public void destroy() {
        view = null;
        programRepository = null;
    }

    // =======================================================================
    // MODEL CALLBACK
    // =======================================================================

    @Override
    public void onProgramListReceived(List<Programs> programsList) {
        view.hideLoading();
        view.renderProgramList(programsList);
    }

    @Override
    public void onFailure(String message) {
        view.hideLoading();
        view.showRetry();
        view.showTemporaryMessage(message);
    }
}
