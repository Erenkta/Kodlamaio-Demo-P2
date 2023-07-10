package kodlamaio.devs.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Languages")
public class ProgrammingLanguage { //one to many
	@Id //
	@GeneratedValue(strategy = GenerationType.AUTO) //auto generate ettik
	@Column(name = "Id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "language")
	private List<LanguageTechnology> technologies;
}
