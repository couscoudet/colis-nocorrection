package eu.fr.insee.formation.transactionnel.ecolis.test;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import eu.fr.indyli.formation.business.dto.EcolisUserBasicDTO;

public class UserDbRestControllerTest {

	public final static String ECOLIS_URI_PREFIX = "http://localhost:8081/ecolis-ws";
	@Test
	public void testGetUserById() throws Exception {
	  Integer id = 2;
	  EcolisUserBasicDTO foundUser = new RestTemplate().getForObject(ECOLIS_URI_PREFIX+"/users/{userId}", EcolisUserBasicDTO.class, id);
	  System.out.println(foundUser);
	 Assert.assertNotNull(foundUser);
	}
	
	@Test
	public void testGetAllUsers() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<EcolisUserBasicDTO>> response = restTemplate.exchange(
				ECOLIS_URI_PREFIX+"/users",
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<List<EcolisUserBasicDTO>>(){});
		List<EcolisUserBasicDTO> userList = response.getBody();
		Assert.assertTrue(userList.size() >0);
	}
	
	@Test
	public void testCreateUser() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		EcolisUserBasicDTO userACreer = new EcolisUserBasicDTO();
		userACreer.setEmail("peter.spin.................@gmail.com");
		userACreer.setYearOfBirth(2000);
		userACreer.setCivility("1");
		userACreer.setLogin("peterSpin");
		userACreer.setName("Peter2");
		userACreer.setPhone("0989876545");
		userACreer.setRegistrationDate(new Date());
		Integer userIdResp = restTemplate.postForObject(ECOLIS_URI_PREFIX+"/users", userACreer, Integer.class);
		Assert.assertTrue(userIdResp != null);
	}
	
//	@Test
//	public void testModifyPerson(){
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.put(ECOLIS_URI_PREFIX+"/users", request);
//		
//	}
	
	
}
