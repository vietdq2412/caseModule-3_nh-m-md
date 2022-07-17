import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.service.DatabaseHandler;
import org.jsoup.Jsoup;
import org.jsoup.internal.NonnullByDefault;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = DatabaseHandler.getInstance();
        String cat1 = "non-fiction";
        String cat2 = "fiction-books";
        String cat3 = "classics";
        String cat4 = "children";
        String cat5 = "poetry-drama";
        String cat6 = "books-into-movies";

        //crawAuthor(databaseHandler);

        for (int i = 1; i < 10; i++) {
            crawBook(databaseHandler, cat1, i, 1);
            crawBook(databaseHandler, cat2, i, 2);
            crawBook(databaseHandler, cat3, i, 3);
            crawBook(databaseHandler, cat4, i, 4);
            crawBook(databaseHandler, cat5, i, 5);
            crawBook(databaseHandler, cat6, i, 6);
        }
    }

    public static void crawBook(DatabaseHandler databaseHandler, String category, int page, int catID) {
        Document document = getConnect("https://boabookstore.com/" + category + "?page=" + page);
        Elements books = document.getElementsByClass("product-box");

        books.forEach(b -> {
            String linkDetail = "https://boabookstore.com" + b.getElementsByTag("a").first().attr("href");
            Document documentDetail = getConnect(linkDetail);
            Element bookDetail = documentDetail.getElementsByClass("col-xs-12 details-product").first();

            String image = "https:" + bookDetail.getElementsByTag("a").first().attr("href");
            String title = bookDetail.getElementsByClass("title-head").first().text().replace("\"", "\\\"").replace("'", "\\'");
            String priceStr = "-11111";
            if (bookDetail.getElementsByClass("money").first() != null) {
                priceStr = bookDetail.getElementsByClass("money").first().text();
            }
            int price = Integer.parseInt(priceStr.substring(0, priceStr.length() - 3).replace(".", ""));
            String authorName = bookDetail.getElementsByTag("b").next().text();
            int authorId = findAuthorByName(databaseHandler, authorName);
            String description = documentDetail.getElementsByClass("rte").text().replace("\"", "\\\"").replace("'", "\\'");
            int quantity = 30;
            int views = 0;

//            Book bookToInsert = new Book(title, authorId, catID, image, price, description, quantity, views);
//            databaseHandler.insertData("book", bookToInsert, bookToInsert.getColumns());
        });

        //System.out.println(bookDetail.getElementsByTag("img").attr("href"));
    }

    public static int findAuthorByName(DatabaseHandler databaseHandler, String name) {
        int id = 0;
        String condition = "where name = \"" + name + "\"";
        ResultSet rs = databaseHandler.findAllByCondition("author", condition);
        try {
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public static void crawAuthor(DatabaseHandler databaseHandler) {
        Document document = getConnect("https://boabookstore.com/collections/all");
        Elements authors = document.getElementsByClass("aside-content filter-group");
        for (Element a : authors.get(1).getElementsByTag("input")) {
            String authorName = a.attr("data-text");
            Author author = new Author(authorName);
            databaseHandler.insertData("author", author, author.getColumns());
        }
    }

    public static Document getConnect(String url) {
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
