package kodlamaio.devs.demo.business.responses.languageTechnologyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnology {
	private int id;
	private String name;
	private int languageId;
}
