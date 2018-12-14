package com.zalego2018dec.exercise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zalego2018dec.exercise.R;
import com.zalego2018dec.exercise.objects.DashboardItem;
import com.zalego2018dec.exercise.objects.TopHits;

import java.util.List;

/**
 * Created by folio on 12/14/2018.
 */

public class TopHitsAdapters extends BaseAdapter {

    Context context;
    List<TopHits> data;
    LayoutInflater inflater;

    public TopHitsAdapters(Context context, List<TopHits> data) {
        this.context = context;
        this.data = data;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.single_list_item,null);
        TextView name_song=view.findViewById(R.id.song_name);
        TextView name_album=view.findViewById(R.id.album_name);
        TextView name_artist=view.findViewById(R.id.artist_name);

        name_song.setText(data.get(i).getSong());
        name_album.setText(data.get(i).getAlbum());
        name_artist.setText(data.get(i).getArtist());


        return view;
    }
}
