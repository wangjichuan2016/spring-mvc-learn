package com.wangjichuan.html;

import com.wangjichuan.springmvc.utils.CommonUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by wangjichuan on 17/4/17.
 */
public class JsoupTest {
    @Test
    public void test(){
        String html = "<b><a href='http://www.baidu.com' name='password' type='password'>我的天啊</a></b>";
        Document document = Jsoup.parseBodyFragment(html);
        CommonUtils.print(document);
        Elements elements = document.getElementsByTag("a");
        for(Element link : elements){
            CommonUtils.print(elements.attr("href"));
            CommonUtils.print(elements.text());
        }
        Element element = elements.get(0);
        Attributes attributes = element.attributes();
        for(Attribute attribute : attributes){
            CommonUtils.print("key="+attribute.getKey()+"--------value="+attribute.getValue());
        }
        CommonUtils.print(element.tag());

    }
    @Test
    public void testRemote() throws Exception{
        String url = "http://m.lesports.com";
        Set<String> urlSet = new HashSet<String>();
        extraUrl(url,urlSet,3);
        for(String u : urlSet){
            CommonUtils.print(u);
        }


    }
    public void extraUrl(String seedUrl,Set<String> urlSet,int deep) throws Exception{
        Document document = Jsoup.connect(seedUrl).userAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1")
                .get();
        Elements elements = document.getElementsByTag("a");

        deep --;
        if(deep >0){
            for(Element link : elements){
                String url  = link.attr("href");
                if(!url.contains("javascript") && url.contains("m.lesports.com")){
                    if(url.startsWith("//m.lesports.com")){
                        url = "http:"+url;
                    }
                    urlSet.add(url);
                    extraUrl(url,urlSet,deep);

                }
            }
        }

    }
    @Test
     public void testLocalFile() throws Exception{
        File local = new File(JsoupTest.class.getClassLoader().getResource("url.txt").getFile());
        Document document = Jsoup.parse(local,"utf8","http://www.baidu.com");
        Elements elements = document.getElementsByTag("a");
        for(Element link : elements){
            CommonUtils.print(link.attr("abs:href"));
        }
        Element element = elements.get(0);
        Attributes attributes = element.attributes();
        for(Attribute attribute : attributes){
            CommonUtils.print("key="+attribute.getKey()+"--------value="+attribute.getValue());
        }

    }
}
