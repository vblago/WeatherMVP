package ltd.vblago.kharkivweather.api;

import ltd.vblago.kharkivweather.api.models.ForecastResponse;
import retrofit2.Call;

public interface ApiManager {
    Call<ForecastResponse> loadForecast(int countDays);
}
