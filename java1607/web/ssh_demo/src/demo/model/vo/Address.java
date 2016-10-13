package demo.model.vo;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column (name = "id")
	private int id;
	
	@Column (name = "address_line_1")
	private String line_1;

	@Column (name = "address_line_2")
	private String line_2;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLine_1() {
		return line_1;
	}

	public void setLine_1(String line_1) {
		this.line_1 = line_1;
	}

	public String getLine_2() {
		return line_2;
	}

	public void setLine_2(String line_2) {
		this.line_2 = line_2;
	}

	public Address() {
		super();
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", line_1=" + line_1 + ", line_2="
				+ line_2 + "]";
	}

}
