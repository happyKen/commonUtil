package com.common.myutil.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.SoundPool;
import android.text.TextUtils;


import java.util.HashMap;

/**
 * 音频播放类
 * 采用SoundPool
 * Created by wangzekeng on 2017/8/27.
 */

public class SoundPoolPlayer {

    private static final int MAX_STREAMS = 5;//最多支持5个音效同时播放
    private static SoundPoolPlayer mInstance;
    private SoundPool mSoundPool;
    private HashMap<String, Integer> mSoundPoolMap;
    private float volume = 1.0f;//游戏音量,默认最大是系统音量
    private HashMap<String, Integer> mSteamIdMap;
    private int mCurrentStreamId = -1;

    private SoundPoolPlayer() {

    }

    public static SoundPoolPlayer getInstance() {
        if (mInstance == null) {
            synchronized (SoundPoolPlayer.class) {
                if (mInstance == null) {
                    mInstance = new SoundPoolPlayer();
                }
            }
        }
        return mInstance;
    }

    private void checkInit() {
        if (mSoundPool == null) {
            mSoundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }
        if (mSoundPoolMap == null) {
            mSoundPoolMap = new HashMap<String, Integer>();
        }
        if (mSteamIdMap == null) {
            mSteamIdMap = new HashMap<String, Integer>();
        }

    }

    public void release() {
        if (mSoundPoolMap != null) {
            mSoundPoolMap.clear();
        }
        if (mSoundPoolMap != null) {
            mSoundPoolMap.clear();
        }
        if (mSoundPool != null) {
            mSoundPool.release();
            mSoundPool = null;
        }

    }

    private Integer getSoundId(String key, int defaultValue) {
        return (mSoundPoolMap.containsKey(key) && mSoundPoolMap.get(key) != null) ? mSoundPoolMap.get(key) : defaultValue;
    }

    private Integer getSteamId(String key, int defaultValue) {
        return (mSteamIdMap.containsKey(key) && mSteamIdMap.get(key) != null) ? mSteamIdMap.get(key) : defaultValue;
    }

    private void playIt(final int soundId, final String assetsFilePath) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mSoundPool != null) {
                    mCurrentStreamId = mSoundPool.play(soundId, 1, 1, 0, 0, 1);
                    mSteamIdMap.put(assetsFilePath, mCurrentStreamId);
                    mSoundPool.setVolume(mCurrentStreamId, volume, volume);//设置音量
                }
            }
        }).start();

    }

    private void loadAndPlayIt(final Context context, final String assetsFilePath) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AssetFileDescriptor fileDescriptor = context.getAssets().openFd(assetsFilePath);
                    int soundId = mSoundPool.load(fileDescriptor, 1);
                    fileDescriptor.close();
                    mSoundPoolMap.put(assetsFilePath, soundId);
                    mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                        @Override
                        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                            if (mSoundPoolMap.get(assetsFilePath) != null) {
                                playIt(mSoundPoolMap.get(assetsFilePath), assetsFilePath);
                            }
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 播放语音
     *
     * @param assetsFilePath
     */
    public void play(Context context, String assetsFilePath) {
        if (TextUtils.isEmpty(assetsFilePath)) {
            return;
        }
        checkInit();
        int soundId = getSoundId(assetsFilePath, -1);
        if (soundId == -1) {
            loadAndPlayIt(context.getApplicationContext(), assetsFilePath);
        } else {
            playIt(soundId, assetsFilePath);
        }
    }

    /**
     * 调节游戏音量
     *
     * @param volume
     */
    public void setGameVolume(float volume) {
        this.volume = volume;
        if (mCurrentStreamId != -1 && mSoundPool != null) {
            mSoundPool.setVolume(mCurrentStreamId, volume, volume);//设置音量
        }
    }


    /**
     * 停止播放音频，多个音频同时播放停止时可能有问题
     */
    private void stop(final String assetsFilePath) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mSoundPool != null) {
                    int streamid = getSteamId(assetsFilePath, 0);
                    mSoundPool.stop(streamid);
                }
            }
        }).start();
    }





    /**
     * 游戏倒计时
     *
     * @param context
     */
    public void countDown(Context context) {
        String path = "other/countDown.mp3";
        play(context, path);
    }

}
