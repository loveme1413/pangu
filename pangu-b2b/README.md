# pangu-b2b

## 目录说明

- `b2b-common` 微服务工程公共依赖
- `b2b-inffrastructure` cloud公共设施
- `b2b-product` 商品模块示例
- `b2b-mall-server` 商城模块示例（聚合多个微服务）

## 端口说明

- `eureka-server` `9000`
- `product-service` `9101`
- `mall-service` `9200`

## 启动顺序

- `eureka-server`
- `product-server`
- `mall-server`

## 访问地址
- `http://localhost:9101/api/product/detail?productId=1`
- `http://localhost:9200/mall/api/product/list?productName=手机`