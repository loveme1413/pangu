# core-orm



- 集成`tkmapper`

  - ````
     Product record = Product.builder()
                                    .briefName(dto.getProductName())
                                    .createTime(new Date())
                                    .updateTime(new Date())
                                    .build();
            int dbRow = productMapper.insertSelective(record);
    ````

- 集成`PageHelper`

````
PageHelper.startPage(dto.getPage(), dto.getSize());

        Example example = new Example(Product.class);

        ExampleUtil.setLikeValue(example, "name", dto.getProductName());

        example.orderBy("productId").desc();


        List<Product> productList = productMapper.selectByExample(example);
````





- 常用工具
  - `ExampleUtil`
  - `PageUtil`