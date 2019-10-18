package com.pana.user.thrift;

import com.pana.thrift.user.UserService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
public class ThriftServer {

	@Value("${service.port}")
	private int servicePort;

	@Autowired
	private UserService.Iface userService;

	/*
	 * 启动thrift server
	 */
	@PostConstruct
	public void startThriftServer() {

		TProcessor processor = new UserService.Processor<>(userService);

		/**
		 * IO 模型 ，单线程 线程池 NIO 
		 * TNonblockingServerSocket NIO 模型
		 */
		TNonblockingServerSocket socket = null;
		try {
			socket = new TNonblockingServerSocket(servicePort,60000);
		} catch (TTransportException e) {
			e.printStackTrace();
		}
		TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
		args.processor(processor);
		// 传输方式 （帧传输）
		args.transportFactory(new TFramedTransport.Factory());
		// 传输协议 （二进制） json protocol
		args.protocolFactory(new TBinaryProtocol.Factory());
		TServer server = new TNonblockingServer(args);
		
		server.serve();
	}
}
