package acceso.myshop.security;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import acceso.myshop.services.UsuarioService;
import acceso.myshop.utiles.JWTutility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
	private static final Logger logger = LogManager.getLogger(AuthTokenFilter.class);
   @Autowired 
   private JWTutility jwtUtils;
   @Autowired
   private UsuarioService usuarioService;

   private String parseJwt(HttpServletRequest request) {
   	String resultado = null;
       String headerAuth = request.getHeader("Authorization");
       System.out.println("FILTRO - Authorization header: " + headerAuth);
       if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
       	resultado = headerAuth.substring(7);
       }
       System.out.println("FILTRO - JWT extraído: " + resultado);
       return resultado;
   }

   @Override
   protected void doFilterInternal( HttpServletRequest request,  HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
   	System.out.println("FILTRO - URL: " + request.getRequestURI());
   	try {
           String jwt = parseJwt(request);
           if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
               String username = jwtUtils.getUsernameFromToken(jwt);
               System.out.println("FILTRO - Usuario extraído del token: " + username);
               UserDetails userDetails = usuarioService.loadUserByUsername(username); 
               UsernamePasswordAuthenticationToken authentication =
                       new UsernamePasswordAuthenticationToken(
                               userDetails,
                               null,
                               userDetails.getAuthorities()
                       );
               authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(authentication);
               System.out.println("FILTRO - Autenticación establecida para: " + username);
           } else {
               System.out.println("FILTRO - Sin token válido, continuando sin autenticar");
           }
       } catch (Exception e) {
           logger.error("Cannot set user authentication: " + e);
       }
       filterChain.doFilter(request, response);
   }
   
   @Override
   protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
       return request.getRequestURI().startsWith("/miweb/auth/");
   }
}