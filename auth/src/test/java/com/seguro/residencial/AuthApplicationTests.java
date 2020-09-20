package com.seguro.residencial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @criado 18/09/2020 - 19:57
 * @projeto Seguro Residencial Simplificado
 * @autor Bruno Leite
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {com.seguro.residencial.auth.AuthApplication.class})
public class AuthApplicationTests  {


    @Test
    public void contextLoads() {
    }

    @Test
    public void tests(){
        System.out.println(new BCryptPasswordEncoder().encode("brunoleite"));
    }

}
