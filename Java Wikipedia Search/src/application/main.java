import java.util.Scanner;

public class main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean repeat = false;

        while (!repeat) {

            System.out.println("\nВведите ваш запрос >>");
            String nextLine = scanner.nextLine();
            String searchText = nextLine;
            if (nextLine == null)
                searchText = "Wikipedia API";
            System.out.println("Поиск...");
            String wikipediaApi = "https://www.wikipedia.org/w/api.php?format=json&action=opensearch&prop=extracts&exintro=&explaintext=&search="
                    + searchText.replace(" ", "%20");

            UrlConnect apilink = new UrlConnect(wikipediaApi);
            String response = apilink.apireturn();
            response = response.replace("[", "");
            response = response.replace("]", "");

            int countSearch = 0;
            for (char element : response.toCharArray()) {
                if (element == '"') countSearch++;
            }
            countSearch = (countSearch / 2 - 1) / 3;

            System.out.println("\nКол-во найденных статей = " + countSearch + ":\n");
            for (int i = 1; i <= countSearch; i++) {
                System.out.println((response.split("\",\"")[i] + " — " + response.split("\",\"")[i + countSearch * 2]));
            }
            if (countSearch == 1) {
                searchText = response.split(",")[1];
                searchText = searchText.replace("\"", "");
                wikipediaApi = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
                        + searchText.replace(" ", "_");
                //System.out.println(wikipediaApi);
                UrlConnect apilink2 = new UrlConnect(wikipediaApi);
                String description = apilink2.apireturn();
                String desctext = description.split("extract\":\"")[1];
                desctext = desctext.length() > 400 ? desctext.substring(0, 100) + "\n" + desctext.substring(100, 200)
                        + "\n" + desctext.substring(200, 300) + "\n" +desctext.substring(300, 400): desctext;
                System.out.println(desctext + "...");
            }
        }
    }
}