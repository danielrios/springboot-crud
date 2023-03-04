package br.com.project.crud.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.project.crud.models.UsersModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UsersDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id_user;
	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotNull
	private Integer status;
	
	private Timestamp created_at;
	
	
	public static UsersDTO convertToDTO(UsersModel entity) {
		return entity!=null?new UsersDTO(entity.getId_user(),entity.getName(),entity.getEmail(),entity.getStatus(), entity.getCreated_at()):null;
	}
	public static UsersModel convertToEntity(UsersDTO dto) {

		
		return dto!=null?new UsersModel(dto.getId_user(),dto.getName(),dto.getEmail(),dto.getStatus(), dto.getCreated_at()):null;
	}
	public static List<UsersDTO> convertToListDTO(List<UsersModel> list){
		List<UsersDTO> listDTO = new ArrayList<UsersDTO>();
		for(UsersModel enti:list) {
			listDTO.add(UsersDTO.convertToDTO(enti));
		}
		return listDTO;
	}
}