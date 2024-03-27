package net.javaguides.springboot.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name="orders")
@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	private String orderTrackingNumber;
	private int totalQuantity;
	private BigDecimal totalPrice;
	private String status;
	
	@CreationTimestamp
	private LocalDateTime dateCreated;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdated;
	private Long shoppingCartId;
}
