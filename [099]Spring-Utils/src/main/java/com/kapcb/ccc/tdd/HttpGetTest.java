package com.kapcb.ccc.tdd;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * <a>Title: HttpGetTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-16:40
 */
@Slf4j
public class HttpGetTest {
    private static final String REQUEST_URL = "https://blog.csdn.net/llllllllll4er5ty/article/details/102588420";
    private static final String REQUEST_URL_TEST="HTTPS://www.baidu.com";

    private HttpGetTest() {
    }

    public static void get() {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(REQUEST_URL);
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        httpGet.setHeader("Cookie", "BDUSS_BFESS=09BdHRVYlF4OEJyRkliWm1XbmdPbUc0aFk1VUp-MWU0RndtTU5SZmpIU05HQnBnSVFBQUFBJCQAAAAAAAAAAAEAAAA1Uh5Qyb3S9cmiUmVuAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAI2L8l-Ni~Jfb; H_BDCLCKID_SF_BFESS=tRAOoCD-tKvjDb7GbKTD-tFO5eT22-usfCPL2hcH0KLKDbn5MPvKKl8Fjf_OJlcnWm5hLlT9Wfb1MRjvyT5aD-PYQqrW56vtWN7BLp5TtUJ4SDnTDMRhqqJXe-jyKMnitKv9-pP2LpQrh459XP68bTkA5bjZKxtq3mkjbPbDfn02eCKu-n5jHjoyjGAH3f; BAIDUID_BFESS=4D5942B7AEC3C6F14E19CE8CE963A6EE:FG=1; ab_sr=1.0.0_YjQ2OWJiYWFiYzI5NTg2YWNhNGFjMmRkMGIxN2JmZWYzZmNmZGMzZWRmNTk3ZjI4YTJjNDVkNDljZWRjZWZlYTViODQwOTAzN2I2M2ViZGZkODAxZjkzNjI5ZDVkZDJm");
        try (CloseableHttpResponse closeableHttpResponse = aDefault.execute(httpGet)) {
            HttpEntity entity = closeableHttpResponse.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println("result = " + result);
        } catch (IOException e) {
            log.error(" do http get request error : " + e.getMessage(), e);
        } finally {
            if (aDefault != null) {
                try {
                    aDefault.close();
                } catch (IOException e) {
                    log.error("close http client error : " + e.getMessage());
                }
            }
        }
    }
}
