package com.assignmt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
//    @Qualifier("userDetailsServiceImpl")
//    @Autowired
//    private UserDetailsService userDetailsService;

	 @Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
	     return new BCryptPasswordEncoder();
	    }
	
	@Autowired
	private DataSource datasource;
	
	private final String user_query = "select email, password, active from user where email=?";
	private final String role_query = "select u.email, r.roleName from user u inner join user_role ur on (u.id = ur.users_user_id) inner join role r on (ur.roles_role_id= r.role_id) where email=?";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
          .authorizeRequests()
              .antMatchers("/resources/**", "/registration").permitAll()
              .anyRequest().authenticated()
              .and()
          .formLogin()
              .loginPage("/login")
              .permitAll()
              .and()
          .logout()
              .permitAll();
         }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
 
     
     protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	 auth.jdbcAuthentication()
    	 	 .usersByUsernameQuery(user_query)
    	 	 .authoritiesByUsernameQuery(role_query)
    	 	 .dataSource(datasource)
    	 	 .passwordEncoder(bCryptPasswordEncoder());
   }
}