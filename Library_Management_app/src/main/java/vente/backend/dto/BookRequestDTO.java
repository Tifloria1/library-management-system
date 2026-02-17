package vente.backend.dto;




import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Min;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class BookRequestDTO {
	
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String author;
	
    @NotBlank
	private String isbn;
	
	@Min(1000)
	private int publicationYear;
	
	@NotNull
	private Boolean available ;

}
