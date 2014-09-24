package co.infinum.androidmvp.models.impl;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import co.infinum.androidmvp.R;
import co.infinum.androidmvp.models.Item;

/**
 * Dodajem comment da vidimo jel radi jenkins.
 *
 */
public class PokemonRemoteItem implements Item {

    private static final String ID_FORMAT ="#%d";

    static class Pokemon {
        private String name;
    }

    private int id;

    @SerializedName("image")
    private String imageUrl;

    private Pokemon pokemon;

    @Override public String getTitle() {
        return pokemon.name;
    }

    @Override public String getSubtitle() {
        return String.format(ID_FORMAT, id - 1);
    }

    @Override public void setImageToView(ImageView imageView) {
        String baseUrl = imageView.getContext().getString(R.string.sprite_server);

        Picasso.with(imageView.getContext()).load(baseUrl + imageUrl).into(imageView);
    }

}
