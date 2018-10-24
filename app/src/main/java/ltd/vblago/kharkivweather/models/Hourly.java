package ltd.vblago.kharkivweather.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hourly implements Parcelable {

    private String time;
    private int tempC;
    private int tempF;
    @SerializedName("FeelsLikeC")
    private int feelsLikeC;
    @SerializedName("FeelsLikeF")
    private int feelsLikeF;
    @SerializedName("HeatIndexC")
    private int heatIndexC;
    @SerializedName("HeatIndexF")
    private int heatIndexF;
    @SerializedName("DewPointC")
    private int dewPointC;
    @SerializedName("DewPointF")
    private int dewPointF;
    @SerializedName("WindChillC")
    private int windChillC;
    @SerializedName("WindChillF")
    private int windChillF;
    private int windspeedMiles;
    private int windspeedKmph;
    private int windspeedKnots;
    private int windspeedMeterSec;
    @SerializedName("WindGustMiles")
    private int windGustMiles;
    @SerializedName("WindGustKmph")
    private int windGustKmph;
    private int winddirDegree;
    private String winddir16Point;
    private int weatherCode;
    private List<WeatherDescription> weatherDesc;
    private List<WeatherIcon> weatherIconUrl;
    private float precipMM;
    private float precipInches;
    private int humidity;
    private int visibility;
    private int visibilityMiles;
    private int pressure;
    private int pressureInches;
    private int cloudcover;
    private int chanceofrain;
    private int chanceofwindy;
    private int chanceofovercast;
    private int chanceofsunshine;
    private int chanceoffrost;
    private int chanceoffog;
    private int chanceofsnow;
    private int chanceofthunder;

    protected Hourly(Parcel in) {
        time = in.readString();
        tempC = in.readInt();
        tempF = in.readInt();
        feelsLikeC = in.readInt();
        feelsLikeF = in.readInt();
        heatIndexC = in.readInt();
        heatIndexF = in.readInt();
        dewPointC = in.readInt();
        dewPointF = in.readInt();
        windChillC = in.readInt();
        windChillF = in.readInt();
        windspeedMiles = in.readInt();
        windspeedKmph = in.readInt();
        windspeedKnots = in.readInt();
        windspeedMeterSec = in.readInt();
        windGustMiles = in.readInt();
        windGustKmph = in.readInt();
        winddirDegree = in.readInt();
        winddir16Point = in.readString();
        weatherCode = in.readInt();
        weatherDesc = in.createTypedArrayList(WeatherDescription.CREATOR);
        weatherIconUrl = in.createTypedArrayList(WeatherIcon.CREATOR);
        precipMM = in.readFloat();
        precipInches = in.readFloat();
        humidity = in.readInt();
        visibility = in.readInt();
        visibilityMiles = in.readInt();
        pressure = in.readInt();
        pressureInches = in.readInt();
        cloudcover = in.readInt();
        chanceofrain = in.readInt();
        chanceofwindy = in.readInt();
        chanceofovercast = in.readInt();
        chanceofsunshine = in.readInt();
        chanceoffrost = in.readInt();
        chanceoffog = in.readInt();
        chanceofsnow = in.readInt();
        chanceofthunder = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(time);
        dest.writeInt(tempC);
        dest.writeInt(tempF);
        dest.writeInt(feelsLikeC);
        dest.writeInt(feelsLikeF);
        dest.writeInt(heatIndexC);
        dest.writeInt(heatIndexF);
        dest.writeInt(dewPointC);
        dest.writeInt(dewPointF);
        dest.writeInt(windChillC);
        dest.writeInt(windChillF);
        dest.writeInt(windspeedMiles);
        dest.writeInt(windspeedKmph);
        dest.writeInt(windspeedKnots);
        dest.writeInt(windspeedMeterSec);
        dest.writeInt(windGustMiles);
        dest.writeInt(windGustKmph);
        dest.writeInt(winddirDegree);
        dest.writeString(winddir16Point);
        dest.writeInt(weatherCode);
        dest.writeTypedList(weatherDesc);
        dest.writeTypedList(weatherIconUrl);
        dest.writeFloat(precipMM);
        dest.writeFloat(precipInches);
        dest.writeInt(humidity);
        dest.writeInt(visibility);
        dest.writeInt(visibilityMiles);
        dest.writeInt(pressure);
        dest.writeInt(pressureInches);
        dest.writeInt(cloudcover);
        dest.writeInt(chanceofrain);
        dest.writeInt(chanceofwindy);
        dest.writeInt(chanceofovercast);
        dest.writeInt(chanceofsunshine);
        dest.writeInt(chanceoffrost);
        dest.writeInt(chanceoffog);
        dest.writeInt(chanceofsnow);
        dest.writeInt(chanceofthunder);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Hourly> CREATOR = new Creator<Hourly>() {
        @Override
        public Hourly createFromParcel(Parcel in) {
            return new Hourly(in);
        }

        @Override
        public Hourly[] newArray(int size) {
            return new Hourly[size];
        }
    };

    public String getTime() {
        return time;
    }

    public int getTempC() {
        return tempC;
    }

    public int getTempF() {
        return tempF;
    }

    public int getFeelsLikeC() {
        return feelsLikeC;
    }

    public int getFeelsLikeF() {
        return feelsLikeF;
    }

    public int getHeatIndexC() {
        return heatIndexC;
    }

    public int getHeatIndexF() {
        return heatIndexF;
    }

    public int getDewPointC() {
        return dewPointC;
    }

    public int getDewPointF() {
        return dewPointF;
    }

    public int getWindChillC() {
        return windChillC;
    }

    public int getWindChillF() {
        return windChillF;
    }

    public int getWindspeedMiles() {
        return windspeedMiles;
    }

    public int getWindspeedKmph() {
        return windspeedKmph;
    }

    public int getWindspeedKnots() {
        return windspeedKnots;
    }

    public int getWindspeedMeterSec() {
        return windspeedMeterSec;
    }

    public int getWindGustMiles() {
        return windGustMiles;
    }

    public int getWindGustKmph() {
        return windGustKmph;
    }

    public int getWinddirDegree() {
        return winddirDegree;
    }

    public String getWinddir16Point() {
        return winddir16Point;
    }

    public int getWeatherCode() {
        return weatherCode;
    }

    public List<WeatherDescription> getWeatherDesc() {
        return weatherDesc;
    }

    public List<WeatherIcon> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public float getPrecipMM() {
        return precipMM;
    }

    public float getPrecipInches() {
        return precipInches;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getVisibility() {
        return visibility;
    }

    public int getVisibilityMiles() {
        return visibilityMiles;
    }

    public int getPressure() {
        return pressure;
    }

    public int getPressureInches() {
        return pressureInches;
    }

    public int getCloudcover() {
        return cloudcover;
    }

    public int getChanceofrain() {
        return chanceofrain;
    }

    public int getChanceofwindy() {
        return chanceofwindy;
    }

    public int getChanceofovercast() {
        return chanceofovercast;
    }

    public int getChanceofsunshine() {
        return chanceofsunshine;
    }

    public int getChanceoffrost() {
        return chanceoffrost;
    }

    public int getChanceoffog() {
        return chanceoffog;
    }

    public int getChanceofsnow() {
        return chanceofsnow;
    }

    public int getChanceofthunder() {
        return chanceofthunder;
    }
}
