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
    
    private static Map<String, SearchArea> conf = loadFromXml();
    
    public static SearchArea getSearchArea(String searchAreaKey) {
        return conf.get(searchAreaKey);
    }
    
	private static Map<String, SearchArea> loadFromXml() {
        Map<String, SearchArea> res = new HashMap<String, SearchArea>();
		
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
				
				List<Field> fields = new ArrayList<Field>();
				NodeList fieldNodes = (NodeList) xpath.evaluate("fields/field", node, XPathConstants.NODESET);
				for (int j = 0; j < fieldNodes.getLength(); j++) {
					Node fieldNode = fieldNodes.item(j);
					
					attribs = fieldNode.getAttributes();
					String fieldKey = attribs.getNamedItem("key").getTextContent();
					
					List<Join> joins = new ArrayList<Join>();
					NodeList joinList = (NodeList) xpath.evaluate("join", fieldNode, XPathConstants.NODESET);

					for (int k = 0; k < joinList.getLength(); k++) {
						Join join = new Join(joinList.item(k).getTextContent());
						joins.add(join);
					}
					
					List<String> columns = new ArrayList<String>();
					NodeList columnList = (NodeList) xpath.evaluate("column", fieldNode, XPathConstants.NODESET);
					for (int k = 0; k < columnList.getLength(); k++) {
						columns.add(columnList.item(k).getTextContent());
					}
					
					fields.add(new Field(fieldKey, joins, columns));
				}
				
				SearchArea area = new SearchArea(key, table, alias, selectColumns, 
						fields, areaJoin, areaWhere);
				System.out.println(area);
				res.put(area.getKey(), area);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
        return res;

	}
}
