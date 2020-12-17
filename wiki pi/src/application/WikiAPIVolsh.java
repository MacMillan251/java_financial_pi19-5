import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WikiAPIVolsh {


    private static final Scanner scanner = new Scanner(System.in);
    private static final String encoding = "UTF-8";


    public static void main(String[] args) {


        boolean exit = false;


        while (!exit) {

            try {

                System.out.println("\nВведите ваш запрос >>");
                String nextLine = scanner.nextLine();
                if (nextLine == null)
                    continue;
                String searchText = nextLine;
                System.out.println("Поиск...");



                String wikipediaApiJSON = "https://www.wikipedia.org/w/api.php?format=json&action=opensearch&prop=extracts&exintro=&explaintext=&search="
                        + searchText;


                System.out.println(wikipediaApiJSON);


                HttpURLConnection wikihttp = (HttpURLConnection) new URL(wikipediaApiJSON).openConnection();
                wikihttp.addRequestProperty("User-Agent", "Mozilla/5.0");
                BufferedReader in = new BufferedReader(new InputStreamReader(wikihttp.getInputStream()));


                String response = in.lines().collect(Collectors.joining());
                in.close();
                ArrayList<String> result = new ArrayList<String>(Arrays.asList(response.split(",")[0]));
                //System.out.println(response);
                //ArrayList<String> result = new ArrayList<String>(Arrays.asList(response.split("extract\":\"")[0]));
                //System.out.println(result);
                System.out.println(result.get(0));


            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}
