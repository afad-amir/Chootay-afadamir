package chootay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="customer",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String contact;
	private String address;
	private String bikeinfo;
	
	
	public customer() {
		super();
		
	}
	public customer(String name, String contact, String address, String bikeinfo) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.bikeinfo = bikeinfo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBikeinfo() {
		return bikeinfo;
	}
	public void setBikeinfo(String bikeinfo) {
		this.bikeinfo = bikeinfo;
	} 
	
	
}
