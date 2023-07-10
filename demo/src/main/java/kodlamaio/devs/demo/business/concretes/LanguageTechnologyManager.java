package kodlamaio.devs.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.devs.demo.business.abstracts.LanguageTechnologyService;
import kodlamaio.devs.demo.business.requests.languageTechnologyRequests.AddTechnologyRequest;
import kodlamaio.devs.demo.business.requests.languageTechnologyRequests.DeleteTechnologyRequest;
import kodlamaio.devs.demo.business.requests.languageTechnologyRequests.UpdateTechnologyRequest;
import kodlamaio.devs.demo.business.responses.languageTechnologyResponses.GetAllTechnology;
import kodlamaio.devs.demo.dataAccess.abstracts.LanguageTechnologyRepository;
import kodlamaio.devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.devs.demo.entities.LanguageTechnology;
import kodlamaio.devs.demo.entities.ProgrammingLanguage;

@Service
public class LanguageTechnologyManager implements LanguageTechnologyService{

	LanguageTechnologyRepository techRepository;
	ProgrammingLanguageRepository languageRepository;
	LanguageTechnology languageTechnology = new LanguageTechnology();
	
	@Autowired
	public LanguageTechnologyManager(LanguageTechnologyRepository languagesTechnologyRepository,ProgrammingLanguageRepository programmingLanguageRepository) {
		this.techRepository = languagesTechnologyRepository;
		this.languageRepository=programmingLanguageRepository;
	}

	@Override
	public void addTechnology(AddTechnologyRequest addTechnologyRequest) {

		ProgrammingLanguage programmingLanguage = languageRepository.getReferenceById(addTechnologyRequest.getLanguageId());
		languageTechnology.setLanguage(programmingLanguage);
		languageTechnology.setName(addTechnologyRequest.getName());
		techRepository.save(languageTechnology);
		
	}

	@Override
	public void deleteTechnology(DeleteTechnologyRequest deleteTechnologyRequest) {
		techRepository.deleteById(deleteTechnologyRequest.getId());
		
	}

	@Override
	public void updateTechnology(UpdateTechnologyRequest updateTechnologyRequest, int id) {
		languageTechnology = techRepository.getReferenceById(id);
		languageTechnology.setLanguage(languageRepository.getReferenceById(updateTechnologyRequest.getLanguageId()));
		languageTechnology.setName(updateTechnologyRequest.getName());
		techRepository.save(languageTechnology);
	}

	@Override
	public List<GetAllTechnology> listTechnology() {
		List<LanguageTechnology> techList = techRepository.findAll();
		List<GetAllTechnology> responseList = new ArrayList<GetAllTechnology>();
		for(LanguageTechnology tech : techList) {
			GetAllTechnology responseItem = new GetAllTechnology();
			responseItem.setId(tech.getId());
			responseItem.setLanguageId(tech.getLanguage().getId());
			responseItem.setName(tech.getName());
			
			
			responseList.add(responseItem);
		}
		return responseList;
	}


}
