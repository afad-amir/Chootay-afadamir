package chootay.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.jdbcAuthentication()
		.dataSource(datasource)
		.usersByUsernameQuery("select username,password,'true' as enabled from users where username=?")
		.authoritiesByUsernameQuery("select us.username,r.authority from users as us join user_role as ur on ur.user_id=us.id "
				+ "join role as  r on  r.id=ur.role_id where us.username=?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/users").hasAnyAuthority("ADMIN")
		.antMatchers("/roles").hasAnyAuthority("ADMIN")
		.antMatchers("/bike").hasAnyAuthority("ADMIN")
		.antMatchers("/inventory").hasAnyAuthority("ADMIN")
		.antMatchers("/parts").hasAnyAuthority("ADMIN")
		.antMatchers("/sales").hasAnyAuthority("ADMIN")
		.antMatchers("/userrole").hasAnyAuthority("ADMIN")
		.antMatchers("/adduser").hasAnyAuthority("ADMIN")
		.antMatchers("/customer").hasAnyAuthority("ADMIN")
		.antMatchers("/login").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/logout").permitAll()
		.and().formLogin()
		.and().csrf().disable();
	}
	
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
}
