package co.infinum.androidmvp.mvp.interactor.impl;

import android.content.res.Resources;

import java.util.ArrayList;

import co.infinum.androidmvp.MvpApplication;
import co.infinum.androidmvp.R;
import co.infinum.androidmvp.models.Item;
import co.infinum.androidmvp.models.impl.PokemonCachedItem;
import co.infinum.androidmvp.mvp.interactor.MainInteractor;
import co.infinum.androidmvp.mvp.listeners.ItemLoadListener;

/**
 * Interactor implementation that loads items from assets.
 */
public class AssetsMainInteractor implements MainInteractor {

    public static final int ITEM_COUNT = 9;

    private static final String CACHED_IMAGE_FORMAT = "pokemon_%d";

    private static final String NUMBER_FORMAT = "#%d";

    @Override public void loadItems(ItemLoadListener listener) {
        ArrayList<Item> items = new ArrayList<>();

        String[] pokemonNames = MvpApplication.getInstance().getResources().getStringArray(R.array.pokemons);

        for (int i = 1; i <= ITEM_COUNT; i++) {
            PokemonCachedItem pokemon = new PokemonCachedItem();

            pokemon.setNumber(String.format(NUMBER_FORMAT, i));
            pokemon.setName(pokemonNames[i - 1]);

            int resId = getPokemonImageResId(i);
            if(resId != 0) {
                pokemon.setImageResId(resId);
            } else {
                listener.failure(MvpApplication.getInstance().getString(R.string.error_loading_data));
                return;
            }

            items.add(pokemon);
        }

        listener.success(items);
    }

    private int getPokemonImageResId(int pokemonNumber) {
        Resources resources = MvpApplication.getInstance().getResources();
        int resId = resources.getIdentifier(
                String.format(CACHED_IMAGE_FORMAT, pokemonNumber),
                "drawable",
                MvpApplication.getInstance().getPackageName()
        );

        return resId;
    }
}
