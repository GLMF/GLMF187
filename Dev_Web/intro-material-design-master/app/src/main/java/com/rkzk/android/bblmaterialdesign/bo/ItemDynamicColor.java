package com.rkzk.android.bblmaterialdesign.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemDynamicColor implements Parcelable {

    private String imageUrl;
    private String title;

    public ItemDynamicColor(String url, String title) {
        this.imageUrl = url;
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageUrl);
        dest.writeString(this.title);
    }

    private ItemDynamicColor(Parcel in) {
        this.imageUrl = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<ItemDynamicColor> CREATOR = new Parcelable.Creator<ItemDynamicColor>() {
        public ItemDynamicColor createFromParcel(Parcel source) {
            return new ItemDynamicColor(source);
        }

        public ItemDynamicColor[] newArray(int size) {
            return new ItemDynamicColor[size];
        }
    };
}
