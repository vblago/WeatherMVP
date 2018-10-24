package ltd.vblago.kharkivweather.forecast;

import ltd.vblago.kharkivweather.base.BasePresenter;

public interface ForecastPresenter extends BasePresenter<ForecastView> {
    void requestForecast(int daysCount);
}
