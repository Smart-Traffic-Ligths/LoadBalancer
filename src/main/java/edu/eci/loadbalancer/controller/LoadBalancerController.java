package edu.eci.loadbalancer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.loadbalancer.controller.dto.DataDto;
import edu.eci.loadbalancer.service.LoadBalancerService;

@RestController
@RequestMapping( "/v1" )
public class LoadBalancerController {
	
	private final LoadBalancerService balancerDataService;

    public LoadBalancerController( @Autowired LoadBalancerService balancerDataService ) {
        this.balancerDataService = balancerDataService;
    }
	
	@PostMapping("/logs")
    public void dataLog(@RequestBody DataDto dataDto) {
		balancerDataService.dataLog(dataDto);
    }

}
