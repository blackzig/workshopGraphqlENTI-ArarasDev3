/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.resolver;

import br.com.enti_ararasdev.enti_ararasdev.model.TypeUser;
import br.com.enti_ararasdev.enti_ararasdev.repository.TypeUserRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;

/**
 *
 * @author Michel
 */
public class TypeUserResolver implements GraphQLResolver<TypeUser> {

    private final TypeUserRepository typeUserRepository;

    public TypeUserResolver(TypeUserRepository typeUserRepository) {
        this.typeUserRepository = typeUserRepository;
    }
}
