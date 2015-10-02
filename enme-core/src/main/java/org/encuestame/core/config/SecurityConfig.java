/*
 *
 *  * Copyright 2015 encuestame
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *
 */

package org.encuestame.core.config;

import org.encuestame.core.security.service.EnMeSocialAccountUserService;
import org.encuestame.core.security.service.EnMeUserServiceImp;
import org.encuestame.core.security.web.EnMeUserAccountProvider;
import org.encuestame.core.security.web.EnMeUsernameProvider;
import org.encuestame.core.security.web.SocialAccountAuthenticationProvider;
import org.jasypt.spring.security3.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * Created by jpicado on 17/09/15.
 */
@Configuration
@ImportResource({
    "classpath:/org/encuestame/config/xml/security-context.xml",
    "classpath:/org/encuestame/config/xml/security-oauth-context.xml"
})
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private Environment env;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(socialAccountProvider());
        auth.authenticationProvider(accountProvider());
        auth.userDetailsService(enMeUserServiceImp()).passwordEncoder(passwordEncoder2());
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("index.jsp").permitAll()
                .antMatchers("/error/**").permitAll()
                .antMatchers("/u/**").permitAll()
                .antMatchers("/a/**").access("hasRole('ENCUESTAME_ADMIN')")
                .antMatchers("/su/**").access("hasRole('ENCUESTAME_SUPER_ADMIN')")
                .antMatchers("/p/*/**").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/api/**").access("hasRole('ENCUESTAME_USER')")
                .and()
                .formLogin()
                .loginPage("");
    }


    @Bean
    public LoginUrlAuthenticationEntryPoint socialAuthenticationEntryPoint(){
        LoginUrlAuthenticationEntryPoint entryPoint = new LoginUrlAuthenticationEntryPoint(env.getRequiredProperty("spring.sec.loginPath"));
        entryPoint.setForceHttps(Boolean.valueOf(env.getRequiredProperty("spring.sec.forceLoginSSL")));
        return entryPoint;
    }

//    @Bean
//    public RememberMeServices rememberMeServices(){
//        PersistentTokenBasedRememberMeServices rememberMeServices = new PersistentTokenBasedRememberMeServices(
//                env.getProperty("application.key"), userAdminService, persistentTokenRepository());
//        rememberMeServices.setAlwaysRemember(true);
//        return rememberMeServices;
//    }

    @Bean
    public RememberMeAuthenticationProvider rememberMeAuthenticationProvider(){
        RememberMeAuthenticationProvider rememberMeAuthenticationProvider =
                new RememberMeAuthenticationProvider(env.getProperty("application.key"));
        return rememberMeAuthenticationProvider;
    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        return new MongoPersistentTokenRepositoryImpl(rememberMeTokenRepository);
//    }


    @Bean
    public SocialAccountAuthenticationProvider socialAccountProvider() {
        return new SocialAccountAuthenticationProvider();
    }

    @Bean
    public EnMeUserAccountProvider accountProvider(){
        return new EnMeUserAccountProvider();
    }

    @Bean
    public EnMeUsernameProvider enMeUsernameProvider(){
        return new EnMeUsernameProvider();
    }

    @Bean
    public EnMeSocialAccountUserService enMeSocialAccountUserService() {
        return new EnMeSocialAccountUserService();
    }

    @Bean
    public EnMeUserServiceImp enMeUserServiceImp(){
        return new EnMeUserServiceImp(
                Boolean.valueOf(env.getRequiredProperty("spring.sec.roleByGroup")),
                Boolean.valueOf(env.getRequiredProperty("spring.sec.roleByAuthor"))
        );
    }

    @Bean
    public StrongPasswordEncryptor strongPasswordEncryptor() {
        return new StrongPasswordEncryptor();
    }

    @Bean
    PasswordEncoder passwordEncoder2(){
        final PasswordEncoder pass = new PasswordEncoder();
        pass.setPasswordEncryptor(strongPasswordEncryptor());
        return pass;
    }

}
