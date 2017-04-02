package com.imooc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class MapperProxyHandler<T> implements InvocationHandler{
	
	private Class<T> target;
	
	public  MapperProxyHandler(Class<T> target) {
		super();
		this.target = target;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass().getInterfaces()[0].getName()+'.'+method.getName());
		
		List<Message> messageList = new ArrayList<Message>();
		Message message;
		message= new Message(1);messageList.add(message);
		message= new Message(2);messageList.add(message);
		message= new Message(2);messageList.add(message);
		
		return messageList;
	}

	public Object getProxy(){
		Class<?>[] targets = {target};
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				targets, this);
	}
}
