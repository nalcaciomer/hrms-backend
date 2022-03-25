package kodlamaio.Hrms.business.adapters.mernis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonForMernisCheckService {
	
	private long TCKimlikNo;
	
	private String ad;
	
	private String soyad;
	
	private int dogumYili;

}
