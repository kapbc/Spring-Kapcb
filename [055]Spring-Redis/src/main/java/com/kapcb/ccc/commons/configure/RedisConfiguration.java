package com.kapcb.ccc.commons.configure;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

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
}
