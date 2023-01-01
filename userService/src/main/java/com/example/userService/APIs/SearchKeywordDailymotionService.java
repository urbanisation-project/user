package com.example.userService.APIs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class SearchKeywordDailymotionService {
    private JSONObject getDailymotionApiSearchResponse(String searchKeyword){
        try {
            URL url = new URL("https://api.dailymotion.com/videos?search=" + Arrays.stream(searchKeyword.split(" ")).collect(Collectors.joining("%20")));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                JSONObject json = new JSONObject(String.valueOf(informationString));

                return json;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject getDailymotionApiDescriptionResponse(String idVideoDailymotion){

        try {
            URL url = new URL("https://api.dailymotion.com/video/"+ idVideoDailymotion + "?fields=thumbnail_1080_url%2Cdescription%2Ctitle");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                //Close the scanner
                scanner.close();

                JSONObject json = new JSONObject(String.valueOf(informationString));

                return json;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray getVideos(String searchKeyword) throws JSONException {

        JSONObject json = getDailymotionApiSearchResponse(searchKeyword);
        if(Objects.isNull(json))
            return null;
        JSONArray jsonModified = json != null ? (JSONArray) json.get("list") : null;

        JSONArray newJsonArray = new JSONArray();

        if (jsonModified != null){
            for (int i = 0; i < jsonModified.length(); i++) {
                JSONObject video = (JSONObject) jsonModified.get(i);

                JSONObject workingJson = getDailymotionApiDescriptionResponse(video.getString("id"));

                JSONObject newVideo = new JSONObject();
                if (workingJson != null){
                    newVideo.put("title", workingJson.getString("title"));
                    newVideo.put("description", workingJson.getString("description"));
                    newVideo.put("link", "https://www.dailymotion.com/embed/video/" + video.getString("id")+"?pubtool=oembed");
                    newVideo.put("thumbnail", workingJson.getString("thumbnail_1080_url"));
                }

                newJsonArray.put(newVideo);
                if(i == 4){
                    return newJsonArray;
                }
            }
        }


        return newJsonArray;
    }
}
