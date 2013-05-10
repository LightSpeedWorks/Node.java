package com.lightspeedworks.node.json;

import java.io.File;

/**
 * JSON class test. {JSONクラスのテスト}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class JSONWorkMainCopy {

	/**
	 * main. メイン・メソッド
	 *
	 * @param args String...
	 */
	public static void main(String... args) {
		String path = new File(new File("").getAbsolutePath()).getName();
		//if ("bin".equals(path))
		System.out.println(path);
		JSON obj, obj2, arr;
		String str = "";

		arr = JSON.createArray();
		System.out.print("typeof arr  = " + arr.typeof());
		System.out.print("\t valueOf arr  = " + arr.valueOf());
		System.out.print("\t " + arr.toString());
		System.out.println("\t " + arr.stringify());
		System.out.println(arr.toIniFile());
		arr.push(JSON.createNumber(1));
		arr.put(1, JSON.createString("b\tb"));
		arr.push(JSON.createNumber(3));
		arr.put(5, JSON.createString("e\\e"));
		arr.put(7, JSON.createNull());

		System.out.print("arr");
		for (int i = 0, n = arr.length(); i < n; ++i) {
			JSON val = arr.get(i);
			if (val == null)
				System.out.print("  \t[" + i + "] = null");
			else
				System.out.print("  \t[" + i + "] = " + val.stringify());
		}
		System.out.println();

		System.out.print("typeof arr  = " + arr.typeof());
		System.out.print("\t valueOf arr  = " + arr.valueOf());
		System.out.print("\t " + arr.toString());
		System.out.println("\t " + arr.stringify());
		System.out.println(arr.toIniFile());

		obj = JSON.createObject();
		System.out.print("typeof obj  = " + obj.typeof());
		System.out.println("\t valueOf obj  = " + obj.valueOf());
		System.out.println(obj.toIniFile());
		obj.put("1", JSON.createString("one"));
		obj.put(2, JSON.createString("two"));
		obj.put(3, JSON.createNumber(3));
		obj.put("x", JSON.createString("xx"));
		obj.put("y", JSON.createString("yy"));
		System.out.print("typeof obj  = " + obj.typeof());
		System.out.print("\t valueOf obj  = " + obj.valueOf());
		System.out.println("\t " + obj.toString());
		System.out.println(obj.stringify());
		System.out.println(obj.toIniFile());
		System.out.println();

		obj2 = JSON.createObject();
		obj2.put("1", JSON.createString("one"));
		obj2.put(2, JSON.createString("two"));
		obj2.put(3, JSON.createNumber(3));
		obj2.put("arr", arr);
		obj2.put("obj", obj);
		System.out.print("typeof obj2 = " + obj2.typeof());
		System.out.println("\t valueOf obj2 = " + obj2.toString());
		System.out.println("\t " + obj2.toString());
		System.out.println(obj2.stringify());
		System.out.println(obj2.toIniFile());
		System.out.println();

		// ####################
		// #### parse test ####
		// ####################

		try {
			str = " null ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " true ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " false ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " true x ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " falsey ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " tlue ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " -123 ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " -123.4 ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " -1.234e-2 ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " \"abc\\txyz\\u0041BC\\n\" ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " [ ] ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\t " + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = "[1,\"2\",3.45,null,true,false,[],[1,2]]";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " [ 1 , \"2\" , 3.45 , null , true , false , [ ] , [ 1 , 2 ] ] ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " [ 1 , \"2\" , 3.45 , null , true , false , [ ] , [ 111, 222, 333, 444, 555, 666, 777, 888, 999 ], [ 111, 222, [ 111, 222, 333, 444, 555, 666, 777, 888, 999 ], 444, 555 ] ] ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}

		System.out.print("\nkeys:");
		for (JSON e : obj.keys())
			System.out.print(" " + e);
		System.out.println("\n");

		for (JSON e : obj) {
			System.out.println("\"" + e.key() + "\": (" + e.typeof() + ") \t"
					+ e.stringify());
		}

		try {
			str = "{\"x\":1,\"y\":2.3,\"z\":\"zz\",\"arr\":[],\"obj\":{}}";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = "{\"x\":1,\"y\":2.3,\"z\":\"zz\",\"a\":true,\"b\":false,\"c\":null,\"arr\":[],\"obj\":{}}";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " { \"x\" : 1 , \"y\" : 2.3 , \"z\" : \"zz\" , \"a\" : true , \"b\" : false , \"c\" : null , \"arr\" : [ ] , \"obj\" : { } } ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
		try {
			str = " { \"x\" : 1 , \"y\" : 2.3 , \"z\" : \"zz\" , \"a\" : true , \"b\" : false , \"c\" : null , \"arr\" : [ 111, 222, 333, 444, [ 111, 222, 333, 444, 555, 666, 777, 888, 999 ], 666, 777, 888, 999 ] , \"obj\" : { \"a\": 111, \"b\": 222, \"c\": 333, \"obj\": { \"a\": 111, \"b\": 222, \"c\": 333, \"d\": 444, \"e\": 555 }, \"d\": 444, \"e\": 555 } } ";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}

		// ###################################################

		System.out.print("\nkeys:");
		for (JSON e : obj.keys())
			System.out.print(" " + e);
		System.out.println("\n");

		for (JSON e : obj) {
			System.out.println("\"" + e.key() + "\": (" + e.typeof() + ") \t"
					+ e.stringify());
		}

		try {
			str = "{\n" + "  \"messageID\": \"mmm\",                \n"
					+ "  \"fromDeviceID\": \"fff\",               \n"
					+ "  \"toCityCode\": \"ttt\",                 \n"
					+ "  \"apCode\": \"aaa\",                     \n"
					+ "  \"dataFormat\": \"ddd\",                 \n"
					+ "  \"compressType\": \"ccc\",               \n"
					+ "  \"status\": \"sss\",                     \n"
					+ "  \"errorCode\": \"eee\",                  \n"
					+ "  \"serialNumber\": \"nnn\",               \n"
					+ "  \"riyosyaID\": \"rrr\",                  \n"
					+ "  \"transCount\": 123                      \n" + "}";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}

		// ###################################################

		System.out.print("\nkeys:");
		for (JSON e : obj.keys())
			System.out.print(" " + e);
		System.out.println("\n");

		for (JSON e : obj) {
			System.out.println("\"" + e.key() + "\": (" + e.typeof() + ") \t"
					+ e.stringify());
		}

		System.out.println("riyosyaID=" + obj.get("riyosyaID"));

		obj2 = JSON.createObject();
		obj2.put("messageID", "メッセージID");
		obj2.put("fromDeviceID", "発送元装置ID");
		obj2.put("toCityCode", "発送先自治体コード");
		obj2.put("apCode", "APコード");
		obj2.put("dataFormat", "データ形式");
		obj2.put("compressType", "圧縮タイプ");
		obj2.put("status", "状態");
		obj2.put("errorCode", "エラーコード");
		obj2.put("serialNumber", "シリアル番号");
		obj2.put("riyosyaID", "利用者ID");
		obj2.put("transCount", 12345);

		System.out.print("typeof obj2 = " + obj2.typeof());
		System.out.println("\t valueOf obj2 = " + obj2.toString());
		System.out.println("\t " + obj2.toString());
		System.out.println(obj2.stringify());
		System.out.println(obj2.toIniFile());
		System.out.println();

		try {
			str = "{\"header\":{\"msg\":\"str\"},\"data\":{\"xml\":\"<>\",\"pdf\":\"\"}}";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}

		try {
			str = "{\"header\":{\"msg\":\"str\"},\"data\":{\"xml\":\"<>\",\"pdf\":\"\"},\"num\":123}";
			obj = JSON.parse(str);
			System.out.println("\n!!! " + str + " !!!\n" + obj.typeof() + " \t"
					+ obj.stringify());
			System.out.println(obj.toIniFile());
		} catch (Exception e) {
			System.out.print("\n### " + str + " ###\t");
			e.printStackTrace(System.out);
			System.out.println();
		}
	}
}
