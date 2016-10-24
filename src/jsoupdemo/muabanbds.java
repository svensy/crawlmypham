package jsoupdemo;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class muabanbds {

	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("muabanbds.txt", "UTF-8");
		String root_url = "https://muaban.net/mua-ban-nha-dat-cho-thue-ha-noi-l24-c3?cp=";
		for (int i=1 ; i<41 ; i++){
			String newurl = root_url + i;
			Document d = Jsoup.connect(newurl).get();
			for (Element element : d.select("a.mbn-image")) {
				//System.out.println(element.attr("href"));
				String href = element.attr("href");
				Document d2 = Jsoup.connect(href).get();
				String e2 = d2.select("div.ct-body.overflow.clearfix").get(0).text();
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
