package order;

import edu.sm.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OrderUpdateStatus {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // orderService Bean을 가져옴
        OrderService orderService = (OrderService) context.getBean("orderService");

        int orderId = 1; // 업데이트할 주문 번호
        String newStatus = "배송 중"; // 변경할 상태

        try {
            // 주문 상태 업데이트 메서드 호출
            orderService.updateOrderStatus(orderId, newStatus);

            System.out.println("=====================================");
            System.out.println("       [ 주문 상태 변경 성공 ]        ");
            System.out.println("-------------------------------------");
            System.out.println("  주문번호     : " + orderId);
            System.out.println("  새로운 상태  : " + newStatus);
            System.out.println("-------------------------------------");
            System.out.println("주문 상태가 '" + newStatus + "'로 성공적으로 변경되었습니다.");
            System.out.println("=====================================");

        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("    [ 주문 상태 변경 중 오류 발생 ]    ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
