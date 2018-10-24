package ltd.vblago.kharkivweather.forecast;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ltd.vblago.kharkivweather.R;
import ltd.vblago.kharkivweather.api.ApiManagerImpl;
import ltd.vblago.kharkivweather.models.Weather;
import ltd.vblago.kharkivweather.router.ActivityRouter;

public class ForecastActivity extends AppCompatActivity implements ForecastView, ForecastAdapter.OnItemClickListener, ActivityRouter.OnIntentReadyListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.list)
    RecyclerView list;

    private ForecastAdapter adapter;
    private ForecastPresenter presenter;
    private ActivityRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        presenter = new ForecastPresenterImpl(new ApiManagerImpl());

        router= new ActivityRouter(this);

        setupList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setListener(this);
        presenter.setView(this);
        presenter.requestForecast(5);
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.setListener(null);
        presenter.setView(null);
    }

    private void setupList() {
        adapter = new ForecastAdapter();
        list.setLayoutManager(new LinearLayoutManager(this));
        list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showForecast(List<Weather> forecast) {
        adapter.updateData(forecast);
    }

    @Override
    public void onItemClick(Weather weather) {
        router.requestDetailedForecastActivityIntent(weather, this);
    }

    @Override
    public void onIntentReady(Intent intent) {
        startActivity(intent);
    }
}
