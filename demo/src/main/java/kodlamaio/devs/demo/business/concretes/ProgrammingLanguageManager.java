package kodlamaio.devs.demo.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.devs.demo.business.abstracts.ProgrammingLanguageService;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.AddLanguageRequest;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.DeleteLanguageRequest;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.UpdateLanguageRequest;
import kodlamaio.devs.demo.business.responses.programmingLanguageResponses.GetAllLanguage;
import kodlamaio.devs.demo.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlamaio.devs.demo.entities.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	ProgrammingLanguageRepository langRepository;
	List<ProgrammingLanguage> languages = new ArrayList<ProgrammingLanguage>();
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository langRepository) {
		this.langRepository = langRepository;
	}

	@Override
	public void addLanguage(AddLanguageRequest addLanguageRequest) throws Exception {
		languages = langRepository.findAll();

		
		for(ProgrammingLanguage lang : languages) {
			if(lang.getName().equalsIgnoreCase(addLanguageRequest.getName())) {
				throw new Exception("Name cannot duplicate !!");
			}
		}
		ProgrammingLanguage Referencelanguage = new ProgrammingLanguage();
		Referencelanguage.setName(addLanguageRequest.getName());
		languages.add(Referencelanguage);
		langRepository.save(Referencelanguage);
		
	}

	@Override
	public void deleteLanguage(DeleteLanguageRequest deleteLanguageRequest) {
		langRepository.delete(langRepository.getReferenceById(deleteLanguageRequest.getId()));
		
	}

	@Override
	public void updateLanguage(UpdateLanguageRequest updateLanguageRequest,int id) {
		ProgrammingLanguage referenceItem = langRepository.getReferenceById(id);
		referenceItem.setName(updateLanguageRequest.getName());
		languages.add(referenceItem);
		langRepository.save(referenceItem);
		
	}

	@Override
	public List<GetAllLanguage> listLanguage() 
	{
		List<ProgrammingLanguage> languageList = langRepository.findAll();
		List<GetAllLanguage> responseList = new ArrayList<GetAllLanguage>();
		
		for(ProgrammingLanguage lang : languageList) {
			GetAllLanguage referenceResponse = new GetAllLanguage();
			
			referenceResponse.setId(lang.getId());
			
			referenceResponse.setName(lang.getName());
			
			referenceResponse.setTechnologies(lang.getTechnologies());
			
			responseList.add(referenceResponse);
		}
		return responseList;
	}



}
