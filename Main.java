import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            String jsonData = readFile("C:\\Users\\wahid\\IdeaProjects\\Lab4\\src\\Booklist.json");
            List<Book> books = parseJsonData(jsonData);
            calculate(books);}
                catch (Exception e) {
            e.printStackTrace();}}
    private static String readFile(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
    private static List<Book> parseJsonData(String jsonData) {
        List<Book> books = new ArrayList<>();
        jsonData = jsonData.trim().substring(1, jsonData.length() - 1);
        String[] jsonObjects = jsonData.split("\\},\\{");
        for (String jsonObject : jsonObjects) {
            jsonObject = jsonObject.replace("{", "").replace("}", "");
            String title = extractFieldValue(jsonObject, "title");
            String author = extractFieldValue(jsonObject, "author");
            String genre = extractFieldValue(jsonObject, "genre");
            int pages = Integer.parseInt(extractFieldValue(jsonObject, "pages"));
            String dateRead = extractFieldValue(jsonObject, "date_read");
            books.add(new Book(title, author, genre, pages, dateRead));
        }
        return books;
    }
    private static String extractFieldValue(String jsonObject, String fieldName) {
        String[] fields = jsonObject.split(",");
        for (String field : fields) {
            String[] keyValue = field.split(":");
            String key = keyValue[0].trim().replace("\"", "");
            if (key.equals(fieldName)) {
                return keyValue[1].trim().replace("\"", "");
            }}
        return null;
    }
    public static void calculate(List<Book> books) {
        System.out.println("Total books read: " + books.size());
        for (Book book : books) {
            System.out.println(book);}
        double avgPages = books.stream().mapToInt(b -> b.getPages()).average().orElse(0);
        System.out.println("Average book length: " + avgPages + " pages");
    }}
