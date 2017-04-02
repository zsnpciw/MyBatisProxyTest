package com.imooc;

import java.util.Iterator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		Message message = new Message();
		message.setId(1);
		
		SqlSession sqlSession = new SqlSession();
		IMessage imessage = sqlSession.getMapper(IMessage.class);
		List<Message> messageList = imessage.query(message);
		
		
		Iterator<Message> it = messageList.iterator();
		while(it.hasNext()){
			System.out.println(it.next().getId());
		}
	}
}
