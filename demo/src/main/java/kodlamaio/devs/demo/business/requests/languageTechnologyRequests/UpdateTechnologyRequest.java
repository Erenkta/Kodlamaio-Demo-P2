package kodlamaio.devs.demo.business.requests.languageTechnologyRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTechnologyRequest {
	private String name;
	private int languageId;
}
