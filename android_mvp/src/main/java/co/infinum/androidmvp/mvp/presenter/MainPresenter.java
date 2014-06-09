package co.infinum.androidmvp.mvp.presenter;

import co.infinum.androidmvp.models.Item;

/**
 * Main screen presenter interface.
 */
public interface MainPresenter {

    /**
     * Method that is called once the view is created.
     */
    public void init();

    /**
     * Method that is called once the item from view is clicked.
     *
     * @param item <code>Item</code> that has been clicked
     */
    public void onItemClicked(Item item);
}
