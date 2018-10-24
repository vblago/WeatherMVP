package ltd.vblago.kharkivweather.router;

import android.content.Context;
import android.content.Intent;

import java.lang.ref.WeakReference;

import ltd.vblago.kharkivweather.detailed.DetailedForecastActivity;
import ltd.vblago.kharkivweather.models.Weather;

public class ActivityRouter {
    public static final String EXTRA_WEATHER = "EXTRA_WEATHER";

    private final WeakReference<Context> contextRef;

    public ActivityRouter(Context context) {
        this.contextRef = new WeakReference<>(context);
    }

    public void requestDetailedForecastActivityIntent(Weather weather, OnIntentReadyListener listener) {
        Intent intent = new Intent(contextRef.get(), DetailedForecastActivity.class);
        intent.putExtra(EXTRA_WEATHER, weather);
        listener.onIntentReady(intent);
    }

    public interface OnIntentReadyListener {
        void onIntentReady(Intent intent);
    }
}
