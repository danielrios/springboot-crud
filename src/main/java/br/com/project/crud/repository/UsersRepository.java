package br.com.project.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.project.crud.models.UsersModel;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer>{
	@Query(value="SELECT * FROM USERS WHERE id_user = :id", nativeQuery = true)
	UsersModel findByIdUser(@Param("id")Integer id);
}
