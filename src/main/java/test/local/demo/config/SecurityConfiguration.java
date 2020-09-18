package test.local.demo.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * @author 张娟娟
 * @date 2019/9/29 5:40 PM
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired DataSource dataSource;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled" + " from users where username=?")
        .authoritiesByUsernameQuery(
            "select username, authority " + "from authorities where username=?")
        .passwordEncoder(new BCryptPasswordEncoder())
        .rolePrefix("ROLE_");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/login", "/", "/static/**", "/webjars/**", "/signIn")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .failureHandler(
            (req, resp, authException) -> {
              System.out.println(authException.getMessage());
              resp.sendRedirect("/login?error");
            })
        .successHandler(
            (req, resp, auth) -> {
              // 获取登录者信息
              Object principal =
                  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
              if (principal != null && principal instanceof UserDetails) {
                UserDetails user = (UserDetails) principal;
                System.out.println("login success:" + user.getUsername());
                // 维护在session中
                req.getSession().setAttribute("userDetail", user);
                resp.sendRedirect("/");
              }
            })
        .permitAll()
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login")
        .and()
        .csrf()
        .disable();
  }
}
