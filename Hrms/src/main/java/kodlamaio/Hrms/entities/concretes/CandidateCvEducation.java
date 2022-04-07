package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_cv_educations")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvEducation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "school_name")
	private String schoolName;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "department_name")
	private String departmentName;
	
	@NotNull
	@Past
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Past
	@Column(name = "date_of_graduation")
	private LocalDate dateOfGraduation;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCv candidateCv;

}
