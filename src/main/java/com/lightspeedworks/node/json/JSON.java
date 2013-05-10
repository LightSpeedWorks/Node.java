package com.lightspeedworks.node.json;

import java.util.Iterator;

/**
 * JSON class. {JSONクラス}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public abstract class JSON implements Iterable<JSON> {
	/**
	 * creates a JSON object. {JSONオブジェクトを作成}
	 *
	 * @return JSON object {JSONオブジェクト}
	 */
	public static final JSON create() {
		return new JSONObject();
	}

	/**
	 * creates a JSON number/integer object. {JSON整数オブジェクトを作成}
	 *
	 * @param intVal
	 *            integer value {整数値}
	 * @return JSON number/integer object {JSON整数オブジェクト}
	 */
	public static final JSON create(int intVal) {
		return new JSONInteger(intVal);
	}

	/**
	 * creates a JSON number/double object. {JSON実数オブジェクトを作成}
	 *
	 * @param doubleVal
	 *            double value {実数値}
	 * @return JSON number/double object {JSON実数オブジェクト}
	 */
	public static final JSON create(double doubleVal) {
		return new JSONDouble(doubleVal);
	}

	/**
	 * creates a JSON boolean object. {JSONブーリアン・オブジェクトを作成}
	 *
	 * @param boolVal
	 *            boolean value {ブーリアン値}
	 * @return JSON boolean object {JSONブーリアン・オブジェクト}
	 */
	public static final JSON create(boolean boolVal) {
		return new JSONBoolean(boolVal);
	}

	/**
	 * creates a JSON string object. {JSON文字列オブジェクトを作成}
	 *
	 * @param strVal
	 *            string value {文字列値}
	 * @return JSON string object {JSON文字列オブジェクト}
	 */
	public static final JSON create(String strVal) {
		return new JSONString(strVal);
	}

	/**
	 * creates a JSON array object. {JSON配列オブジェクトを作成}
	 *
	 * @param objVals
	 *            Object... {オブジェクト...}
	 * @return JSON array object {JSON配列オブジェクト}
	 */
	public static final JSON create(Object... objVals) {
		JSON obj = new JSONArray();
		for (Object e : objVals) {
			if (e == null)
				obj.push(createNull());
			else if (e.getClass().equals(Integer.class))
				obj.push(create((Integer) e));
			else if (e.getClass().equals(Double.class))
				obj.push(create((Double) e));
			else if (e.getClass().equals(Boolean.class))
				obj.push(create((Boolean) e));
			else if (e.getClass().equals(String.class))
				obj.push(create((String) e));
			else if (e.getClass().equals(JSON.class))
				obj.push((JSON) e);
			else if (e.getClass().equals(JSONType.class)) {
				switch ((JSONType) e) {
				case NULL:
					obj.push(createNull());
					break;
				case OBJECT:
					obj.push(createObject());
					break;
				case ARRAY:
					obj.push(createArray());
					break;
				case NUMBER:
					obj.push(createNumber(0));
					break;
				case STRING:
					obj.push(createString(""));
					break;
				case BOOLEAN:
					obj.push(createBoolean(false));
					break;
				default:
					obj.push(e.toString());
					break;
				}
			} else {
				obj.push(createObject().put(e.getClass().getName(), e.toString()));
			}
		}
		return obj;
	}

	/**
	 * creates a JSON array object. {JSON配列オブジェクトを作成}
	 *
	 * @param intVals
	 *            int... {整数...}
	 * @return JSON array object {JSON配列オブジェクト}
	 */
	public static final JSON create(int[] intVals) {
		JSON obj = new JSONArray();
		for (int e : intVals)
			obj.push(e);
		return obj;
	}

	/**
	 * creates a JSON array object. {JSON配列オブジェクトを作成}
	 *
	 * @param doubleVals
	 *            double... {実数...}
	 * @return JSON array object {JSON配列オブジェクト}
	 */
	public static final JSON create(double[] doubleVals) {
		JSON obj = new JSONArray();
		for (double e : doubleVals)
			obj.push(e);
		return obj;
	}

	/**
	 * creates a JSON array object. {JSON配列オブジェクトを作成}
	 *
	 * @param boolVals
	 *            boolean... {ブーリアン...}
	 * @return JSON array object {JSON配列オブジェクト}
	 */
	public static final JSON create(boolean[] boolVals) {
		JSON obj = new JSONArray();
		for (boolean e : boolVals)
			obj.push(e);
		return obj;
	}

	/**
	 * creates a JSON array object. {JSON配列オブジェクトを作成}
	 *
	 * @param strVals
	 *            string... {文字列...}
	 * @return JSON array object {JSON配列オブジェクト}
	 */
	public static final JSON create(String[] strVals) {
		JSON obj = new JSONArray();
		for (String e : strVals) {
			if (e == null)
				obj.push(createNull());
			else
				obj.push(e);
		}
		return obj;
	}

	/**
	 * creates a JSON array object. {JSON配列オブジェクトを作成}
	 *
	 * @param objVals
	 *            JSON... {JSONオブジェクト...}
	 * @return JSON array object {JSON配列オブジェクト}
	 */
	public static final JSON create(JSON[] objVals) {
		JSON obj = new JSONArray();
		for (JSON e : objVals) {
			if (e == null)
				obj.push(createNull());
			else
				obj.push(((JSONKeyValue) e).valueJSON());
		}
		return obj;
	}

	/**
	 * creates a JSON number object from integer value. {JSON整数オブジェクトを作成(整数値より)}
	 *
	 * @param intVal
	 *            integer value {整数値}
	 * @return JSON number/int object {JSON整数オブジェクト}
	 */
	public static final JSON createNumber(int intVal) {
		return new JSONInteger(intVal);
	}

	/**
	 * creates a JSON number object from double value. {JSON実数オブジェクトを作成(実数値より)}
	 *
	 * @param doubleVal
	 *            double value {実数値}
	 * @return JSON number/double object {JSON実数オブジェクト}
	 */
	public static final JSON createNumber(double doubleVal) {
		return new JSONDouble(doubleVal);
	}

	/**
	 * creates a JSON number object from string value. {JSON数値オブジェクトを作成(文字列値より)}
	 *
	 * @param strVal
	 *            string value {文字列値}
	 * @return JSON number object {JSON数値オブジェクト}
	 * @throws Exception
	 *             NumberFormatException number format exception {数値形式例外}
	 */
	public static final JSON createNumber(String strVal) throws Exception {
		strVal = strVal.trim();
		try {
			return createNumber(Integer.parseInt(strVal));
		} catch (Exception e) {
			// e.printStackTrace(System.err);
			try {
				return createNumber(Double.parseDouble(strVal));
			} catch (Exception e2) {
				// e2.printStackTrace(System.err);
				String msg = e2.getMessage();

				throw new NumberFormatException("createNumber: Unexpected number string: " + msg);
			}
		}
	}

	/**
	 * creates a JSON boolean object from boolean value.
	 * {JSONブーリアン・オブジェクトを作成(ブーリアン値より)}
	 *
	 * @param boolVal
	 *            boolean value {ブーリアン値}
	 * @return JSON boolean object {JSONブーリアン・オブジェクト}
	 */
	public static final JSON createBoolean(boolean boolVal) {
		return new JSONBoolean(boolVal);
	}

	/**
	 * creates a JSON boolean object from string value.
	 * {JSONブーリアン・オブジェクトを作成(文字列値より)}
	 *
	 * @param strVal
	 *            string value {文字列値}
	 * @return JSON boolean object {JSONブーリアン・オブジェクト
	 * @throws Exception
	 *             {例外}
	 */
	public static final JSON createBoolean(String strVal) throws Exception {
		strVal = strVal.trim();
		JSON objJSON = JSON.parse(strVal);

		if (objJSON.typeof() != JSONType.BOOLEAN)
			throw new Exception("createBoolean: Unexpected boolean string: " + strVal);

		return objJSON;
		// return createBoolean(Boolean.parseBoolean(strVal));
	}

	/**
	 * creates a JSON string object from string value.
	 * {JSON文字列オブジェクトを作成(文字列値より)}
	 *
	 * @param strVal
	 *            string value {文字列値}
	 * @return JSON string object {JSON文字列オブジェクト}
	 */
	public static final JSON createString(String strVal) {
		return new JSONString(strVal);
	}

	/**
	 * creates a JSON null object. {JSONヌル・オブジェクトを作成}
	 *
	 * @return JSON null object {JSONヌル・オブジェクト}
	 */
	public static final JSON createNull() {
		return new JSONNull();
	}

	/**
	 * creates a JSON array object. {JSON配列オブジェクトを作成}
	 *
	 * @return JSON array object {JSON配列オブジェクト}
	 */
	public static final JSON createArray() {
		return new JSONArray();
	}

	/**
	 * creates a JSON object. {JSONオブジェクトを作成}
	 *
	 * @return JSON object {JSONオブジェクト}
	 */
	public static final JSON createObject() {
		return new JSONObject();
	}

	/**
	 * creates a JSON key with value object from object key.
	 * {JSONキーと値オブジェクトを作成(オブジェクト)}
	 *
	 * @param objKey
	 *            Object key {キーオブジェクト}
	 * @param objVal
	 *            JSON object value {JSONオブジェクト値}
	 * @return JSON key with value object {JSONキーと値オブジェクト}
	 */
	public static final JSON createKeyValue(Object objKey, JSON objVal) {
		return new JSONKeyValue(objKey, objVal);
	}

	/**
	 * creates a JSON key with value object from string key.
	 * {JSONキーと値オブジェクトを作成(文字列)}
	 *
	 * @param strKey
	 *            String key {文字列キー}
	 * @param objVal
	 *            JSON object value {JSONオブジェクト値}
	 * @return JSON key with value object {JSONキーと値オブジェクト}
	 */
	public static final JSON createKeyValue(String strKey, JSON objVal) {
		return new JSONKeyValue(strKey, objVal);
	}

	/**
	 * creates a JSON key with value objectfrom int key. {JSONキーと値オブジェクトを作成(整数)}
	 *
	 * @param intKey
	 *            int key {整数型のキー}
	 * @param objVal
	 *            JSON object value {JSONオブジェクト値}
	 * @return JSON key with value object {JSONキーと値オブジェクト}
	 */
	public static final JSON createKeyValue(int intKey, JSON objVal) {
		return new JSONKeyValue(intKey, objVal);
	}

	/**
	 * returns type of JSON object. {JSONオブジェクトの型を返す}
	 *
	 * @return JSONType{NUMBER/STRING/BOOLEAN/ARRAY/OBJECT/NULL}
	 */
	public abstract JSONType typeof();

	/**
	 * returns value of JSON object. {JSONオブジェクトの値を返す}
	 *
	 * @return value of JSON object {JSONオブジェクトの値}
	 */
	public abstract Object valueOf();

	/**
	 * returns string value of JSON object. {JSONオブジェクトの文字列値を返す}
	 *
	 * @return string value {文字列値}
	 */
	@Override
	public String toString() {
		return valueOf().toString();
	}

	/**
	 * returns element of array or object by int key.
	 * {配列もしくはオブジェクトの要素を取得する(整数キーによる)}
	 *
	 * @param intKey
	 *            int key {整数キー}
	 * @return JSON object {JSONオブジェクト}
	 */
	public JSON get(int intKey) {
		throw new Error("get(int): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * returns element of array or object by string key.
	 * {配列もしくはオブジェクトの要素を取得する(文字列キーによる)}
	 *
	 * @param strKey
	 *            string key {文字列キー}
	 * @return JSON object {JSONオブジェクト}
	 */
	public JSON get(String strKey) {
		throw new Error("get(str): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * sets element into array or object and return self by int key.
	 * {配列もしくはオブジェクトに要素を設定する(整数キーによる)}
	 *
	 * @param intKey
	 *            int key {整数キー}
	 * @param objJSON
	 *            JSON object {JSONオブジェクト}
	 * @return JSON object {JSONオブジェクト}
	 */
	public JSON put(int intKey, JSON objJSON) {
		throw new Error("put(int,JSON): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * sets element into array or object and return self by int key.
	 * {配列もしくはオブジェクトに要素を設定する(整数キーによる)}
	 *
	 * @param intKey
	 *            int key {整数キー}
	 * @param strVal
	 *            string value {文字列値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(int intKey, String strVal) {
		return put(Integer.toString(intKey), createString(strVal));
	}

	/**
	 * sets element into array or object and return self by int key.
	 * {配列もしくはオブジェクトに要素を設定する(整数キーによる)}
	 *
	 * @param intKey
	 *            integer key {整数キー}
	 * @param intVal
	 *            integer value {整数値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(int intKey, int intVal) {
		return put(Integer.toString(intKey), createNumber(intVal));
	}

	/**
	 * sets element into array or object and return self by int key.
	 * {配列もしくはオブジェクトに要素を設定する(整数キーによる)}
	 *
	 * @param intKey
	 *            integer key {整数キー}
	 * @param doubleVal
	 *            double value {実数値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(int intKey, double doubleVal) {
		return put(Integer.toString(intKey), createNumber(doubleVal));
	}

	/**
	 * sets element into array or object and return self by int key.
	 * {配列もしくはオブジェクトに要素を設定する(整数キーによる)}
	 *
	 * @param intKey
	 *            integer key {整数キー}
	 * @param boolVal
	 *            boolean value {ブーリアン値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(int intKey, boolean boolVal) {
		return put(Integer.toString(intKey), createBoolean(boolVal));
	}

	/**
	 * sets element into array or object and return self by string key.
	 * {配列もしくはオブジェクトに要素を設定する(文字列キーによる)}
	 *
	 * @param strKey
	 *            string key {文字列キー}
	 * @param objJSON
	 *            JSON object {JSONオブジェクト}
	 * @return JSON object {JSONオブジェクト}
	 */
	public JSON put(String strKey, JSON objJSON) {
		throw new Error("put(str,JSON): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * sets element into array or object and return self by string key.
	 * {配列もしくはオブジェクトに要素を設定する(文字列キーによる)}
	 *
	 * @param strKey
	 *            string key {文字列キー}
	 * @param strVal
	 *            string value {文字列値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(String strKey, String strVal) {
		return put(strKey, createString(strVal));
	}

	/**
	 * sets element into array or object and return self by string key.
	 * {配列もしくはオブジェクトに要素を設定する(文字列キーによる)}
	 *
	 * @param strKey
	 *            string key {文字列キー}
	 * @param intVal
	 *            integer value {整数値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(String strKey, int intVal) {
		return put(strKey, createNumber(intVal));
	}

	/**
	 * sets element into array or object and return self by string key.
	 * {配列もしくはオブジェクトに要素を設定する(文字列キーによる)}
	 *
	 * @param strKey
	 *            string key {文字列キー}
	 * @param doubleVal
	 *            double value {実数値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(String strKey, double doubleVal) {
		return put(strKey, createNumber(doubleVal));
	}

	/**
	 * sets element into array or object and return self by string key.
	 * {配列もしくはオブジェクトに要素を設定する(文字列キーによる)}
	 *
	 * @param strKey
	 *            string key {文字列キー}
	 * @param boolVal
	 *            boolean value {ブーリアン値}
	 * @return JSON object {JSONオブジェクト}
	 */
	public final JSON put(String strKey, boolean boolVal) {
		return put(strKey, createBoolean(boolVal));
	}

	/**
	 * returns length of array. {配列の長さ}
	 *
	 * @return int length of array {配列の長さ}
	 */
	public int length() {
		throw new Error("length(): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * push a JSON object value into JSON array. {JSONオブジェクト値をJSON配列に追加する}
	 *
	 * @param objJSON
	 *            JSON object value {JSONオブジェクト値}
	 * @return JSON object
	 */
	public JSON push(JSON objJSON) {
		throw new Error("push(JSON): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * push a string value into JSON array. {文字列値をJSON配列に追加する}
	 *
	 * @param strVal
	 *            string value {文字列値}
	 * @return JSON object
	 */
	public final JSON push(String strVal) {
		return push(createString(strVal));
	}

	/**
	 * push a integer value into JSON array. {整数値をJSON配列に追加する}
	 *
	 * @param intVal
	 *            integer value {整数値}
	 * @return JSON object
	 */
	public final JSON push(int intVal) {
		return push(createNumber(intVal));
	}

	/**
	 * push a double value into JSON array. {実数値をJSON配列に追加する}
	 *
	 * @param doubleVal
	 *            double value {実数値}
	 * @return JSON object
	 */
	public final JSON push(double doubleVal) {
		return push(createNumber(doubleVal));
	}

	/**
	 * push a boolean value into JSON array. {ブーリアン値をJSON配列に追加する}
	 *
	 * @param boolVal
	 *            double value {ブーリアン値}
	 * @return JSON object
	 */
	public final JSON push(boolean boolVal) {
		return push(createBoolean(boolVal));
	}

	/**
	 * returns JSON string format. (instance) {JSON文字列を返す(インスタンス)}
	 *
	 * @return string of JSON format {JSON形式の文字列}
	 */
	public String stringify() {
		return stringify(0);
	}

	/**
	 * returns JSON string format with level of depth. (instance)
	 * {深さレベルに応じたJSON文字列を返す(インスタンス)}
	 *
	 * @param level
	 *            int level of depth {深さレベル}
	 * @return string of JSON format {JSON形式の文字列}
	 */
	public String stringify(int level) {
		return toString();
	}

	/**
	 * returns JSON string format. (static) {JSON文字列を返す(静的)}
	 *
	 * @param objJSON
	 *            JSON object value {JSONオブジェクト値}
	 * @return string of JSON format {JSON形式の文字列}
	 */
	public static final String stringify(JSON objJSON) {
		return objJSON.stringify(0);
	}

	/**
	 * creates JSON object from JSON string format. {文字列からJSONオブジェクトを生成}
	 *
	 * @param strJSON
	 *            string of JSON format {JSON形式の文字列}
	 * @return JSON object value {JSONオブジェクト値}
	 * @throws Exception
	 *             {例外}
	 */
	public static final JSON parse(String strJSON) throws Exception {
		JSON objJSON;
		int n = strJSON.length();
		int[] nextPos = new int[] { 0 };

		objJSON = parse(strJSON, n, 0, nextPos);
		int i = skipWhiteSpaces(strJSON, n, nextPos[0]);
		if (i < n)
			throw new Exception("Unexpected token, end of string expected(JSON): " + strJSON.substring(i));
		return objJSON;
	}

	/**
	 * JSON parse. {文字列からJSONオブジェクトを生成(内部)}
	 *
	 * @param strJSON
	 *            string of JSON format {JSON形式の文字列}
	 * @param n
	 *            length of JSON string {JSON文字列の長さ}
	 * @param pos
	 *            int position {位置}
	 * @param nextPos
	 *            int[] next position {次の位置}
	 * @return JSON object value {JSONオブジェクト値}
	 * @throws Exception
	 *             {例外}
	 */
	private static JSON parse(String strJSON, int n, int pos, int[] nextPos) throws Exception {
		// int n = str.length(); // for performance

		int i = skipWhiteSpaces(strJSON, n, pos);
		if (i < n) {
			char ch = strJSON.charAt(i);

			if (ch == '-' || (ch >= '0' && ch <= '9')) {
				// number
				StringBuilder sb = new StringBuilder("");
				sb.append(ch);
				for (i = i + 1; i < n; ++i) {
					ch = strJSON.charAt(i);
					if (ch == '.' || ch == 'e' || ch == 'E' || ch == '+' || ch == '-' || (ch >= '0' && ch <= '9')) {
						sb.append(ch);
						continue;
					}
					break;
				}
				nextPos[0] = i;
				return createNumber(sb.toString());
			} else if (ch == 't' || ch == 'f') {
				// boolean
				if (strJSON.substring(i).startsWith("true")) {
					nextPos[0] = i + "true".length();
					return createBoolean(true);
				} else if (strJSON.substring(i).startsWith("false")) {
					nextPos[0] = i + "false".length();
					return createBoolean(false);
				} else
					throw new Exception("Unexpected token(JSON boolean): " + strJSON.substring(i));
			} else if (ch == 'n') {
				// null
				if (strJSON.substring(i).startsWith("null")) {
					nextPos[0] = i + "null".length();
					return createNull();
				} else
					throw new Exception("Unexpected token(JSON null): " + strJSON.substring(i));
			} else if (ch == CHAR_DQUOTE) {
				// string
				StringBuilder sb = new StringBuilder("");
				for (int j = i + 1; j < n; ++j) {
					ch = strJSON.charAt(j);
					if (ch == CHAR_DQUOTE) {
						nextPos[0] = j + 1;
						return createString(sb.toString());
					}
					if (ch == CHAR_BACKSLASH) {
						ch = strJSON.charAt(++j);
						if (ch == 'b')
							sb.append(CHAR_BS);
						else if (ch == 'f')
							sb.append(CHAR_FF);
						else if (ch == 'n')
							sb.append(CHAR_LF);
						else if (ch == 'r')
							sb.append(CHAR_CR);
						else if (ch == 't')
							sb.append(CHAR_TAB);
						else if (ch == 'u') {
							int code = Integer.parseInt(strJSON.substring(j + 1, j + 5), 16);
							sb.append((char) code);
							j += 4;
						} else
							sb.append(ch);
					} else
						sb.append(ch);
				}
				throw new Exception("Unexpected end of string(JSON string)");
			} else if (ch == '[') {
				// array
				JSON arr = createArray();
				i = skipWhiteSpaces(strJSON, n, i + 1);
				if (i < n && strJSON.charAt(i) == ']') {
					nextPos[0] = i + 1;
					return arr;
				}
				for (; i < n; ++i) {
					int[] nextPos2 = new int[] { 0 };
					JSON val = parse(strJSON, n, i, nextPos2);
					arr.push(val);
					i = skipWhiteSpaces(strJSON, n, nextPos2[0]);
					if (strJSON.charAt(i) == ']') {
						nextPos[0] = i + 1;
						return arr;
					}
					if (strJSON.charAt(i) != ',')
						throw new Exception("Unexpected token, ',' expected(JSON array): " + strJSON.substring(i));
				}
				throw new Exception("Unexpected end of string(JSON array)");
			} else if (ch == '{') {
				// object
				JSON obj = createObject();
				i = skipWhiteSpaces(strJSON, n, i + 1);
				if (i < n && strJSON.charAt(i) == '}') {
					nextPos[0] = i + 1;
					return obj;
				}
				for (; i < n; ++i) {
					int[] nextPos2 = new int[] { 0 };
					JSON key = parse(strJSON, n, i, nextPos2);
					if (key.typeof() != JSONType.STRING)
						throw new Exception("Unexpected token, String key expected(JSON object): " + key.stringify());
					i = skipWhiteSpaces(strJSON, n, nextPos2[0]);
					if (strJSON.charAt(i) != ':')
						throw new Exception("Unexpected token, ':' expected(JSON object): " + strJSON.substring(i));
					JSON val = parse(strJSON, n, i + 1, nextPos2);
					obj.put(key.toString(), val);
					i = skipWhiteSpaces(strJSON, n, nextPos2[0]);
					if (strJSON.charAt(i) == '}') {
						nextPos[0] = i + 1;
						return obj;
					} else if (strJSON.charAt(i) != ',')
						throw new Exception("Unexpected token, ',' expected(JSON object): " + strJSON.substring(i));
				}
				throw new Exception("Unexpected end of string(JSON object)");
			} else
				throw new Exception("Unexpected token(JSON first char): " + ch + LINE_SEPARATOR + CHAR_TAB
						+ strJSON.substring(i));
		}
		return null;
	}

	/**
	 * skips white spaces and returns position of string. {空白をスキップし、文字列の位置を返す}
	 *
	 * @param str
	 *            String
	 * @param n
	 *            int length of string
	 * @param pos
	 *            int position of string
	 * @return nextPos int
	 * @throws Exception
	 *             some exception
	 */
	protected static final int skipWhiteSpaces(String str, int n, int pos) throws Exception {
		int i;

		for (i = pos; i < n; ++i) {
			char ch = str.charAt(i);

			if (ch == '/' && i + 1 < n && str.charAt(i + 1) == '/') {
				// line comment from "//" to end of line {ライン・コメント}
				for (i = i + 2; i < n; ++i) {
					ch = str.charAt(i);
					if (ch == CHAR_LF || ch == CHAR_CR) {
						++i;
						break;
					}
				}
				if (i >= n)
					return i;
				ch = str.charAt(i);
			} else if (ch == '/' && i + 1 < n && str.charAt(i + 1) == '*') {
				// block comment from "/*" to "*/" {ブロック・コメント}
				boolean comment = true;
				for (i = i + 2; i < n; ++i) {
					ch = str.charAt(i);
					if (ch == '*' && i + 1 < n && str.charAt(i + 1) == '/') {
						i += 2;
						comment = false;
						break;
					}
				}
				if (comment)
					throw new Exception("Unexpected end of string, \"*/\" expected");
				if (i >= n)
					return i;
				ch = str.charAt(i);
			}
			// skip white spaces, break if not white spaces
			if (ch != CHAR_SPACE && ch != CHAR_TAB && ch != CHAR_LF && ch != CHAR_CR)
				break;
		}
		return i;
	}

	/**
	 * escape string with double quotation. {文字列クォート化}
	 *
	 * @param str
	 *            string {文字列}
	 * @return quoted string {二重引用符で囲まれた文字列}
	 */
	public static final String escape(String str) {
		StringBuilder sb = new StringBuilder();
		sb.append(CHAR_DQUOTE);
		for (int i = 0, n = str.length(); i < n; ++i) {
			char ch = str.charAt(i);
			if (ch == CHAR_DQUOTE || ch == CHAR_BACKSLASH) { // || ch == '/') {
				sb.append(CHAR_BACKSLASH);
				sb.append(ch);
			} else if (ch == CHAR_BS)
				sb.append(CHAR_BACKSLASH + "b");
			else if (ch == CHAR_FF)
				sb.append(CHAR_BACKSLASH + "f");
			else if (ch == CHAR_LF)
				sb.append(CHAR_BACKSLASH + "n");
			else if (ch == CHAR_CR)
				sb.append(CHAR_BACKSLASH + "r");
			else if (ch == CHAR_TAB)
				sb.append(CHAR_BACKSLASH + "t");
			else
				sb.append(ch);
		}
		sb.append(CHAR_DQUOTE);
		return sb.toString();
	}

	// ##########################################################################

	/**
	 * width for indent. {インデントするかどうかを決める幅}
	 */
	static int widthForIndent = 40;

	/**
	 * get width for indent. {インデントするかどうかを決める幅を取得}
	 *
	 * @return width for indent {インデントするかどうかを決める幅}
	 */
	public static final int getWidthForIndent() {
		return widthForIndent;
	}

	/**
	 * set width for indent. {インデントするかどうかを決める幅を設定}
	 *
	 * @param width
	 *            width for indent {インデントするかどうかを決める幅} -1: do not indent 0 or
	 *            more: width for indent
	 */
	public static final void setWidthForIndent(int width) {
		if (width < -1)
			throw new Error("setWidth: Out of range: width=" + width);
		widthForIndent = width;
	}

	// ##########################################################################

	/**
	 * indent string. {インデンテーション文字列}
	 */
	protected static String indentString = "  ";

	/**
	 * get indent string. {インデンテーション文字列を取得}
	 *
	 * @return indent string {インデンテーション文字列}
	 */
	public static final String getIndentString() {
		return indentString;
	}

	/**
	 * set indent string. {インデンテーション文字列を設定}
	 *
	 * @param indent
	 *            indent String {インデンテーション文字列} valid only 1, 2, 4, 6, 8 spaces
	 *            or tab
	 */
	public static final void setIndentString(String indent) {
		if (indent.equals(" ") || indent.equals("  ") || indent.equals("    ") || indent.equals("      ")
				|| indent.equals("        ") || indent.equals("\t")) {
			indentString = indent;
		} else
			throw new Error("setIndentString: invalid indent string, expected 1, 2, 4, 6, 8 spaces or tab");
	}

	// ##########################################################################

	/**
	 * returns JSON iterator. {JSONイテレータを返す}
	 *
	 * @return Iterator<JSON> {JSONイテレータ}
	 */
	public Iterator<JSON> iterator() {
		throw new Error("iterator(): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * returns string key of JSON Key Value object.
	 * {JSONキー・バリュー・オブジェクトの文字列キーを返す}
	 *
	 * @return key string {キー文字列}
	 */
	public String key() {
		throw new Error("key(): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
	}

	/**
	 * returns string key array of JSON array or object. (instance)
	 * {JSON配列またはJSONオブジェクトのキー配列を返す(instance)}
	 *
	 * @return JSON array {JSON配列}
	 */
	public JSON keys() {
		if (typeof() != JSONType.ARRAY && typeof() != JSONType.OBJECT)
			throw new Error("keys(): Not Supported: JSON type: " + typeof() + " class: " + this.getClass().getName());
		if (valueOf() == null)
			throw new Error("keys(): Not Supported: JSON type: null" + " class: " + this.getClass().getName());

		JSON keyArray = createArray();

		for (JSON e : this)
			keyArray.push(createString(e.key()));

		return keyArray;
	}

	/**
	 * returns string key array of JSON array or object. (static)
	 * {JSON配列またはJSONオブジェクトのキー配列を返す(static)}
	 *
	 * @param objJSON
	 *            JSON object {JSONオブジェクト}
	 * @return JSON array {JSON配列}
	 */
	public static final JSON keys(JSON objJSON) {
		return objJSON.keys();
	}

	/**
	 * line separator. (CR/LF) {行区切り(復帰/改行)}
	 */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	/**
	 * CR carriage return. {復帰}
	 */
	public static final char CHAR_CR = '\r';
	/**
	 * LF line feed. {行送り}
	 */
	public static final char CHAR_LF = '\n';
	/**
	 * FF form feed. {改ページ}
	 */
	public static final char CHAR_FF = '\f';
	/**
	 * BS back space. {バック・スペース}
	 */
	public static final char CHAR_BS = '\b';
	/**
	 * tab. {タブ}
	 */
	public static final char CHAR_TAB = '\t';
	/**
	 * space. {空白}
	 */
	public static final char CHAR_SPACE = ' ';
	/**
	 * double quote. {二重引用符}
	 */
	public static final char CHAR_DQUOTE = '\"';
	/**
	 * back slash. {バック・スラッシュ}
	 */
	public static final char CHAR_BACKSLASH = '\\';
	/**
	 * section separator. {セクション区切り}
	 */
	public static final char CHAR_SECTION_SEPARATOR = '/';

	/**
	 * returns Ini File format string. {INIファイル形式文字列を返す}
	 *
	 * @return String ini File format string {INIファイル形式文字列}
	 */
	public final String toIniFile() {
		return toIniFile("", "");
	}

	/**
	 * to Ini File format string. {INIファイル形式文字列}
	 *
	 * @param section
	 *            String {セクション文字列}
	 * @param key
	 *            String {キー文字列}
	 * @return String ini File format string {INIファイル形式文字列}
	 */
	private String toIniFile(String section, String key) {
		StringBuilder sb = new StringBuilder();
		String nextSection;

		if ("".equals(section) && "".equals(key))
			nextSection = typeof().toString();
		else if ("".equals(section))
			nextSection = key;
		else if ("".equals(key))
			nextSection = section;
		else
			nextSection = section + CHAR_SECTION_SEPARATOR + key;

		switch (typeof()) {
		case NUMBER:
		case BOOLEAN:
		case NULL:
			if ("".equals(key)) {
				sb.append("[");
				sb.append(nextSection);
				sb.append("]");
				sb.append(LINE_SEPARATOR);
				sb.append("value");
			} else {
				sb.append(key);
			}
			sb.append("=");
			sb.append(toString());
			sb.append(LINE_SEPARATOR);
			break;
		case STRING:
			if ("".equals(key)) {
				sb.append("[");
				sb.append(nextSection);
				sb.append("]");
				sb.append(LINE_SEPARATOR);
				sb.append("value");
			} else {
				sb.append(key);
			}
			sb.append("=");
			String s1 = toString();
			String s2 = stringify();
			if (s2.equals(CHAR_DQUOTE + s1 + CHAR_DQUOTE))
				sb.append(s1);
			else
				sb.append(s2);
			sb.append(LINE_SEPARATOR);
			break;
		case OBJECT:
		case ARRAY:
			JSON simpleObj = createObject(); // NUMBER, BOOLEAN, NULL, STRING
			JSON complexObj = createObject(); // ARRAY, OBJECT

			for (JSON e : this) {
				switch (e.typeof()) {
				case NUMBER:
				case BOOLEAN:
				case NULL:
				case STRING:
					simpleObj.put(e.key(), ((JSONKeyValue) e).valueJSON());
					break;
				case OBJECT:
				case ARRAY:
					complexObj.put(e.key(), ((JSONKeyValue) e).valueJSON());
					break;
				default:
					throw new Error("toIniFile(): Not Supported: JSON type: " + e.typeof() + " class: "
							+ this.getClass().getName());
				}
			}

			if (simpleObj.length() != 0 || complexObj.length() == 0) {
				sb.append("[");
				sb.append(nextSection);
				sb.append("]");
				sb.append(LINE_SEPARATOR);

				for (JSON e : simpleObj) {
					sb.append(e.toIniFile(nextSection, e.key()));
				}
			}

			if ("".equals(section) && "".equals(key))
				nextSection = "";
			else if ("".equals(section))
				nextSection = key;
			else
				nextSection = section + CHAR_SECTION_SEPARATOR + key;

			for (JSON e : complexObj) {
				sb.append(e.toIniFile(nextSection, e.key()));
			}
			break;
		default:
			throw new Error("toIniFile(): Not Supported: JSON type: " + typeof() + " class: "
					+ this.getClass().getName());
		}
		return sb.toString();
	}
}
