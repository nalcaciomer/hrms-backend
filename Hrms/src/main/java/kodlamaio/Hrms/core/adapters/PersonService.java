package kodlamaio.Hrms.core.adapters;

import kodlamaio.Hrms.core.utilities.results.Result;

public interface PersonService {
	Result checkIfRealPerson(String ad, String soyad, int dogumYili, long TcKimlikNo);
}
