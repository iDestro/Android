package com.idestro.utils;

import android.os.Message;
import android.util.Log;
import com.idestro.model.User;
import com.alibaba.fastjson.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by idestro on 2018/11/26.
 */

public class TransferUtils {

    public static String getReceiveStream(HttpURLConnection request) {
        try {
            InputStream inputStream = request.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer result = new StringBuffer();
            String temp = "";
            while ((temp = bufferedReader.readLine()) != null) {
                result.append(temp);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static HttpURLConnection getConnection(URL url, String action) {
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(50*1000);
            urlConnection.setReadTimeout(5000);
            urlConnection.setUseCaches(true);
            urlConnection.setRequestMethod(action);
            urlConnection.setRequestProperty("Charset", "UTF-8");
            urlConnection.setRequestProperty("User-Agent", "Fiddler");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.connect();
            return urlConnection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean userRegister(final User user) {
        new Thread() {
            @Override
            public void run() {
                try {
                    String content = JSON.toJSONString(user);
                    URL url = new URL("http://10.200.128.247:8080/AndroidService/register");
                    HttpURLConnection urlConnection = getConnection(url, "POST");
                    OutputStream outputStream = urlConnection.getOutputStream();
                    outputStream.write(content.getBytes());
                    outputStream.close();
                    String result = getReceiveStream(urlConnection);
                    Log.i("Result", result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return true;
    }

    public static boolean userLogin(final String userName, final String passWord) {
//        new Thread() {
//            @Override
//            public void run() {
//                try {
//                    JSONObject userJSON = new JSONObject();
//                    userJSON.put("username", userName);
//                    userJSON.put("password", passWord);
//                    String content = JSON.toJSONString(userJSON);
//                    Log.i("JSON", content);
//                    URL url = new URL("http://10.200.128.247:8080/AndroidService/login");
//                    HttpURLConnection urlConnection = getConnection(url, "POST");
//                    OutputStream outputStream = urlConnection.getOutputStream();
//                    outputStream.write(content.getBytes());
//                    outputStream.close();
//                    String result = urlConnection.getInputStream().toString();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
        NewThread newThread = new NewThread(){
            @Override
            public void run() {
                this.setResult();
            }
        };
        String result = newThread.getResult();

        return true;
    }

    public static LinkedList<Message> getMessage() {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://10.200.128.247:8080/AndroidService/getmsg");
                    HttpURLConnection urlConnection = getConnection(url, "POST");
                    String result = urlConnection.getInputStream().toString();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        return null;
    }
}
