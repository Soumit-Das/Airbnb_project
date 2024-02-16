package com.masai.service;

import java.util.List;
import java.util.Optional;

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
		
		if(hostRepository.existsById(host.getHostId())) {
			throw new HostException("host already exists with id "+host.getHostId());
		}
		
		return hostRepository.save(host);
	}

	@Override
	public Host getHostById(int hostId) throws HostException {
		
		if(!hostRepository.existsById(hostId)) {
			throw new HostException("host doesn't exists with id "+hostId);
		}
		
		Optional<Host> host = hostRepository.findById(hostId);
		
		return host.get();
	}

	@Override
	public List<Host> getAllHost() throws HostException {
		
		
		List<Host> list = hostRepository.findAll();
		
		if(list.size() < 1) {
			throw new HostException("No hosts exists");
		}
		
		return list;
	}

	@Override
	public Host updateHostById(int hostId, Host host) throws HostException {
		
		if(!hostRepository.existsById(hostId)) {
			throw new HostException("host doesn't exists with id "+hostId);
		}
		
		Optional<Host> hos = hostRepository.findById(hostId);
		
		Host h = hos.get();
		
		h.setName(host.getName());
		h.setLocation(host.getLocation());
		h.setAbout(host.getAbout());
		h.setHostingSince(host.getHostingSince());
		h.setStatus(host.getStatus());
		
		
		return hostRepository.save(h);
	}
	
}
