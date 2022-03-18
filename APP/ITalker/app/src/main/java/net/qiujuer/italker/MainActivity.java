package net.qiujuer.italker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import net.qiujuer.italker.common.Common;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Common();
    }
}
