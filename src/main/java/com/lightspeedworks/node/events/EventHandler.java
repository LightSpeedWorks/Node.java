package com.lightspeedworks.node.events;

/**
 * EventHandler class.
 *
 * @author LightSpeedC (Kazuaki Nishizawa; 西澤 和晃)
 */
public class EventHandler implements Callback {
	/**
	 * callback function, listener or event handler.
	 */
	Callback callback;

	/**
	 * once. (one time if true)
	 */
	boolean once;

	/**
	 * constractor.
	 *
	 * @param callback
	 *            Callback
	 * @param once
	 *            boolean
	 */
	public EventHandler(Callback callback, boolean once) {
		this.callback = callback;
		this.once = once;
	}

	/**
	 * do callback.
	 *
	 * @param args
	 *            Object...
	 */
	public void callback(Object... args) {
		callback.callback(args);
	}
}
