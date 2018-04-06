package app.sveriges.radio.com.view.component;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import app.sveriges.radio.com.Environment;


/**
 * Created by Mustafizur Rahman on 04/04/2018.
 */

public class UIMessage {

    public static void showMessage(View parent, String message) {
        if (Environment.useSnackbar) {
            Snackbar.make(parent, message, Snackbar.LENGTH_LONG).show();
        } else {
            Toast.makeText(parent.getContext(), message, Toast.LENGTH_LONG).show();
        }
    }
}
