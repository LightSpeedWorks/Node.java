package com.lightspeedworks.node.json;

import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * all tests. デフォルト・パッケージのTestSuite
 */
public class AllTests {

	/**
	 * main.
	 *
	 * @param args String...
	 */
	public static void main(String... args) {
		//TestRunner.run(JSONTest.class);
		TestRunner.run(suite());
	}

	/**
	 * suite.
	 *
	 * @return TestSuite
	 */
	public static TestSuite suite() {
		TestSuite suite = new TestSuite("Test for default package");
		suite.addTest(new TestSuite(JSONTest.class));
		return suite;
	}
}
