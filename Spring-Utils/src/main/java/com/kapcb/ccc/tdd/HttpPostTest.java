package com.kapcb.ccc.tdd;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: HttpPostTest </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-17:01
 */
@Slf4j
public class HttpPostTest {

    private static final String REQUEST_URL = "";


    private HttpPostTest() {
    }

    public static void post() {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(REQUEST_URL);
        httpPost.setHeader("Connection", "keep-alive");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        httpPost.setHeader("Cookie", "UM_distinctid=16442706a09352-0376059833914f-3c604504-1fa400-16442706a0b345; CNZZDATA1262458286=1603637673-1530123020-%7C1530123020; JSESSIONID=805587506F1594AE02DC45845A7216A4");

        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", "123456"));

        CloseableHttpResponse httpResponse = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            httpResponse = aDefault.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            String result = EntityUtils.toString(entity);
            System.out.println("result = " + result);
        } catch (IOException e) {
            log.error(" do http post request error : " + e.getMessage(), e);
        } finally {
            if (aDefault != null) {
                try {
                    aDefault.close();
                } catch (IOException e) {
                    log.error("close http client error : " + e.getMessage());
                }
            }
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    log.error("close http response error : " + e.getMessage());
                }
            }
        }
    }
}
