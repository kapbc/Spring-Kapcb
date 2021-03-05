import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <a>Title: ConalConfig </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/5-9:53
 */
@Setter
@Component
@ConfigurationProperties(prefix = "canal")
public class CanalProperties {

    private String host;

    private Integer port;

    private String destination;

    private String username;

    private String password;

    private Integer batchSize;

    private String filter;

    private Boolean custom;

    private Boolean clusterEnabled;

    private List<String> clusterAddress;

    public String getHost() {
        return host == null ? CanalConstants.DEFAULT_HOST : host;
    }

    public int getPort() {
        return port == null ? CanalConstants.DEFAULT_PORT : port;
    }

    public String getDestination() {
        return destination == null ? CanalConstants.DEFAULT_DESTINATION : destination;
    }

    public String getUsername() {
        return username == null ? CanalConstants.DEFAULT_USERNAME : username;
    }

    public String getPassword() {
        return password == null ? CanalConstants.DEFAULT_PASSWORD : password;
    }

    public Integer getBatchSize() {
        return batchSize == null ? CanalConstants.DEFAULT_BATCH_SIZE : batchSize;
    }

    public String getFilter() {
        return filter == null ? CanalConstants.DEFAULT_FILTER : filter;
    }

    public Boolean getCustom() {
        return custom == null ? CanalConstants.DEFAULT_CUSTOM : custom;
    }

    public Boolean getClusterEnabled() {
        return clusterEnabled == null ? CanalConstants.DEFAULT_CLUSTER_ENABLED : clusterEnabled;
    }

    public List<String> getClusterAddress() {
        if (clusterEnabled && !clusterAddress.isEmpty()) {
            return clusterAddress;
        } else {
            throw new RuntimeException("must enable cluster and config the server address!");
        }
    }
}
