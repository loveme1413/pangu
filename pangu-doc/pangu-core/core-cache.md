# core-cache



## 统一缓存key

- `com.miaosuan.pangu.core.cache.CacheKeyUtil`

````
        String key = CacheKeyUtil.get("b2b", "product", "1000");
        
        //key="b2b:product:1000";
````



## 分布式锁

- `com.miaosuan.pangu.core.cache.lock.impl.RedisDistributedLock`

````
@Slf4j
public class RedisDistributedLockTest {

    ApplicationContext ctx;

    DistributedLock distributedLock;

    @Before
    public void init() {
        ctx = new ClassPathXmlApplicationContext("classpath*:spring.xml");

        distributedLock = ctx.getBean(DistributedLock.class);
    }


    @Test
    public void lockTest() throws Exception {
        String key = CacheKeyUtil.get("b2b", "product", "1000");

        boolean result = distributedLock.lock(key);
        log.info("lock result={}", result);


        result = distributedLock.release(key);
        log.info("result result={}", result);
    }
}
````

