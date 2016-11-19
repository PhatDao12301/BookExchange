package com.example.hoangha.customlistview;


import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by HoangHa on 11/9/2016.
 */

public class Note {

    private String title;
    private String content;
    private Drawable drawable;

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public Drawable getDrawable() {

        return drawable;
    }

    public Note(){

    }

    public Note(String title, String content, Drawable drawable) {
        this.title = title;
        this.content = content;
        this.drawable = drawable;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }


}
