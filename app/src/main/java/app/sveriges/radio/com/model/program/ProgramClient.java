package app.sveriges.radio.com.model.program;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import app.sveriges.radio.com.Environment;
import app.sveriges.radio.com.model.BaseClient;
import app.sveriges.radio.com.model.entity.Programs;
import app.sveriges.radio.com.model.network.NetworkCallback;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */

public class ProgramClient extends BaseClient {

    private static final String TAG = ProgramClient.class.getName();

    public ProgramClient() {
        super();
    }

    public void getProgramList(@NonNull final ProgramRepository.ProgramListListener callback) {

        String postUrl = Environment.PROGRAM_API_URL;

        // Configure post response
        NetworkCallback networkCallback = new NetworkCallback() {
            @Override
            public void success(String body) {
                //Log.i(TAG, "Response: " + body);
                JSONObject mainJsonObject = null;
                JSONArray programArray = null;
                try {
                    mainJsonObject = new JSONObject(body);
                    programArray =  mainJsonObject.getJSONArray("programs");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Programs[] programs = new Gson().fromJson(String.valueOf(programArray), Programs[].class);
                callback.onProgramListReceived(Arrays.asList(programs));
            }

            @Override
            public void failure(String body) {
                String message = "";
                if (!TextUtils.isEmpty(body)) {
                    Error error = new Gson().fromJson(body, Error.class);
                    message = error.getMessage();
                }
                callback.onFailure(message);
            }
        };

        makeGetRequest(postUrl, networkCallback);
    }
}
