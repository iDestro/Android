package com.example.idestro.networkprogramming;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button httpBtn = (Button) findViewById(R.id.http_btn);
        httpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginActivity);
            }
        });
    }

//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            ((TextView)findViewById(R.id.http_show)).setText(msg.obj.toString());
//        }
//    };
//
//    private Thread getThread = new Thread() {
//        public void run() {
//            try{
//                URL url = new URL("http://10.200.224.112:8080/AndroidService/login");
//                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                urlConnection.setConnectTimeout(50*1000);
//                urlConnection.setReadTimeout(5000);
//                urlConnection.setUseCaches(true);
//                urlConnection.setRequestMethod("GET");
//                urlConnection.setRequestProperty("Charset", "UTF-8");
//                urlConnection.connect();
//                if (urlConnection.getResponseCode() == 200) {
//                    InputStream inputStream = urlConnection.getInputStream();
//                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                    StringBuffer result = new StringBuffer();
//                    String temp = "";
//                    while ((temp = bufferedReader.readLine()) != null) {
//                        result.append(temp);
//                    }
//                    Message message = new Message();
//                    message.obj = result.toString();
//                    handler.sendMessage(message);
//                    bufferedReader.close();
//                    inputStreamReader.close();
//                    inputStream.close();
//                }
//            } catch (java.io.IOException e) {
//                e.printStackTrace();
//            }
//        }
//    };
}
