package com.blogspot.diegopacheco.cxf.cglib.proxy;

/**
 * 
 * @author Diego Pacheco
 *
 */
public interface OperationCallback {
	public Object  execute(String operationName,Object args);
	public boolean isHandleable(String operationName);
}
