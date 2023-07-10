package kodlamaio.devs.demo.business.responses.programmingLanguageResponses;

import java.util.List;

import kodlamaio.devs.demo.entities.LanguageTechnology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllLanguage {
	private int id;
	private String name;
	private List<LanguageTechnology> technologies;
}
