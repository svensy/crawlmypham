package jsoupdemo;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
public class GetDocumentFromURL {
 
   public static void main(String[] args) throws IOException {
       Document doc = Jsoup.connect("http://eclipse.org").get();
       String title = doc.title();
       System.out.println("Title : " + title);
   }
 
}
