package team4.proj2.model.vo.prod;

import javax.persistence.Column;
import javax.persistence.Entity;

import team4.proj2.model.vo.ValueObject;

@Entity
public class Product extends ValueObject {

	private String name;
	/** how many items of this product is selled" */
	private long sells;

	@Column(name = "prod_name")
	public String getName() {
		return name;
	}

	@Column(name = "prod_sell")
	public long getSells() {
		return sells;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSells(long sells) {
		this.sells = sells;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

}
