package com.tutorials.hp.listviewpicassowebimages.mListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.listviewpicassowebimages.R;

/**
 * Created by Oclemmy on 4/12/2016 for ProgrammingWizards Channel.
 */
public class MyViewHolder {

    TextView nameTxt;
    ImageView img;

    public MyViewHolder(View itemView) {

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img= (ImageView) itemView.findViewById(R.id.movieImage);


    }
}
