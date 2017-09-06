package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.brainmagic.Audio_list;
import com.brainmagic.R;
import com.brainmagic.VideoPlayer;

import java.util.ArrayList;
import java.util.List;

import Shared.Config;

/**
 * Created by system9 on 7/24/2017.
 */

public class Vedio_adapter extends BaseAdapter {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    private List<String> sino = new ArrayList<>();
    private List<String> vediolist = new ArrayList<>();
    int count = 1;

    private LayoutInflater mInflater;

    public Vedio_adapter(
            Context context2,
            List<String> vediolist
    ) {

        this.context = context2;
        this.vediolist = vediolist;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return vediolist.size();
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
            child = layoutInflater.inflate(R.layout.video_adapter, null);
            holder = new Holder();

            holder.tv_sino = (TextView) child.findViewById(R.id.adpt_slno);
            holder.tv_title = (TextView) child.findViewById(R.id.adpt_title);
            holder.bt_play = (ImageView) child.findViewById(R.id.bt_play);
            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        if (vediolist.size() > 0) {
            for (int i1 = 1; i1 <= vediolist.size(); i1++) {
                String sio = String.valueOf(count);
                sino.add(sio);
                count++;
            }
        }
        holder.tv_sino.setText(sino.get(position));

        holder.tv_title.setText(vediolist.get(position));


        holder.bt_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = context.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("KEY_link", "");
                editor.apply();
                context.startActivity(new Intent(context,VideoPlayer.class));
            }
        });

        return child;
    }

    private class Holder {
        TextView tv_sino, tv_title;
        ImageView bt_play, bt_pause;
    }
}
