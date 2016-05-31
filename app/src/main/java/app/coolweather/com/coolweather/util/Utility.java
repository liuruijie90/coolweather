package app.coolweather.com.coolweather.util;

import android.text.TextUtils;

import app.coolweather.com.coolweather.db.CoolWeatherDB;
import app.coolweather.com.coolweather.model.City;
import app.coolweather.com.coolweather.model.County;
import app.coolweather.com.coolweather.model.Province;

/**
 * Created by liuruijie on 16/5/31.
 */
public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public synchronized  static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB,String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvinces=response.split(",");
            if (allProvinces!=null&&allProvinces.length>0){
                for (String p:allProvinces){
                    String[] array=p.split("\\|");//  |符号需要转义
                    Province province=new Province();
                    province.setProvinceCode(array[0]);  //代号
                    province.setProvinceName(array[1]);   //城市
                    //将解析出来的数据存储到Province表
                    coolWeatherDB.saveProvince(province);
                }
                return  true;
            }
        }
        return  false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public synchronized  static boolean handleCityResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[] allCities=response.split(",");
            if (allCities!=null&&allCities.length>0){
                for (String p:allCities){
                    String[] array=p.split("\\|");//  |符号需要转义
                    City city=new City();
                    city.setCityCode(array[0]);//代号
                    city.setCityName(array[1]); //城市
                    city.setProvinceId(provinceId);
                    //将解析出来的数据存储到City表
                    coolWeatherDB.saveCity(city);
                }
                return  true;
            }
        }
        return  false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public synchronized  static boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            String[] allCounties=response.split(",");
            if (allCounties!=null&&allCounties.length>0){
                for (String p:allCounties){
                    String[] array=p.split("\\|");//  |符号需要转义
                    County county=new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    //将解析出来的数据存储到City表
                    coolWeatherDB.saveCount(county);
                }
                return  true;
            }
        }
        return  false;
    }
}
