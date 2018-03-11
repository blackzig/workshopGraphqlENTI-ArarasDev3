/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.graphql;

import br.com.enti_ararasdev.enti_ararasdev.model.Operator;
import br.com.enti_ararasdev.enti_ararasdev.repository.OperatorRepository;
import br.com.enti_ararasdev.enti_ararasdev.repository.TypeUserRepository;
import br.com.enti_ararasdev.enti_ararasdev.tools.DateTime;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import java.util.Date;

/**
 *
 * @author Michel
 */
public class Mutation implements GraphQLMutationResolver {

    private final OperatorRepository operatorRepository;
    private final TypeUserRepository typeUserRepository;

    public Mutation(OperatorRepository operatorRepository,
            TypeUserRepository typeUserRepository) {
        this.operatorRepository = operatorRepository;
        this.typeUserRepository = typeUserRepository;
    }

    public Operator setDataOperator(String idOperator, String pass) {
        Date date;
        DateTime dt = new DateTime();
        date = dt.saveDateInBD();

        Operator op = operatorRepository.findOne(idOperator);
        op.setPass(pass);
        op.setLogged(Boolean.TRUE);
        op.setLoggedIn(date);

        return operatorRepository.save(op);
    }

}
