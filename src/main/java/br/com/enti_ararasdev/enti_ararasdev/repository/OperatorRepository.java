/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.repository;

import br.com.enti_ararasdev.enti_ararasdev.model.Operator;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends CrudRepository<Operator, String>{
    
    @Query("select o from Operator o where o.login = ?1 and o.password = ?2")
    Operator findByOperator(@Param("login") String login, 
            @Param("password") String password);
    
}
