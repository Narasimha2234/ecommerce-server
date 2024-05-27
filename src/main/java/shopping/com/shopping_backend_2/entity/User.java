package shopping.com.shopping_backend_2.entity;

import java.util.List;

import javax.management.relation.Role;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
//	@Column(unique = true)
	private String email;
	private String name;
	@Enumerated(EnumType.STRING)
	private shopping.com.shopping_backend_2.config.Role role;
	private String password;
	@OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
	 @JsonIgnore
	private List<Products> products;
}
