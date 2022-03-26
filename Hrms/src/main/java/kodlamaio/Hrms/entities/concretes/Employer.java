package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@OneToOne(mappedBy = "employer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private EmployeeVerification employeeVerification;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisements;
	
}
