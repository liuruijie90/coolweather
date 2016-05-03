coolweather中具体的步骤：
1.activity包：放所有活动相关代码。 db：所有数据库相关代码。  model：所有模型相关代码。 receiver：所有广播接收器相关代码。  service:服务相关代码。 util:工具相关代码。 
2.创建数据库和表，这样从服务器获取到的数据才能够存储到本地。建立三张表，Province， City，County 分别存放省，市，县各种数据信息。
3.在db包下新建一个CoolWeatherOpenHelper类。（讲三条建表语句定义成常量，然后在onCreate()方法中去执行创建）
4.三个实体类。（每张表对应一个实体类）
5.创建一个CoolWeatherDB 类，这个类会把一些常用的数据库操作封装起来。
