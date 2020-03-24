# 工程骨架规范

## 总体骨架

````
pangu-b2b
  ├── README.md
  ├── TODO.md
  ├── b2b-common             //公共模块
  ├── b2b-mall-server        // 商城模块
  ├── b2b-product
  │   ├── b2b-product-api 	 //商品微服务对外接口
  │   ├── b2b-product-biz		 //商品微服务业务层
  │   ├── b2b-product-server //商品启动入口
  ├── base-infrastructure  	 //基础设施
  │   ├── eureka-server    	 //注册中心
  ├── doc
````



### module骨架

````
.
├── b2b-product-api
├── b2b-product-biz
│   └── src
│       ├── main
│       │   ├── java
│       │   └── resources
│       │       ├── README.md
│       │       ├── i18n
│       │       │   ├── product.properties    //错误信息
│       │       │   └── product_zh.properties
│       │       ├── mybatis
│       │       │   ├── ProductMapper.xml // mybatis xml文件
│       │       │   └── REAME.md
│       │       └── mybatis-generator     // xml生成工具
│       │           ├── config.properties
│       │           └── generatorConfig.xml
├── b2b-product-server
│   └── src
│       ├── main
│       │   ├── java
│       │   └── resources
│       │       ├── application-dev.yml
│       │       ├── application-local.yml
│       │       ├── application-prod.yml
│       │       ├── application-test.yml
│       │       ├── application.yml
│       │       └── static

````

