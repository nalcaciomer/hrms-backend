package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements", "employeeVerification"})
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Employer extends User{
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "website")
	private String website;

	@NotNull
	@NotBlank
	@Size(min = 11, max = 11)
	@Pattern(regexp = "^\\d{11}$")
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne(mappedBy = "employer")
	private EmployeeVerification employeeVerification;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
}
