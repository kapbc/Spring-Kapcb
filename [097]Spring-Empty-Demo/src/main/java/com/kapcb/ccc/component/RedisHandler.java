import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import service.RedisService;

/**
 * <a>Title: RedisHandlerComponent </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-13:27
 */
@Slf4j
@RequiredArgsConstructor
@Component(value = "redisHandler")
public class RedisHandler {

    private final RedisService redisService;

    @Value(value = "canal.redis.key")
    public String canalRedisServerKey;

    private void firstAdd(Object addObject) {
        redisService.set(canalRedisServerKey, addObject);
        log.info("first add data to redis success the data is : " + addObject.toString());
    }

}
