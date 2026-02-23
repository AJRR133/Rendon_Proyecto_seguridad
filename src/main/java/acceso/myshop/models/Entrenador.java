package acceso.myshop.models;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "entrenadores")
public class Entrenador {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    @Column
	    private String nombre;
	    @Column
	    private int experiencia;
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "idEntrenador")
	    private List<Equipo> equiposAsignados = new ArrayList<>();
	      
		
}
		
		