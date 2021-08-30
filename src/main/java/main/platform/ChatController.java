package main.platform;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import main.platform.model.ChatMessage;

/***
 * 
 * @author Joe	2021/08/31
 * @MessageMapping @SendTo ���|���۰ʫʸ� ChatMessage �t��Name Content type �T�����ѫe�ݵo�eJson���ഫ
 *
 */

@Controller
public class ChatController 
{
	@MessageMapping("/hello")	//�����Ӧۦ����|�T��		�e���j�w setApplicationDestinationPrefixes �ҳ]�w�����|
	@SendTo("/topic/greetings")	//���e�V�q�\���W�D		�e���j�w enableSimpleBroker	�ҳ]�w�����|
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) throws InterruptedException
	{
		Thread.sleep(1000);		
		return  new ChatMessage(chatMessage.getName(),chatMessage.getContent(),chatMessage.getType());
	}
}
