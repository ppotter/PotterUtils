package com.potter.java.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlParser {
	private DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	private DocumentBuilder db = dbf.newDocumentBuilder();
	private Document doc;
	
	public XmlParser(File xmlFile) throws ParserConfigurationException, SAXException, IOException{
		doc = db.parse(xmlFile);
	}
	
	public XmlParser(String url) throws ParserConfigurationException, SAXException, IOException{
		UrlReader reader = new UrlReader();
		doc = db.parse(reader.getStreamFromUrl(url));
	}
	
	public String toString(){
		try{
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			String output = writer.getBuffer().toString();
			return output;
		}catch(TransformerException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getValueTagText(Element ele) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName("Value");
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}
	
	public static String getTextValue(Element ele) {
		return ele.getFirstChild().getNodeValue();
	}
	
	public static boolean hasChild(Element ele, String child){
		NodeList nl = ele.getElementsByTagName(child);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			return el!=null;
		}
		return false;
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		XmlParser xml = new XmlParser(new File("./files/xml/sample.xml"));
		System.out.println(xml.toString());
	}
}
