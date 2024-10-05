package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CustomerSelect {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = context.getBean("customerService", CustomerService.class);

        int id = 20; // ID로 고객 검색
        Customer customer = null;

        // ID로 고객 검색 테스트
        try {
            customer = customerService.get(id);
            if (customer != null) {
                System.out.println("=====================================");
                System.out.println("       [ ID로 검색된 고객 정보 ]       ");
                System.out.println("-------------------------------------");
                System.out.println("  고객 ID      : " + customer.getCid());
                System.out.println("  이름         : " + customer.getCname());
                System.out.println("  이메일       : " + customer.getEmail());
                System.out.println("  전화번호     : " + customer.getPhone());
                System.out.println("  생년월일     : " + customer.getBirth_date());
                System.out.println("  닉네임       : " + customer.getNick_name());
                System.out.println("-------------------------------------");
                System.out.println("고객 정보가 성공적으로 조회되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("       [ 고객 정보 조회 실패 ]        ");
                System.out.println("-------------------------------------");
                System.out.println("해당 ID의 고객을 찾을 수 없습니다: " + id);
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("     [ ID로 고객 조회 중 오류 발생 ]    ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
