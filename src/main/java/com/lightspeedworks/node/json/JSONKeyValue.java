package com.lightspeedworks.node.json;

import java.util.Iterator;

/**
 * JSON Key with Value class. {JSONキーと値クラス}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class JSONKeyValue extends JSON {
	/**
	 * string key value. {文字列キー値}
	 */
	private String strKey = "";
	/**
	 * JSON object value. {JSONオブジェクト値}
	 */
	private JSON objJSON = null;

	/**
	 * constractor. {コンストラクタ}
	 *
	 * @param objKey object key value {オブジェクト・キー値}
	 * @param objJSON JSON object value {JSONオブジェクト値}
	 */
	public JSONKeyValue(Object objKey, JSON objJSON) {
		this.strKey = objKey.toString();
		this.objJSON = objJSON;
	}

	/**
	 * constractor. {コンストラクタ}
	 *
	 * @param strKey string key value {文字列キー値}
	 * @param objJSON JSON object value {JSONオブジェクト値}
	 */
	public JSONKeyValue(String strKey, JSON objJSON) {
		this.strKey = strKey;
		this.objJSON = objJSON;
	}

	/**
	 * constractor. {コンストラクタ}
	 *
	 * @param intKey int key value {整数キー値}
	 * @param objJSON JSON object value {JSONオブジェクト値}
	 */
	public JSONKeyValue(int intKey, JSON objJSON) {
		this.strKey = Integer.toString(intKey);
		this.objJSON = objJSON;
	}

	/**
	 * returns type of JSON key with value object. {JSONキーと値オブジェクトの型を返す}
	 *
	 * @return JSONType {JSON型}
	 */
	@Override
	public JSONType typeof() {
		return objJSON.typeof();
	}

	/**
	 * returns value of JSON key with value object. {JSONキーと値オブジェクトの値を返す}
	 *
	 * @return value of JSON key with value object {JSONキーと値オブジェクトの値}
	 */
	@Override
	public Object valueOf() {
		return objJSON.valueOf();
	}

	/**
	 * returns string value of JSON object. {JSONオブジェクトの文字列値を返す}
	 *
	 * @return string value {文字列値}
	 */
	@Override
	public String toString() {
		return objJSON.toString();
	}

	/**
	 * returns JSON string format. (instance) {JSON文字列を返す(インスタンス)}
	 *
	 * @return string of JSON format {JSON形式の文字列}
	 */
	@Override
	public String stringify() {
		return objJSON.stringify(0);
	}

	/**
	 * returns JSON string format with level of depth. (instance)
	 * {深さレベルに応じたJSON文字列を返す(インスタンス)}
	 *
	 * @param level
	 *            int level of depth {深さレベル}
	 * @return JSON format string of JSON object {JSON形式の文字列}
	 */
	@Override
	public String stringify(int level) {
		return objJSON.stringify(level);
	}

	/**
	 * returns string key of JSON Key Value object. {JSONキー・バリュー・オブジェクトの文字列キーを返す}
	 *
	 * @return key string {キー文字列}
	 */
	@Override
	public String key() {
		return strKey;
	}

	/**
	 * returns JSON iterator. {JSONイテレータを返す}
	 *
	 * @return Iterator<JSON> {JSONイテレータ}
	 */
	@Override
	public Iterator<JSON> iterator() {
		return objJSON.iterator();
	}

	/**
	 * returns length of array. {配列の長さ}
	 *
	 * @return int length of array {配列の長さ}
	 */
	public int length() {
		return objJSON.length();
	}

	/**
	 * returns value of JSON object. {JSONオブジェクトを返す}
	 *
	 * @return JSON object {JSONオブジェクト}
	 */
	public JSON valueJSON() {
		return objJSON;
	}
}
