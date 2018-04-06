package app.sveriges.radio.com.model.program;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;


import java.util.List;

import app.sveriges.radio.com.model.RepositoryListener;
import app.sveriges.radio.com.model.entity.Programs;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */

public class ProgramRepository {

    private static final String TAG = ProgramRepository.class.getName();
    private ProgramClient client;
    private ProgramCache cache;

    public ProgramRepository(Context context) {
        client = new ProgramClient();
        cache = new ProgramCache(context);
    }

    public void getProgramList(@NonNull final ProgramListListener programCallback) {
        //Log.i(TAG, "Requesting list... :: Cache status: " + cache.savedListIsValid());
        if (cache.savedListIsValid()) {
            Log.i(TAG, "Saved list is still valid");
            // Return saved data
            programCallback.onProgramListReceived(cache.getList());
        } else {
            Log.i(TAG, "No saved list.");

            ProgramListListener programListListener = new ProgramListListener() {
                @Override
                public void onProgramListReceived(List<Programs> programsList) {
                    // Save response for future requests
                    cache.saveList(programsList);
                    // Return response to callback
                    programCallback.onProgramListReceived(programsList);
                }

                @Override
                public void onFailure(String message) {
                    programCallback.onFailure(message);
                }
            };

            client.getProgramList(programListListener);
        }
    }

    // =============================================================================
    // CALLBACKS
    // =============================================================================

    public interface ProgramListListener extends RepositoryListener {
        void onProgramListReceived(List<Programs> programsList);
    }
}
