package co.infinum.androidmvp.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;

import co.infinum.androidmvp.R;
import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by ivan on 09/06/14.
 */
public class Utils {

    @SuppressLint("ResourceAsColor")
    public static void showError(final Activity activity, final ViewGroup viewGroup,
                                 String message, boolean permanent) {
        Style.Builder styleBuilder = new Style.Builder();

        if (permanent) {
            styleBuilder.setConfiguration(new Configuration.Builder().setDuration(Configuration.DURATION_INFINITE).build());
        }

        styleBuilder.setBackgroundColor(R.color.crouton_error);

        if (activity != null && !activity.isFinishing() && viewGroup != null) {
            Crouton.makeText(activity, message, styleBuilder.build(), viewGroup).show();
        }
    }
}
