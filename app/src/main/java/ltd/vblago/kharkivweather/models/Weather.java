package ltd.vblago.kharkivweather.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather implements Parcelable {

    private List<Astronomy> astronomy;
    private String date;
    private int maxtempC;
    private int maxtempF;
    private int mintempC;
    private int mintempF;
    private int uvIndex;
    @SerializedName("totalSnow_cm")
    private float totalSnowCM;
    private float sunHour;
    private List<Hourly> hourly;

    protected Weather(Parcel in) {
        astronomy = in.createTypedArrayList(Astronomy.CREATOR);
        date = in.readString();
        maxtempC = in.readInt();
        maxtempF = in.readInt();
        mintempC = in.readInt();
        mintempF = in.readInt();
        uvIndex = in.readInt();
        totalSnowCM = in.readFloat();
        sunHour = in.readFloat();
        hourly = in.createTypedArrayList(Hourly.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(astronomy);
        dest.writeString(date);
        dest.writeInt(maxtempC);
        dest.writeInt(maxtempF);
        dest.writeInt(mintempC);
        dest.writeInt(mintempF);
        dest.writeInt(uvIndex);
        dest.writeFloat(totalSnowCM);
        dest.writeFloat(sunHour);
        dest.writeTypedList(hourly);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public List<Astronomy> getAstronomy() {
        return astronomy;
    }

    public String getDate() {
        return date;
    }

    public int getMaxtempC() {
        return maxtempC;
    }

    public int getMaxtempF() {
        return maxtempF;
    }

    public int getMintempC() {
        return mintempC;
    }

    public int getMintempF() {
        return mintempF;
    }

    public int getUvIndex() {
        return uvIndex;
    }

    public float getTotalSnowCM() {
        return totalSnowCM;
    }

    public float getSunHour() {
        return sunHour;
    }

    public List<Hourly> getHourly() {
        return hourly;
    }

    public String getDescription() {
        return hourly.get(4).getWeatherDesc().get(0).getValue();
    }

    public String getIcon() {
        return hourly.get(4).getWeatherIconUrl().get(0).getValue();
    }


    public int getTemperature() {
        return hourly.get(4).getTempC();
    }

    public int getFeeling() {
        return hourly.get(4).getFeelsLikeC();
    }

    public int getPressure() {
        return hourly.get(4).getPressure();
    }
}
