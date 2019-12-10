package io.github.kongxiaojun.spaniel;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

/**
 * Created by kongxiaojun on 2019-12-09.
 */
public class SpaPermissionsFragment extends Fragment {

    private static final String TAG = "PermissionsFragment";

    private String[] preRequestPermissions = null;

    public SpaPermissionsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        SpaPermissions.getInstance().notifyPermissionsChange(getContext(), permissions, grantResults);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (preRequestPermissions != null) {
            requestPermissions(preRequestPermissions, Constant.PERMISSIONS_REQUEST_CODE);
        }
        preRequestPermissions = null;
    }

    public void setPreRequestPermissions(String[] preRequestPermissions) {
        this.preRequestPermissions = preRequestPermissions;
    }
}
