package com.example.admin.ortambo;


        import android.content.Context;
        import android.support.annotation.LayoutRes;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;

        import java.util.List;

/**
 * Created by Admin on 7/28/2017.
 */

public class ORtamboAdapter extends ArrayAdapter<ORtambo> {
    public ORtamboAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ORtambo> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.hotel_list,parent,false);

        }

        ImageView photoImageView = listItemView.findViewById(R.id.image_view);
        TextView headTextView = listItemView.findViewById(R.id.head_view);

        TextView descriptionView = listItemView.findViewById(R.id.decr_view);
        ORtambo ORtambo = getItem(position);
        boolean isPhoto = ORtambo.getPhotoUrl()!=null;

        if (isPhoto)
        {
            Glide.with(photoImageView.getContext())
                    .load(ORtambo.getPhotoUrl())
                    .into(photoImageView);
            headTextView.setText(ORtambo.getHead());
            descriptionView.setText(ORtambo.getDescription());
        }
        else {
            photoImageView.setVisibility(View.GONE);
            headTextView.setText(ORtambo.getHead());
            descriptionView.setText(ORtambo.getDescription());
        }
        return listItemView;
    }

}