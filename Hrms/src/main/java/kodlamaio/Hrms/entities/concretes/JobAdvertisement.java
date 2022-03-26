package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "is_active")
	private boolean isActive;

}
