package kodlamaio.Hrms.core.adapters;

//import java.util.Locale;

import org.springframework.stereotype.Service;

//import kodlamaio.Hrms.core.utilities.results.ErrorResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.core.utilities.results.SuccessResult;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements PersonService {

	@Override
	public Result checkIfRealPerson(String ad, String soyad, int dogumYili, long TcKimlikNo){
		/*
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		boolean result = false;
		
		try {
			result = client.TCKimlikNoDogrula(TcKimlikNo, ad.toUpperCase(new Locale("tr")),
					soyad.toUpperCase(new Locale("tr")), dogumYili);
		} catch (Exception e) {
			e.printStackTrace();
		}
				

		return result ? new SuccessResult() : new ErrorResult("Not a valid person!");
		*/
		
		return new SuccessResult();
	}

}
