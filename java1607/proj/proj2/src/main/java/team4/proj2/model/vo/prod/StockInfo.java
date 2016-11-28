package team4.proj2.model.vo.prod;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import team4.proj2.model.vo.ValueObject;

@Entity
public class StockInfo extends ValueObject {

	int stock;
	float price;
	Product product;
	Seller seller;

	public float getPrice() {
		return price;
	}

	@ManyToOne
	@JoinColumn(name="prod_id")
	public Product getProduct() {
		return product;
	}

	@ManyToOne
	@JoinColumn(name="sell_by")
	public Seller getSeller() {
		return seller;
	}

	public int getStock() {
		return stock;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "StockInfo [stock=" + stock + ", price=" + price + ", product="
				+ product + ", seller=" + seller + "]";
	}

}
