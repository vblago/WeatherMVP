package ltd.vblago.kharkivweather.forecast;

import java.util.List;

import ltd.vblago.kharkivweather.base.BaseView;
import ltd.vblago.kharkivweather.models.Weather;

public interface ForecastView extends BaseView {
    void showForecast(List<Weather> forecast);
}
