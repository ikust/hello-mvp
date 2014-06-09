package co.infinum.androidmvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.androidmvp.R;
import co.infinum.androidmvp.models.Item;

/**
 * Created by ivan on 09/06/14.
 */
public class ItemAdapter extends ArrayAdapter<Item> {

    class ViewHolder {
        @InjectView(R.id.ivThumbnail) ImageView thumbnailImageView;
        @InjectView (R.id.tvName) TextView nameTextView;
        @InjectView (R.id.tvNumber) TextView numberTextView;

        public ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    private int layoutResourceId;

    public ItemAdapter(Context context, int layoutResourceId, ArrayList<Item> objects) {
        super(context, layoutResourceId, objects);
        this.layoutResourceId = layoutResourceId;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater.from(getContext()));
            convertView = inflater.inflate(layoutResourceId, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        Item item = getItem(position);
        item.setImageToView(viewHolder.thumbnailImageView);
        viewHolder.nameTextView.setText(item.getTitle());
        viewHolder.numberTextView.setText(item.getSubtitle());

        return convertView;
    }
}
