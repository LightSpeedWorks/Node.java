package com.lightspeedworks.node.json;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * JSON Object class. {JSONオブジェクト・クラス}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class JSONObject extends JSON {
	/**
	 * contents of object. {オブジェクトの内容}
	 */
	LinkedHashMap<Object, JSON> mapObject = null;

	/**
	 * constractor. {コンストラクタ}
	 */
	public JSONObject() {
		mapObject = new LinkedHashMap<Object, JSON>();
	}

	/**
	 * returns type of JSON object. {JSONオブジェクトの型を返す}
	 *
	 * @return JSONType.OBJECT {オブジェクト型}
	 */
	@Override
	public JSONType typeof() {
		return JSONType.OBJECT;
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
		StringBuilder sb = new StringBuilder("{");
		for (Entry<Object, JSON> e : mapObject.entrySet()) {
			sb.append(delim);
			sb.append((String) e.getKey());
			sb.append(":");
			sb.append(e.getValue());
			delim = ",";
		}
		sb.append("}");
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
		String strJSON;

		for (Entry<Object, JSON> e : mapObject.entrySet()) {
			strJSON = escape((String) e.getKey()) + ": " + e.getValue().stringify(level + 1);
			strArray.add(strJSON);
			width += strJSON.length() + 2;
		}
		if (width == 0)
			width = 2;

		String delim = "";
		String indent = LINE_SEPARATOR;
		StringBuilder sb = new StringBuilder("{");
		int n = strArray.size();

		if (widthForIndent >= 0 && width > widthForIndent) {
			// do indent {インデントする場合}
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
			// do not indent {インデントしない場合}
			for (String e : strArray) {
				sb.append(delim);
				sb.append(e);
				delim = ", ";
			}
		}

		sb.append("}");
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
		return mapObject.get(intKey);
	}

	/**
	 * returns element of array or object by string key.
	 * {配列もしくはオブジェクトの要素を取得する(文字列キーによる)}
	 *
	 * @param strKey
	 *            string key {文字列キー}
	 * @return JSON object {JSONオブジェクト}
	 */
	@Override
	public JSON get(String strKey) {
		return mapObject.get(strKey);
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
		mapObject.put(Integer.toString(intKey), objJSON);
		return this;
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
	@Override
	public JSON put(String strKey, JSON objJSON) {
		mapObject.put(strKey, objJSON);
		return this;
	}

	/**
	 * returns iterator. {イテレータを返す}
	 *
	 * @return Iterator<JSON>
	 */
	@Override
	public Iterator<JSON> iterator() {
		return new JSONIterator(mapObject);
	}

	/**
	 * length of array. {配列の長さ}
	 *
	 * @return int length of array {配列の長さ}
	 */
	public int length() {
		return mapObject.size();
	}
}
