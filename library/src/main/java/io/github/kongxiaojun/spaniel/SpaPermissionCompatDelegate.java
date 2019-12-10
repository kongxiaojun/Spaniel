package io.github.kongxiaojun.spaniel;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;

import java.lang.reflect.Method;

/**
 * Created by kongxiaojun on 2019-12-10.
 */
public class SpaPermissionCompatDelegate implements ActivityCompat.PermissionCompatDelegate {
    @Override
    public boolean requestPermissions(@NonNull Activity activity, @NonNull String[] permissions, int requestCode) {
        try {
            Method method = activity.getPackageManager().getClass().getMethod("buildRequestPermissionsIntent", String[].class);
            Intent intent = (Intent) method.invoke(activity.getPackageManager(), (Object) permissions);
            if (intent != null) {
                activity.startActivityForResult(intent, requestCode);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onActivityResult(@NonNull Activity activity, int requestCode, int resultCode, @Nullable Intent data) {
        ActivityCompat.setPermissionCompatDelegate(null);
        String[] permissions = (data != null) ? data.getStringArrayExtra(
                Constant.EXTRA_REQUEST_PERMISSIONS_NAMES) : new String[0];
        final int[] grantResults = (data != null) ? data.getIntArrayExtra(
                Constant.EXTRA_REQUEST_PERMISSIONS_RESULTS) : new int[0];
        SpaPermissions.getInstance().notifyPermissionsChange(activity, permissions, grantResults);
        return true;
    }
}
