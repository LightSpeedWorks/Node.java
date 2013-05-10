package com.lightspeedworks.node.json;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Kauzaki
 */
public class JSONTest extends TestCase {
	/**
	 * new line.
	 */
	static final String NL = JSON.LINE_SEPARATOR;
	/**
	 * double quote.
	 */
	static final String DQ = "\"";

	/**
	 * JSONTest. TestCaseを継承したJSONのテストケース
	 *
	 * @param arg0 String
	 */
	public JSONTest(String arg0) {
		super(arg0);
		//System.out.println("*** JSONTest: " + arg0 + " ***");
	}

	/**
	 * fail if not exception occured. {例外が発生しないなら失敗}
	 */
	private void failNoException() {
		fail("Exceptionが発生するので、ここは通らない");
	}

	/**
	 * @throws java.lang.Exception {例外}
	 */
	@Before
	public void setUp() throws Exception {
		//System.out.println("setUp");
		JSON.setIndentString("  ");
		JSON.setWidthForIndent(40);
	}

	/**
	 * @throws java.lang.Exception {例外}
	 */
	@After
	public void tearDown() throws Exception {
		//System.out.println("tearDown");
	}

	/**
	 * NUMBER.
	 */
	static final String NUM = "NUMBER";

	/**
	 * number test.
	 */
	@Test
	public void test0010Number123int() {
		JSON obj = null;
		int num = 123;
		String expStr = "123";

		obj = JSON.createNumber(num);
		assertNotNull(obj);

		if (!NUM.equals(obj.typeof().toString()))
			System.out.print(num + ":\ttypeof = " + obj.typeof());
		assertEquals(NUM, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(num, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + NUM + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * number test.
	 */
	@Test
	public void test0020Number123double() {
		JSON obj = null;
		double num = 1.23;
		String expStr = "1.23";

		obj = JSON.createNumber(num);
		assertNotNull(obj);

		if (!NUM.equals(obj.typeof().toString()))
			System.out.print(num + ":\ttypeof = " + obj.typeof());
		assertEquals(NUM, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(num, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + NUM + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * number test.
	 */
	@Test
	public void test0030Number123intStr() {
		JSON obj = null;
		int num = 123;
		String srcStr = " 123 ";
		String expStr = "123";

		try {
			obj = JSON.createNumber(srcStr);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		assertNotNull(obj);

		if (!NUM.equals(obj.typeof().toString()))
			System.out.print(srcStr + ":\ttypeof = " + obj.typeof());
		assertEquals(NUM, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(num, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + NUM + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * number test.
	 */
	@Test
	public void test0040Number123doubleStr() {
		JSON obj = null;
		double num = 1.23;
		String srcStr = " 1.23 ";
		String expStr = "1.23";

		try {
			obj = JSON.createNumber(srcStr);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		assertNotNull(obj);

		if (!NUM.equals(obj.typeof().toString()))
			System.out.print(srcStr + ":\ttypeof = " + obj.typeof());
		assertEquals(NUM, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(num, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + NUM + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * number test.
	 */
	@Test
	public void test0050Number123xintStr() {
		JSON obj = null;
		String srcStr = " 123x ";

		try {
			obj = JSON.createNumber(srcStr);
			failNoException();
		} catch (Exception e) {
			//e.printStackTrace(System.err);
			//System.out.println(e.getMessage());
			assertNotSame("", e.getMessage());
		}

		assertNull(obj);
	}

	/**
	 * number test.
	 */
	@Test
	public void test0060Number123xdoubleStr() {
		JSON obj = null;
		String srcStr = " 1.23x ";

		try {
			obj = JSON.createNumber(srcStr);
			fail("Exceptionが発生するので、ここは通らない");
		} catch (Exception e) {
			//e.printStackTrace(System.err);
			//System.out.println(e.getMessage());
			assertNotSame("", e.getMessage());
		}

		assertNull(obj);
	}

	/**
	 * BOOLEAN.
	 */
	static final String BOOL = "BOOLEAN";

	/**
	 * boolean test.
	 */
	@Test
	public void test0110BooleanTrue() {
		JSON obj = null;
		boolean bool = true;
		String expStr = "true";

		obj = JSON.createBoolean(bool);
		assertNotNull(obj);

		if (!BOOL.equals(obj.typeof().toString()))
			System.out.print(bool + ":\ttypeof = " + obj.typeof());
		assertEquals(BOOL, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(bool, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + BOOL + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * boolean test.
	 */
	@Test
	public void test0120BooleanFalse() {
		JSON obj = null;
		boolean bool = false;
		String expStr = "false";

		obj = JSON.createBoolean(bool);
		assertNotNull(obj);

		if (!BOOL.equals(obj.typeof().toString()))
			System.out.print(bool + ":\ttypeof = " + obj.typeof());
		assertEquals(BOOL, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(bool, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + BOOL + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * boolean test.
	 */
	@Test
	public void test0130BooleanTrueStr() {
		JSON obj = null;
		boolean bool = true;
		String srcStr = " true ";
		String expStr = "true";

		try {
			obj = JSON.createBoolean(srcStr);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		assertNotNull(obj);

		if (!BOOL.equals(obj.typeof().toString()))
			System.out.print(srcStr + ":\ttypeof = " + obj.typeof());
		assertEquals(BOOL, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(bool, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + BOOL + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * boolean test.
	 */
	@Test
	public void test0140BooleanFalseStr() {
		JSON obj = null;
		boolean bool = false;
		String srcStr = " false ";
		String expStr = "false";

		try {
			obj = JSON.createBoolean(srcStr);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		assertNotNull(obj);

		if (!BOOL.equals(obj.typeof().toString()))
			System.out.print(srcStr + ":\ttypeof = " + obj.typeof());
		assertEquals(BOOL, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(bool, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + BOOL + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * boolean test.
	 */
	@Test
	public void test0150BooleanTruexStr() {
		JSON obj = null;
		String srcStr = " truex ";

		try {
			obj = JSON.createBoolean(srcStr);
			failNoException();
		} catch (Exception e) {
			//e.printStackTrace(System.err);
			//System.out.println(e.getMessage());
			assertNotSame("", e.getMessage());
		}

		assertNull(obj);
	}

	/**
	 * boolean test.
	 */
	@Test
	public void test0160BooleanFalseyStr() {
		JSON obj = null;
		String srcStr = " falsey ";

		try {
			obj = JSON.createBoolean(srcStr);
			failNoException();
		} catch (Exception e) {
			//e.printStackTrace(System.err);
			//System.out.println(e.getMessage());
			assertNotSame("", e.getMessage());
		}

		assertNull(obj);
	}

	/**
	 * STRING.
	 */
	static final String STR = "STRING";

	/**
	 * string test.
	 */
	@Test
	public void test0210StringNormal() {
		JSON obj = null;
		String srcStr = " string ";
		String expStr = " string ";
		String quoStr = "\" string \"";

		obj = JSON.createString(srcStr);
		assertNotNull(obj);

		if (!STR.equals(obj.typeof().toString()))
			System.out.print(srcStr + ":\ttypeof = " + obj.typeof());
		assertEquals(STR, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(expStr, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(quoStr, obj.stringify());
		assertEquals(quoStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + STR + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * string test.
	 */
	@Test
	public void test0220StringQuote() {
		JSON obj = null;
		String srcStr = " str\"ing ";
		String expStr = " str\"ing ";
		String quoStr = "\" str\\\"ing \"";

		obj = JSON.createString(srcStr);
		assertNotNull(obj);

		if (!STR.equals(obj.typeof().toString()))
			System.out.print(srcStr + ":\ttypeof = " + obj.typeof());
		assertEquals(STR, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(expStr, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(quoStr, obj.stringify());
		assertEquals(quoStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + STR + "]" + NL + "value=" + quoStr + NL, obj.toIniFile());
	}

	/**
	 * NULL.
	 */
	static final String NULL = "NULL";

	/**
	 * null test.
	 */
	@Test
	public void test0310Null() {
		JSON obj = null;
		String expStr = "null";

		obj = JSON.createNull();
		assertNotNull(obj);

		if (!NULL.equals(obj.typeof().toString()))
			System.out.print(null + ":\ttypeof = " + obj.typeof());
		assertEquals(NULL, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(null, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + NULL + "]" + NL + "value=" + expStr + NL, obj.toIniFile());
	}

	/**
	 * ARRAY.
	 */
	static final String ARR = "ARRAY";

	/**
	 * array test.
	 */
	@Test
	public void test0410ArrayZero() {
		JSON obj = null;
		String expStr = "[]";

		obj = JSON.createArray();
		assertNotNull(obj);

		if (!ARR.equals(obj.typeof().toString()))
			System.out.print("arr:\ttypeof = " + obj.typeof());
		assertEquals(ARR, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(obj, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + ARR + "]" + NL, obj.toIniFile());
	}

	/**
	 * array test.
	 */
	@Test
	public void test0420ArrayIndent() {
		JSON obj = null;
		String expStr = "[123,1.23,true,false,,str,abc\\xyz,null,[],{}]";
		String quoStr = "[" + NL
				+ "  123," + NL
				+ "  1.23," + NL
				+ "  true," + NL
				+ "  false," + NL
				+ "  null," + NL
				+ "  \"str\"," + NL
				+ "  \"abc\\\\xyz\"," + NL
				+ "  null," + NL
				+ "  []," + NL
				+ "  {}" + NL
				+ "]";
		String iniStr = "[ARRAY]" + NL
				+ "0=123" + NL
				+ "1=1.23" + NL
				+ "2=true" + NL
				+ "3=false" + NL
				+ "5=str" + NL
				+ "6=\"abc\\\\xyz\"" + NL
				+ "7=null" + NL
				+ "[8]" + NL
				+ "[9]" + NL;

		obj = JSON.createArray();
		assertNotNull(obj);

		obj.push(JSON.createNumber(123));
		obj.put(1, JSON.createNumber(1.23));
		obj.push(JSON.createBoolean(true));
		obj.push(JSON.createBoolean(false));
		obj.put(5, JSON.createString("str"));
		obj.push(JSON.createString("abc\\xyz"));
		obj.push(JSON.createNull());
		obj.push(JSON.createArray());
		obj.push(JSON.createObject());

		if (!ARR.equals(obj.typeof().toString()))
			System.out.print("arr:\ttypeof = " + obj.typeof());
		assertEquals(ARR, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(obj, obj.valueOf());

		//System.out.println("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		if (!quoStr.equals(obj.stringify())) {
			System.out.println("WidthForIndent: " + JSON.getWidthForIndent());
			System.out.println("\t " + quoStr);
			System.out.println("\t " + obj.stringify());
		}
		assertEquals(quoStr, obj.stringify());
		assertEquals(quoStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals(iniStr, obj.toIniFile());
	}

	/**
	 * array test.
	 */
	@Test
	public void test0430ArrayNoIndent() {
		JSON obj = null;
		String expStr = "[123,1.23,true,false,,str,abc\\xyz,null,[],{}]";
		String quoStr = "[123, 1.23, true, false, null, \"str\", \"abc\\\\xyz\", null, [], {}]";
		String iniStr = "[ARRAY]" + NL
				+ "0=123" + NL
				+ "1=1.23" + NL
				+ "2=true" + NL
				+ "3=false" + NL
				+ "5=str" + NL
				+ "6=\"abc\\\\xyz\"" + NL
				+ "7=null" + NL
				+ "[8]" + NL
				+ "[9]" + NL;

		JSON.setWidthForIndent(-1); // do not indent

		obj = JSON.createArray();
		assertNotNull(obj);

		obj.push(JSON.createNumber(123));
		obj.put(1, JSON.createNumber(1.23));
		obj.push(JSON.createBoolean(true));
		obj.push(JSON.createBoolean(false));
		obj.put(5, JSON.createString("str"));
		obj.push(JSON.createString("abc\\xyz"));
		obj.push(JSON.createNull());
		obj.push(JSON.createArray());
		obj.push(JSON.createObject());

		if (!ARR.equals(obj.typeof().toString()))
			System.out.print("arr:\ttypeof = " + obj.typeof());
		assertEquals(ARR, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(obj, obj.valueOf());

		//System.out.println("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + quoStr);
		//System.out.println("\t " + obj.stringify());
		assertEquals(quoStr, obj.stringify());
		assertEquals(quoStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals(iniStr, obj.toIniFile());
	}

	/**
	 * array test.
	 */
	@Test
	public void test0440Array() {
		JSON obj = null;
		String expStr = "[123, \"123\"]";
		String expStr2 = "[" + NL + "  123," + NL + "  \"123\"" + NL + "]";

		obj = JSON.createArray();
		assertNotNull(obj);

		obj.push(123);
		obj.push("123");

		JSON.setWidthForIndent(expStr.length());
		//System.out.println("WidthForIndent: " + JSON.getWidthForIndent());
		//System.out.println(obj.stringify());
		assertEquals(expStr, obj.stringify());

		JSON.setWidthForIndent(expStr.length() - 1);
		//System.out.println("WidthForIndent: " + JSON.getWidthForIndent());
		//System.out.println(obj.stringify());
		assertEquals(expStr2, obj.stringify());
		assertNotSame(expStr, obj.stringify());
	}

	/**
	 * OBJECT.
	 */
	static final String OBJ = "OBJECT";

	/**
	 * object test.
	 */
	@Test
	public void test0510ObjectZero() {
		JSON obj = null;
		String expStr = "{}";

		obj = JSON.createObject();
		assertNotNull(obj);

		if (!OBJ.equals(obj.typeof().toString()))
			System.out.print("obj:\ttypeof = " + obj.typeof());
		assertEquals(OBJ, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(obj, obj.valueOf());

		//System.out.print("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println(quoStr);
		//System.out.println("\t " + obj.stringify());
		assertEquals(expStr, obj.stringify());
		assertEquals(expStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println(iniStr);
		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals("[" + OBJ + "]" + NL, obj.toIniFile());
	}

	/**
	 * object test.
	 */
	@Test
	public void test0520ObjectIndent() {
		JSON obj = null;
		String expStr = "{a:123,b:1.23,c:true,d:false,5:str,6:abc\\xyz,e:null,f:[],g:{}}";
		String quoStr = "{" + NL
				+ "  \"a\": 123," + NL
				+ "  \"b\": 1.23," + NL
				+ "  \"c\": true," + NL
				+ "  \"d\": false," + NL
				+ "  \"5\": \"str\"," + NL
				+ "  \"6\": \"abc\\\\xyz\"," + NL
				+ "  \"e\": null," + NL
				+ "  \"f\": []," + NL
				+ "  \"g\": {}" + NL
				+ "}";
		String iniStr = "[OBJECT]" + NL
				+ "a=123" + NL
				+ "b=1.23" + NL
				+ "c=true" + NL
				+ "d=false" + NL
				+ "5=str" + NL
				+ "6=\"abc\\\\xyz\"" + NL
				+ "e=null" + NL
				+ "[f]" + NL
				+ "[g]" + NL;

		obj = JSON.createObject();
		assertNotNull(obj);

		obj.put("a", JSON.createNumber(123));
		obj.put("b", JSON.createNumber(1.23));
		obj.put("c", JSON.createBoolean(true));
		obj.put("d", JSON.createBoolean(false));
		obj.put(5, JSON.createString("str"));
		obj.put(6, JSON.createString("abc\\xyz"));
		obj.put("e", JSON.createNull());
		obj.put("f", JSON.createArray());
		obj.put("g", JSON.createObject());

		if (!OBJ.equals(obj.typeof().toString()))
			System.out.print("obj:\ttypeof = " + obj.typeof());
		assertEquals(OBJ, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(obj, obj.valueOf());

		//System.out.println("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + quoStr);
		//System.out.println("\t " + obj.stringify());
		assertEquals(quoStr, obj.stringify());
		assertEquals(quoStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println(iniStr);
		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals(iniStr, obj.toIniFile());
	}

	/**
	 * object test.
	 */
	@Test
	public void test0530ObjectNoIndent() {
		JSON obj = null;
		String expStr = "{a:123,b:1.23,c:true,d:false,5:str,6:abc\\xyz,e:null,f:[],g:{}}";
		String quoStr = "{\"a\": 123, \"b\": 1.23, \"c\": true, \"d\": false, "
				+ "\"5\": \"str\", \"6\": \"abc\\\\xyz\", \"e\": null, "
				+ "\"f\": [], \"g\": {}}";
		String iniStr = "[OBJECT]" + NL
				+ "a=123" + NL
				+ "b=1.23" + NL
				+ "c=true" + NL
				+ "d=false" + NL
				+ "5=str" + NL
				+ "6=\"abc\\\\xyz\"" + NL
				+ "e=null" + NL
				+ "[f]" + NL
				+ "[g]" + NL;

		JSON.setWidthForIndent(-1); // do not indent

		obj = JSON.createObject();
		assertNotNull(obj);

		obj.put("a", JSON.createNumber(123));
		obj.put("b", JSON.createNumber(1.23));
		obj.put("c", JSON.createBoolean(true));
		obj.put("d", JSON.createBoolean(false));
		obj.put(5, JSON.createString("str"));
		obj.put(6, JSON.createString("abc\\xyz"));
		obj.put("e", JSON.createNull());
		obj.put("f", JSON.createArray());
		obj.put("g", JSON.createObject());

		if (!OBJ.equals(obj.typeof().toString()))
			System.out.print("obj:\ttypeof = " + obj.typeof());
		assertEquals(OBJ, obj.typeof().toString());

		//System.out.print("\t valueOf = " + obj.valueOf());
		assertEquals(obj, obj.valueOf());

		//System.out.println("\t " + obj.toString());
		assertEquals(expStr, obj.toString());

		//System.out.println("\t " + quoStr);
		//System.out.println("\t " + obj.stringify());
		assertEquals(quoStr, obj.stringify());
		assertEquals(quoStr, JSON.stringify(obj));
		try {
			assertEquals(obj.stringify(), JSON.parse(obj.stringify()).stringify());
		} catch (Exception e) {
			e.printStackTrace(System.err);
			fail(e.getMessage());
		}

		//System.out.println(iniStr);
		//System.out.println("====<ini>====" + NL + obj.toIniFile() + "=============");
		assertEquals(iniStr, obj.toIniFile());

		JSON.setWidthForIndent(40);
	}

	/**
	 * object test.
	 */
	@Test
	public void test0540Object() {
		JSON obj = null;
		String expStr = "{\"x\": 123, \"y\": \"123\"}";
		String expStr2 = "{" + NL + "  \"x\": 123," + NL + "  \"y\": \"123\"" + NL + "}";

		obj = JSON.createObject();
		assertNotNull(obj);

		obj.put("x", 123);
		obj.put("y", "123");

		JSON.setWidthForIndent(expStr.length());
		if (!expStr.equals(obj.stringify())) {
			System.out.println("WidthForIndent: " + JSON.getWidthForIndent());
			System.out.println(expStr);
			System.out.println(obj.stringify());
		}
		assertEquals(expStr, obj.stringify());
		assertNotSame(expStr2, obj.stringify());

		JSON.setWidthForIndent(expStr.length() - 1);
		if (!expStr2.equals(obj.stringify())) {
			System.out.println("WidthForIndent: " + JSON.getWidthForIndent());
			System.out.println(expStr2);
			System.out.println(obj.stringify());
		}
		assertEquals(expStr2, obj.stringify());
		assertNotSame(expStr, obj.stringify());
	}
}
