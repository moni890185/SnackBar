package com.github.mrengineer13.snackbar;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by monicacurti on 26/04/2015.
 */
public class Margins implements Parcelable {

    final int mLeft;
    final int mTop;
    final int mRight;
    final int mBottom;

    public int getLeft() {
        return mLeft;
    }

    public int getTop() {
        return mTop;
    }

    public int getRight() {
        return mRight;
    }

    public int getBottom() {
        return mBottom;
    }

    public Margins(int left, int top, int right, int bottom) {
        mLeft = left;
        mTop = top;
        mRight = right;
        mBottom = bottom;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mLeft);
        parcel.writeInt(mTop);
        parcel.writeInt(mRight);
        parcel.writeInt(mBottom);
    }

    public static final Parcelable.Creator<Margins> CREATOR
            = new Parcelable.Creator<Margins>() {
        public Margins createFromParcel(Parcel in) {
            return new Margins(in.readInt(), in.readInt(), in.readInt(), in.readInt());
        }

        public Margins[] newArray(int size) {
            return new Margins[size];
        }
    };
}
