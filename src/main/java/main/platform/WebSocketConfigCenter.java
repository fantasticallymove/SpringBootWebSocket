package main.platform;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/***
 * 
 * @author Joe
 * @EnableWebSocketMessageBroker 宣告可使用 @MessageMapping @SendTo
 */
@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfigCenter implements WebSocketMessageBrokerConfigurer
{
	/**
	 * 这个方法的作用是添加一个服务端点，来接收客户端的连接。
	 */
	@Override
	public void registerStompEndpoints(final StompEndpointRegistry registry) {
		/*****表示添加了一个/gs-guide-websocket端点，客户端就可以通过这个端点来进行连接 並开启SockJS支持 *****/
		/**	
		 ** 	【JavaScript】
		 ** 	var socket = new SockJS('/gs-guide-websocket');
         ** 	stompClient = Stomp.over(socket);
         **		stompClient.connect({}, function (frame) 
         **		{
         **   		setConnected(true);
         **   		console.log('Connected: ' + frame);
         **   	}
		 */
		registry.addEndpoint("/gs-guide-websocket").withSockJS();
	}
	
	/**
	 * 这个方法的作用是定义消息代理，通俗一点讲就是设置消息连接请求的各种规范信息。
	 */
	@Override
	public void configureMessageBroker(final MessageBrokerRegistry registry)
	{
		/*****指服务端接收地址的前缀*****/
		registry.setApplicationDestinationPrefixes("/app");
		
		
		/*****指客戶接收地址的前缀*****/
		registry.enableSimpleBroker("/topic");
	}
}
