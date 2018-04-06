package app.sveriges.radio.com.contract;

import java.util.List;

import app.sveriges.radio.com.model.entity.Programs;
import app.sveriges.radio.com.view.LoadingView;

/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public interface ProgramListContract {

    /** Represents the View in MVP. */
    interface View extends LoadingView{
        void renderProgramList(List<Programs> programs);
    }

    /** Represents the Presenter in MVP. */
    interface Presenter {
        void initialize();
        void destroy();
    }
}
