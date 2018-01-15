package vaje.si.fri.emp.zdravila.API;

/**
 * Created by Hisa on 09/01/2018.
 */


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import vaje.si.fri.emp.zdravila.Zdravilo.Zdravilo;


public interface APIs {

    @GET("Zdravila")
    Call<ArrayList<Zdravilo>> getZdracila();

    @GET("Zdravila/{name}")
    Call<ArrayList<Zdravilo>> getOmejenoZdravilo(@Path("name") String name);

}
