package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.masai.exception.HostException;
import com.masai.model.Host;
import com.masai.service.HostService;

@Controller
public class HostController {

	@Autowired
	private HostService hostService;
	
	public Host createHost(Host host) throws HostException{
		
		
		
	}
	
	public Host getHostById(int hostId) throws HostException{
		
		
		
	}
	
	public List<Host> getAllHost() throws HostException{
		
		
		
	}
	
	public Host updateHostById(int hostId) throws HostException{
		
		
		
	}
	
	
}
