package sandbox;

import java.io.File;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class XalanTest {

	@Test
	public void test() {
		File testBase = new File("./src/test");
		File targetBase = new File("./target");
		
		File xml = new File(testBase, "xml/xml/hello.xml");
		File xslt = new File(testBase, "xml/xslt/hello.xslt");
		File outFile = new File(targetBase, "xalan");
		
		new Xalan().process(xml, xslt, outFile);
	}
}
