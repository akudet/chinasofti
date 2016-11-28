package team4.proj2.model.vo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Product extends ValueObject {

	private String name;

	@Column(name="prod_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

}
