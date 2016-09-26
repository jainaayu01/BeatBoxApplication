package com.example.india.beatbox;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by india on 9/7/2016.
 */
public class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {
    Context mContext;
    List<Sound> mSounds;
    BeatBox mBeatBox;
    public SoundAdapter(Context context,List<Sound> sounds,BeatBox beatBox){
        mContext = context;
        mSounds = sounds;
        mBeatBox = beatBox;

    }
    @Override
    public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return new SoundHolder(inflater,parent);
    }

    @Override
    public void onBindViewHolder(SoundHolder holder, int position) {
             Sound sound = mSounds.get(position);
               holder.bindSound(sound,mBeatBox);
    }

    @Override
    public int getItemCount() {
        return mSounds.size();
    }
}
