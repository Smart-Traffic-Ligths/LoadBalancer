package edu.eci.loadbalancer.service;

import java.io.IOException;

public class LoadBalancerService {
	
	//public static LogServiceConnection logServiceConnection;
	//public static LoadBalancer roundRobin;
	
	public LoadBalancerService(){
		//logServiceConnection = LogServiceConnection.getInstance();
		//roundRobin = new RoundRobin();
	}
	
	/*public String read (Request req, Response res) {
		res.type("application/json");
		String url = roundRobin.getServer();
		String result = "";
		try {
			result = logServiceConnection.sendGET(url+"/string");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	 }

	public String create(Request req, Response res) {
		res.type("application/json");
		String url = roundRobin.getServer();
		String result = "";
		try {
			result = logServiceConnection.sendPOST(url+"/string", req.body());	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return result;
	}*/
}
