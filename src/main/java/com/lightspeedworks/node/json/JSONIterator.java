package com.lightspeedworks.node.json;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * JSON Iterator class. {JSONイテレータ・クラス}
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
class JSONIterator implements Iterator<JSON> {
	/**
	 * iterator.
	 */
	Iterator<Entry<Object, JSON>> iterator;

	/**
	 * constructor. {コンストラクタ}
	 *
	 * @param map LinkedHashMap<Integer or String, JSON>
	 */
	public JSONIterator(LinkedHashMap<Object, JSON> map) {
		iterator = map.entrySet().iterator();
	}

	/**
	 * has next? {次があるか?}
	 *
	 * @return hasNext boolean
	 */
	public boolean hasNext() {
		return iterator.hasNext();
	}

	/**
	 * next. {次}
	 *
	 * @return next JSON
	 */
	public JSON next() {
		Entry<Object, JSON> e = iterator.next();
		return JSON.createKeyValue(e.getKey().toString(), e.getValue());
	}

	/**
	 * remove. {削除}
	 */
	public void remove() {
		iterator.remove();
	}
}
