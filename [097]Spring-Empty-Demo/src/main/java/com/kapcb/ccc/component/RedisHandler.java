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

    private void updateOrDeleteFromList(boolean update, boolean after,CanalEntry.RowData rowData, String updateColumn) {
        if (hasKey()) {
            List<Object> result = redisService.getList(canalRedisServerKey, 0L, -1L);
            log.info("before update or delete operation's data is : " + result);
            Map<String, String> parse = DataParser.parse(rowData, after);
            String s = parse.get(updateColumn);
        }
    }

    private boolean hasKey() {
        return redisService.hasKey(canalRedisServerKey);
    }


}
