package com.ideyatech.opentides.um.config;

import java.util.Arrays;

import javax.servlet.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;*/
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.ideyatech.opentides.core.security.JwtAuthenticationEntryPoint;
import com.ideyatech.opentides.core.security.JwtAuthenticationFilter;
import com.ideyatech.opentides.core.security.JwtAuthenticationProvider;
import com.ideyatech.opentides.core.security.JwtAuthenticationSuccessHandler;
import com.ideyatech.opentides.um.validator.Ot4RulesPasswordValidator;
import com.ideyatech.opentides.um.validator.PasswordValidator;

/**
 * @author Gino
 */

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private JwtAuthenticationProvider authenticationProvider;
    
    @Autowired
    private ApplicationContext applicationContext;
    
//    @Autowired
//    OAuth2ClientContext oauth2ClientContext;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }

    @Bean
    public PasswordValidator passwordValidator() {
        return new Ot4RulesPasswordValidator();
    }

    //@Bean
    public JwtAuthenticationFilter authenticationFilterBean() throws Exception {
    	JwtAuthenticationFilter authenticationFilter = new JwtAuthenticationFilter();
        authenticationFilter.setAuthenticationManager(authenticationManager());
        authenticationFilter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());
        return authenticationFilter;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/resources*")
            .antMatchers("/", "/csrf", "/v2/api-docs", "/swagger-resources/configuration/ui", 
            		"/configuration/ui", "/swagger-resources", 
            		"/swagger-resources/configuration/security", 
            		"/configuration/security", "/swagger-ui.html", "/webjars/**","/swagger.json")
             //Open resources for front end
            .antMatchers(HttpMethod.GET, "/", "/home", "/**.html", "/css/**", "/images/**", "/js/**", "/main/**" )
            .antMatchers(HttpMethod.POST, "/api/application")
            .antMatchers(HttpMethod.OPTIONS, "/**") //TODO Think of a better way to handle preflights.
            .antMatchers("/api", "/api/login", "/api/login/fb", "/api/logout", "/api/*/search",
                    "/api/user/reset-password", "/um-ws/**", "/api/file-info/get/*", "/api/login/google",
                    "/api/user/activateByUser/**", "/api/user/register","/api/user/registerByUser", "/api/user/register/**", "/api/refreshToken", "/api/recaptcha");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        
        
        

            .csrf().disable()
            
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/application/{id}")
                .hasAuthority("MANAGE_APPLICATION")
                .antMatchers(HttpMethod.POST, "/api/user")
                .hasAuthority("MANAGE_USER")
                .antMatchers(HttpMethod.PUT, "/api/user")
                .hasAuthority("MANAGE_USER")
                   
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);

        http.headers().cacheControl();
        
        // for outh
//        http
//        .antMatcher("/**")
//        .authorizeRequests()
//          .antMatchers("/", "/login**", "/webjars/**", "/error**")
//          .permitAll()
//        .anyRequest()
//          .authenticated();
          
//        .and()
//        .logout().logoutSuccessUrl("/").permitAll()
//        .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//        .and().addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class) ;
       
    }
	/*
	 * private Filter ssoFilter() { // TODO Auto-generated method stub
	 * OAuth2ClientAuthenticationProcessingFilter facebookFilter = new
	 * OAuth2ClientAuthenticationProcessingFilter("/login/facebook");
	 * OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(),
	 * oauth2ClientContext); facebookFilter.setRestTemplate(facebookTemplate);
	 * UserInfoTokenServices tokenServices = new
	 * UserInfoTokenServices(facebookResource().getUserInfoUri(),
	 * facebook().getClientId()); tokenServices.setRestTemplate(facebookTemplate);
	 * facebookFilter.setTokenServices(tokenServices); return facebookFilter; }
	 * 
	 * 
	 * 
	 * @Bean
	 * 
	 * @ConfigurationProperties("facebook.client") public
	 * AuthorizationCodeResourceDetails facebook() { return new
	 * AuthorizationCodeResourceDetails(); }
	 * 
	 * @Bean
	 * 
	 * @ConfigurationProperties("facebook.resource") public ResourceServerProperties
	 * facebookResource() { return new ResourceServerProperties(); }
	 */
}
