package com.example.gitflow;

public class CardItem {
    private String mImageUrl;
    private String mCreator;
    private int mLikes;


    public CardItem(String mImageUrl, String mCreator, int mLikes){
        this.mImageUrl = mImageUrl;
        this.mCreator = mCreator;
        this.mLikes = mLikes;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }
}
