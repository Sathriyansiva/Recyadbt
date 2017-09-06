package com.brainmagic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.Audio_adapter;
import Shared.Config;

public class Audio_list extends AppCompatActivity {
    TextView tv_tittle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Title;
    ListView lv_aud;
    List<String> aud_list;
    Audio_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_list);
        sharedPreferences = this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        Title = sharedPreferences.getString("KEY_Title", "");
        lv_aud=(ListView)findViewById(R.id.list_audio);
        tv_tittle=(TextView)findViewById(R.id.title_name);
        tv_tittle.setText(Title +" List");
        aud_list=new ArrayList<>();
        aud_list.add("Audio1");
        aud_list.add("Audio2");
        aud_list.add("Audio3");
        aud_list.add("Audio4");
        aud_list.add("Audio5");
        adapter = new Audio_adapter(Audio_list.this, aud_list);
        lv_aud.setAdapter(adapter);
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
