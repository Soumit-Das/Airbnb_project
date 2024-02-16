package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.HostException;
import com.masai.model.Host;
import com.masai.repository.HostRepository;

@Service
public class HostServiceImpl implements HostService{

	@Autowired
	private  HostRepository hostRepository;

	@Override
	public Host createHost(Host host) throws HostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Host getHostById(int hostId) throws HostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Host> getAllHost() throws HostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Host updateHostById(int hostId) throws HostException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
