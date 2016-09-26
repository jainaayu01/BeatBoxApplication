package com.example.india.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by india on 9/25/2016.
 */
public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int  MAX_SOUNDS =5;
    private AssetManager  mAssets;
    public List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;
    public BeatBox(Context mContext){
        mAssets = mContext.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }
    private void loadSounds() {
        String[] soundNames;
        try{
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.d(TAG,"FOUND "+soundNames.length + " sounds");
        }catch(Exception e){
            Log.i(TAG,"Could not list assets "+e);
            return;
        }
        for(String fileName : soundNames){
            try{
            String assetPath = SOUNDS_FOLDER + "/" + fileName;
            Sound sound = new Sound(assetPath);
            load(sound);
            mSounds.add(sound);}
            catch(IOException exc){
                Log.i(TAG,"Could Not Load Sound "+ fileName,exc);
            }
        }

    }
    private void load(Sound sound) throws IOException{
        AssetFileDescriptor assetFileDescriptor = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(assetFileDescriptor,1);
        sound.setSoundId(soundId);
    }
    public void play(Sound sound){
        Integer soundId =sound.getSoundId();
        if(soundId ==null)
            return;
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }
    public void release(){
        mSoundPool.release();
    }
    public List<Sound> getSounds() {
        return mSounds;
    }

}
