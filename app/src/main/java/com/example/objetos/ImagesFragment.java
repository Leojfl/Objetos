package com.example.objetos;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ImagesFragment extends Fragment {


    RecyclerView recyclerView;
    List<Images> imagesList;
    MyImagesRecyclerViewAdapter imagesRecyclerViewAdapter;
    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ImagesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            imagesList = new ArrayList<>();


            imagesList.add(
                new Images(""
                    , "Imagen uno ", R.drawable.img1));

            imagesList.add(
                new Images(R.drawable.img2 + ""
                    , "Imagen dos"
                    , R.drawable.img2));


            imagesList.add(
                new Images(R.drawable.img3 + ""
                    , "Imagen tres", R.drawable.img3));

            imagesList.add(
                new Images(R.drawable.img4 + ""
                    , "Imagen cuatro ", R.drawable.img4));


            imagesList.add(
                new Images(R.drawable.img5 + ""
                    , "Imagen cinco", R.drawable.img5));


            imagesList.add(
                new Images(R.drawable.img6 + ""
                    , "Imagen seis", R.drawable.img6));

            for (int y = 0; y < 10; y++) {
                imagesList.add(
                    new Images(R.drawable.peso + ""
                        , "Imagen de pesos con for " + y
                    , R.drawable.peso));
            }


            MyImagesRecyclerViewAdapter imagesRecyclerViewAdapter = new MyImagesRecyclerViewAdapter(imagesList, mListener);
            recyclerView.setAdapter(imagesRecyclerViewAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Images item);
    }
}
