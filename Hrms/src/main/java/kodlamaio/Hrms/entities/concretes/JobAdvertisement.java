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
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

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
	
	@NotNull
	@NotBlank
	@Size(max = 300)
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Min(1)
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@PastOrPresent
	@Column(name = "created_at", columnDefinition = "Date default " + "CURRENT_TIMESTAMP")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@NotNull
	@Future
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	
	@PositiveOrZero
	@Column(name = "min_salary")
	private int minSalary;
	
	@PositiveOrZero
	@Column(name = "max_salary")
	private int maxSalary;
	
	@Column(name = "is_active" , columnDefinition = "boolean default true")
	private boolean isActive = true;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "job_id")
	private Job job;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

}
