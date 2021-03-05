import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * <a>Title: CancalConnectorConfig </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-12:45
 */
@Slf4j
@Configuration
public class CanalConnectorConfig {

    @Bean("canalConnector")
    @ConditionalOnBean(CanalProperties.class)
    public CanalConnector initCanalConnector(CanalProperties canalProperties) {
        log.info("begin to initial canal connector");
        CanalConnector connector = null;
        if (canalProperties.getClusterEnabled()) {
            // cluster connector method
        } else {
            // single connector method
            connector = CanalConnectors.newSingleConnector(
                    new InetSocketAddress(canalProperties.getHost(), canalProperties.getPort()),
                    canalProperties.getDestination(),
                    canalProperties.getUsername(),
                    canalProperties.getPassword());
        }

        connector.connect();
        if (StringUtils.isEmpty(canalProperties.getFilter())) {
            connector.subscribe();
        } else {
            connector.subscribe(canalProperties.getFilter());
        }
        connector.rollback();
        log.info("initial canal connector success!");
        return connector;
    }
}
