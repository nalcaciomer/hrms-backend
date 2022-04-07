package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employee_verifications")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVerification {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@PastOrPresent
	@Column(name = "created_at", columnDefinition = "Date default " + "CURRENT_TIMESTAMP")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "employee_id")
    private Employee employee;
	
	@NotNull
	@OneToOne()
	@JoinColumn(name = "employer_id")
    private Employer employer;
	
}
