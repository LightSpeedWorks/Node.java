package com.lightspeedworks.node.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * JSON Array class. {JSON配列クラス}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class JSONArray extends JSON {
	/**
	 * contents of array. {配列の内容}
	 */
	LinkedHashMap<Object, JSON> mapArray = null;
	/**
	 * length of array. {配列の長さ}
	 */
	int length = 0;

	/**
	 * constractor. {コンストラクタ}
	 */
	public JSONArray() {
		this.mapArray = new LinkedHashMap<Object, JSON>();
	}

	/**
	 * returns type of JSON array. {JSON配列の型を返す}
	 *
	 * @return JSONType.ARRAY {配列型}
	 */
	@Override
	public JSONType typeof() {
		return JSONType.ARRAY;
	}

	/**
	 * returns value of JSON object. {JSONオブジェクトの値を返す}
	 *
	 * @return value of JSON object {JSONオブジェクトの値}
	 */
	@Override
	public Object valueOf() {
		return this;
	}

	/**
	 * returns string value of JSON object. {JSONオブジェクトの文字列値を返す}
	 *
	 * @return string value {文字列値}
	 */
	@Override
	public String toString() {
		String delim = "";
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < length; ++i) {
			JSON val2 = mapArray.get(i);
			sb.append(delim);
			if (val2 != null)
				sb.append(val2.toString());
			delim = ",";
		}
		sb.append("]");
		return sb.toString();
	}

	/**
	 * returns JSON string format with level of depth. (instance)
	 * {深さレベルに応じたJSON文字列を返す(インスタンス)}
	 *
	 * @param level
	 *            int level of depth {深さレベル}
	 * @return string of JSON format {JSON形式の文字列}
	 */
	@Override
	public String stringify(int level) {
		ArrayList<String> strArray = new ArrayList<String>();
		int width = 0;

		for (int i = 0; i < length; ++i) {
			JSON obj = mapArray.get(i);
			String strJSON;

			if (obj == null)
				strJSON = "null";
			else
				strJSON = obj.stringify(level + 1);

			width += strJSON.length() + 2;
			strArray.add(strJSON);
		}
		if (width == 0)
			width = 2;

		String delim = "";
		String indent = LINE_SEPARATOR;
		StringBuilder sb = new StringBuilder("[");
		int n = strArray.size();

		if (widthForIndent >= 0 && width > widthForIndent) {
			for (int i = 0; i < level; ++i)
				indent += indentString;
			delim += indent;

			for (String e : strArray) {
				sb.append(delim);
				sb.append(indentString);
				sb.append(e);
				delim = "," + indent;
			}

			if (n > 0)
				sb.append(indent);
		} else {
			for (String e : strArray) {
				sb.append(delim);
				sb.append(e);
				delim = ", ";
			}
		}

		sb.append("]");
		return sb.toString();
	}

	/**
	 * returns element of array or object by int key.
	 * {配列もしくはオブジェクトの要素を取得する(整数キーによる)}
	 *
	 * @param intKey
	 *            int key {整数キー}
	 * @return JSON object {JSONオブジェクト}
	 */
	@Override
	public JSON get(int intKey) {
		return mapArray.get(intKey);
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
	@Override
	public JSON put(int intKey, JSON objJSON) {
		mapArray.put(intKey, objJSON);
		if (length <= intKey)
			length = intKey + 1;
		return this;
	}

	/**
	 * returns length of array. {配列の長さ}
	 *
	 * @return int length of array {配列の長さ}
	 */
	@Override
	public int length() {
		return length;
	}

	/**
	 * push a JSON object value into JSON array. {JSONオブジェクト値をJSON配列に追加する}
	 *
	 * @param objJSON
	 *            JSON object value {JSONオブジェクト値}
	 * @return JSON
	 */
	@Override
	public JSON push(JSON objJSON) {
		return put(length++, objJSON);
	}

	/**
	 * returns iterator. {イテレータを返す}
	 *
	 * @return Iterator<JSON>
	 */
	@Override
	public Iterator<JSON> iterator() {
		return new JSONIterator(mapArray);
	}
}
