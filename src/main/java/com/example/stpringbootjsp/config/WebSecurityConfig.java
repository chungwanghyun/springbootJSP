package com.example.stpringbootjsp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity // Spring Securityを使うための設定
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println("1");
		// 主に全体に対するセキュリティ設定を行う
//		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 主にURLごとに異なるセキュリティ設定を行う
//		http.authorizeRequests() // 認証が必要となるURLを設定します
//				.antMatchers("/**").permitAll() // /account以下のURLも認証不要
//				.anyRequest().authenticated(); // それ以外はすべて認証された状態じゃなきゃダメだよ〜
		System.out.println("2");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService)
		// 主に認証方法の実装の設定を行う
		System.out.println("3");
	}
}
