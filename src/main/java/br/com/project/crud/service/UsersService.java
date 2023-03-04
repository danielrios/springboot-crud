package br.com.project.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.crud.dto.UsersDTO;
import br.com.project.crud.models.UsersModel;
import br.com.project.crud.repository.UsersRepository;
import jakarta.transaction.Transactional;

@Service
public class UsersService {
	@Autowired
	private UsersRepository repository;
	public List<UsersDTO> findAll(){
		return UsersDTO.convertToListDTO(repository.findAll());
	}
	
	public UsersDTO findByIdMaterial(Integer id_material) {
		return UsersDTO.convertToDTO(repository.findByIdUser(id_material));	
	}
	
	@Transactional
	public UsersModel save(UsersModel entity) {
		return repository.save(entity);
	}
	
	@Transactional
	public void delete(Integer id_user) {
		repository.deleteById(id_user);
	}

	public Optional<UsersModel> findById(Integer id_user) {
		return repository.findById(id_user);
	}
}

