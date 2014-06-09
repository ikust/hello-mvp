package co.infinum.androidmvp.mvp.interactor.impl;

import java.util.ArrayList;

import co.infinum.androidmvp.mvp.interactor.MainInteractor;
import co.infinum.androidmvp.mvp.listeners.ItemLoadListener;
import co.infinum.androidmvp.models.Item;
import co.infinum.androidmvp.models.impl.PokemonItem;

/**
 * Interactor implementation that loads items from assets.
 */
public class AssetsMainInteractor implements MainInteractor {

    public static final int ITEM_COUNT = 9;

    @Override public void loadItems(ItemLoadListener listener) {
        ArrayList<Item> items = new ArrayList<>();

        for(int i = 1; i <= ITEM_COUNT; i++) {
            PokemonItem pokemon = new PokemonItem();

        }
    }
}
