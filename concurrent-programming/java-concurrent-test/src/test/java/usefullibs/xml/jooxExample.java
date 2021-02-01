package usefullibs.xml;
import org.joox.Match;
import org.w3c.dom.Document;

import java.util.List;

import static org.joox.JOOX.*;
public class jooxExample {
    public static void main(String[] args) {
//        // Find the order at index 4 and add an element "paid"
//        $(document).find("orders").children().eq(4).append("<paid>true</paid>");
//
//// Find those orders that are paid and flag them as "settled"
//        $(document).find("orders").children().find("paid").after("<settled>true</settled>");
//
//// Add a complex element
//        $(document).find("orders").append(
//                $("order", $("date", "2011-08-14"),
//                        $("amount", "155"),
//                        $("paid", "false"),
//                        $("settled", "false")).attr("id", "13");
//
//        // Parse the document from a file
//        Document xmlFile;
//        Document document = $(xmlFile).document();
//
//// Wrap the document with the jOOX API
//        Match x1 = $(document);
//
//// This will get all books (wrapped <book/> DOM Elements)
//        Match x2 = $(document).find("book");
//
//// This will get all even or odd books
//        Match x3 = $(document).find("book").filter(even());
//        Match x4 = $(document).find("book").filter(odd());
//
//// This will get all book ID's
//        List<String> ids = $(document).find("book").ids();
//
//// This will get all books with ID = 1 or ID = 2
//        Match x5 = $(document).find("book").filter(ids(1, 2));
//
//// Or, use css-selector syntax:
//        Match x6 = $(document).find("book#1, book#2");
//
//// This will use XPath to find books with ID = 1 or ID = 2
//        Match x7 = $(document).xpath("//book[@id = 1 or @id = 2]");
//
//        // This will add a new book
//        $(document).find("books").append("<book id=\"5\"><name>Harry Potter</name></book>");
//
//// But so does this
//        $(document).find("book").filter(ids(5)).after("<book id=\"6\"/>");
//
//// This will remove book ID = 1
//        $(document).find("book").filter(ids(1)).remove();
//
//// Or this
//        $(document).find("book").remove(ids(1));
    }
}
