package main.platform.model;

import lombok.Data;

@Data
public class ChatMessage 
{
	public ChatMessage()
	{}
	
	public ChatMessage(String name,String content,MessageTypeEnum type)
	{
		this.name = name;
		this.content = content;
		this.type = type;
	}
	
	private String name;
	
	private String content;
	
	private MessageTypeEnum type;
}
