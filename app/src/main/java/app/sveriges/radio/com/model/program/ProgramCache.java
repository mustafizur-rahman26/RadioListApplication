package app.sveriges.radio.com.model.program;

import android.content.Context;


import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import app.sveriges.radio.com.Environment;
import app.sveriges.radio.com.model.BaseCache;
import app.sveriges.radio.com.model.entity.CachedData;
import app.sveriges.radio.com.model.entity.Programs;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */

public class ProgramCache extends BaseCache {

    private static final String LIST_ID = "LIST";
    private static final String CACHE_PROGRAM_FILE_NAME = "Programs.json";

    public ProgramCache(Context context) {
        super(context, CACHE_PROGRAM_FILE_NAME);
    }

    public void saveList(List<Programs> programsList) {
        String responseJson = gson.toJson(programsList);
        // Search if there was a previous response
        CachedData cachedData = find(LIST_ID);
        // If there was no previous response, create object
        if (cachedData == null) {
            cachedData = new CachedData(LIST_ID);
        }
        // Update response
        cachedData.saveResponse(responseJson);
        save(cachedData);
    }

    public boolean savedListIsValid() {
        CachedData foundCachedData = find(LIST_ID);
        return foundCachedData != null && System.currentTimeMillis() - foundCachedData.savedTimestamp < Environment.CACHE_MAX_LIFETIME_IN_MILLIS;
    }

    /**
     * Gets saved list of Programs.
     * @return The post list or null if there is no data.
     */

    public List<Programs> getList() {
        List<Programs> programsList = null;

        CachedData foundCachedData = find(LIST_ID);
        if (foundCachedData != null && System.currentTimeMillis() - foundCachedData.savedTimestamp < Environment.CACHE_MAX_LIFETIME_IN_MILLIS) {
            Type listType = new TypeToken<ArrayList<Programs>>() {
            }.getType();
            programsList = gson.fromJson(foundCachedData.responseJson, listType);
        }

        return programsList;
    }
}
