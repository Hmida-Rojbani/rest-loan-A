package de.tekup.loan.rest.ctrl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.loan.rest.models.CustomerRequest;
import de.tekup.loan.rest.models.WsResponse;
import de.tekup.loan.rest.service.LoanService;

@RestController
@RequestMapping("/api")
public class LoanRestController {
	
	@Autowired
	private LoanService service;
	
	@PostMapping(path="/get-status", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}
							, consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<WsResponse> getLoanCheck(@RequestBody CustomerRequest request){
		WsResponse response = service.checkLoanEligeblity(request);
		
		ResponseEntity<WsResponse> ent = new ResponseEntity<WsResponse>(response,HttpStatus.OK) ;
		
		return ent;
	}

}
