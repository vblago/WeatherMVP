package ltd.vblago.kharkivweather.models;


import android.os.Parcel;
import android.os.Parcelable;

public class Astronomy implements Parcelable {

    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;

    protected Astronomy(Parcel in) {
        sunrise = in.readString();
        sunset = in.readString();
        moonrise = in.readString();
        moonset = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sunrise);
        dest.writeString(sunset);
        dest.writeString(moonrise);
        dest.writeString(moonset);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Astronomy> CREATOR = new Creator<Astronomy>() {
        @Override
        public Astronomy createFromParcel(Parcel in) {
            return new Astronomy(in);
        }

        @Override
        public Astronomy[] newArray(int size) {
            return new Astronomy[size];
        }
    };

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public String getMoonset() {
        return moonset;
    }
}
