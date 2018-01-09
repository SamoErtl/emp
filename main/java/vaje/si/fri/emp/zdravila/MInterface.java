package vaje.si.fri.emp.zdravila;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by jjmse on 06/01/2018.
 */

public interface MInterface {
    @GET("/users/mobilesiri")
    void getUser(Callback<Pojo> uscb);
}

