package hibernate_demo.vo;

import javax.persistence.*;

@Entity
@Table(name = "MESSAGES")
public class Message {
	@Id
	@GeneratedValue
	@Column(name = "MESSAGE_ID")
	private Long id;
	@Column(name = "MESSAGE_TEXT")
	private String text;

	public Message() {
	}

	public Message(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Message(String text) {
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setId(Long id) {
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