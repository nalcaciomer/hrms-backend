package kodlamaio.Hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employeeVerifications"})
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName = "id")
public class Employee extends User{
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@NotBlank
	@Size(max = 100)
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "employee")
	private List<EmployeeVerification> employeeVerifications;
	
}
