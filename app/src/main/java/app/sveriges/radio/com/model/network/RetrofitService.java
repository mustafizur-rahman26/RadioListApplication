package app.sveriges.radio.com.model.network;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Mustafizur Rahman on 05/04/2018.
 */

public interface RetrofitService {

    @GET("")
    Call<ResponseBody> get(@Url String url);
}
