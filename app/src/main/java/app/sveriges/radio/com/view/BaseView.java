package app.sveriges.radio.com.view;

import android.content.Context;

/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public interface BaseView {
    Context getContext();
    void showTemporaryMessage(String message);
}
