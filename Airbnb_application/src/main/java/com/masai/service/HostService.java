package com.masai.service;

import java.util.*;

import com.masai.exception.HostException;
import com.masai.model.Host;
import com.masai.model.Property;

public interface HostService {

	// add Host 
	// get Host By id 
	// get All Host  
	// update Host By id 
	
	public Host createHost(Host host) throws HostException;
	
	public Host getHostById(int hostId) throws HostException;
	
	public Host getHostByName(String name) throws HostException;
	
	public List<Host> getAllHost() throws HostException;
	
	public Host updateHostById(int hostId,Host host) throws HostException;
	
	public List<Property> getPropertyByHostId(int hostId) throws HostException;
	
}
