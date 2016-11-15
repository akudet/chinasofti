package demo.vo;

public class Message {
	
	private int id;
	private String text;
	
	public Message() {
		super();
	}
	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}

}
