package co.infinum.androidmvp.mvp.view;

import java.util.ArrayList;

import co.infinum.androidmvp.models.Item;

/**
 * Created by ivan on 09/06/14.
 */
public interface MainView {

    /**
     * Shows the given items.
     */
    public void showItems(ArrayList<Item> item);

    /**
     * Show details for item.
     *
     * @param item
     */
    public void showDetails(Item item);

    /**
     * Shows an error message.
     *
     * @param message Message content
     */
    public void showError(String message);

    /**
     * Shows loading layout on the view.
     */
    public void showLoadingLayout();

    /**
     * Hides loading layout.
     */
    public void hideLoadingLayout();
}
