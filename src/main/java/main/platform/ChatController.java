package main.platform;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import main.platform.model.ChatMessage;

/***
 * 
 * @author Joe	2021/08/31
 * @MessageMapping @SendTo 接會做自動封裝 ChatMessage 含有Name Content type 三種欄位由前端發送Json做轉換
 *
 */

@Controller
public class ChatController 
{
	@MessageMapping("/hello")	//接收來自此路徑訊息		前面綁定 setApplicationDestinationPrefixes 所設定的路徑
	@SendTo("/topic/greetings")	//推送向訂閱此頻道		前面綁定 enableSimpleBroker	所設定的路徑
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) throws InterruptedException
	{
		Thread.sleep(1000);		
		return  new ChatMessage(chatMessage.getName(),chatMessage.getContent(),chatMessage.getType());
	}
}
