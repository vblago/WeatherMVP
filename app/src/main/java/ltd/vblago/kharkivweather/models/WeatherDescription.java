package ltd.vblago.kharkivweather.models;

import android.os.Parcel;
import android.os.Parcelable;

public class WeatherDescription implements Parcelable {

    private String value;

    protected WeatherDescription(Parcel in) {
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

    public static final Creator<WeatherDescription> CREATOR = new Creator<WeatherDescription>() {
        @Override
        public WeatherDescription createFromParcel(Parcel in) {
            return new WeatherDescription(in);
        }

        @Override
        public WeatherDescription[] newArray(int size) {
            return new WeatherDescription[size];
        }
    };

    public String getValue() {
        return value;
    }
}
