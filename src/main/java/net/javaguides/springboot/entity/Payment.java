package net.javaguides.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="payments")
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String type;
	private String cardName;
	private String cardNumber;
	private int expiryYear;
	private int expiryMonth;
	private int cvc;
	private Long orderId;
}
