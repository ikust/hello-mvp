package co.infinum.androidmvp.mvp.presenter.impl;

import java.util.ArrayList;

import co.infinum.androidmvp.models.Item;
import co.infinum.androidmvp.mvp.interactor.MainInteractor;
import co.infinum.androidmvp.mvp.interactor.impl.RemoteMainInteractor;
import co.infinum.androidmvp.mvp.listeners.ItemLoadListener;
import co.infinum.androidmvp.mvp.presenter.MainPresenter;
import co.infinum.androidmvp.mvp.view.MainView;

/**
 * Created by ivan on 09/06/14.
 */
public class MainPresenterImpl implements MainPresenter, ItemLoadListener {

    /**
     * Dependency on {@link co.infinum.androidmvp.mvp.view.MainView}.
     */
    private MainView mainView;

    private MainInteractor mainInteractor;

    /**
     * Creates a new implementation of {@link co.infinum.androidmvp.mvp.presenter.MainPresenter}
     * and "injects" the given {@link co.infinum.androidmvp.mvp.view.MainView} dependency.
     *
     * @param mainView
     */
    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
        this.mainInteractor = new RemoteMainInteractor(); //Injecting interactor.
    }

    @Override public void init() {
        mainView.showLoadingLayout();
        mainInteractor.loadItems(this);
    }

    @Override public void onItemClicked(Item item) {
        mainView.showDetails(item);
    }

    //region ItemLoadListener

    @Override public void success(ArrayList<Item> items) {
        mainView.hideLoadingLayout();
        mainView.showItems(items);
    }

    @Override public void failure(String errorMessage) {
        mainView.hideLoadingLayout();
        mainView.showError(errorMessage);
    }
    //endregion
}
