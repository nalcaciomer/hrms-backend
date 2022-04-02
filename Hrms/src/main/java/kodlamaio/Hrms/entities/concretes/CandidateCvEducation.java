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
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department_name")
	private String departmentName;
	
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@Column(name = "date_of_graduation")
	private LocalDate dateOfGraduation;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCv candidateCv;

}
