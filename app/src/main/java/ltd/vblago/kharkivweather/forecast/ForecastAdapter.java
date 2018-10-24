package ltd.vblago.kharkivweather.forecast;

import android.content.res.Resources;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ltd.vblago.kharkivweather.R;
import ltd.vblago.kharkivweather.models.Weather;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Weather weather);

    }


    private final List<Weather> data;
    private OnItemClickListener listener;

    public ForecastAdapter() {
        data = new ArrayList<>();
    }

    public void updateData(List<Weather> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ForecastAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflateView(parent, R.layout.item_weather));
    }

    private View inflateView(ViewGroup parent, @LayoutRes int layout) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.description)
        TextView description;
        @BindView(R.id.temperature)
        TextView temperature;
        @BindView(R.id.feeling)
        TextView feeling;
        @BindView(R.id.pressure)
        TextView pressure;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Weather weather) {
            Glide.with(itemView).load(weather.getIcon()).into(icon);
            Resources res = itemView.getResources();

            description.setText(res.getString(R.string.pattern_description, weather.getDescription()));
            date.setText(res.getString(R.string.pattern_date, weather.getDate()));
            temperature.setText(res.getString(R.string.pattern_temperature, weather.getTemperature()));
            feeling.setText(res.getString(R.string.pattern_feeling, weather.getFeeling()));
            pressure.setText(res.getString(R.string.pattern_pressure, weather.getPressure()));
        }

        @OnClick(R.id.item)
        void onClick() {
            if (listener!=null) {
                listener.onItemClick(data.get(getAdapterPosition()));
            }
        }
    }
}
