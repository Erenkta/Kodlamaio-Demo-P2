package kodlamaio.devs.demo.business.abstracts;

import java.util.List;

import kodlamaio.devs.demo.business.requests.languageTechnologyRequests.AddTechnologyRequest;
import kodlamaio.devs.demo.business.requests.languageTechnologyRequests.DeleteTechnologyRequest;
import kodlamaio.devs.demo.business.requests.languageTechnologyRequests.UpdateTechnologyRequest;
import kodlamaio.devs.demo.business.responses.languageTechnologyResponses.GetAllTechnology;

public interface LanguageTechnologyService {
	public void addTechnology(AddTechnologyRequest addTechnologyRequest);
	public void deleteTechnology(DeleteTechnologyRequest deleteTechnologyRequest);
	public void updateTechnology(UpdateTechnologyRequest updateTechnologyRequest,int id);
	public List<GetAllTechnology> listTechnology();
}
