package Util;

import java.io.Serializable;

public class Message implements Serializable{
	//消息类型
	private String type;
	//消息内容
	private Object content;
		//发送方
	private String from;		
		//接收方
	private String to;
	
	private String others;
	
	private int size;
	private String file;
		
		
		
		public void setType(String type) {
			this.type = type;			
		}
		
		public void setContent(Object content) {
			this.content = content;			
		}
		
		public void setTo(String to) {
			this.to = to;			
		}
		
		public void setFrom(String from) {
			this.from = from;			
		}
		
		public void setOthers(String others) {
			this.others = others;
			
		}
		
		public void setSize(int size) {
			this.size = size;			
		}
		
		public void setFile(String file) {
			this.file = file;			
		}
		
		public String getType() {
			return(this.type );		
		}
		
		public Object getContent() {
			return(this.content );			
		}
		
		public String getTo() {
			return(this.to);			
		}
		
		public String getFrom() {
			return(this.from);			
		}
		
		public String getOthers() {
			return(this.others);
			
		}
		
		public int getSize() {
			return(this.size);
			
		}
		
		public String getFile() {
			return(this.file);
			
		}

}
