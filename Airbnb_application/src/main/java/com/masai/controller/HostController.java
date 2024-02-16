package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.masai.exception.HostException;
import com.masai.model.Guest;
import com.masai.model.Host;
import com.masai.service.HostService;

@Controller
@RequestMapping("/host")
public class HostController {

	@Autowired
	private HostService hostService;
	
	@PostMapping("/createHost")
	public ResponseEntity<Host> createHost(@RequestBody Host host) throws HostException{
		
		Host cat = hostService.createHost(host);
		return new ResponseEntity<>(cat, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getHostById/{hostId}")
	public ResponseEntity<Host> getHostById(@PathVariable int hostId) throws HostException{
		
		Host cat = hostService.getHostById(hostId);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAllHost")
	public ResponseEntity<List<Host>> getAllHost() throws HostException{
		
		List<Host> cat = hostService.getAllHost();
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateHostById/{hostId}")
	public ResponseEntity<Host> updateHostById(@PathVariable int hostId,@RequestBody Host host) throws HostException{
		
		Host cat = hostService.updateHostById(hostId,host);
		return new ResponseEntity<>(cat, HttpStatus.OK);
		
	}
	
	
}
