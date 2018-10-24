package ltd.vblago.kharkivweather.base;

import android.support.annotation.Nullable;

public interface BasePresenter<V> {
    void setView(@Nullable V view);
}
