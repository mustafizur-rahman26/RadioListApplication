package app.sveriges.radio.com.view.component;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */

public class ImageLoader {

    public static void loadImage(Context context, String url, ImageView iv) {
        Glide.with(context).load(url).into(iv);
    }
}
