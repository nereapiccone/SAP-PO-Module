package org.json;

import org.json.JSONObject;
import java.util.List;
import java.util.ArrayList;

public class JsonConversor {

	static String text1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
	static String text2 = "\"<ns0:xxxxxxx xmlns:ns0=\\\"xxxxxxx\\\">\\n\"";
	static String text3 = "  <nro_oc>2000</nro_oc>\n";
	static String text4 = "  <proveedor>4100</proveedor>\n";
	static String text5 = "</ns0:xxxxxxx> ";;

	public static void main(String[] args) throws JSONException {

		List<String> xml = new ArrayList<String>();
		List<String> tags = new ArrayList<String>();

		tags.add("nro_oc");
		tags.add("proveedor");

		xml.add(text1);
		xml.add(text2);
		xml.add(text3);
		xml.add(text4);
		xml.add(text5);		
		
		JSONObject obj = new JSONObject();
		for (String tag : tags) {
			for (String line : xml) {
				if (line.contains(tag)) {
					String result = line.split("<" + tag + ">")[1].split("</" + tag + ">")[0];
					obj.put(tag, result);
					
				}
			}
		}
		System.out.print(obj);
	}
}
