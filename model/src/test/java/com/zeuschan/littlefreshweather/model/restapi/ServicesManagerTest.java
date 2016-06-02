package com.zeuschan.littlefreshweather.model.restapi;



import com.zeuschan.littlefreshweather.model.entities.CityEntity;
import com.zeuschan.littlefreshweather.model.entities.WeatherConditionEntity;
import com.zeuschan.littlefreshweather.model.entities.WeatherEntity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.logging.Logger;

import rx.Subscriber;

/**
 * Created by chenxiong on 2016/6/1.
 */
public class ServicesManagerTest {
    public static final String TAG = ServicesManagerTest.class.getSimpleName();
    private ServicesManager mServicesManger = null;
    private List<CityEntity> mCitys = null;
    private List<WeatherConditionEntity> mWeatherConditions = null;
    private WeatherEntity mWeatherEntity = null;

    @Before
    public void createServicesManager() {
        mServicesManger = ServicesManager.getInstance();
    }

    @Test
    public void testServicesManagerGetCitys() throws Exception {
        final Logger logger = Logger.getLogger("testServicesManagerGetCitys");
        assertNotNull(mServicesManger);
        mServicesManger.getCitys()
                .subscribe(new Subscriber<List<CityEntity>>() {
                    @Override
                    public void onCompleted() {
                        logger.info("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        logger.info("onError");
                    }

                    @Override
                    public void onNext(List<CityEntity> cityEntities) {
                        logger.info("onNext");
                        mCitys = cityEntities;
                        for (CityEntity city :
                                cityEntities) {
                            logger.info(city.toString());
                        }
                    }
                });
        assertNotNull(mCitys);
        assertFalse(mCitys.isEmpty());
    }

    @Test
    public void testServicesManagerGetWeatherConditions() throws Exception {
        final Logger logger = Logger.getLogger("testServicesManagerGetWeatherConditions");
        assertNotNull(mServicesManger);
        mServicesManger.getWeatherConditions()
                .subscribe(new Subscriber<List<WeatherConditionEntity>>() {
                    @Override
                    public void onCompleted() {
                        logger.info("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        logger.info("onError");
                    }

                    @Override
                    public void onNext(List<WeatherConditionEntity> weatherConditionEntities) {
                        logger.info("onNext");
                        mWeatherConditions = weatherConditionEntities;
                        for (WeatherConditionEntity condition :
                                weatherConditionEntities) {
                            logger.info(condition.toString());
                        }
                    }
                });
        assertNotNull(mWeatherConditions);
        assertFalse(mWeatherConditions.isEmpty());
    }

    @Test
    public void testServicesManagerGetCityWeather() throws Exception {
        final Logger logger = Logger.getLogger("testServicesManagerGetCityWeather");
        assertNotNull(mServicesManger);
        mServicesManger.getCityWeather("CN101010300")
                .subscribe(new Subscriber<WeatherEntity>() {
                    @Override
                    public void onCompleted() {
                        logger.info("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        logger.info("onError");
                        logger.info(e.getMessage());
                    }

                    @Override
                    public void onNext(WeatherEntity weatherEntity) {
                        logger.info("onNext");
                        mWeatherEntity = weatherEntity;
                        logger.info(mWeatherEntity.toString());
                    }
                });
        assertNotNull(mWeatherEntity);
    }
}
