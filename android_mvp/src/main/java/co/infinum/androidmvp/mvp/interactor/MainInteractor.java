package co.infinum.androidmvp.mvp.interactor;

import co.infinum.androidmvp.mvp.listeners.ItemLoadListener;

/**
 * Created by ivan on 09/06/14.
 */
public interface MainInteractor {


    public void loadItems(ItemLoadListener listener);
}
