package co.infinum.androidmvp.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.androidmvp.R;
import co.infinum.androidmvp.adapters.ItemAdapter;
import co.infinum.androidmvp.models.Item;
import co.infinum.androidmvp.mvp.presenter.MainPresenter;
import co.infinum.androidmvp.mvp.presenter.impl.MainPresenterImpl;
import co.infinum.androidmvp.mvp.view.MainView;
import co.infinum.androidmvp.utils.Utils;


public class ListMainActivity extends ActionBarActivity implements MainView {

    @InjectView(R.id.rootView) ViewGroup rootView;
    @InjectView(R.id.listView) ListView listView;
    @InjectView(R.id.progressBar) ProgressBar progressBar;

    private ItemAdapter adapter;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);

        ButterKnife.inject(this);
        adapter = new ItemAdapter(this, R.layout.listitem, new ArrayList<Item>());
        listView.setAdapter(adapter);

        //Injecting dependencies.
        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.init();
    }

    @Override public void showLoadingLayout() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideLoadingLayout() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void showError(String message) {
        Utils.showError(this, rootView, message, false);
    }

    @Override public void showItems(ArrayList<Item> items) {
        adapter.clear();

        for(Item item : items) {
            adapter.add(item);
        }
    }

    @Override public void showDetails(Item item) {

    }
}
