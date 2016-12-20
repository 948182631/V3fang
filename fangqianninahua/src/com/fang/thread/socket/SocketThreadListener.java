package com.fang.thread.socket;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author think
 * 
 */
public class SocketThreadListener implements ServletContextListener  {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
		ServletContext ctx = event.getServletContext();
		String ctxPort = ctx.getInitParameter("ctxPort");
		String poolSize = ctx.getInitParameter("POOL_SIZE");
//		System.out.println("socket start listener get ctxPort..."+ctxPort);
//		System.out.println("socket start listener get poolSize..."+poolSize);
		//Integer.parseInt(ctxPort),Integer.parseInt(poolSize)
		
		SocketThread ss =new SocketThread(Integer.parseInt(ctxPort),Integer.parseInt(poolSize));
		ss.start();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		SocketThread ss =new SocketThread();
		ss.stop();
//		System.out.println("BatchFileThreadService shutdown ...");
	}
}
