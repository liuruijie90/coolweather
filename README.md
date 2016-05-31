coolweather中具体的步骤：
1.activity包：放所有活动相关代码。 db：所有数据库相关代码。  model：所有模型相关代码。 receiver：所有广播接收器相关代码。  service:服务相关代码。 util:工具相关代码。 
2.创建数据库和表，这样从服务器获取到的数据才能够存储到本地。建立三张表，Province， City，County 分别存放省，市，县各种数据信息。
3.在db包下新建一个CoolWeatherOpenHelper类。（讲三条建表语句定义成常量，然后在onCreate()方法中去执行创建）
4.三个实体类。（每张表对应一个实体类）
5.创建一个CoolWeatherDB 类，这个类会把一些常用的数据库操作封装起来。(CoolWeatherDB 是一个单例，我们将它的结构方法私有化，并提供了一个getInstance()方法来获取CoolWeatherDB的实例，这样就可以保证全局范围内只有一个CoolWeatherDB的实例。接下来提供了6组方法，SaveProvince(),loadProvinces(),saveCity(),loadCities(),saveCounty(),loadCounties()，分别用于存储省份数据，读取所有省份数据，存储城市数据，读取某省内所有城市数据，存储县数据，读取某市内所有县的数据)
6.第一阶段的代码，提交代码（不知道如何提交）
