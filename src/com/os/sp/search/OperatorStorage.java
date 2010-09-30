package com.os.sp.search;

import java.io.File;
import java.util.HashMap;
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

public class OperatorStorage {
	
	private static Map<String, Operator> storage = loadFromXml();
    
    public static Operator getOperator(String name) {
        return storage.get(name);
    }
    
	public static Map<String, Operator> loadFromXml() {
		
		Map<String, Operator> res = new HashMap<String, Operator>();
				
		// parse the XML as a W3C Document
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(new File("doc/operators.xml"));

			XPath xpath = XPathFactory.newInstance().newXPath();
			NodeList nodes = (NodeList) xpath.evaluate("/operators/operator", document, 
					XPathConstants.NODESET);
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				NamedNodeMap attribs = node.getAttributes();
				String name = attribs.getNamedItem("name").getTextContent();
				String type = xpath.evaluate("type", node);
				String template = xpath.evaluate("template", node);
				
				Operator op = new Operator(name, Type.fromString(type), template);
				res.put(name, op);
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return res;
	}
}
