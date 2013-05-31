package com.lightspeedworks.node.json;

/**
 * JSON Integer class. {JSON整数クラス}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class JSONInteger extends JSON {
	/**
	 * returns type of JSON number object. {JSON数値オブジェクトの型を返す}
	 *
	 * @return JSONType.NUMBER {数値型}
	 */
	@Override
	public JSONType typeof() {
		return JSONType.NUMBER;
	}

	/**
	 * integer value. {整数値}
	 */
	int intVal;

	/**
	 * constractor. {コンストラクタ}
	 *
	 * @param intVal
	 *            integer value {整数値}
	 */
	public JSONInteger(int intVal) {
		this.intVal = intVal;
	}

	/**
	 * returns value of JSON number/integer object. {JSON整数オブジェクトの値を返す}
	 *
	 * @return integer value of JSON number/integer object {JSON整数オブジェクトの値}
	 */
	@Override
	public Object valueOf() {
		return intVal; // new Integer(intVal);
	}
}
