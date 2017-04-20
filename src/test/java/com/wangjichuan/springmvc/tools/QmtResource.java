package com.wangjichuan.springmvc.tools;

import com.wangjichuan.springmvc.utils.BatchPublishResource;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by wangjichuan on 17/4/7.
 */
public class QmtResource {
    private String session = "5a6fc922-265d-44b8-af7d-8d1b4bcec197";
    @Test
    public void batchPublish() throws Exception{
        Set<Long> resourceIds = Collections.synchronizedSet(new HashSet<Long>());
        String filePath = QmtResource.class.getClassLoader().getResource("1.txt").getPath();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String content = null;
        while ((content = reader.readLine()) != null){
            resourceIds.add(Long.parseLong(content.trim()));
        }
        BatchPublishResource.batchPublishResource(resourceIds,session);
    }
}
