package br.com.project.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.crud.dto.UsersDTO;
import br.com.project.crud.models.UsersModel;
import br.com.project.crud.service.UsersService;
import jakarta.validation.Valid;

@RestController
@RequestMapping()
public class UsersController {
	@Autowired
	private UsersService service;
	
	@GetMapping(value="/users/search")
	public ResponseEntity<List<UsersDTO>> test(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/users/search/{id}")
	public ResponseEntity<Object> findByIdUsuário(@PathVariable(value = "id") int id){
		Optional<UsersModel> searched = service.findById(id);
		if(!searched.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}

		return ResponseEntity.ok().body(searched);

	}

	@RequestMapping(value="/users/save",method=RequestMethod.POST)
	public ResponseEntity<Object> save(@RequestBody @Valid UsersDTO dto) throws Exception {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(UsersDTO.convertToEntity(dto)));	
	}
	
	@DeleteMapping(value="/users/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") int id) {
		Optional<UsersModel> searched = service.findById(id);
		if(!searched.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		service.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");	
	}
	
	@PutMapping(value="/users/update/{id}")
	public ResponseEntity<Object> update(@PathVariable(value = "id") int id, @RequestBody @Valid UsersDTO dto) {
		UsersModel userSearched = service.findById(id).orElse(null);
		
		if(id != dto.getId_user()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Different id_user in Body.");
		}

		if(userSearched == null){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		
		dto.setCreated_at(userSearched.getCreated_at());
		
		return ResponseEntity.status(HttpStatus.OK).body(service.save(UsersDTO.convertToEntity(dto)));	
	}
}
