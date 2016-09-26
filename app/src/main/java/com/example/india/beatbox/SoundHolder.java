package com.example.india.beatbox;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by india on 9/7/2016.
 */
public class SoundHolder extends RecyclerView.ViewHolder implements OnClickListener {
    private Button mButton;
    private Sound mSound;
    private BeatBox mBeatBox;
    public SoundHolder(LayoutInflater inflater, ViewGroup container) {
       super(inflater.inflate(R.layout.list_item_sound,container,false));
        mButton = (Button)itemView.findViewById(R.id.list_item_sound_button);
        mButton.setOnClickListener(this);
    }
    public void bindSound(Sound sound,BeatBox beatbox){
        mSound = sound;
        mBeatBox = beatbox;
        mButton.setText(sound.getName());

    }

    @Override
    public void onClick(View view) {
        mBeatBox.play(mSound);
    }
}
