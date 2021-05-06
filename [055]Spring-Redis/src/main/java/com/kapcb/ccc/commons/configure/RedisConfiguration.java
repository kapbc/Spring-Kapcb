package com.kapcb.ccc.commons.configure;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

/**
 * <a>Title: RedisConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/27-16:20
 */
@Configuration
public class RedisConfiguration {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.activateDefaultTyping(OBJECT_MAPPER.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(OBJECT_MAPPER);
        StringRedisSerializer redisSerializer = new StringRedisSerializer();
        /**
         * key采用 String的序列化方式
         */
        template.setKeySerializer(redisSerializer);
        /**
         * hash的 key也采用 String的序列化方式
         */
        template.setHashKeySerializer(redisSerializer);
        /**
         * value序列化方式采用 jackson
         */
        template.setValueSerializer(jackson2JsonRedisSerializer);
        /**
         * hash的 value序列化方式采用 jackson
         */
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 连接池配置
     *
     * @return JedisPoolConfig
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        /**
         * 最大连接数
         */
        jedisPoolConfig.setMaxTotal(30);
        /**
         * 设置最大空闲数
         */
        jedisPoolConfig.setMaxIdle(10);
        /**
         * 设置每次释放连接的最大数目
         */
        jedisPoolConfig.setNumTestsPerEvictionRun(1024);
        /**
         * 设置释放连接的扫描间隔（毫秒）
         */
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
        /**
         * 连接最小空闲时间
         */
        jedisPoolConfig.setMinEvictableIdleTimeMillis(1800000);
        /**
         * 连接空闲多久后释放, 当空闲时间>该值 且 空闲连接>最大空闲连接数 时直接释放
         */
        jedisPoolConfig.setSoftMinEvictableIdleTimeMillis(10000);
        /**
         * 设置获取连接时的最大等待毫秒数,小于零:阻塞不确定的时间,默认-1
         */
        jedisPoolConfig.setMaxWaitMillis(15000);
        /**
         * 在获取连接的时候检查有效性, 默认false
         */
        jedisPoolConfig.setTestOnBorrow(true);
        /**
         * 在空闲时检查有效性, 默认false
         */
        jedisPoolConfig.setTestWhileIdle(true);
        return jedisPoolConfig;
    }
    
//         @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//     @JsonSerialize(using = LocalDateTimeSerializer.class)
    
//     @Bean
//     public JedisConnectionFactory jedisConnectionFactory(){
//         RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//         redisStandaloneConfiguration.setPort(1);
//         redisStandaloneConfiguration.setHostName("");
//         redisStandaloneConfiguration.setDatabase(0);
//         redisStandaloneConfiguration.setPassword("");
//         return new JedisConnectionFactory(redisStandaloneConfiguration);
//     }
    
//         @Bean(value = "redisTemplate")
//     public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
//         log.info("begin to create redisTemplate");
//         lettuceConnectionFactory.setShareNativeConnection(false);
//         RedisTemplate<String, Object> template = new RedisTemplate<>();

//         Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);

//         ObjectMapper objectMapper = new ObjectMapper();
//         PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder().allowIfBaseType(Object.class).build();
//         objectMapper.registerModule(new Jdk8Module());
//         objectMapper.registerModule(new JavaTimeModule());
//         objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//         objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//         objectMapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
//         jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

//         template.setKeySerializer(RedisSerializer.string());
//         template.setHashKeySerializer(RedisSerializer.string());
//         template.setValueSerializer(jackson2JsonRedisSerializer);
//         template.setHashValueSerializer(jackson2JsonRedisSerializer);
//         template.setConnectionFactory(lettuceConnectionFactory);
//         template.afterPropertiesSet();
//         return template;
//     }

//     @Bean
//     @ConditionalOnBean(name = "redisTemplate")
//     public RedisService redisService(@Qualifier("redisTemplate") RedisTemplate<String, Object> redisTemplate) {
//         return new RedisService(redisTemplate);
//     }

}
