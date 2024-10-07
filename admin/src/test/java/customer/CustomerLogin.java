package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerLogin {
    public static void main(String[] args) {
        // Spring ApplicationContext를 통해 CustomerService를 가져옴
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = context.getBean("customerService", CustomerService.class);

        String email = "ascc@naver.com";
        String pwd = "1234";

        try {
            Customer customer = customerService.login(email, pwd);
            if (customer != null) {
                System.out.println("=====================================");
                System.out.println("           [ 로그인 성공 ]           ");
                System.out.println("-------------------------------------");
                System.out.println("  고객 ID      : " + customer.getCid());
                System.out.println("  고객 이름    : " + customer.getCname());
                System.out.println("  이메일       : " + customer.getEmail());
                System.out.println("  전화번호     : " + customer.getPhone());
                System.out.println("  생년월일     : " + customer.getBirth_date());
                System.out.println("  닉네임       : " + customer.getNick_name());
                System.out.println("-------------------------------------");
                System.out.println("환영합니다, " + customer.getCname() + "님!");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("           [ 로그인 실패 ]           ");
                System.out.println("-------------------------------------");
                System.out.println("입력한 이메일 또는 비밀번호가 올바르지 않습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 로그인 중 오류 발생 ]        ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
