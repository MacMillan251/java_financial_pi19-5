import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class UrlConnect {

    private String link;

    public UrlConnect(String link) {

        this.link = link;
    }

    public String apireturn() {
        String response;
        try {
            HttpURLConnection wikihttp = (HttpURLConnection) new URL(link).openConnection();
            wikihttp.addRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(wikihttp.getInputStream()));
            response = in.lines().collect(Collectors.joining());
            in.close();
        } catch (Exception ex) {
            response = "error";
        }
        return response;
    }

}