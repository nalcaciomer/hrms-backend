package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidate_cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCvEducations", "candidateCvExperiences", "candidateCvLanguages"})
public class CandidateCv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
	private Candidate candidate;

	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvEducation> candidateCvEducations;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvExperience> candidateCvExperiences;
	
	@OneToMany(mappedBy = "candidateCv")
	private List<CandidateCvLanguage> candidateCvLanguages;
}
