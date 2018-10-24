package ltd.vblago.kharkivweather.api;

import ltd.vblago.kharkivweather.api.models.ForecastResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManagerImpl implements ltd.vblago.kharkivweather.api.ApiManager {
    private final WeatherApi api;

    private final String url = "https://api.worldweatheronline.com/premium/v1/";
    private final String key = "2248dae001f044969e4144429183009";

    public ApiManagerImpl() {
        api = createRetrofit().create(WeatherApi.class);
    }

    private Retrofit createRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(url);
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.client(createOkHttpClient());
        return builder.build();
    }

    private OkHttpClient createOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(createInterceptor());
        return builder.build();
    }

    private HttpLoggingInterceptor createInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Override
    public Call<ForecastResponse> loadForecast(int daysCount) {
        return api.loadForecast(
                key,
                "Kharkiv",
                "json",
                daysCount
        );
    }
}
