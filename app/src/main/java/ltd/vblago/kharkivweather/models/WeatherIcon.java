package ltd.vblago.kharkivweather.models;


import android.os.Parcel;
import android.os.Parcelable;

public class WeatherIcon implements Parcelable {

    private String value;

    protected WeatherIcon(Parcel in) {
        value = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<WeatherIcon> CREATOR = new Creator<WeatherIcon>() {
        @Override
        public WeatherIcon createFromParcel(Parcel in) {
            return new WeatherIcon(in);
        }

        @Override
        public WeatherIcon[] newArray(int size) {
            return new WeatherIcon[size];
        }
    };

    public String getValue() {
        return value;
    }
}
