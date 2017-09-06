package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.brainmagic.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by system9 on 7/24/2017.
 */
public class Present_adapter_re extends RecyclerView.Adapter<Present_adapter_re.ViewHolder> {
    private ArrayList<String> sino = new ArrayList<>();
    private List<String> presentlist = new ArrayList<>();
    int count = 1;
    private Context context;

    public Present_adapter_re(Context context, ArrayList<String> presentlist) {
        this.context = context;
        this.presentlist = presentlist;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.present_adapter, viewGroup, false);
        return new ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if (presentlist.size() > 0) {
            for (int i1 = 1; i1 <= presentlist.size(); i1++) {
                String sio = String.valueOf(count);
                sino.add(sio);
                count++;
            }
        }
        viewHolder.tv_sino.setText(sino.get(i));
        viewHolder.tv_android.setText(presentlist.get(i));
//        Picasso.with(context).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into(viewHolder.img_android);
        viewHolder.img_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                CopyReadAssets();
            }
        });
    }
    @Override
    public int getItemCount() {
        return presentlist.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_android;
        TextView tv_sino;
        ImageView img_view;
        public ViewHolder(View view) {
            super(view);
            tv_android = (TextView) view.findViewById(R.id.adpt_title);
            tv_sino = (TextView) view.findViewById(R.id.adpt_slno);
            img_view = (ImageView) view.findViewById(R.id.bt_view);
        }
    }
    private void CopyReadAssets()
    {
        AssetManager assetManager =  context.getAssets();
        InputStream in = null;
        OutputStream out = null;
        File file = new File( context.getFilesDir(), "hr.pdf");
        try
        {
            in = assetManager.open("hr.pdf");
            out = context.getApplicationContext().openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);
            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + context. getFilesDir() + "/hr.pdf"),"application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        context.startActivity(intent);
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }
}

