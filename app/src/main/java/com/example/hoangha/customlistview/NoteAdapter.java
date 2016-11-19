package com.example.hoangha.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoangha.customlistview.Utils.DetailUtils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by HoangHa on 11/9/2016.
 */

public class NoteAdapter extends ArrayAdapter<DetailUtils> {

    private List<DetailUtils> mNotes;
    private Context mContext;

    public NoteAdapter(Context context, List<DetailUtils> notes) {
        super(context, -1);
        mNotes = notes;
        mContext = context;
    }
//    public NoteAdapter() {
//
//        this.mNotes = new ArrayList<Note>();
//    }

    public void setmNotes(List<DetailUtils> tweets) {
        mNotes.clear();
        mNotes.addAll(tweets);
        notifyDataSetChanged();
    }


    public void addNote(DetailUtils note) {
        mNotes.add(note);
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return mNotes.size();
    }

    @Nullable
    @Override
    public DetailUtils getItem(int position) {
        return mNotes.get(position);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_note, parent, false);

            viewHolder = new ViewHolder(convertView);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
            viewHolder.ivImage = (ImageView) convertView.findViewById(R.id.ivImage);
            viewHolder.tvTime = (TextView) convertView.findViewById(R.id.tvTime);
            viewHolder.tvAddress = (TextView) convertView.findViewById(R.id.tvAddress);
            viewHolder.tvCommentNum = (TextView) convertView.findViewById(R.id.tvCommentNum);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        DetailUtils note = getItem(position);

        //Fill the data
        viewHolder.tvTitle.setText(note.getTvTitle());
        viewHolder.tvContent.setText(note.getTvContent());

        //viewHolder.ivImage.setImageResource(R.drawable.sample); // run

        viewHolder.tvAddress.setText(note.getTvAddress());
        viewHolder.tvTime.setText(note.getTvTime());

        viewHolder.ivImage.setImageDrawable(note.getIvImage());
        viewHolder.tvCommentNum.setText(note.getTvCommentNum());

        return convertView;
    }


    private class ViewHolder {
        TextView tvTitle;
        TextView tvContent;
        ImageView ivImage;
        TextView tvAddress;
        TextView tvTime;
        String url;
        TextView tvCommentNum;

        public ViewHolder(View view) {
            ButterKnife.bind(view);
        }
    }
}
