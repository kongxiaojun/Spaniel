package io.github.kongxiaojun.spaniel.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import io.github.kongxiaojun.spaniel.PermissionsResultAction;
import io.github.kongxiaojun.spaniel.SpaPermissions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.request_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpaPermissions.getInstance().requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, new PermissionsResultAction() {
                    @Override
                    public void onGranted() {
                        Toast.makeText(MainActivity.this, "onGranted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDenied(String permission) {
                        Toast.makeText(MainActivity.this, "onDenied", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
