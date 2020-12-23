package cn.tedu.sp06;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

//@EnableCircuitBreaker //使能断路器
//@EnableDiscoveryClient //启用发现客户端
//@SpringBootApplication
@SpringCloudApplication //Spring云应用
public class Sp07hystrix {

    @LoadBalanced//负载均衡注解
    @Bean//创建 RestTemplate 实例，并存入spring 容器
    public RestTemplate getRestTemplate(){
        //简单客户端Http请求工厂
        SimpleClientHttpRequestFactory f = new SimpleClientHttpRequestFactory();
        f.setConnectTimeout(1000);//设置连接超时
        f.setReadTimeout(1000);//设置读取超时
        return new RestTemplate(f);

        //RestTemplate 中默认的 Factory 实例中，两个超时属性默认是 -1，
        //未启用超时，也不会触发重试
        //return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(Sp07hystrix.class, args);
    }

}
