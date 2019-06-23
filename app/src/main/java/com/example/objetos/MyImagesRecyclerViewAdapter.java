package com.example.objetos;

import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.objetos.ImagesFragment.OnListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;


public class MyImagesRecyclerViewAdapter extends RecyclerView.Adapter<MyImagesRecyclerViewAdapter.ViewHolder> {

    private final List<Images> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyImagesRecyclerViewAdapter(List<Images> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.fragment_images, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdTextView.setText(holder.mItem.getDescription());
        Picasso.get()
            .load(Integer.valueOf(holder.mItem.getUrl()))
            .into(holder.imagePhoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdTextView;
        public final ImageView imagePhoto;

        public Images mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdTextView = view.findViewById(R.id.image_description);
            imagePhoto=view.findViewById(R.id.imageViewFoto);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mIdTextView.getText() + "'";
        }
    }
}
