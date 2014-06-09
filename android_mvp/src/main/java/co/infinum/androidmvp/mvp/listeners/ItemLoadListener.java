package co.infinum.androidmvp.mvp.listeners;

import java.util.ArrayList;

import co.infinum.androidmvp.models.Item;

/**
 * Created by ivan on 09/06/14.
 */
public interface ItemLoadListener {

    /**
     * Called when items have loaded successfully.
     *
     * @param items
     */
    public void success(ArrayList<Item> items);

    /**
     * Called when there was an error loading the items.
     */
    public void failure(String errorMessage);
}
