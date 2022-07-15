import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.service.DatabaseHandler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {

        DatabaseHandler databaseHandler = DatabaseHandler.getInstance();
        Document document = getConnect();
        Elements books = document.getElementsByClass("product-item");

        System.out.println(books.get(0).getElementsByClass("slimmage").attr("src"));
        System.out.println(books.get(0).getClass().getSimpleName());

        for (Element b : books) {
            String authorName = b.getElementsByClass("au-view").get(0).text();
            Author author = new Author(authorName);
            databaseHandler.insertData("author", author, author.getColumns());
        }
//        for (Element b : books) {
//            String title = b.getElementsByClass("t-view").get(0).text();
//            String authorName = b.getElementsByClass("au-view").get(0).text();
//            String priceStr = b.getElementsByClass("p-view").get(0).getElementsByClass("real-price").get(0).ownText();
//            String image = "https://bookbuy.vn/" + b.getElementsByClass("slimmage").attr("src");
//            int price = Integer.parseInt(priceStr.replaceAll(",", ""));
//
//            Author author = new Author(authorName);
//            Book book = new Book(title, author, image, price);
//            System.out.println(book.toString());
//
//            databaseHandler.insertData("book", book, book.getColumns());
//        }
//        books.forEach(b -> {
//            String title = b.getElementsByClass("t-view").get(0).text();
//            String author = b.getElementsByClass("au-view").get(0).text();
//            String priceStr = b.getElementsByClass("p-view").get(0).getElementsByClass("real-price").get(0).ownText();
//            String image = "https://bookbuy.vn/"+ b.getElementsByClass("slimmage").attr("src");
//            int price = Integer.parseInt(priceStr.replaceAll(",", ""));
//            Book book = new Book(title, author, image, price);
//            System.out.println(book.toString());
//            databaseHandler.insertData("book", book, book.getColumns());
//        });

    }

    public static Document getConnect() {
        String url = "https://bookbuy.vn/sach/van-hoc-nuoc-ngoai";
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url).openStream(), "ISO-8859-1", url);
            document.outputSettings().escapeMode(Entities.EscapeMode.xhtml);
            return document;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
