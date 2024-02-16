package eu.fr.indyli.formation.transactionnel.ecolis.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.fr.indyli.formation.business.dto.UtilisateurBasicDTO;
import eu.fr.indyli.formation.business.dto.UtilisateurFullDTO;
import eu.fr.indyli.formation.business.ecolis.exception.EcolisBusinessException;
import eu.fr.indyli.formation.business.ecolis.service.IUtilisateurService;
import eu.fr.indyli.formation.business.utils.EcolisConstantes.EcolisConstantesService;

@RestController
@RequestMapping("/users")
public class UtilisateurRestController {

  @Resource(name = EcolisConstantesService.USER_SERVICE_KEY)
  IUtilisateurService userService;

  
  @RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
  public List<UtilisateurBasicDTO> findAllUsers() {
		return this.userService.findAll();
  }

  @RequestMapping(value="/{userId}",method = RequestMethod.GET)
  public UtilisateurFullDTO findUser(@PathVariable Integer userId) throws EcolisBusinessException  {
	return this.userService.findById(userId);
  }
}
