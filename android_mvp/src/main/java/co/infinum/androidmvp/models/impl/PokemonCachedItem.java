package co.infinum.androidmvp.models.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;

import co.infinum.androidmvp.models.Item;

/**
 * Created by ivan on 09/06/14.
 */
public class PokemonCachedItem implements Item {

    private String number;

    private String name;

    private Bitmap image;

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

    @Override public String getTitle() {
        return getName();
    }

    @Override public String getSubtitle() {
        return getNumber();
    }

    @Override public void setImageToView(ImageView imageView) {

    }
}


