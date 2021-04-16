package chootay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user_role",uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private Long user_id;
	private Long role_id;
	
	public UserRole() {
		super();
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public UserRole(Long user_id, Long role_id) {
		super();
		this.user_id = user_id;
		this.role_id = role_id;
	}
}
