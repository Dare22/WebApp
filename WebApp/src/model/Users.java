package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import validation.PasswordMatches;
import validation.ValidEmail;

@PasswordMatches(first = "password", second = "confirmpass", errorMessage = "{PasswordMatches.users.confirmpass}")
@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Size(min = 4, max = 20)
	@Column(name = "username")
	private String username;

	@Size(min = 8, max = 20)
	@Pattern(regexp = "^\\S+$")
	@Column(name = "password")
	private String password;

	@Column(name = "confirmpass")
	private String confirmpass;

	@NotEmpty
	@Column(name = "name")
	private String name;

	@ValidEmail
	@Column(name = "email")
	private String email;

	@Column(name = "enabled")
	private boolean enabled = true;

	@NotEmpty
	@Column(name = "authority")
	private String authority;

	public Users() {

	}

	public Users(int id, String username, String password, String confirmpass, String name, String email,
			boolean enabled, String authority) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.confirmpass = confirmpass;
		this.name = name;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", confirmpass=" + confirmpass
				+ ", name=" + name + ", email=" + email + ", enabled=" + enabled + ", authority=" + authority + "]";
	}

}