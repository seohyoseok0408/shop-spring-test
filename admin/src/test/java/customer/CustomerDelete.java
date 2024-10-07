package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerDelete {
    public static void main(String[] args) {
        // Spring ApplicationContext를 통해 CustomerService를 가져옴
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService = context.getBean("customerService", CustomerService.class);

        int id = 15;

        try {
            boolean result = customerService.remove(id);
            if (result) {
                System.out.println("=====================================");
                System.out.println("       [ 고객 삭제 성공 ]             ");
                System.out.println("-------------------------------------");
                System.out.println("  삭제된 고객 ID : " + id);
                System.out.println("-------------------------------------");
                System.out.println("고객 정보가 성공적으로 삭제되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("        [ 고객 삭제 실패 ]            ");
                System.out.println("-------------------------------------");
                System.out.println("해당 ID의 고객을 찾을 수 없습니다: " + id);
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("    [ 고객 삭제 중 오류 발생 ]        ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
