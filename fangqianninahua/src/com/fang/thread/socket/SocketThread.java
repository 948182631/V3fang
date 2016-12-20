package com.fang.thread.socket;

import java.io.IOException;

/**
 * @author V3芳
 * 
 */
public class SocketThread extends Thread {

	private int port;
	private int POOL_SIZE;// 单个CPU线程池大小
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPOOL_SIZE() {
		return POOL_SIZE;
	}

	public void setPOOL_SIZE(int pOOL_SIZE) {
		POOL_SIZE = pOOL_SIZE;
	}
	//构造器
	public SocketThread(){
		
	}

	public SocketThread(int _port,int _pool_size){
		this.port= _port;
		this.POOL_SIZE =_pool_size;
	}
	
	
	/*
	 * 单线程消息接收 (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		
		try {
			new TcpServer(port,POOL_SIZE).startPoolService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
