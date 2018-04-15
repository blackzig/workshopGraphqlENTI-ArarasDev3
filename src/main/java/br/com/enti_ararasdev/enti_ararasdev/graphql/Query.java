/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.enti_ararasdev.enti_ararasdev.graphql;

import br.com.enti_ararasdev.enti_ararasdev.model.Operator;
import br.com.enti_ararasdev.enti_ararasdev.repository.OperatorRepository;
import br.com.enti_ararasdev.enti_ararasdev.repository.TypeUserRepository;
import br.com.enti_ararasdev.enti_ararasdev.tools.GenerateKey;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

/**
 *
 * @author Michel
 */
public class Query implements GraphQLQueryResolver {

    private final OperatorRepository operatorRepository;
    private final TypeUserRepository typeUserRepository;

    public Query(OperatorRepository operatorRepository,
            TypeUserRepository typeUserRepository) {
        this.operatorRepository = operatorRepository;
        this.typeUserRepository = typeUserRepository;
    }

    public Operator login(String login, String password) {
        Operator operator;
        operator = operatorRepository.findByOperator(login, password);

        if (operator.getLogged() == false && operator.getActive() == true
                && login.equals(operator.getLogin())
                && password.equalsIgnoreCase(operator.getPassword())) {

            Mutation m = new Mutation(operatorRepository, typeUserRepository);

            GenerateKey gk = new GenerateKey();
            String pass = gk.generatePass();

            operator = m.setDataOperator(operator.getId(), pass, 1);

            return operator;
        }

        return null;
    }

    public Operator logout(String id, String pass) {
        Operator operator;
        operator = operatorRepository.findOne(id);

        if (operator.getLogged() == true && operator.getActive() == true
                && id.equals(operator.getId())
                && pass.equalsIgnoreCase(operator.getPass())) {
            Mutation m = new Mutation(operatorRepository, typeUserRepository);
            operator = m.setDataOperator(operator.getId(), pass, 0);
        }
        return operator;
    }
}
