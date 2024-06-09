package eu.fr.indyli.formation.transactionnel.ecolis.controller;

import java.nio.file.AccessDeniedException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.fr.indyli.formation.business.dto.EcolisUserBasicDTO;
import eu.fr.indyli.formation.business.dto.EcolisUserFullDTO;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IEcolisUserService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;

@RestController
@RequestMapping("/users")
public class EcolisUserRestController {

	@Resource(name = EcolisConstantesService.USER_SERVICE_KEY)
	IEcolisUserService userService;

	@RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<EcolisUserBasicDTO> listUsers() {
		return this.userService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> creerNewUser(@RequestBody EcolisUserFullDTO user) throws EcolisBusinessException {

		if(StringUtils.isBlank(user.getEmail()) || StringUtils.isBlank(user.getLogin())) {
			return ResponseEntity.status(HttpStatus.PRECONDITION_REQUIRED) 
					.body("L'email ou le login semble non renseigné...");
		}

		return ResponseEntity.ok(this.userService.create(user));
	}

	@PutMapping(value = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EcolisUserFullDTO> updateOneUser(@RequestBody EcolisUserFullDTO user, @PathVariable("userId") Integer userId) throws EcolisBusinessException, AccessDeniedException {

		EcolisUserFullDTO userFull = this.userService.findById(userId);
		if (userFull == null) {
			return ResponseEntity.notFound().build(); 
		}

		EcolisUserFullDTO updateNewUser = this.userService.update(user);
		return ResponseEntity.ok().body(updateNewUser);
	}

	@RequestMapping(value="/{userId}",method = RequestMethod.DELETE)
	public ResponseEntity<EcolisUserBasicDTO> deleteUserById(@PathVariable Integer userId) throws AccessDeniedException, EcolisBusinessException  {
		this.userService.deleteById(userId);
		return ResponseEntity.ok().build(); 
	}

	@RequestMapping(value="/{userId}",method = RequestMethod.GET)
	public EcolisUserFullDTO findUser(@PathVariable Integer userId) throws EcolisBusinessException  {
		return this.userService.findById(userId);
	}
}
