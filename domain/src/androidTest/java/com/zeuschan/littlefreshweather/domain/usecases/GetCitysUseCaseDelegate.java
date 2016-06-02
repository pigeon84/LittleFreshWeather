package com.zeuschan.littlefreshweather.domain.usecases;

import android.util.Log;

import com.zeuschan.littlefreshweather.model.entities.CityEntity;

import java.util.List;

/**
 * Created by chenxiong on 2016/6/2.
 */
public class GetCitysUseCaseDelegate extends TestSubscriberDelegate<List<CityEntity>> {
    @Override
    protected void LogContent(List<CityEntity> citys) {
        for (CityEntity city :
                citys) {
            Log.e(TAG, city.toString());
        }
    }
}
