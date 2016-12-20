package com.fang.thread.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;




/**
 * @author think
 * 
 */
public class SocketHandler implements Runnable {

	private Socket socket;
	public SocketHandler(Socket socket) {
		this.socket = socket;
	}

	/*
	 * 单线程消息接收 (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("进入run方法的");
		String s = "";
		byte[] reqByte = new byte[2000];
		InputStream din;
		try {
			din = socket.getInputStream();
			din.read(reqByte);
			String sss =new String(reqByte,"UTF-8").toString();
			
			 for(int i=0;i<2000;i++){
		        	if(reqByte[i]!=0){
		        		s = s + new String(reqByte,i,1);
		        	}
		        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//381290
			
		System.out.println(s);
		
		
		
	    }
}
