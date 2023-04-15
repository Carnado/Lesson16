package com.example.lesson16.core;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.lesson16.R;

import java.util.ArrayList;

public class WeatherAdapter extends BaseAdapter {
    private ArrayList<WeatherData> weatherData= new ArrayList<>();
    public void setWeatherData(ArrayList<WeatherData> weatherData){
        this.weatherData=weatherData;
        notifyDataSetChanged();
    }
    public void addWeatherData(WeatherData weatherData){
        this.weatherData.add(weatherData);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return weatherData.size();
    }

    @Override
    public WeatherData getItem(int i) {
        return weatherData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_prog,viewGroup,false);
        WeatherData data=getItem(i);
        ImageView imageView=myView.findViewById(R.id.image_weather_view);
        TextView country=myView.findViewById(R.id.country_view);
        TextView countryCity=myView.findViewById(R.id.country_center);
        TextView weather=myView.findViewById(R.id.weather_view);
        ConstraintLayout constraintLayout=myView.findViewById(R.id.weather_constraint_view);
        if (data.getWeather()<30 && 20<data.getWeather()){
            Glide.with(imageView).load(R.drawable.cloudy).into(imageView);
            constraintLayout.setBackgroundColor(Color.parseColor("#5F7A96"));
        }
        if (data.getWeather()<40 && 30<data.getWeather()){
            Glide.with(imageView).load(R.drawable.cloudy_day).into(imageView);
            constraintLayout.setBackgroundColor(Color.parseColor("#088EE9"));
        }
        if (data.getWeather()<20 && 10<data.getWeather()){
            Glide.with(imageView).load(R.drawable.rain).into(imageView);
            constraintLayout.setBackgroundColor(Color.parseColor("#5065BC"));
        }

        country.setText(data.getNameCountry());
        countryCity.setText(data.getNameCountryCity());
        weather.setText(data.getWeather().toString()+"°");
        return myView;
    }
}
