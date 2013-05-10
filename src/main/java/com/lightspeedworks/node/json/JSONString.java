package com.lightspeedworks.node.json;

/**
 * JSON String class. {JSON文字列クラス}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class JSONString extends JSON {
	/**
	 * string value of JSON string object. {JSON文字列オブジェクトの文字列値}
	 */
	String strVal = null;

	/**
	 * constractor. {コンストラクタ}
	 *
	 * @param strVal string value of JSON string object {JSON文字列オブジェクトの文字列値}
	 */
	public JSONString(String strVal) {
		this.strVal = strVal;
	}

	/**
	 * returns type of JSON string object. {JSON文字列オブジェクトの型を返す}
	 *
	 * @return JSONType.STRING {文字列型}
	 */
	@Override
	public JSONType typeof() {
		return JSONType.STRING;
	}

	/**
	 * returns string value of JSON object. {JSONオブジェクトの値(文字列)を返す}
	 *
	 * @return string value of JSON object {JSONオブジェクトの値(文字列)}
	 */
	@Override
	public Object valueOf() {
		return strVal;
	}

	/**
	 * returns string value of JSON object. {JSONオブジェクトの文字列値を返す}
	 *
	 * @return string value {文字列値}
	 */
	@Override
	public String toString() {
		return strVal;
	}

	/**
	 * returns JSON string format. (instance) {JSON文字列を返す(インスタンス)}
	 *
	 * @return string of JSON format {JSON形式の文字列}
	 */
	@Override
	public String stringify() {
		return escape(strVal);
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
		return escape(strVal);
	}
}
