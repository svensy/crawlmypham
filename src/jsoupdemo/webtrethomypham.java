package jsoupdemo;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class webtrethomypham {

	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("webtretho.txt", "UTF-8");
		String root_url = "http://www.webtretho.com/forum/f3268/index";
		for (int i=2 ; i<3 ; i++){
			String newurl = root_url + i + ".html?prefixid=2015_LamDep_Da_Mun";
			System.out.println(newurl);
			Document d = Jsoup.connect(newurl).get();
			for (Element element : d.select("a.title.threadtitle_unread")) {
				System.out.println(element.attr("href"));
				String href = element.attr("href");
				Document d2 = Jsoup.connect(href).get();
				String e2 = d2.select("blockquote.postcontent.restore").get(0).text();
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
