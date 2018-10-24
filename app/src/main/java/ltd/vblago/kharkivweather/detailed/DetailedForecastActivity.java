package ltd.vblago.kharkivweather.detailed;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import ltd.vblago.kharkivweather.R;
import ltd.vblago.kharkivweather.models.Astronomy;
import ltd.vblago.kharkivweather.models.Weather;
import ltd.vblago.kharkivweather.router.ActivityRouter;

public class DetailedForecastActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.temperature)
    TextView temperature;
    @BindView(R.id.feeling)
    TextView feeling;
    @BindView(R.id.pressure)
    TextView pressure;
    @BindView(R.id.sunrise)
    TextView sunrise;
    @BindView(R.id.sunset)
    TextView sunset;
    @BindView(R.id.moonrise)
    TextView moonrise;
    @BindView(R.id.moonset)
    TextView moonset;

    private Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_forecast);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        weather = getIntent().getParcelableExtra(ActivityRouter.EXTRA_WEATHER);

        Glide.with(this).load(weather.getIcon()).into(icon);
        Resources res = getResources();

        description.setText(res.getString(R.string.pattern_description, weather.getDescription()));
        date.setText(res.getString(R.string.pattern_date, weather.getDate()));
        temperature.setText(res.getString(R.string.pattern_temperature, weather.getTemperature()));
        feeling.setText(res.getString(R.string.pattern_feeling, weather.getFeeling()));
        pressure.setText(res.getString(R.string.pattern_pressure, weather.getPressure()));

        Astronomy astronomy = weather.getAstronomy().get(0);

        sunrise.setText(res.getString(R.string.pattern_sunrise, astronomy.getSunrise()));
        sunset.setText(res.getString(R.string.pattern_sunset, astronomy.getSunset()));
        moonrise.setText(res.getString(R.string.pattern_moonrise, astronomy.getMoonrise()));
        moonset.setText(res.getString(R.string.pattern_moonset, astronomy.getMoonset()));


    }

}
