package acceso.myshop.models;





import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "equipos")
public class Equipo {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    @Column
	    private String nombre;
	    @Column
	    private String region;
	    @ManyToMany(mappedBy = "equiposParticipantes")
	    private List<Juego> juegos = new ArrayList<>();
}
