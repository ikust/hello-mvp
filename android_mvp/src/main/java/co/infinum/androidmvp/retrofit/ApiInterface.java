package co.infinum.androidmvp.retrofit;

import co.infinum.androidmvp.models.impl.PokemonRemoteItem;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by ivan on 09/06/14.
 */
public interface ApiInterface {

    @GET("/sprite/{id}")
    public void getPokemon(@Path("id") int pId, Callback<PokemonRemoteItem> callback);
}
