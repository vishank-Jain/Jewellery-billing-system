package jewellry_billing_system.jewellry_billing_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Customer {

	@Id
	private int c_id;
	private String c_name;
	private Long c_mobileNo;
	
	
	
}
	