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
public class SearchKeywordYoutubeService {
    private JSONObject getYoutubeApiResponse(String searchKeyword){
        try {
            String API_KEY = "AIzaSyChTRL1w_f2Q-LcyKp9V191ML69wYYVzQY&q";
            URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&key=" + API_KEY + "=" + Arrays.stream(searchKeyword.split(" ")).collect(Collectors.joining()));

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

        JSONObject json = getYoutubeApiResponse(searchKeyword);
        if(Objects.isNull(json)|| json.isNull("items"))
            return null;
        JSONArray jsonModified = (JSONArray) json.get("items");

        JSONArray newJsonArray = new JSONArray();

        for (int i = 0; i < jsonModified.length(); i++) {
            JSONObject video = (JSONObject) jsonModified.get(i);
//            if(json.isNull("snippet")||json.isNull("thumbnails")||json.isNull("high")||json.isNull("id"))
//                return null;
            JSONObject snippet = (JSONObject) video.get("snippet");
            JSONObject thumbnails = (JSONObject) snippet.get("thumbnails");
            JSONObject high = (JSONObject) thumbnails.get("high");
            JSONObject youtubeId = (JSONObject) video.get("id");

            JSONObject newVideo = new JSONObject();

            if(!youtubeId.isNull("videoId")){
                newVideo.put("title", snippet.get("title"));
                newVideo.put("description", snippet.get("description"));
                newVideo.put("link", "https://www.youtube.com/embed/" + youtubeId.get("videoId"));
                newVideo.put("thumbnail", high.get("url"));
                newJsonArray.put(newVideo);
            }
        }

        return newJsonArray;
    }
}
