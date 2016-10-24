package jsoupdemo;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class myphamvatgia {

	public static void main(String[] args) throws IOException {
		PrintWriter writer = new PrintWriter("myphamvatgia.txt", "UTF-8");
		String root_url = "http://www.vatgia.com/hoidap/4199/my-pham-lam-dep.html,";
		for (int i=1 ; i<2 ; i++){
			String newurl = root_url + i;
			//System.out.println(newurl);
			Document d = Jsoup.connect(newurl).get();
			String e1 = d.select("div.description").get(0).text();
			System.out.println(e1);
			for (Element element : d.select("a.tooltip")) {
				System.out.println(element.attr("href"));
				String href = "http://www.vatgia.com/" + element.attr("href");
				System.out.println(href);
				Document d2 = Jsoup.connect(href).get();
				String e2 = d2.select("div.detail_description").get(0).text();
				if (e2 != null) {writer.println(e2 + "\t");}
				//writer.println();
				//System.out.println("----------------------------------");
				System.out.println(e2);
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
