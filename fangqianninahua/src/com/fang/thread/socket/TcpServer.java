package com.fang.thread.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/**
 * 随WEB服务启动TCP
 * @author think
 *
 */
public class TcpServer {
	private int port;
	private int POOL_SIZE ;// 单个CPU线程池大小
//	public int port =  Integer.valueOf(PropertiesUtil.getInstance().getProperty("socket.port"));
//	public int POOL_SIZE = Integer.valueOf(PropertiesUtil.getInstance().getProperty("socket.POOL_SIZE"));
	
	private ServerSocket serverSocket;
	private ExecutorService executorService;// 线程池

	//默认构造方法
	public TcpServer(){
	}
	
	public TcpServer(int _port,int _pool_size) throws IOException{
		this.port = _port;
    	this.POOL_SIZE = _pool_size;
        serverSocket=new ServerSocket(port);
		executorService = Executors.newFixedThreadPool(POOL_SIZE);
		System.out.println("BatchFileThreadService start ...");
	}

	public void startPoolService(){
        while(true){
            Socket socket=null;
            try {
                //接收客户连接,只要客户进行了连接,就会触发accept();从而建立连接
                socket=serverSocket.accept();
                //加入线程池
                executorService.execute(new SocketHandler(socket)); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

	public int getPOOL_SIZE() {
		return POOL_SIZE;
	}

	public void setPOOL_SIZE(int pOOL_SIZE) {
		POOL_SIZE = pOOL_SIZE;
	}
	
	//启动线程池主函数
    public static void main(String[] args) throws IOException {
        new TcpServer(8801,10).startPoolService();
    	
//    	String str = "部";
//    	// 部 陓
//    	System.out.println("------------"+str.split("|").length);
//    	System.out.println("----"+str.split(Pattern.quote("|")).length);
    	
    }
    
}
