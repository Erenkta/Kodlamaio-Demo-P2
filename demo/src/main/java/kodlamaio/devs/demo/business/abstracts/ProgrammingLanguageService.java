package kodlamaio.devs.demo.business.abstracts;

import java.util.List;

import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.AddLanguageRequest;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.DeleteLanguageRequest;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.UpdateLanguageRequest;
import kodlamaio.devs.demo.business.responses.programmingLanguageResponses.GetAllLanguage;

public interface ProgrammingLanguageService {
	public void addLanguage(AddLanguageRequest addLanguageRequest) throws Exception;
	public void deleteLanguage(DeleteLanguageRequest deleteLanguageRequest);
	public void updateLanguage(UpdateLanguageRequest updateLanguageRequest,int id);
	public List<GetAllLanguage> listLanguage();
}
