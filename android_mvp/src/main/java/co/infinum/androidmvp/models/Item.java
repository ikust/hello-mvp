package co.infinum.androidmvp.models;

import android.widget.ImageView;

/**
 * Created by ivan on 09/06/14.
 */
public interface Item {

    public String getSubtitle();

    public String getTitle();

    public void setImageToView(ImageView imageView);
}
