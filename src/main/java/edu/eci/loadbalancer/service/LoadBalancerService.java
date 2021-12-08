package edu.eci.loadbalancer.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import edu.eci.loadbalancer.controller.dto.DataDto;
import edu.eci.loadbalancer.roundrobin.LoadBalancer;
import edu.eci.loadbalancer.roundrobin.RoundRobin;

@Service
public class LoadBalancerService {
	
	private RestTemplate restTemplate;
	public static LoadBalancer roundRobin;
	
	@Autowired
	public LoadBalancerService(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
		roundRobin = new RoundRobin();
	}

	public void dataLog(DataDto dataDto) {
		String url = roundRobin.getServer();
		sendData(url, dataDto);	
	}
	
	public void sendData(String url, DataDto dataDto) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <DataDto> entity = new HttpEntity<DataDto>(dataDto,headers);
	    restTemplate.exchange(url+"/string", HttpMethod.POST, entity, Void.class);  //Poner endpoint del java de redis. Cambiar por "/string"
	}
}
