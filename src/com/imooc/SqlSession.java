package com.imooc;

public class SqlSession {

	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> target){
		
		MapperProxyHandler<T> h = new MapperProxyHandler<T>(target);
		
		return (T) h.getProxy();
	}
}
