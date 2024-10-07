package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.List;

public class CustomerSelectAll {
    public static void main(String[] args) {
        // Spring ApplicationContext를 통해 CustomerService를 가져옴
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = context.getBean("customerService", CustomerService.class);

        try {
            List<Customer> customers = customerService.get();

            if (customers.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("       [ 조회된 고객 정보가 없습니다 ] ");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("         [ 전체 고객 목록 조회 ]      ");
                System.out.println("=====================================");

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                for (Customer customer : customers) {
                    System.out.println("고객 ID     : " + customer.getCid());
                    System.out.println("이름        : " + customer.getCname());
                    System.out.println("이메일      : " + customer.getEmail());
                    System.out.println("전화번호    : " + customer.getPhone());
                    System.out.println("생년월일    : " + customer.getBirth_date());
                    System.out.println("닉네임      : " + customer.getNick_name());
                    System.out.println("등급        : " + customer.getGrade());
                    System.out.println("가입일      : " + dateFormat.format(customer.getJoin_date()));
                    System.out.println("-------------------------------------");
                }

                System.out.println("총 " + customers.size() + "명의 고객이 조회되었습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("      [ 고객 목록 조회 중 오류 발생 ]  ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
