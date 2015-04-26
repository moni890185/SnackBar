package com.github.mrengineer13.snackbar;

import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;

class Snack implements Parcelable {

    final String mMessage;

    final String mActionMessage;

    final int mActionIcon;

    final Parcelable mToken;

    final short mDuration;

    final ColorStateList mBtnTextColor;

    final ColorStateList mBackgroundColor;

    final int mHeight;

    final int mWidth;

    final Margins mMargins;

    Snack(String message, String actionMessage, int actionIcon, Parcelable token, short duration,
          ColorStateList textColor, ColorStateList backgroundColor, int height, int width,
          Margins margins) {
        mMessage = message;
        mActionMessage = actionMessage;
        mActionIcon = actionIcon;
        mToken = token;
        mDuration = duration;
        mBtnTextColor = textColor;
        mBackgroundColor = backgroundColor;
        mHeight = height;
        mWidth = width;
        mMargins = margins;
    }

    // reads data from parcel
    Snack(Parcel p) {
        mMessage = p.readString();
        mActionMessage = p.readString();
        mActionIcon = p.readInt();
        mToken = p.readParcelable(p.getClass().getClassLoader());
        mDuration = (short) p.readInt();
        mBtnTextColor = p.readParcelable(p.getClass().getClassLoader());
        mBackgroundColor = p.readParcelable(p.getClass().getClassLoader());
        mHeight = p.readInt();
        mWidth = p.readInt();
        mMargins = p.readParcelable(p.getClass().getClassLoader());
    }

    // writes data to parcel
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mMessage);
        out.writeString(mActionMessage);
        out.writeInt(mActionIcon);
        out.writeParcelable(mToken, 0);
        out.writeInt((int) mDuration);
        out.writeParcelable(mBtnTextColor, 0);
        out.writeParcelable(mBackgroundColor, 0);
        out.writeInt(mHeight);
        out.writeInt(mWidth);
        out.writeParcelable(mMargins, 0);
    }

    public int describeContents() {
        return 0;
    }

    // creates snack array
    public static final Parcelable.Creator<Snack> CREATOR = new Parcelable.Creator<Snack>() {
        public Snack createFromParcel(Parcel in) {
            return new Snack(in);
        }

        public Snack[] newArray(int size) {
            return new Snack[size];
        }
    };
}
