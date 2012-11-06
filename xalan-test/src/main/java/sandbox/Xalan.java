package sandbox;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Xalan {

	public void process(File xml, File xslt, File outFile) {
		OutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(outFile));
			
			// 1. Instantiate a TransformerFactory.
			TransformerFactory tFactory = TransformerFactory.newInstance();
			// 2. Use the TransformerFactory to process the stylesheet 
			// Source and generate a Transformer.
			Transformer transformer = tFactory.newTransformer(new StreamSource(xslt));
			// 3. Use the Transformer to transform an XML Source and send the
			// output to a Result object.
			transformer.transform(new StreamSource(xml), new StreamResult(out));
		} catch (TransformerConfigurationException e) {
			throw new IllegalStateException(e);
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		} catch (TransformerException e) {
			throw new IllegalStateException(e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// do nothing
				}
			}
		}
	}
}
