package br.com.enti_ararasdev.enti_ararasdev;

/*
JRebel
https://www.youtube.com/watch?v=nzinps6YH2M
 */
import br.com.enti_ararasdev.enti_ararasdev.graphql.Mutation;
import br.com.enti_ararasdev.enti_ararasdev.graphql.Query;
import br.com.enti_ararasdev.enti_ararasdev.repository.OperatorRepository;
import br.com.enti_ararasdev.enti_ararasdev.repository.TypeUserRepository;
import br.com.enti_ararasdev.enti_ararasdev.resolver.OperatorResolver;
import br.com.enti_ararasdev.enti_ararasdev.resolver.TypeUserResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EntiArarasdevApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntiArarasdevApplication.class, args);
    }

    @Bean
    public Query query(OperatorRepository operatorRepository,
            TypeUserRepository typeUserRepository) {
        return new Query(operatorRepository,
                typeUserRepository);
    }

    @Bean
    public Mutation mutation(OperatorRepository operatorRepository,
            TypeUserRepository typeUserRepository) {
        return new Mutation(operatorRepository,
                typeUserRepository);
    }

    @Bean
    public OperatorResolver operatorResolver(OperatorRepository operatorRepository) {
        return new OperatorResolver(operatorRepository);
    }

    @Bean
    public TypeUserResolver typeUserRevoler(TypeUserRepository typeUserRepository) {
        return new TypeUserResolver(typeUserRepository);
    }
}
