/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.resolver;

import br.com.enti_ararasdev.enti_ararasdev.model.Operator;
import br.com.enti_ararasdev.enti_ararasdev.repository.OperatorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

/**
 *
 * @author Michel
 */
public class OperatorResolver implements GraphQLResolver<Operator>{
 
    private final OperatorRepository operatorRepository;
    
    public OperatorResolver(OperatorRepository operatorRepository){
        this.operatorRepository = operatorRepository;
    }
    
}
