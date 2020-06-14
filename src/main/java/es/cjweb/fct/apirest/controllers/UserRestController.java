package es.cjweb.fct.apirest.controllers;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import es.cjweb.fct.apirest.models.entity.Cita;
import es.cjweb.fct.apirest.models.entity.Ranking;
import es.cjweb.fct.apirest.models.entity.Role;
import es.cjweb.fct.apirest.models.entity.Usuario;
import es.cjweb.fct.apirest.models.services.IRankingService;
import es.cjweb.fct.apirest.models.services.IUserService;

@CrossOrigin(origins= {"http://localhost:4200","http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRankingService rankService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/clientes",method=RequestMethod.GET)
	public List<Usuario> findAll(){
		return this.userService.findAll();
	}
	

	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/clientes/{id}",method=RequestMethod.GET)
	public Usuario findById(@PathVariable("id") Integer id){
		//prueba cambiandole el codigo del ranking a un usuario
		/*if (id==2) {
			User uno = this.userService.findById(1);
			uno.setCod_rank(1);
			
			this.userService.save(uno);
		}*/
		
		return this.userService.findById(id);
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/clientes/maspelaos",method=RequestMethod.GET)
	public List<Usuario> findTop3ByOrderByCantidadDesc(){
		
		return this.userService.findTop3ByOrderByCantidadDesc();
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/clientes/maspelaos/ranking",method=RequestMethod.GET)
	public List<Usuario> findAllByOrderByCantidadDesc(){
		
		return this.userService.findAllByOrderByCantidadDesc();
	}
	
	
	@RequestMapping(value="/clientes",method=RequestMethod.POST, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE},
			consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })	
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		usuario.setVerify(true);
		
		List<Ranking> rank = rankService.findAll();
		Ranking create = new Ranking();
		int valorMin = 0;
		
		for (Ranking ranking : rank) {
			if (ranking.getPosicion() > valorMin) {
				valorMin = ranking.getPosicion();
			}
		}
		valorMin++;
		create.setPosicion(valorMin);
		this.rankService.save(create);
		usuario.setCod_rank(valorMin);
		
		usuario.setRoles(new Role(1));
		usuario.setVerify(true);
		
		
		Usuario usuarioNew = null;
		Map<String,Object> response = new HashMap<>();
		
		try {
			 
			 if (usuario.getPass() == null || usuario.getPass() == "") {
				 
				 response.put("mensaje","Error al crear su usuario, la contraseña no puede estar vacía.");
				 
			}else {
				usuario.setPass(passwordEncoder.encode(usuario.getPass()));
				
			}
			
			 response.put("mensaje","El usuario ha sido creado con éxito!");
				response.put("usuario",usuarioNew);
				if (usuario.getNombre().length()==0) {
					response.put("mensaje","Error al crear su usuario, el nombre no puede estar vacío.");
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}else if(usuario.getPass() == "" || usuario.getPass() == null) {
					response.put("mensaje","Error al crear su usuario, la contraseña no puede estar vacía.");
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
				}
				else {
					usuarioNew = this.userService.save(usuario);
					return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
				}
		
		} catch (DataAccessException e) {
			
			
			response.put("mensaje","Error al crear su usuario, el correo o telefono proporcionado ya existe");
			
		
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	@Secured({"ROLE_ADMIN","ROLE_USER"})
	@RequestMapping(value="/clientes/{id}",method=RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Integer id){
		Map<String,Object> response = new HashMap<>();
		
		Usuario usuarioNew = null;
		try {
			Usuario usuarioActual = userService.findById(id);
			usuarioActual.setNombre(usuario.getNombre());
			usuarioActual.setApellidos(usuario.getApellidos());
			usuarioActual.setEmail(usuario.getEmail());
			usuarioActual.setDireccion(usuario.getDireccion());
			usuarioActual.setMovil(usuario.getMovil());
			usuarioActual.setVerify(usuario.isVerified());
			usuarioNew = this.userService.save(usuarioActual);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al modificar su usuario, el correo o telefono proporcionado ya existe");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","Los datos se han modificado con éxito!");
		response.put("usuario",usuarioNew);
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
	}
	
	// @Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/clientes/{id}",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id){
		Usuario usuario = userService.findById(id);
		String nombreFotoAnterior = usuario.getFoto();
		
		if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
			Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
			}
		}
		
		this.userService.deleteById(id);
	}
	
	
	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Integer id){
		
		
		Map<String,Object> response = new HashMap<>();
		
		Usuario usuario = userService.findById(id);
		
		if (!archivo.isEmpty()) {
			// Con el randomUUID, le asignamos un identificador unico aleatorio al nombre del archivo,
			// es decir seria 111_nombreArchivo, por ejemplo.
			String nombreArchivo = UUID.randomUUID().toString() + "_" +archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("src/main/resources/uploads").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				// copiamos el archivo subido al servidor a la ruta escogida
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {				
				response.put("mensaje","Error al subir la foto.");
				response.put("error",e.getMessage().concat(":").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			String nombreFotoAnterior = usuario.getFoto();
			
			if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
				File archivoFotoAnterior = rutaFotoAnterior.toFile();
				if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
					archivoFotoAnterior.delete();
				}
			}
			
			usuario.setFoto(nombreArchivo);
			userService.save(usuario);
			response.put("usuario", usuario);
			response.put("mensaje","Has subido correctamente la imagen:" + nombreArchivo);
		}
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(value="/clientes/img/{nombreFoto:.+}",method=RequestMethod.GET)
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto){
		Path rutaArchivo = Paths.get("src/main/resources/uploads").resolve(nombreFoto).toAbsolutePath();
		Resource recurso = null;
		
		try {
			recurso = new UrlResource(rutaArchivo.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		if (recurso.exists() && !recurso.isReadable()) {
			throw new RuntimeException("Error no se pudo cargar la imagen: " + nombreFoto);
		}
		
		HttpHeaders cabecera = new HttpHeaders();
		cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");
		
		// El recurso seria la url de la foto, la cabecera seria el httpheader con el content disposition para forzar la descarga y el codigo de estado OK
		return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
	}
	
}
