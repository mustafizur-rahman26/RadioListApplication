package app.sveriges.radio.com.model.network;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */
public interface NetworkCallback {
    void success(String body);
    void failure(String body);
}
