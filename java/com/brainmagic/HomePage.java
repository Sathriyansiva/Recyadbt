package com.brainmagic;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.dd.CircularProgressButton;

import Shared.Config;

public class HomePage extends AppCompatActivity {
    RadioGroup rg_pol, rg_mode;
    RadioButton rb_pol, rb_mode;
    int selectedId, selectedId2;
    String policies, mode;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    CircularProgressButton b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.activity_home_page);
            rg_pol = (RadioGroup) findViewById(R.id.hm_choose_policies);
            rg_mode = (RadioGroup) findViewById(R.id.hm_select_mode);
            b = (CircularProgressButton) findViewById(R.id.cancelbtn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void logout(View view) {
        try {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomePage.this);
            alertDialog.setTitle("Name");
            alertDialog.setMessage("Are you sure want to Logout?");
            alertDialog.setIcon(R.drawable.close);
            alertDialog.setPositiveButton("YES",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                startActivity(new Intent(HomePage.this, Login.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                                finish();
                            } catch (Exception e) {
                                e.printStackTrace();
                                Toast.makeText(HomePage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
            alertDialog.setNegativeButton("NO",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            alertDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void go(View view) {
        try {
            selectedId = rg_pol.getCheckedRadioButtonId();
            rb_pol = (RadioButton) findViewById(selectedId);
            policies = rb_pol.getText().toString().trim();
            selectedId2 = rg_mode.getCheckedRadioButtonId();
            rb_mode = (RadioButton) findViewById(selectedId2);
            mode = rb_mode.getText().toString().trim();
            b.setProgress(0);

            if ((policies + "," + mode).equals("HR Policies,Audio")) {
                b.setIndeterminateProgressMode(true); // turn on indeterminate
                b.setProgress(10); // set progress > 0 & < 100 to display
                b.setProgress(100); //
                sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("KEY_Title", (policies + " " + mode));
                editor.apply();
                startActivity(new Intent(this, Audio_list.class));
            } else if ((policies + "," + mode).equals("HR Policies,Video")) {
                b.setIndeterminateProgressMode(true); // turn on indeterminate
                b.setProgress(10); // set progress > 0 & < 100 to display
                b.setProgress(100); //
                sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("KEY_Title", (policies + " " + mode));
                editor.apply();
                startActivity(new Intent(this, Vedio_ist.class));
            } else if ((policies + "," + mode).equals("HR Policies,Presentation")) {
                b.setIndeterminateProgressMode(true); // turn on indeterminate
                b.setProgress(10); // set progress > 0 & < 100 to display
                b.setProgress(100); //
                sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("KEY_Title", (policies + " " + mode));
                editor.apply();
                startActivity(new Intent(this, Present_list.class));
            } else if ((policies + "," + mode).equals("Safety Policies,Audio")) {
                b.setIndeterminateProgressMode(true); // turn on indeterminate
                b.setProgress(10); // set progress > 0 & < 100 to display
                b.setProgress(100); //
                sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("KEY_Title", (policies + " " + mode));
                editor.apply();
                startActivity(new Intent(this, Audio_list.class));
            } else if ((policies + "," + mode).equals("Safety Policies,Video")) {
                b.setIndeterminateProgressMode(true); // turn on indeterminate
                b.setProgress(10); // set progress > 0 & < 100 to display
                b.setProgress(100); //
                sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("KEY_Title", (policies + " " + mode));
                editor.apply();
                startActivity(new Intent(this, Vedio_ist.class));
            } else if ((policies + "," + mode).equals("Safety Policies,Presentation")) {
                b.setIndeterminateProgressMode(true); // turn on indeterminate
                b.setProgress(10); // set progress > 0 & < 100 to display
                b.setProgress(100); //
                sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("KEY_Title", (policies + " " + mode));
                editor.apply();
                startActivity(new Intent(this, Present_list.class));
            } else {
                Toast.makeText(this, "No Records Found", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void exit(View view) {
        try {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomePage.this);
        alertDialog.setTitle("Name");
        alertDialog.setMessage("Are you sure want to Exit?");
        alertDialog.setIcon(R.drawable.close);
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(HomePage.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
