package jsoupdemo;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class jamchamerun {

	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("lamchame.txt", "UTF-8");
		String root_url = "https://www.lamchame.com/forum/forums/du-lich.170/page-";
		for (int i=1 ; i<2 ; i++){
			String newurl = root_url + i + "?prefix_id=13";
			Document d = Jsoup.connect(newurl).get();
			for (Element element : d.select("a.PreviewTooltip")) {
				System.out.println(element.attr("href"));
				String href = "https://www.lamchame.com/forum/" + element.attr("href");
				Document d2 = Jsoup.connect(href).get();
				String e2 = d2.select("blockquote.messageText.SelectQuoteContainer.ugc.baseHtml").get(0).text();
				writer.println(e2 + "\t");
				//writer.println();
				//System.out.println("----------------------------------");
				//System.out.println(e2);
				//Document d2=Jsoup.connect(href).get();
				//System.out.println(href);
				//String title = element.text();
				//System.out.println(title);
			}
			System.out.println(i);
		}
		writer.close();
		System.out.println("done");
	}

}
