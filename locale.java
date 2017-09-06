package dev.set;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Locale;

public class locale extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            String locale = intent.getStringExtra("l");
            Log.i("DevSet", "Locale=" + locale);
            Class.forName("com.android.internal.app.LocalePicker")
                 .getMethod("updateLocale", Locale.class)
                 .invoke(null, parseLocale(locale));
        } catch (Exception e) {
            Log.wtf("DevSet", e);
        }
    }

    private static Locale parseLocale(String locale) {
        String[] parts = locale.replace('-', '_').split("_");
        switch (parts.length) {
            case 0: return Locale.US;
            case 1: return new Locale(parts[0]);
            default: return new Locale(parts[0], parts[1]);
        }
    }
}
