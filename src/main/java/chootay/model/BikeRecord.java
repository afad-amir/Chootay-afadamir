package chootay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="bike_records",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class BikeRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long customer_id;
	private String bike_model;
	private String service_deescription;
	private Long service_charges;
	
	
	public BikeRecord() {
		super();
		
	}
	public BikeRecord(Long customer_id, String bike_model, String service_deescription, Long service_charges) {
		super();
		this.customer_id = customer_id;
		this.bike_model = bike_model;
		this.service_deescription = service_deescription;
		this.service_charges = service_charges;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public String getBike_model() {
		return bike_model;
	}
	public void setBike_model(String bike_model) {
		this.bike_model = bike_model;
	}
	public String getService_deescription() {
		return service_deescription;
	}
	public void setService_deescription(String service_deescription) {
		this.service_deescription = service_deescription;
	}
	public Long getService_charges() {
		return service_charges;
	}
	public void setService_charges(Long service_charges) {
		this.service_charges = service_charges;
	} 
}
