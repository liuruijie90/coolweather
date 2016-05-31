package app.coolweather.com.coolweather.util;

/**
 * Created by liuruijie on 16/5/31.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);

}
