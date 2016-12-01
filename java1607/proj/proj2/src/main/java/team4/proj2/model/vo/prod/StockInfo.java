package team4.proj2.model.vo.prod;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import team4.proj2.model.vo.ValueObject;

@Entity
public class StockInfo extends ValueObject {

	int stock;
	float price;
	Product product;
	Seller seller;
	private float discount;

	@Column(name = "stock_discount")
	public float getDiscount() {
		return discount;
	}

	@Column(name = "stock_price")
	public float getPrice() {
		return price;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "prod_id")
	public Product getProduct() {
		return product;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "sell_by")
	public Seller getSeller() {
		return seller;
	}

	@Column(name = "stock_amount")
	public int getStock() {
		return stock;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
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
		return "StockInfo [stock=" + stock + ", price=" + price + ", discount="
				+ discount + "]";
	}

}
