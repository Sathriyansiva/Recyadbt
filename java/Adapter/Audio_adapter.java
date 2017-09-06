package Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brainmagic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by system9 on 7/24/2017.
 */

public class Audio_adapter extends BaseAdapter {
    MediaPlayer mp;
    Context context;
    private List<String> sino = new ArrayList<>();
    private List<String> audiolist = new ArrayList<>();
    int count = 1;

    private LayoutInflater mInflater;

    public Audio_adapter(
            Context context2,
            List<String> audiolist
    ) {
        this.context = context2;
        this.audiolist = audiolist;

    }
    public int getCount() {
        // TODO Auto-generated method stub
        return audiolist.size();
    }
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    public View getView(final int position, View child, ViewGroup parent) {
        final Holder holder;
        LayoutInflater layoutInflater;
        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.audio_adapter,null);
            holder = new Holder();
            holder.tv_sino = (TextView) child.findViewById(R.id.adpt_slno);
            holder.tv_title = (TextView) child.findViewById(R.id.adpt_title);
            holder.bt_play = (ImageView) child.findViewById(R.id.bt_play);
            holder.bt_pause = (ImageView) child.findViewById(R.id.bt_pause);
            mp = MediaPlayer.create(context, R.raw.audio);
            child.setTag(holder);
        } else {
            holder = (Holder) child.getTag();
        }
        holder.tv_title.setText(audiolist.get(position));
        if (audiolist.size() > 0) {
            for (int i1 = 1; i1 <= audiolist.size(); i1++) {
                String sio = String.valueOf(count);
                sino.add(sio);
                count++;
            }
        }
        holder.tv_sino.setText(sino.get(position));
        holder.bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        holder.bt_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        return child;
    }
    private class Holder {
        TextView tv_sino, tv_title;
        ImageView bt_play, bt_pause;
    }
}
