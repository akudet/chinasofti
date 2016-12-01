package team4.proj2.model.vo.prod;

import javax.persistence.Column;
import javax.persistence.Entity;

import team4.proj2.model.vo.ValueObject;

@Entity
public class Seller extends ValueObject {

	private String name;

	@Column(name = "seller_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Seller [name=" + name + "]";
	}

}
