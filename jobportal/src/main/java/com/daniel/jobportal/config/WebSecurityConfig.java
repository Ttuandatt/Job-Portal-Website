package com.daniel.jobportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //Đánh dấu class này là một lớp cấu hình, Spring sẽ xử lý nó khi khởi động ứng dụng.
public class WebSecurityConfig {

    // Các URL này sẽ không yêu cầu đăng nhập (miễn xác thực).
    private final String[] publicUrl = {"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts**", "/favicon.ico", "/resources/**", "/error"};

    @Bean // Chỉ ra rằng một method trả về một đối tượng sẽ được quản lý bởi Spring container.
    // SecurityFilterChain: Đại diện cho chuỗi filter mà Spring Security dùng để xử lý các request HTTP.
    // Dùng để cấu hình HTTP security.
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->{
          auth.requestMatchers(publicUrl).permitAll();  // Cho phép mọi người (kể cả chưa đăng nhập) truy cập vào tất cả các URL được liệt kê trong publicUrl.

            auth.anyRequest().authenticated(); // Mọi URL khác không nằm trong danh sách trên sẽ yêu cầu người dùng phải đăng nhập (authenticated) mới được truy cập.

        });

        return http.build(); // Trả về đối tượng SecurityFilterChain đã được cấu hình.
        
    }
}


