package com.os.sp.search;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OperatorStorage {
	
	public static void loadFromXml() {
				
		// parse the XML as a W3C Document
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(new File("doc/config.xml"));

			XPath xpath = XPathFactory.newInstance().newXPath();
			System.out.println(xpath.evaluate("/search-config/main-query-template", document).trim());
			System.out.println(xpath.evaluate("/search-config/search-area[1]/area-where", document));
			
			NodeList nodes = (NodeList) xpath.evaluate("/search-config/search-area", document, 
					XPathConstants.NODESET);
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				NamedNodeMap attribs = node.getAttributes();
				String table = attribs.getNamedItem("table").getTextContent();
				String alias = attribs.getNamedItem("alias").getTextContent();
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
