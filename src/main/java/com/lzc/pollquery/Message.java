package com.lzc.pollquery;

import com.alibaba.fastjson.JSON;
import com.lzc.http.HttpRequestUtil;

import java.util.Map;

public class Message {
    private int pass;
    private String json;
    public Message(int pass)
    {
        this.pass=pass;
        getResult();
    }
    public void display(){
        System.out.println("pass="+pass+",json:"+json);
        if(json!=null&&json.contains("true"))
        {
            System.out.println("破获斤斤计较急急急急急急急急急，pass="+pass+","+json);
            Thread.yield();
        }
    }

    private  String getResult()
    {
        String url="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767069&kqmm="+pass+"&yzm=&_dlmc=kejian2009&_dlmm=456";
        json = HttpRequestUtil.getRequest(url);
        return json;
    }

}