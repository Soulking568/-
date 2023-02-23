
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Viber {

    private String apiUrl;
    private String token;
    private String channel;

    public Viber(String apiUrl, String token, String channel) {
        this.apiUrl = apiUrl;
        this.token = token;
        this.channel = channel;
    }

    public void sendTextMessage(String message) throws Exception {
        String url = apiUrl;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // set request method
        con.setRequestMethod("POST");

        // set request headers
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("X-Viber-Auth-Token", token);

        // set request body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("receiver", channel);
            requestBody.put("type", "text");
            requestBody.put("text", message);
            //String requestBodyJson = new ObjectMapper().writeValueAsString(requestBody);
            con.setDoOutput(true);
            //con.getOutputStream().write("UTF-8".getBytes(requestBodyJson));
            // send request and receive response
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print response
            System.out.println("Response code: " + responseCode);
            System.out.println("Response body: " + response.toString());
        }
    }


