package kodlamaio.devs.demo.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.devs.demo.business.abstracts.ProgrammingLanguageService;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.AddLanguageRequest;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.DeleteLanguageRequest;
import kodlamaio.devs.demo.business.requests.programmingLanguageRequests.UpdateLanguageRequest;
import kodlamaio.devs.demo.business.responses.programmingLanguageResponses.GetAllLanguage;

@RestController
@RequestMapping("/api/language") // bu iki madde api oluşturmak içindi
public class ProgrammingLanguageController {
	
	private ProgrammingLanguageService languageService;
 
	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<GetAllLanguage> getAll(){
		return languageService.listLanguage();
	}
	
	@PostMapping("/addlanguage")
	public void add(AddLanguageRequest addLanguageRequest) throws Exception {
		languageService.addLanguage(addLanguageRequest);
	}
	@DeleteMapping("/deletelanguage")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageService.deleteLanguage(deleteLanguageRequest);
	}
	@PutMapping("/updatelanguage")
	public void update(int id,UpdateLanguageRequest updateLanguageRequest) {
		languageService.updateLanguage(updateLanguageRequest,id);
	}


}
