package com.example.hoangha.customlistview.Utils;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 11/17/2016.
 */

public class DetailUtils implements Parcelable {

    /*private TextView tvTitle;
    private TextView tvContent;
    private TextView tvAddress;
    private TextView tvTime;

    private ImageView ivImage;
    private String url;

    private EditText etComments;*/

    private String tvTitle;
    private String tvContent;
    private String tvAddress;
    private String tvTime;

    private Drawable ivImage;
    private String url;

    private String etComments;
    private String tvCommentNum;


    public DetailUtils(String title, String content, Drawable drawable, String time, String address) {
        this.tvTitle = title;
        this.tvContent = content;
        this.ivImage = drawable;
        this.tvTime = time;
        this.tvAddress = address;
    }

    public DetailUtils() {
//        this.tvTitle="";
//        this.tvContent = "";
////        this.ivImage.setImageDrawable(drawable);
//        this.tvTime = "";
//        this.tvAddress = "";
    }


    public DetailUtils(String title, String content, Drawable drawable, String time, String addres, String url) {
        this.tvTitle = title;
        this.tvContent = content;
        this.ivImage = drawable;
        this.tvTime = time;
        this.tvAddress = addres;
        this.url = url;

    }

    public DetailUtils(String title, String content, Drawable drawable, String time, String addres, String url, int cmt) {
        this.tvTitle = title;
        this.tvContent = content;
        this.ivImage = drawable;
        this.tvTime = time;
        this.tvAddress = addres;
        this.url = url;
        this.tvCommentNum = String.valueOf(cmt);
    }

//auto generate
    protected DetailUtils(Parcel in) {
        tvTitle = in.readString();
        tvContent = in.readString();
        tvAddress = in.readString();
        tvTime = in.readString();
        url = in.readString();
        etComments = in.readString();
        tvCommentNum = in.readString();
    }
//auto generate
    public static final Creator<DetailUtils> CREATOR = new Creator<DetailUtils>() {
        @Override
        public DetailUtils createFromParcel(Parcel in) {
            return new DetailUtils(in);
        }

        @Override
        public DetailUtils[] newArray(int size) {
            return new DetailUtils[size];
        }
    };

    public String getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(String tvTitle) {
        this.tvTitle = tvTitle;
    }

    public String getTvContent() {
        return tvContent;
    }

    public void setTvContent(String tvContent) {
        this.tvContent = tvContent;
    }

    public String getTvAddress() {
        return tvAddress;
    }

    public void setTvAddress(String tvAddress) {
        this.tvAddress = tvAddress;
    }

    public String getTvTime() {
        return tvTime;
    }

    public void setTvTime(String tvTime) {
        this.tvTime = tvTime;
    }

    public Drawable getIvImage() {
        return ivImage;
    }

    public void setIvImage(Drawable ivImage) {
        this.ivImage = ivImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEtComments() {
        return etComments;
    }

    public void setEtComments(String etComments) {
        this.etComments = etComments;
    }

    public String getTvCommentNum() {
        return tvCommentNum;
    }

    public void setTvCommentNum(String tvCommentNum) {
        this.tvCommentNum = tvCommentNum;
    }

//auto generate
    @Override
    public int describeContents() {
        return 0;
    }

//auto generate
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tvTitle);
        dest.writeString(tvContent);
        dest.writeString(tvAddress);
        dest.writeString(tvTime);
        dest.writeString(url);
        dest.writeString(etComments);
        dest.writeString(tvCommentNum);
    }
}
