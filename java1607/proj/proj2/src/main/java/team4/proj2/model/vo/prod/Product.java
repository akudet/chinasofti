package team4.proj2.model.vo.prod;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import team4.proj2.model.vo.ValueObject;

@Entity
public class Product extends ValueObject {

	private String name;
	/** how many items of this product is selled" */
	private long sells;
	private String type;
	private Date onSaleTime;

	@Column(name = "prod_name")
	public String getName() {
		return name;
	}

	@Column(name = "on_sale_time")
	public Date getOnSaleTime() {
		return onSaleTime;
	}

	@Column(name = "prod_sell")
	public long getSells() {
		return sells;
	}

	@Column(name = "prod_type")
	public String getType() {
		return type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOnSaleTime(Date onSaleTime) {
		this.onSaleTime = onSaleTime;
	}

	public void setSells(long sells) {
		this.sells = sells;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + "]";
	}

}
