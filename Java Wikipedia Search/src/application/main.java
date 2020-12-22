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
                continue;
            System.out.println("Поиск...");
            //Пункт №2
            String wikipediaApi = "https://www.wikipedia.org/w/api.php?format=json&action=opensearch&prop=extracts&exintro=&explaintext=&search="
                    + searchText.replace(" ", "%20");

            UrlConnect apilink = new UrlConnect(wikipediaApi);
            String response = apilink.apireturn();
            //Пункт №3,4
            response = response.replace("[", "");
            response = response.replace("]", "");
            int countRes = 0;
            String output;
            if (response != "error") {
                try {
                    for (char element : response.toCharArray()) {
                        if (element == '"') countRes++;
                    }
                    countRes = (countRes / 2 - 1) / 3;
                    System.out.println("\nКол-во найденных статей = " + countRes + ":\n");

                    for (int i = 1; i <= countRes; i++) {
                        output = (response.split("\",\"")[i] + " — " + response.split("\",\"")[i + countRes * 2]);
                        System.out.println(output.replace("\"", ""));
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Некорректный ввод запроса");
                }
            } else {
                System.out.println("Некорректный ввод запроса");
            }

            //Пункт №5
            if (countRes == 1) {
                try {

                    searchText = response.split(",")[3];
                    searchText = searchText.replace("\"", "");
                    wikipediaApi = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
                            + searchText.replace("https://en.wikipedia.org/wiki/", "");
                    UrlConnect apilink2 = new UrlConnect(wikipediaApi);
                    String description = apilink2.apireturn();
                    output = description.split("extract\":\"")[1];
                    output = output.length() > 400 ? output.substring(0, 100) + "\n" + output.substring(100, 200)
                            + "\n" + output.substring(200, 300) + "\n" + output.substring(300, 400) : output;
                    if (output.length() > 20) {
                        System.out.println(output.replace("\"}}}}", "") + "...");
                    } else {
                        System.out.println("Описание недоступно");
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Описание недоступно");
                }
            }
        }
    }
}