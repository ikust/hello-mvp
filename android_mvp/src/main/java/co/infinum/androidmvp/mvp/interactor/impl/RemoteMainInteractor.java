package co.infinum.androidmvp.mvp.interactor.impl;

import java.util.ArrayList;

import co.infinum.androidmvp.MvpApplication;
import co.infinum.androidmvp.R;
import co.infinum.androidmvp.models.Item;
import co.infinum.androidmvp.models.impl.PokemonRemoteItem;
import co.infinum.androidmvp.mvp.interactor.MainInteractor;
import co.infinum.androidmvp.mvp.listeners.ItemLoadListener;
import co.infinum.androidmvp.retrofit.ApiInterface;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by ivan on 09/06/14.
 */
public class RemoteMainInteractor implements MainInteractor {

    public static final int ITEM_COUNT = 9;

    private static final int START_ID = 2;

    private ApiInterface apiInterface;

    private ArrayList<Item> items = new ArrayList<>();

    private ItemLoadListener listener;

    private Callback<PokemonRemoteItem> callback = new Callback<PokemonRemoteItem>() {
        @Override public void success(PokemonRemoteItem pokemonRemoteItem, Response response) {
            items.add(pokemonRemoteItem);

            if(items.size() < ITEM_COUNT) {
                apiInterface.getPokemon(items.size() + START_ID, this);
            } else {
                listener.success(items);
            }
        }

        @Override public void failure(RetrofitError error) {
            listener.failure(MvpApplication.getInstance().getString(R.string.error_connectivity));
        }
    };

    @Override public void loadItems(ItemLoadListener listener) {
        this.listener = listener;

        String endpoint = MvpApplication.getInstance().getString(R.string.api_server);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endpoint)
                .build();

        apiInterface = restAdapter.create(ApiInterface.class);

        //Start from the second, first one doesn't return proper data.
        apiInterface.getPokemon(START_ID, callback);
    }
}
