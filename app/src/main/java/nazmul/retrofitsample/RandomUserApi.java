package nazmul.retrofitsample;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by po on 12/20/16.
 */

public interface RandomUserApi {
    @GET("/")
    Call<RandomUser>getAllData();
}
