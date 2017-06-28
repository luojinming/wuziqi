package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private GobangView gobangView;
    private Button restart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        gobangView = (GobangView) findViewById(R.id.gobang);
        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(this);
        gobangView.setIChessResultListener(new GobangView.IChessResultListener() {
            @Override
            public void ResultListerer(int result) {
                String win = "";
                if (result == 0) {
                    win = "这局黑棋赢了！";
                } else {
                    win = "这局白棋赢了！";
                }

                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);

                builder.setTitle(win+"是否再来一局？");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gobangView.reStart();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).create().show();
            }
        });
    }

    private void showMst(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.restart) {
            gobangView.reStart();
        }
    }
}
