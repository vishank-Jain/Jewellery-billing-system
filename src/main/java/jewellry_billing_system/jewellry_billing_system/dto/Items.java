package jewellry_billing_system.jewellry_billing_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Items {
	
   @Id	
   private int i_id;
   private String i_name;
   private double price;
}
