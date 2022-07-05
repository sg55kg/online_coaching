package com.dlc.server.security;

import com.google.api.client.util.Value;
import com.nimbusds.jose.util.Resource;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseAuthConfig {

    @Value("classpath:fb-auth-serviceaccount.json")
    Resource serviceAccount;


}
