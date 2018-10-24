package ltd.vblago.kharkivweather.api;

import ltd.vblago.kharkivweather.api.models.ForecastResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather.ashx")
    Call<ForecastResponse> loadForecast(
            @Query("key") String key,
            @Query("q") String q,
            @Query("format") String format,
            @Query("num_of_days") int daysCount
    );
}
