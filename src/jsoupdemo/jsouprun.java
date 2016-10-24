package jsoupdemo;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class jsouprun {

	public static void main(String[] args) throws IOException {
		String root_url = "http://www.webtretho.com/forum/f110/index";
		for (int i=1 ; i<157 ; i++){
			String newurl = root_url + i + ".html";
			Document d=Jsoup.connect(newurl).get();
			for (Element element : d.select("a.title")) {
				String href = element.attr("href");
				
				Document d2=Jsoup.connect(href).get();
				//System.out.println(href);
				//String title = element.text();
				//System.out.println(title);
			}
		}
	}

}
