package chootay.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="sales",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Sales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long sold_item_code;
	private Long sale_count;
	private Long charged_amount;
	private String sale_person;
	@Column(name="datetime")
	private java.util.Date date;
	
	public Sales(Long sold_item_code, Long sale_count, Long charged_amount, String sale_person) {
		super();
		Date date =new Date(); 
		this.sold_item_code = sold_item_code;
		this.sale_count = sale_count;
		this.charged_amount = charged_amount;
		this.sale_person = sale_person;
		this.date = date;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public Sales() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSold_item_code() {
		return sold_item_code;
	}
	public void setSold_item_code(Long sold_item_code) {
		this.sold_item_code = sold_item_code;
	}
	public Long getSale_count() {
		return sale_count;
	}
	public void setSale_count(Long sale_count) {
		this.sale_count = sale_count;
	}
	public Long getCharged_amount() {
		return charged_amount;
	}
	public void setCharged_amount(Long charged_amount) {
		this.charged_amount = charged_amount;
	}
	public String getSale_person() {
		return sale_person;
	}
	public void setSale_person(String sale_person) {
		this.sale_person = sale_person;
	}
	
	
	
}
