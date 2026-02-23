package acceso.myshop.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import acceso.myshop.models.Product;
import acceso.myshop.models.*;
import acceso.myshop.services.EntrenadorService;
import acceso.myshop.services.EquipoService;
import acceso.myshop.services.JuegoService;
import acceso.myshop.services.ProductService;
import exceptions.EntrenadorNotFoundException;
import exceptions.ProductNotFoundException;

@Controller
@RequestMapping("/miweb")

public class WebController {
	@Autowired
	private ProductService productService;
	@Autowired
	private EntrenadorService entreservice;
	@Autowired
	private EquipoService equiservice;
	@Autowired
	private JuegoService juegoservice;

	@RequestMapping("/") 
	public String index(Model model) {
		return "index";
	}

	@PostMapping("/producto")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product addedProduct = productService.createProduct(product);
		return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
	}
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product) {
		Product addedProduct = productService.updatenameProduct(id,product);
		return new ResponseEntity<>(addedProduct, HttpStatus.ACCEPTED);
	}
	

	@RequestMapping("/lista")
	public String catalog(Model model) {
		List<Product> productos = productService.findAll();
		model.addAttribute("productos", productos);
		return "lista";
	}
	
    // Método para obtener un producto por ID
    @GetMapping("/producto/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Product product = productService.findProductById(id);
    	model.addAttribute("detalleProducto", product);
        return "detalle";
    }
    
    //Entrenadores
    
    @RequestMapping("/listaentrenadores")
    public String listaentrenadores(Model model) {
		List<Entrenador> Entrenador = entreservice.findAll();
		model.addAttribute("entrenador", Entrenador);
		return "entrenadores";
	}
    
    @PostMapping("/entrenador")
	public ResponseEntity<Entrenador> addEntrenador(@RequestBody Entrenador entrenador) {
    		Entrenador addedEntrenador = entreservice.createEntrenador(entrenador);
		return new ResponseEntity<>(addedEntrenador, HttpStatus.CREATED);
	}
    @PutMapping("/entrenador/{id}")
	public ResponseEntity<Entrenador> updateEntrenador(@PathVariable Long id,@RequestBody Entrenador entrenador) {
		Entrenador addedentre = entreservice.updatenameEntrenador(id,entrenador);
		return new ResponseEntity<>(addedentre, HttpStatus.ACCEPTED);
	}
    
   
    
    
	
	@ExceptionHandler(EntrenadorNotFoundException.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Response> handleException(EntrenadorNotFoundException pnfe) {
	        Response response = Response.errorResonse(Response.NOT_FOUND, pnfe.getMessage());
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	 }
	
	 //Equipo
	
	@PostMapping("/equipo")
	@ResponseBody 
	public String addEquipo(@RequestBody Equipo equipo) {
		Equipo addedEquipo = equiservice.createEquipo(equipo);
		String a  = ("se ha añadido al equipo" + addedEquipo);
		return a;
	}
	
	@RequestMapping("/listaequipos")
    public String listaequipos(Model model) {
		List<Equipo> equipo = equiservice.findAll();
		model.addAttribute("equipo", equipo);
		return "equipos";
	}
	
	//Juego
	
	@RequestMapping("/listajuegos")
    public String listajuegos(Model model) {
		List<Juego> juego = juegoservice.findAll();
		model.addAttribute("juego", juego);
		return "juegos";
	}
	
	
	
	@GetMapping("/juego/{nombre}")
	@ResponseBody
    public Map<String, Juego> getJuegoByNombre(@PathVariable String nombre, Model model) {
		Map<String, Juego> respuesta = new HashMap<>();
        Juego juego = juegoservice.findByNombre(nombre);
        	respuesta.put("Juego",juego);
        return respuesta;
    }

	
}
