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
	
	static {
		loadConfiguration();
		loadOperators();
	}
    
    private static Map<String, SearchArea> areas;
    private static Map<String, Operator> operators;
    private static String queryTemplate;
    
    public static SearchArea getSearchArea(String searchAreaKey) {
        SearchArea area = areas.get(searchAreaKey);
        if (area == null) {
        	throw new IllegalArgumentException("unknown search area: " + searchAreaKey);
        }
        return area;
    }
    
    public static List<Field> getFields(String searchAreaKey) {
    	return getSearchArea(searchAreaKey).getFields();
    }
    
    public static Field getField(String searchAreaKey, String fieldKey) {
    	SearchArea area = getSearchArea(searchAreaKey);
    	
    	for (Field f : area.getFields()) {
    		if (f.getKey().equals(fieldKey)) {
    			return f; 
    		}
    	}
    	
    	throw new IllegalArgumentException("unknown field: " + fieldKey + " in search area " + searchAreaKey);
    }

    public static Operator getOperator(String operatorKey) {
        Operator op = operators.get(operatorKey);
        if (op == null) {
        	throw new IllegalArgumentException("unknown operator: " + operatorKey);
        }
        return op;
    }
    
    public static String getQueryTemplate() {
    	return queryTemplate;
    }
    
	private static void loadConfiguration() {
        areas = new HashMap<String, SearchArea>();
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(new File("doc/config.xml"));
			XPath xpath = XPathFactory.newInstance().newXPath();
			
			queryTemplate = xpath.evaluate("/search-config/main-query-template", document).trim();
			NodeList nodes = (NodeList) xpath.evaluate("/search-config/search-area", document, 
					XPathConstants.NODESET);
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				NamedNodeMap attribs = node.getAttributes();
				String table = attribs.getNamedItem("table").getTextContent();
				String alias = attribs.getNamedItem("alias").getTextContent();
				String key = attribs.getNamedItem("key").getTextContent();
				String selectColumns = xpath.evaluate("select-columns", node);
				String areaWhere = xpath.evaluate("area-where", node);
				
				List<Join> areaJoins = new ArrayList<Join>();
				NodeList areaJoinList = (NodeList) xpath.evaluate("area-join", node, XPathConstants.NODESET);
				for (int j = 0; j < areaJoinList.getLength(); j++) {
					Join join = new Join(areaJoinList.item(j).getTextContent());
					areaJoins.add(join);
				}
				
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
				
				SearchArea area = new SearchArea(key, table, alias, selectColumns, fields, areaJoins, areaWhere);
				//System.out.println(area);
				areas.put(area.getKey(), area);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void loadOperators() {
		
		operators = new HashMap<String, Operator>();
				
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
				
				operators.put(name, new Operator(name, Type.fromString(type), template));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
