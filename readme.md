## 项目概述 

本项目是一个简单的java SPI (Service Provider Interface)的学习，实现了一个简易的日志系统

## 模块介绍

项目包含三个模块，一个是服务的使用者SPIMain, 一个是服务接口SPIService 还有一个是具体的服务（可卸载和替换的服务，类似于插件）SPIServiceProvider。

- SPIMain 只实现了一个简单的方法，调用loggerService服务
- SPIService 定义接口和对服务进行包装
- SPIServiceProvider 一个符合SPIService中接口定义的规约的具体实现。

## 快速上手
目前项目已经使用了插件。直接运行SPIMain中的main方法，会发现打印的内容是：

![结果](https://github.com/zhifeiyv666/SPISample/blob/master/resource/provider.png)


如果移除SPIMain中的

``` xml
<dependency>
    <groupId>store.xiaowei</groupId>
    <artifactId>SPIServiceProvider</artifactId>
    <version>1.0.0</version>
</dependency>
```
    
重新运行会打印

![结果](https://github.com/zhifeiyv666/SPISample/blob/master/resource/default.png)
    
## 扩展说明
可以在SPIMain中更换不同的具体实现，只需要通过更改maven依赖即可换成自己的日志插件，而无需修改任何代码。

## 核心方法
``` java
ServiceLoader<Logger> loader = ServiceLoader.load(Logger.class);
```

并且具体的插件实现的资源文件夹下要有META-INF/services文件夹，文件夹内有命名为上述方法加载的类的全名的文件，文件内容为实现上述接口的类的全称