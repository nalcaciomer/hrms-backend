package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
    private Employee employee;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id")
    private Employer employer;
	
}
