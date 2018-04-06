package app.sveriges.radio.com.view;

import android.app.Application;
import app.sveriges.radio.com.Environment;


/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Environment.configure();
    }
}
