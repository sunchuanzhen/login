package cn.itcast.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtil {
	private static String  filepath = null;
	static{
		filepath = XmlUtil.class.getClassLoader().getResource("user.xml").getPath();
	}

	public static Document getDoc() throws DocumentException {

		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filepath));
		return document;

	}
	
	public static void write2xml(Document document) throws IOException
	{
		
		FileWriter out = new FileWriter(filepath);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter( out, format );
        writer.write( document );
		out.close();
		writer.close();
	}
	
}
