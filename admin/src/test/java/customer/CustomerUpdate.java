package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerUpdate {
    public static void main(String[] args) {
        // Spring ApplicationContext를 통해 CustomerService를 가져옴
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = context.getBean("customerService", CustomerService.class);

        int id = 20;

        Customer cust = Customer.builder()
                .cid(id)
                .cname("홍길동")
                .phone("01012341234")
                .email("test@naver.com")
                .nick_name("낄똥")
                .build();

        try {
            Customer isUpdated = customerService.modify(cust);

            if (isUpdated != null) {
                System.out.println("=====================================");
                System.out.println("        [ 고객 정보 수정 성공 ]       ");
                System.out.println("-------------------------------------");
                System.out.println("  고객 ID      : " + cust.getCid());
                System.out.println("  이름         : " + cust.getCname());
                System.out.println("  이메일       : " + cust.getEmail());
                System.out.println("  전화번호     : " + cust.getPhone());
                System.out.println("  닉네임       : " + cust.getNick_name());
                System.out.println("-------------------------------------");
                System.out.println("고객 정보가 성공적으로 수정되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("         [ 고객 정보 수정 실패 ]       ");
                System.out.println("-------------------------------------");
                System.out.println("해당 ID의 고객을 찾을 수 없습니다: " + cust.getCid());
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("    [ 고객 정보 수정 중 오류 발생 ]    ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
