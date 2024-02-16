package com.masai.service;

import java.util.*;

import com.masai.exception.HostException;
import com.masai.model.Host;

public interface HostService {

	// add Host 
	// get Host By id 
	// get All Host  
	// update Host By id 
	
	public Host createHost(Host host) throws HostException;
	
	public Host getHostById(int hostId) throws HostException;
	
	public List<Host> getAllHost() throws HostException;
	
	public Host updateHostById(int hostId) throws HostException;
	
	
}
