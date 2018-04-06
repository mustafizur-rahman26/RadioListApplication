package app.sveriges.radio.com.model;


import app.sveriges.radio.com.Environment;
import app.sveriges.radio.com.model.network.Network;
import app.sveriges.radio.com.model.network.NetworkCallback;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */

public abstract class BaseClient {

    private Network network;

    public BaseClient() {
        network = new Network(Environment.BASE_API_URL);
    }

    protected void makeGetRequest(String url, NetworkCallback callback) {
        network.get(url, callback);
    }
}
