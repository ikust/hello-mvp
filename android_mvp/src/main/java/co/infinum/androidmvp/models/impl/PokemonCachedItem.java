package co.infinum.androidmvp.models.impl;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import co.infinum.androidmvp.models.Item;

/**
 * Created by ivan on 09/06/14.
 */
public class PokemonCachedItem implements Item {

    private String number;

    private String name;

    private int imageResId;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    @Override public String getTitle() {
        return getName();
    }

    @Override public String getSubtitle() {
        return getNumber();
    }

    @Override public void setImageToView(ImageView imageView) {
        Picasso.with(imageView.getContext()).load(imageResId).into(imageView);
    }
}


