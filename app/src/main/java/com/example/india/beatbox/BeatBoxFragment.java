package com.example.india.beatbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by india on 9/7/2016.
 */
public class BeatBoxFragment extends Fragment {
    private  BeatBox mBeatBox;
 public static BeatBoxFragment newInstance(){
     return new BeatBoxFragment();
 }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeatBox = new BeatBox(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beat_box, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.list_item_sound_button);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        recyclerView.setAdapter(new SoundAdapter(getActivity(),mBeatBox.getSounds(),mBeatBox));
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();

    }
}
