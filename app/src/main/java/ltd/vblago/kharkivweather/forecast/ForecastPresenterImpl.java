package ltd.vblago.kharkivweather.forecast;

import android.support.annotation.Nullable;

import ltd.vblago.kharkivweather.api.ApiManager;
import ltd.vblago.kharkivweather.api.models.ForecastResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForecastPresenterImpl implements ForecastPresenter {

    private final ApiManager api;
    private ForecastView view;

    public ForecastPresenterImpl(ApiManager api) {
        this.api = api;
    }

    @Override
    public void requestForecast(int daysCount) {
        api.loadForecast(daysCount)
                .enqueue(new Callback<ForecastResponse>() {
                    @Override
                    public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                        if (!isViewSet()) {
                            return;
                        }
                        if (response.isSuccessful()) {
                            view.showForecast(response.body().getData().getWeather());
                        } else {
                            view.showError(response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ForecastResponse> call, Throwable t) {
                        if (!isViewSet()) {
                            return;
                        }
                        view.showError(t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void setView(@Nullable ForecastView view) {
        this.view = view;
    }

    private boolean isViewSet() {
        return view != null;
    }
}
