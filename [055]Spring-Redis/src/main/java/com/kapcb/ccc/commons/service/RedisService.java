package com.kapcb.ccc.commons.service;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: RedisService </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/27-13:57
 */
@Service(value = "redisService")
public class RedisService {

    private static final Logger log = LoggerFactory.getLogger(RedisService.class);

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效的时间
     *
     * @param key  String
     * @param time Long
     * @return Boolean
     */
    public Boolean expire(String key, Long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("redis set expire time for key : " + key + " error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * 根据key获取当前对象的过期时间
     * 返回 0 代表永久有效
     * key 不能为空
     *
     * @param key String
     * @return Long
     */
    public Long getExpire(String key) {
        return redisTemplate.getExpire(Objects.requireNonNull(key), TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key String
     * @return Boolean
     */
    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            log.error("redis judgement has key error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * 输出缓存
     *
     * @param key String... 可以是一个值或者多个值
     */
    public void delete(String... key) {
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
                log.warn("delete key : " + key[0] + " in redis success");
            } else {
                redisTemplate.delete(Arrays.asList(key));
                log.warn("delete multiple key in redis success");
            }
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key String
     * @return Object
     */
    public Object get(String key) {
        return StringUtils.isBlank(key) ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   String
     * @param value Object
     * @return Boolean
     */
    public Boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            log.error("redis ops for key: " + key + " value : " + value + " error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * 普通缓存放入并设置失效时间
     *
     * @param key   String
     * @param value Object
     * @param time  Long
     * @return Boolean
     */
    public Boolean set(String key, Object value, Long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                this.set(key, value);
            }
            return true;
        } catch (Exception e) {
            log.error("redis ops for key: " + key + " value : " + value + " error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key   String
     * @param delta Long
     * @return Long
     */
    public Long increase(String key, Long delta) {
        if (delta < 0) {
            throw new RuntimeException("the delta of the increase must bigger than zero");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   String
     * @param delta Long
     * @return Long
     */
    public Long decrement(String key, Long delta) {
        if (delta < 0) {
            throw new RuntimeException("the delta of the increase must bigger than zero");
        }
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    /**
     * get hash
     *
     * @param key  String
     * @param item String
     * @return Object
     */
    public Object getHash(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * get multiple hash of all the key that value is : key
     *
     * @param key String
     * @return Map<Object, Object>
     */
    public Map<Object, Object> getMultipleHash(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * set hash if not exist it will be create
     *
     * @param key   String
     * @param item  String
     * @param value Object
     * @return Boolean
     */
    public Boolean setHash(String key, String item, Object value) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            return true;
        } catch (Exception e) {
            log.error("redis set hash error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * set hash with expire time if not exist it will be create
     *
     * @param key   String
     * @param item  String
     * @param value Object
     * @param time  Long
     * @return Boolean
     */
    public Boolean setHashWithExpireTime(String key, String item, Object value, Long time) {
        try {
            redisTemplate.opsForHash().put(key, item, value);
            if (time > 0) {
                this.expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("redis set hash with expire time of key : {} error, the exception is : {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * set multiple hash
     *
     * @param key   String
     * @param value Map<String, Object>
     * @return Boolean
     */
    public Boolean setMultipleHash(String key, Map<String, Object> value) {
        try {
            redisTemplate.opsForHash().putAll(key, value);
            return true;
        } catch (Exception e) {
            log.error("redis set multiple hash of key : " + key + " error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * set multiple hash with expire time
     *
     * @param key   String
     * @param value Map<String, Object>
     * @param time  Long
     * @return Boolean
     */
    public Boolean setMultipleHashWithExpireTime(String key, Map<String, Object> value, Long time) {
        try {
            redisTemplate.opsForHash().putAll(key, value);
            if (time > 0) {
                this.expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("redis set multiple hash with expire time of key : " + key + " error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * delete hash in redis
     *
     * @param key  String
     * @param item Object...
     */
    public void deleteHash(String key, Object... item) {
        try {
            redisTemplate.opsForHash().delete(key, item);
        } catch (Exception e) {
            log.error("delete of key : {} error, the exception is : {}", key, e.getMessage());
        }
    }

    /**
     * judgement whether has the hash key in the redis
     *
     * @param key  String
     * @param item String
     * @return Boolean
     */
    public Boolean hasHashKey(String key, String item) {
        try {
            return redisTemplate.opsForHash().hasKey(Objects.requireNonNull(key), Objects.requireNonNull(item));
        } catch (Exception e) {
            log.error("redis judgement has hash key of : {} error, the exception is : {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * hash increase , if not exist it will be create, and return the result after create value add by
     *
     * @param key  String
     * @param item String
     * @param by   Double
     * @return Double
     */
    public Double hashIncrease(String key, String item, Double by) {
        if (by < 0) {
            throw new RuntimeException("the hash delta of the increase must bigger than zero");
        }
        return redisTemplate.opsForHash().increment(key, item, Objects.requireNonNull(by));
    }

    /**
     * hash decrement
     *
     * @param key  String
     * @param item String
     * @param by   Double
     * @return Double
     */
    public Double hashDecrement(String key, String item, Double by) {
        if (by < 0) {
            throw new RuntimeException("the hash delta of the increase must bigger than zero");
        }
        return redisTemplate.opsForHash().increment(key, item, -by);
    }

    /**
     * get the key of the all set value
     *
     * @param key String
     * @return Set<Object>
     */
    public Set<Object> getSet(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.error("get the set key of : {} from redis error, the exception is : {}", key, e.getMessage());
            return null;
        }
    }

    /**
     * judgement whether has the set key in the redis
     *
     * @param key   String
     * @param value Object
     * @return Boolean
     */
    public Boolean hasSetKey(String key, Object value) {
        try {
            return redisTemplate.opsForSet().isMember(key, value);
        } catch (Exception e) {
            log.error("redis judgement of set key : {} error, the exception is : {}", key, e.getMessage());
            return false;
        }
    }

    /**
     * put into set
     * the return value is add success value
     *
     * @param key    String
     * @param values Object...
     * @return Long
     */
    public Long setSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            log.error("set value into set error, the exception is : " + e.getMessage());
            return 0L;
        }
    }

    /**
     * put into set with expire time
     *
     * @param key    String
     * @param time   Long
     * @param values Object...
     * @return Long
     */
    public Long setSetWithExpireTime(String key, Long time, Object... values) {
        try {
            Long count = redisTemplate.opsForSet().add(key, values);
            if (time > 0) {
                this.expire(key, time);
            }
            return count;
        } catch (Exception e) {
            log.error("set value into set with expire time error, the exception is : " + e.getMessage());
            return 0L;
        }
    }

    /**
     * get set size in redis
     *
     * @param key String
     * @return Long
     */
    public Long getSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            log.error("get set size error, the exception is : " + e.getMessage());
            return 0L;
        }
    }

    /**
     * remove the value is values in set
     *
     * @param key    String
     * @param values Object...
     * @return Long
     */
    public Long removeSet(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            log.error("remove set in redis error, the exception is : " + e.getMessage());
            return 0L;
        }
    }

    /**
     * get list result in redis
     *
     * @param key   String
     * @param start Long
     * @param end   Long
     * @return List<Object>
     */
    public List<Object> getList(String key, Long start, Long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            log.error("get list from redis error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * get list size in redis
     *
     * @param key String
     * @return Long
     */
    public Long getListSize(String key) {
        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            log.error("get the list size in redis error, the exception is : " + e.getMessage());
            return 0L;
        }
    }

    /**
     * get list by index
     *
     * @param key   String
     * @param index Long
     * @return Object
     */
    public Object getListByIndex(String key, Long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            log.error("get the list by index error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * put list into redis
     *
     * @param key   String
     * @param value Object
     * @return Boolean
     */
    public Boolean setList(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            log.error("set list into redis error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * put list into redis with expire time
     *
     * @param key   String
     * @param value Object
     * @param time  Long
     * @return Boolean
     */
    public Boolean setListWithExpireTime(String key, Object value, Long time) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                this.expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("set list with expire time into redis error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * set list into redis
     *
     * @param key   String
     * @param value List<Object>
     * @return Boolean
     */
    public Boolean setList(String key, List<Object> value) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            log.error("set list into redis error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * set list with expire time
     *
     * @param key   String
     * @param value List<Object>
     * @param time  Long
     * @return Boolean
     */
    public Boolean setListWithExpireTime(String key, List<Object> value, Long time) {
        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                this.expire(key, time);
            }
            return true;
        } catch (Exception e) {
            log.error("set list with expire time into redis error, the exception is : " + e.getMessage());
            return false;
        }
    }

    /**
     * update list by index
     *
     * @param key   String
     * @param index Long
     * @param value Object
     * @return Boolean
     */
    public Boolean updateListByIndex(String key, Long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            log.error("update list by index error, the exception is : " + e.getMessage());
            return false;
        }
    }

}
