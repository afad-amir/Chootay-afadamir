package chootay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="inventory",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long itemid;
	private Long item_count_in_stock;
	private Long last_stock_in;
	
	public Inventory(Long itemid, Long item_count_in_stock, Long last_stock_in) {
		super();
		this.itemid = itemid;
		this.item_count_in_stock = item_count_in_stock;
		this.last_stock_in = last_stock_in;
	}
	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getItemid() {
		return itemid;
	}
	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}
	public Long getItem_count_in_stock() {
		return item_count_in_stock;
	}
	public void setItem_count_in_stock(Long item_count_in_stock) {
		this.item_count_in_stock = item_count_in_stock;
	}
	public Long getLast_stock_in() {
		return last_stock_in;
	}
	public void setLast_stock_in(Long last_stock_in) {
		this.last_stock_in = last_stock_in;
	}
	
}
