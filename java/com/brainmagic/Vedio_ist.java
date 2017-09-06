package com.brainmagic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adapter.Audio_adapter;
import Adapter.Vedio_adapter;
import Shared.Config;

public class Vedio_ist extends AppCompatActivity {
    TextView tv_tittle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String Title;
    ListView lv_video;
    List<String> ved_list;
    Vedio_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vedio_list);
        sharedPreferences = this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        Title = sharedPreferences.getString("KEY_Title", "");
        lv_video=(ListView)findViewById(R.id.list_video);

        tv_tittle=(TextView)findViewById(R.id.title_name);
        tv_tittle.setText(Title+" List");
        ved_list=new ArrayList<>();
        ved_list.add("Vedio1");
        ved_list.add("Vedio2");
        ved_list.add("Vedio3");
        ved_list.add("Vedio4");
        ved_list.add("Vedio5");
        adapter = new Vedio_adapter(Vedio_ist.this, ved_list);
        lv_video.setAdapter(adapter);
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
