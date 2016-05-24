package com.iteam.findu.Util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HttpUtil {

    public static String urll = "http://api.map.baidu.com/telematics/v3/weather?location=%E5%8C%97%E4%BA%AC&output=json&ak=uiQdHkU6HMAap4Pe74HdIcqe";
    static URL url = null;

    public static void  httpGet(String url) {
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                //NOT UI Thread
                if(response.isSuccessful()) {
                    System.out.println(response.code());
                    System.out.println(response.body().string());
                }
            }
        });
    }



    public static String sendPostMessage(String path,Map<String,String> params)
    {
        try {
            return sendPostMessage(path,params, "utf-8");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

        return "";
    }
    public static String sendPostMessage(String path,Map<String,String> params,String encode) throws UnsupportedEncodingException
    {

        StringBuffer buffer = new StringBuffer();
        if(!params.isEmpty()&&params.size()!=0)
        {
            for(Map.Entry<String, String> entry:params.entrySet())
            {
                buffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), encode)).append("&");

            }
            buffer.deleteCharAt(buffer.length()-1);
            System.out.println(buffer);
            try {

                url = new URL(path);
                HttpURLConnection httpCon = (HttpURLConnection)url.openConnection();
                httpCon.setReadTimeout(3000);
                httpCon.setDoInput(true);
                httpCon.setDoOutput(true);
                byte mydata[] = new byte[1024];
                mydata = buffer.toString().getBytes();
                httpCon.setRequestMethod("POST");
                httpCon.setRequestProperty("Cotent-Type", "application/x-www-form-urlenconded");
                httpCon.setRequestProperty("Content-Length",String.valueOf(mydata.length));
                httpCon.setRequestProperty("Charset", "utf-8");
                OutputStream outStream = httpCon.getOutputStream();
                outStream.write(mydata,0,mydata.length);
                outStream.close();
                int respondCode = httpCon.getResponseCode();
                System.out.println(respondCode);
                if(200==respondCode)
                {
                    return changeInputStream(httpCon.getInputStream(),encode);
                }
            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }

        }
        return "";


    }



    private static String changeInputStream(InputStream inputStream,String encode) {


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String result;
        int length = 0;
        byte data[] = new byte[1024];
        try {
            while((length=inputStream.read(data))!=-1)
            {
                out.write(data, 0, length);

            }
            result = new String(out.toByteArray(), encode);
            return result;
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static String createJsonString(Object value)
    {
        Gson gson = new Gson();
        String gString = gson.toJson(value);
        return gString;
    }

    public static <T> T getModelFromGson(String jsonString,Class <T> cls)
    {
        T t = null;
        try
        {
            Gson gson = new Gson();
            t = gson.fromJson(jsonString, cls);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return t;
    }

    public static <T> List<T> getModelsFromJson(String jsonString,Class <T> cls)
    {
        List<T> list = new ArrayList<T>();
        try
        {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString, new TypeToken<List<T>>(){}.getType());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return list;
    }

}
