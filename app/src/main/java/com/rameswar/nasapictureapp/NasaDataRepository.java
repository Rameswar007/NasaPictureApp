package com.rameswar.nasapictureapp;

import android.app.Activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class NasaDataRepository {
    private static ArrayList<NasaData> list = new ArrayList<>();


    public static ArrayList<NasaData> getNasaDataList(Activity activity){
        if(list.size()==0){
            list = convertStringTOJson(getJSONString(activity));
        }
        return list;
    }

    private static String getJSONString(Activity activity){
        String json = null;
        try {
            InputStream is = activity.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    private static ArrayList<NasaData> convertStringTOJson(String string){
        ArrayList<NasaData> list = new ArrayList<>();
        JSONArray m_jArry = null;
        try {
            m_jArry = new JSONArray(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i1 = 0; i1 < m_jArry.length(); i1++) {
            JSONObject json_obj = null;
            try {
                json_obj = m_jArry.getJSONObject(i1);

                String copyright = json_obj.getString("copyright");
                String  date = json_obj.getString("date");
                String explanation = json_obj.getString("explanation");
                String hdurl = json_obj.getString("hdurl");
                String media_type = json_obj.getString("media_type");
                String service_version = json_obj.getString("service_version");
                String title = json_obj.getString("title");
                String  url= json_obj.getString("url");

                NasaData model = new NasaData(copyright,date,explanation,hdurl,media_type,service_version,title,url);
                list.add(model);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return list;
    }
}
