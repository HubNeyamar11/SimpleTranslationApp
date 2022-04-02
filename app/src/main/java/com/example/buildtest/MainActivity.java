package com.example.buildtest;

import static android.content.ContentValues.TAG;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    EditText textView1;
    EditText editText1;
    Button button1;
    String getresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (EditText) findViewById(R.id.textView1);
        editText1 = (EditText)findViewById(R.id.editText1);
        button1 = (Button)findViewById(R.id.button1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Translate translate = new Translate();
                translate.execute(); //ASYNC 실행


            }
        });
    }

     class Translate extends AsyncTask<String, Void, String> {


         @RequiresApi(api = Build.VERSION_CODES.KITKAT)
         @Override

         protected String doInBackground(String... strings) {


             String apiKey = "카카오 개발자 사이트에서 생성한 REST API Key";

             try {

                 String text = URLEncoder.encode(editText1.getText().toString(), "UTF-8");

                 //URL 생성
                 String apiURL = "https://dapi.kakao.com/v2/translation/translate";
                 URL url = new URL(apiURL);
                 HttpURLConnection con = (HttpURLConnection) url.openConnection();
                 con.setRequestMethod("POST"); // POST 요청

                 //API 요청시 필요한 파라미터 추가
                 String basicAuth = "KakaoAK " + apiKey; //KakaoAK 뒤에 공백이 필요
                 con.setRequestProperty("Authorization", basicAuth);
                 con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                 con.setRequestProperty("charset", "utf-8");
                 con.setUseCaches(false);
                 //con.setDoInput(true);
                 String postParams = "src_lang=kr&target_lang=en&query=" + text;
                 con.setDoOutput(true);
                 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                 wr.writeBytes(postParams);
                 wr.flush();
                 wr.close();

                 int responseCode = con.getResponseCode();
                 System.out.println("responseCode : " + responseCode);
                 BufferedReader br;
                 if (responseCode == 200) {
                     br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                     System.out.println("연결 성공!!");
                 } else {
                     br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                     System.out.println("연결 실패!!");
                 }
                 String inputLine;
                 StringBuffer res = new StringBuffer();
                 while ((inputLine = br.readLine()) != null) {
                     res.append(inputLine);
                 }
                 br.close();
                 textView1.setText(res.toString());
                 getresult = res.toString();

                 getresult = getresult.split("\"")[57];
                 textView1.setText(getresult);


             } catch (Exception e) {
                 e.printStackTrace();
             }

             return null;
         }


     }


}

