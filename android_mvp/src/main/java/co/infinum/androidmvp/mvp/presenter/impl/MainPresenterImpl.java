package co.infinum.androidmvp.mvp.presenter.impl;

import co.infinum.androidmvp.models.Item;
import co.infinum.androidmvp.mvp.interactor.MainInteractor;
import co.infinum.androidmvp.mvp.interactor.impl.AssetsMainInteractor;
import co.infinum.androidmvp.mvp.presenter.MainPresenter;
import co.infinum.androidmvp.mvp.view.MainView;

/**
 * Created by ivan on 09/06/14.
 */
public class MainPresenterImpl implements MainPresenter {

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
        this.mainInteractor = new AssetsMainInteractor(); //Injecting interactor.
    }

    @Override public void init() {

    }

    @Override public void onItemClicked(Item item) {

    }
}
