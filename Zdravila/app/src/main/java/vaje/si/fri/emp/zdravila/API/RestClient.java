package vaje.si.fri.emp.zdravila.API;

/**
 * Created by Hisa on 09/01/2018.
 */

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestClient {
    private static APIs rClient;


    public RestClient (Context context, final String token ){

        String url = "http://zdravilnica.azurewebsites.net/IZdravila.svc/";
        //"Zdravila" - vsa zdravila  Zdravila/Durg - Vsa zdravila ki vsebujejo to besedo

        // Za header
        /*HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder().addInterceptor(interceptor);*/
        /*
        if(!Utils.isEmpty(token)) {
            builder.addInterceptor(new Interceptor() {
                @Override public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request().newBuilder().addHeader("Authorization", token).build();
                    return chain.proceed(request);
                }
            });
        }
        */

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //.client(builder.build())

        rClient = retrofit.create(APIs.class);
    }

    public APIs getrClient() {
        return rClient;
    }
}