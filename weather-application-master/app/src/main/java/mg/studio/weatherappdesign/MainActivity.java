package mg.studio.weatherappdesign;

import android.app.DownloadManager;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        new DownloadUpdate().execute();
        Toast toast=Toast.makeText(MainActivity.this, "Update complete",  Toast.LENGTH_SHORT);
        toast.show();
    }


    private class DownloadUpdate extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {
            String stringUrl = "http://t.weather.sojson.com/api/weather/city/101040100";
            HttpURLConnection urlConnection = null;
            BufferedReader reader;

            try {
                URL url = new URL(stringUrl);

                // Create the request to get the information from the server, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Mainly needed for debugging
                    Log.d("TAG", line);
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                //The temperature
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String jsondata) {
            //Update the temperature displayed
            String tem,date,loc,wek,wek2,wek3,wek4,wek5;
            try {
                JSONObject root = new JSONObject(jsondata);
                Log.d("TAG","date=" + root.getString("date"));
                date=root.getString("date");

                Log.d("TAG","data=" + root.getString("data"));
                String data=root.getString("data");
                JSONObject root2 = new JSONObject(data);
                Log.d("TAG","wendu=" + root2.getString("wendu"));
                tem=root2.getString("wendu");

                Log.d("TAG","cityInfo=" + root.getString("cityInfo"));
                String cityInfo=root.getString("cityInfo");
                JSONObject root3 = new JSONObject(cityInfo);
                Log.d("TAG","city=" + root3.getString("city"));
                loc=root3.getString("city");

                Log.d("TAG","forecast=" + root2.getString("forecast"));
                JSONArray array = root2.getJSONArray("forecast");
                wek=array.getJSONObject(0).getString("week");
                wek2=array.getJSONObject(1).getString("week");
                wek3=array.getJSONObject(2).getString("week");
                wek4=array.getJSONObject(3).getString("week");
                wek5=array.getJSONObject(4).getString("week");

                ((TextView) findViewById(R.id.temperature_of_the_day)).setText(tem);
                ((TextView) findViewById(R.id.tv_date)).setText(date);
                ((TextView) findViewById(R.id.tv_location)).setText(loc);
                ((TextView) findViewById(R.id.tv_week_theday)).setText(wek);
                ((TextView) findViewById(R.id.tv_week2)).setText(wek2);
                ((TextView) findViewById(R.id.tv_week3)).setText(wek3);
                ((TextView) findViewById(R.id.tv_week4)).setText(wek4);
                ((TextView) findViewById(R.id.tv_week5)).setText(wek5);
                //1
                if(array.getJSONObject(0).getString("type").equals("小雨")) {
                    ((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.rainy_small);
                }
                else if(array.getJSONObject(0).getString("type").equals("多云")){
                    ((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.windy_small);
                }
                else if(array.getJSONObject(0).getString("type").equals("阴")){
                    ((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.partly_sunny_small);
                }
                else if(array.getJSONObject(0).getString("type").equals("晴")){
                    ((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.sunny_small);
                }else{((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.rainy_small);}
                //2
                if(array.getJSONObject(1).getString("type").equals("小雨")) {
                    ((ImageView) findViewById(R.id.img2)).setImageResource(R.drawable.rainy_small);
                }
                else if(array.getJSONObject(1).getString("type").equals("多云")){
                    ((ImageView) findViewById(R.id.img2)).setImageResource(R.drawable.windy_small);
                }
                else if(array.getJSONObject(1).getString("type").equals("阴")){
                    ((ImageView) findViewById(R.id.img2)).setImageResource(R.drawable.partly_sunny_small);
                }
                else if(array.getJSONObject(1).getString("type").equals("晴")){
                    ((ImageView) findViewById(R.id.img2)).setImageResource(R.drawable.sunny_small);
                }else{((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.rainy_small);}
                //3
                if(array.getJSONObject(2).getString("type").equals("小雨")) {
                    ((ImageView) findViewById(R.id.img3)).setImageResource(R.drawable.rainy_small);
                }
                else if(array.getJSONObject(2).getString("type").equals("多云")){
                    ((ImageView) findViewById(R.id.img3)).setImageResource(R.drawable.windy_small);
                }
                else if(array.getJSONObject(2).getString("type").equals("阴")){
                    ((ImageView) findViewById(R.id.img3)).setImageResource(R.drawable.partly_sunny_small);
                }
                else if(array.getJSONObject(2).getString("type").equals("晴")){
                    ((ImageView) findViewById(R.id.img3)).setImageResource(R.drawable.sunny_small);
                }else{((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.rainy_small);}
                //4
                if(array.getJSONObject(3).getString("type").equals("小雨")) {
                    ((ImageView) findViewById(R.id.img4)).setImageResource(R.drawable.rainy_small);
                }
                else if(array.getJSONObject(3).getString("type").equals("多云")){
                    ((ImageView) findViewById(R.id.img4)).setImageResource(R.drawable.windy_small);
                }
                else if(array.getJSONObject(3).getString("type").equals("阴")){
                    ((ImageView) findViewById(R.id.img4)).setImageResource(R.drawable.partly_sunny_small);
                }
                else if(array.getJSONObject(3).getString("type").equals("晴")){
                    ((ImageView) findViewById(R.id.img4)).setImageResource(R.drawable.sunny_small);
                }else{((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.rainy_small);}
                //5
                if(array.getJSONObject(4).getString("type").equals("小雨")) {
                    ((ImageView) findViewById(R.id.img5)).setImageResource(R.drawable.rainy_small);
                }
                else if(array.getJSONObject(4).getString("type").equals("多云")){
                    ((ImageView) findViewById(R.id.img5)).setImageResource(R.drawable.windy_small);
                }
                else if(array.getJSONObject(4).getString("type").equals("阴")){
                    ((ImageView) findViewById(R.id.img5)).setImageResource(R.drawable.partly_sunny_small);
                }
                else if(array.getJSONObject(4).getString("type").equals("晴")){
                    ((ImageView) findViewById(R.id.img5)).setImageResource(R.drawable.sunny_small);
                }else{((ImageView) findViewById(R.id.img_weather_condition)).setImageResource(R.drawable.rainy_small);}

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
