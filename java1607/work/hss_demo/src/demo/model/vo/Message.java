package demo.model.vo;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class Message {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	@Column(name = "MESSAGE_TEXT")
	private String text;

	public Message() {
	}

	public Message(int id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Message(String text) {
		this.text = text;
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