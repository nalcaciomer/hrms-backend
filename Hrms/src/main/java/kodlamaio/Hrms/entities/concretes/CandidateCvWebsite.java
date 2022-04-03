package kodlamaio.Hrms.entities.concretes;

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
@Table(name = "candidate_cv_websites")
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCvWebsite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "address")
	private String address;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCv candidateCv;
	
	@ManyToOne()
	@JoinColumn(name = "website_id")
	private Website website;
}
