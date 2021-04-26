package com.example.casestudy.config;

import com.example.casestudy.service.user.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailsServiceImpl;

    @Autowired
    DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

        // Trang /furama yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN hoặc ROLE_GIAMDOC.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/furama",
                "/customer",
                "/customer/search",
                "/employee",
                "/employee/search",
                "/service",
                "/contract",
                "/contract-detail/view",
                "/contract/customerEXP",
                "/contract/customerEXP/search").access("hasAnyRole('ROLE_NHANVIEN', 'ROLE_ADMIN', 'ROLE_GIAMDOC')");

        // Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/customer/create",
                "/employee/create",
                "/service/createVilla",
                "/service/createHouse",
                "/service/createRoom",
                "/contract/create",
                "/contract-detail/create",
                "/user-role/create").access("hasAnyRole('ROLE_ADMIN', 'ROLE_GIAMDOC')");

        // Trang chỉ dành cho GIAMDOC
        http.authorizeRequests().antMatchers("/customer/edit",
                "/customer/delete",
                "/employee/edit",
                "/employee/delete",
                "/contract/customerEXP/delete").access("hasRole('ROLE_GIAMDOC')");

        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/furama")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful"); //cach 1
                 .and().logout().logoutUrl("/logout"); // cach 2

        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
            //    .rememberMe().tokenRepository(this.persistentTokenRepository()) // dung token
                .rememberMe().key("uniqueAndSecret")
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("login-info")
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}
