package com.wangjichuan.springmvc.utils;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by wangjichuan on 17/4/7.
 */
public class BatchPublishResource {
    private static final String url = "http://s.qmt.lesports.com/sbc/api/v2/resources/publish?caller=1001";
    private final static String DEFAULT_CODE = "utf8";
    public static void batchPublishResource(Collection<Long> ids,String session) throws Exception{
        for(Long id : ids){
            singlePublishResource(id,session);
        }

    }
    public static void singlePublishResource(Long id,String session) throws Exception{
        HttpPost post = new HttpPost(url);
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("resourceId",""+id));
        post.setEntity(new UrlEncodedFormEntity(params,DEFAULT_CODE));
        post.addHeader(new BasicHeader("Cookie","SESSION="+session));

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpResponse response = closeableHttpClient.execute(post);
        InputStream instream = response.getEntity().getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(instream, DEFAULT_CODE));
        System.out.println(response.getStatusLine());
        System.out.println(reader.readLine());
    }
}
