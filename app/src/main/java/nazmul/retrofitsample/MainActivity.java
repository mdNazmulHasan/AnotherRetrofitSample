package nazmul.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RandomUserApi randomUserApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkingLibraryInitilizer();
        getData();
    }

    private void getData() {
        Call<RandomUser>randomUserCall=randomUserApi.getAllData();
        randomUserCall.enqueue(new Callback<RandomUser>() {
            @Override
            public void onResponse(Call<RandomUser> call, Response<RandomUser> response) {
                RandomUser randomUser=response.body();
                Log.e("response", "onResponse: "+randomUser.getResults().get(0).getDob());
            }

            @Override
            public void onFailure(Call<RandomUser> call, Throwable t) {

            }
        });
    }

    private void networkingLibraryInitilizer() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        randomUserApi=retrofit.create(RandomUserApi.class);
    }
}
