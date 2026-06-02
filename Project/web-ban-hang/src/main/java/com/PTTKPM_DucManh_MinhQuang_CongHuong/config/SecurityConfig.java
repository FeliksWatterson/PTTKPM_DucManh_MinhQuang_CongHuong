package com.PTTKPM_DucManh_MinhQuang_CongHuong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Tạo nhanh 2 tài khoản ảo trong bộ nhớ để test phân quyền
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user1")
                .password(encoder.encode("123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin1")
                .password(encoder.encode("123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Tạm thời tắt CSRF để dễ test các hàm POST/PUT
            .authorizeHttpRequests(auth -> auth
                // Chặn toàn bộ URL có tiền tố /admin/, yêu cầu quyền ADMIN
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // Các đường dẫn còn lại cho phép truy cập tự do
                .requestMatchers("/**", "/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()
            )
            // Sử dụng form đăng nhập mặc định cực đẹp của Spring Security để test nhanh
            .formLogin(form -> form
                .defaultSuccessUrl("/admin/dashboard", true) // Đăng nhập xong nhảy vào trang admin test
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }
}