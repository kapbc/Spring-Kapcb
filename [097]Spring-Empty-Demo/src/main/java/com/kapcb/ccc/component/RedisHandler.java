@Slf4j
@RequiredArgsConstructor
@Component(value = "redisHandler")
public class RedisHandler {

    private final RedisService redisService;

    @Value(value = "canal.redis.key")
    public String canalRedisServerKey;

    private void firstAdd(CanalEntry.RowData rowData) {
        Map<String, String> resultData = DataParser.parse(rowData, true);
        redisService.setMultipleHashString(canalRedisServerKey, resultData);
        log.info("first time insert data into redis success, the data is : " + resultData);
    }

    public void delete(CanalEntry.RowData rowData, String rowKey) {
        if (StringUtils.isNotBlank(rowKey) && hasKey(rowKey)) {
            Object beforeDeleteValue = redisService.getHash(canalRedisServerKey, rowKey);
            redisService.deleteHash(canalRedisServerKey, rowKey);
            log.info("delete the key : " + canalRedisServerKey + " of the rowKey : " + rowKey + " from redis success, the value before delete is : " + beforeDeleteValue);
            return;
        }
        log.info("the key is not exist in redis");
    }

    public void update(CanalEntry.RowData rowData, String rowKey) {
        if (StringUtils.isNotBlank(rowKey) && hasKey(rowKey)) {
            log.info("the key is exist in the redis, delete the key of : " + canalRedisServerKey + " of the rowKey : " + rowKey);
            Object beforeDeleteValue = redisService.getHash(canalRedisServerKey, rowKey);
            log.info("the value before delete is : " + beforeDeleteValue);
            redisService.deleteHash(canalRedisServerKey, rowKey);
            log.info("delete the key : " + canalRedisServerKey + " of the rowKey : " + rowKey + " success");
        }
        Map<String, String> parse = DataParser.parse(rowData, true);
        redisService.setMultipleHashString(rowKey, parse);
        log.info("update the key : " + canalRedisServerKey + " of the rowKey : " + rowKey + redisService.getHash(canalRedisServerKey, rowKey));
    }

    public void insert(CanalEntry.RowData rowData, String rowKey) {
        if (StringUtils.isNotBlank(rowKey) && hasKey(rowKey)) {
            log.info("the key : " + canalRedisServerKey + " of the rowKey : " + rowKey + " is exist in the redis service");
            Object beforeInsertValue = redisService.getHash(canalRedisServerKey, rowKey);
            log.info("the value before insert is : " + beforeInsertValue);
            redisService.deleteHash(canalRedisServerKey, rowKey);
            log.info("delete the key : " + canalRedisServerKey + " of the rowKey : " + rowKey + " success");
        }
        Map<String, String> parse = DataParser.parse(rowData, true);
        redisService.setMultipleHashString(rowKey, parse);
        log.info("insert the key : " + canalRedisServerKey + " of the rowKey : " + rowKey + redisService.getHash(canalRedisServerKey, rowKey));
    }

    private boolean hasKey(String rowKey) {
        return redisService.hasHashKey(canalRedisServerKey, rowKey);
    }
}
