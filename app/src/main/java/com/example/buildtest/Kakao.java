package com.example.buildtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Kakao {
     public String getTranslation ( String word, String source, String target){


        /* try {
             String text = URLEncoder.encode(editText1.getText().toString(), "Utf8");
             String postParams = "src_lang=kr&target_lang=en&query="+text;
             String apiURL = "https://dapi.kakao.com/v2/translation/translate" + postParams;
             URL url = new URL(apiURL);

             HttpURLConnection con = (HttpURLConnection)url.openConnection();
             String userCredentials = apiKey;
             String basicAuth = "KakaoAK" + userCredentials;
             con.setRequestProperty("Authorization",basicAuth);
             con.setRequestMethod("GET");
             con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
             con.setRequestProperty("charset","utf-8");
             con.setUseCaches(false);
             con.setDoInput(true);
             con.setDoOutput(true);
             int responseCode = con.getResponseCode();
             System.out.println("responseCode : " + responseCode);
             BufferedReader br;
             if(responseCode == 200){
                 br = new BufferedReader(new InputStreamReader(con.getInputStream()));
             }
             else{
                 br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
             }
         }catch (Exception e) {
             e.printStackTrace();
         }*/
         return "0";


     }
}
