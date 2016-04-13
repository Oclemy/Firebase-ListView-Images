package com.tutorials.hp.listviewpicassowebimages.mListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;
import com.tutorials.hp.listviewpicassowebimages.R;
import com.tutorials.hp.listviewpicassowebimages.mData.Movie;
import com.tutorials.hp.listviewpicassowebimages.mPicasso.PicassoClient;

import java.util.ArrayList;

/**
 * Created by Oclemmy on 4/12/2016 for ProgrammingWizards Channel.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Movie> movies;
    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Movie> movies) {
        this.c = c;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,parent,false);

        }

        MyViewHolder holder=new MyViewHolder(convertView);
        //BIND DATA
        holder.nameTxt.setText(movies.get(position).getName());
        PicassoClient.downloadImage(c,movies.get(position).getUrl(),holder.img);

        return convertView;
    }
}
