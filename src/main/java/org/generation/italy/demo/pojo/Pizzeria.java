package org.generation.italy.demo.pojo;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Pizzeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull(message="Il contenuto non può essere null")
	@NotEmpty(message="L'immagine deve contenere qualcosa")
	@Size(min=3, message="Deve contenere almeno 3 caratteri")
	@Column
	private String name;
	
	@NotNull(message="Il contenuto non può essere null")
	@NotEmpty(message="L'immagine deve contenere qualcosa")
	@Size(min=5, message="Deve contenere almeno tre caratteri")
	@Column
	private String img;
	
	@NotNull(message="Il contenuto non può essere null")
	@Min(value=6)
	@Column
	private Integer price;
	
	@NotNull(message="Il contenuto non può essere null")
	@NotEmpty(message="L'immagine deve contenere qualcosa")
	@Size(min=5, message="Deve contenere almeno 5 caratteri")
	@Column
	private String description;
	
	public Pizzeria() {
		
	}
	public Pizzeria(String name, String img, Integer price, String description) {
		setName(name);
		setImg(img);
		setPrice(price);
		setDescription(description);
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}


