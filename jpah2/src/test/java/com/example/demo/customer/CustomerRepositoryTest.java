package com.example.demo.customer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.repository.CustomerRepository;
@SpringBootTest
public class CustomerRepositoryTest { //test할 클래스 이름에 +test붙여주면됨
	
	@Autowired
	CustomerRepository repo;

	@AfterEach //모든 테스트가 끝나고 한번 실행 
	public void cleanup() {
		repo.deleteAll();
	}
	
	@Test
	public void 저장_조회() {
		//given
		String name = "황비홍";
		String phone = "010-1111-1111";
		
		Customer customer = Customer.builder()
									.name(name)
									.phone(phone)
									.build(); //객체 생성해주기 
		repo.save(customer); // repository에 저장하면 알아서 만들어줌
	
		//when
		List <Customer> list = repo.findByNameLike(name); // 담겼는지 테스트	
		//then
		Customer result = list.get(0);
		assertThat(result.getName()).isEqualTo(name);
	}
}
