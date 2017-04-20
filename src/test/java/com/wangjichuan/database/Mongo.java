package com.wangjichuan.database;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.wangjichuan.springmvc.utils.CommonUtils;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by wangjichuan on 17/4/11.
 */
public class Mongo {
    private MongoCollection collection = null;
    @Before
    public void before(){
        MongoClient client = new MongoClient("localhost",27017);
        MongoDatabase database = client.getDatabase("school");
        collection = database.getCollection("student");
    }
    @Test
    public void insert(){
        for(int i= 0;i<10000;i++){
            doInsert("wang"+i,i);
        }

    }
    public void doInsert(String name,int age){
        Document document = new Document();
        document.put("name",name);
        document.put("age",age);
        collection.insertOne(document);
    }
    @Test
    public void printAll(){
        FindIterable findIterable = collection.find();
        MongoCursor<Document> cursor = findIterable.iterator();
        while (cursor.hasNext()){
            Document document = cursor.next();
            CommonUtils.print(document.getString("name"));
        }

    }
}
