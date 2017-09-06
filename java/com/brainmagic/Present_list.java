package com.brainmagic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import Adapter.Present_adapter_re;
import Shared.Config;

public class Present_list extends AppCompatActivity {
    TextView tv_tittle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Title;
    ListView lv_present;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Present_adapter_re adapter;
    ArrayList<String> pre_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_present_list);
        try {
            sharedPreferences = this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
            Title = sharedPreferences.getString("KEY_Title", "");
            lv_present = (ListView) findViewById(R.id.list_present);

            tv_tittle = (TextView) findViewById(R.id.title_name);
            recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
            tv_tittle.setText(Title + " List");
            pre_list = new ArrayList<>();
            pre_list.add("Presentation1");
            pre_list.add("Presentation2");
            pre_list.add("Presentation3");
            pre_list.add("Presentation4");
            pre_list.add("Presentation5");
            recyclerView.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            adapter = new Present_adapter_re(getApplicationContext(), pre_list);
            recyclerView.setAdapter(adapter);
            recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                    CopyReadAssets();
                    return false;
                }
                @Override
                public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//                    CopyReadAssets();
                }
                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void CopyReadAssets() {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "hr.pdf");
        try {
            in = assetManager.open("hr.pdf");
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);
            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/hr.pdf"), "application/pdf");
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

    public void Home(View view) {
        startActivity(new Intent(this, HomePage.class));
    }

    public void Back(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
