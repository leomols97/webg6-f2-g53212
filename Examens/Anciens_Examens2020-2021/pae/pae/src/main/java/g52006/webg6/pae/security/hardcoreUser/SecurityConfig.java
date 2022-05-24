// package g52006.webg6.pae.security.hardcoreUser;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private DataSource dataSource;


//     // Stockage des utilisateurs , de leur mot de passe et de leur autorités dans une base de donnée utilisant le sgbd embarqué: h2.
//     // Ici, le chéma est par défaut, spring choisit les noms de tables et des colonnes pour stocker les informations de sécurité.
//     // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     //     auth.jdbcAuthentication()
//     //         .dataSource(dataSource)
//     //         .withDefaultSchema()
//     //         .withUser(
//     //             User.withUsername("user").password("{noop}user").authorities("USER")
//     //         );
//     // }

        


//     // Stockage des utilisateurs , de leur mot de passe et de leur autorités en dur dans le code java.
//     /*@Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication()
//         .withUser("etudiant").password("{noop}etudiant").authorities("ETU")
//         .and().withUser("prof").password("{noop}prof").authorities("PROF")
//         .and().withUser("secretaire").password("{noop}secretaire").authorities("SEC");

//     }*/

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests()
//         .antMatchers("/courses").hasAuthority("SEC")
//         .antMatchers("/students").hasAuthority("SEC")
//         .antMatchers("/student").hasAuthority("SEC")
//         .antMatchers("/course").hasAuthority("SEC")
//         .antMatchers("/**").permitAll()
//         .and().formLogin().loginPage("/login")
//         .and().exceptionHandling().accessDeniedPage("/")
//         .and().logout().logoutSuccessUrl("/");
//     }


//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
//         auth.jdbcAuthentication()
//         .dataSource(dataSource)
//         .usersByUsernameQuery("select username, password, enabled from user where username=?")
//         .authoritiesByUsernameQuery("select username, authority from authority where username=?");
//     }
    

// }
