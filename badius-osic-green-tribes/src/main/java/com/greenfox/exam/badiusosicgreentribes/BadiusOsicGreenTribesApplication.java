package com.greenfox.exam.badiusosicgreentribes;

import com.greenfox.exam.badiusosicgreentribes.repository.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class BadiusOsicGreenTribesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BadiusOsicGreenTribesApplication.class, args);
    }

}
