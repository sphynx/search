package com.os.sp.search;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SearchConfiguration {
    
    private static Map<String, SearchArea> conf = initConfiguration();
    
    private static Map<String, SearchArea> initConfiguration() {
        Map<String, SearchArea> res = new HashMap<String, SearchArea>();
        return res;
    }
    
    public static SearchArea getSearchArea(Integer searchArea) {
        return conf.get(searchArea);
    }
    
	public static void loadFromXml() {
		
		// parse the XML as a W3C Document
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(new File("doc/config.xml"));
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			NodeList nodes = (NodeList) xpath.evaluate("/search-config/search-area", document, 
					XPathConstants.NODESET);
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				NamedNodeMap attribs = node.getAttributes();
				String table = attribs.getNamedItem("table").getTextContent();
				String alias = attribs.getNamedItem("alias").getTextContent();
				String key = attribs.getNamedItem("key").getTextContent();
				String selectColumns = xpath.evaluate("select-columns", node);
				String areaJoin = xpath.evaluate("area-join", node);
				String areaWhere = xpath.evaluate("area-where", node);
				
				SearchArea area = new SearchArea(table, alias, selectColumns);
				System.out.println(area);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
