## Redis缓存

### 缓存注解详解

**@Cacheable**

_添加在方法上,根据条件添加缓存_

* value:  缓存的名称,不能为空
* cacheNames:  缓存的名称,和value二选一
* key:  缓存的key,默认为空,表示使用方法的参数类型及参数值作为key,支持SpEL
* keyGenerator:  指定key的生成策略
* cacheManager:  指定缓存管理器
* cacheResolver:  指定获取解析器
* condition:  条件符合则缓存
* unless:  条件符合则不缓存
* sync:  是否使用异步模式 默认false

**@CachePut**

_添加在方法上,根据条件添加缓存_

@CachePut作用和@Cacheable类似,区别是@Cacheable没有缓存数据会执行方法后,把结果缓存起来,第二次调用方法不执行方法,直接从缓存中获取数据并返回.
@CachePut每次都会执行方法,不管缓存中有没有数据,都会把结果缓存.

**@CacheEvict**

_添加在方法上,根据条件清空缓存._

* value:  缓存名称,不能为空
* cacheNames: 缓存的名称,与value二选一
* keyGenerator:  key的生成器。key/keyGenerator二选一使用
* condition:  触发条件,支持SpEL
* allEntries:  true表示清除value中的全部缓存,默认为false
* beforeInvocation:  是否在方法执行前就清空 默认false
* cacheManager:  指定缓存管理器
* cacheResolver:  或者指定获取解析器

**@CacheConfig**

_作用在类上,为本类的缓存注解配置全局属性_

* cacheNames: 缓存名称
* keyGenerator: key的生成器
* cacheManager: 缓存管理器
* cacheResolver: 获取解析器

**@Caching**

_组合多个缓存注解_

### 更多关于缓存注解的使用：

https://www.cnblogs.com/qlqwjy/p/8559119.html