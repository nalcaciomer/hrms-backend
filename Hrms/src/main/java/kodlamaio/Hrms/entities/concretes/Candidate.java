package kodlamaio.Hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidateCv"})
public class Candidate extends User{

	@NotNull
	@NotBlank
	@Pattern(regexp = "^\\d{11}$", message = "National identity must be 11 digits")
	@Column(name = "national_identity")
	private String nationalIdentity;
	
	@NotNull
	@NotBlank
	@Size(max = 50)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Size(max = 50)
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull
	@Past
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	@OneToOne(mappedBy = "candidate")
	private CandidateCv candidateCv;
}
