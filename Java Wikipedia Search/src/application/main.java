import java.util.Scanner;

public class main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean repeat = false;

        while (!repeat) {

            //Пункт №1
            System.out.println("\nВведите ваш запрос >>");
            String nextLine = scanner.nextLine();
            String searchText = nextLine;
            if (nextLine == null)
                searchText = "Wikipedia API";
            System.out.println("Поиск...");
            //Пункт №2
            String wikipediaApi = "https://www.wikipedia.org/w/api.php?format=json&action=opensearch&prop=extracts&exintro=&explaintext=&search="
                    + searchText.replace(" ", "%20");

            UrlConnect apilink = new UrlConnect(wikipediaApi);
            String response = apilink.apireturn();
            //Пункт №3,4
            response = response.replace("[", "");
            response = response.replace("]", "");

            int countSearch = 0;
            for (char element : response.toCharArray()) {
                if (element == '"') countSearch++;
            }
            countSearch = (countSearch / 2 - 1) / 3;
            System.out.println("\nКол-во найденных статей = " + countSearch + ":\n");
            String output;
            for (int i = 1; i <= countSearch; i++) {
                output = (response.split("\",\"")[i] + " — " + response.split("\",\"")[i + countSearch * 2]);
                System.out.println(output.replace("\"", ""));
            }
            //Пункт №5
            if (countSearch == 1) {
                searchText = response.split(",")[1];
                searchText = searchText.replace("\"", "");
                wikipediaApi = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
                        + searchText.replace(" ", "_");
                UrlConnect apilink2 = new UrlConnect(wikipediaApi);
                String description = apilink2.apireturn();
                output = description.split("extract\":\"")[1];
                output = output.length() > 400 ? output.substring(0, 100) + "\n" + output.substring(100, 200)
                        + "\n" + output.substring(200, 300) + "\n" + output.substring(300, 400) : output;
                System.out.println(output + "...");
            }
        }
    }
}