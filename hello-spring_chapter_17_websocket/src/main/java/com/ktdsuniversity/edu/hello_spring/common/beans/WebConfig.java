package com.ktdsuniversity.edu.hello_spring.common.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.ktdsuniversity.edu.hello_spring.access.dao.AccessLogDao;

// application.yml에서 설정하지 못하는 디테일한 설정을 위한 Annotation
// application.yml보다 높은 우선순위를 가지게 되면서 WhitelabelError 발생
// Spring Bean 을 수동으로 생성하는 기능
@Configuration
// Spring WebMvc에 있는 다양한 요소를 활성화 해주는 Annotation
// 		- Spring Validator
// 		- Spring Interceptor
// 		- ...
@EnableWebMvc
@EnableWebSocket // 웹소켓을 활성화 시킴
public class WebConfig 
			implements WebMvcConfigurer // WebMVC를 사용하기 위한 설정 인터페이스
					 , WebSocketConfigurer // WebSocket을 사용하기 위한 설정 인터페이스 
{
	
	@Autowired
	private AccessLogDao accessLogDao;
	
	@Autowired
	private TextWebSocketHandler textWebSocketHandler;
	
	@Value("${app.interceptors.check-session.path-patterns}")
	private List<String> checkSessionPathPatterns;
	@Value("${app.interceptors.check-session.exclude-path-patterns}")
	private List<String> checkSessionExcludePathPatterns;
	@Value("${app.interceptors.check-dup-login.path-patterns}")
	private List<String> checkDupLoginPathPatterns;
	@Value("${app.interceptors.check-dup-login.exclude-path-patterns}")
	private List<String> checkDupLoginExcludePathPatterns;
	@Value("${app.interceptors.add-access-log.path-patterns}")
	private List<String> addAccessLogPathPatterns;
	@Value("${app.interceptors.add-access-log.exclude-path-patterns}")
	private List<String> addAccessLogExcludePathPatterns;
	
	/**
	 * Auto DI: @Component
	 * Manual DI: @Bean
	 *  -> 객체 생성을 스프링이 아닌 개발자가 직접 하는 것
	 * @return
	 */
	@Bean // Sha라는 이름의 Bean이 생김
	Sha createShaInstance() {
		Sha sha = new Sha();
		return sha;
	}

	
	// 우선순위가 바뀌게 되면서 yml에 있는 jsp 경로를 우선순위로 변경해줘야 함
	/**
	 * JSP View Resolver 설정
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	/**
	 * Static Resource 설정 (CSS, JS)
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/"); // css 경로
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/"); // js 경로
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// First Interceptor
		registry.addInterceptor( new CheckSessionInterceptor() )
		.addPathPatterns(this.checkSessionPathPatterns)
		.excludePathPatterns(this.checkSessionExcludePathPatterns);
		
		// Second Interceptor
		registry.addInterceptor( new CheckDuplicateLoginInterceptor() )
		.addPathPatterns(this.checkDupLoginPathPatterns)
		.excludePathPatterns(this.checkDupLoginExcludePathPatterns);
		
		// Third Interceptor
		registry.addInterceptor( new AddAccessLogHistoryInterceptor(this.accessLogDao))
		.addPathPatterns(this.addAccessLogPathPatterns)
		.excludePathPatterns(this.addAccessLogExcludePathPatterns);
	}
	
	/**
	 * 웹소켓의 엔드포인트(URL)를 설정
	 * 해당 엔드포인트(URL)의 통신을 담당할 클래스가 필요
	 */
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(this.textWebSocketHandler, "/ws")
				.setAllowedOrigins("http://localhost:8080")
				.withSockJS() // /ws URL에 접근할 수 있는 JS라이브러리를 sock.js로 제한
				;
	}
	
}
