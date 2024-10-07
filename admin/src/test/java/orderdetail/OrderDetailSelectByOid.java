package orderdetail;

import edu.sm.dto.OrderDetail;
import edu.sm.service.OrderDetailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OrderDetailSelectByOid {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // orderDetailService Bean을 가져옴
        OrderDetailService orderDetailService = (OrderDetailService) context.getBean("orderDetailService");

        int oid = 10;  // 조회할 주문 ID

        try {
            List<OrderDetail> orderDetails = orderDetailService.getByOid(oid);

            if (orderDetails.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("   [ 주문 ID " + oid + "에 대한 주문 상세 정보가 없습니다 ] ");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("   [ 주문 ID " + oid + "에 대한 주문 상세 정보 ]   ");
                System.out.println("=====================================");

                for (OrderDetail detail : orderDetails) {
                    System.out.println("주문 상세 번호 : " + detail.getOrderDetailId());
                    System.out.println("상품 번호     : " + detail.getPid());
                    System.out.println("개수         : " + detail.getItemCnt());
                    System.out.println("가격         : " + detail.getOdPrice() + "원");
                    System.out.println("-------------------------------------");
                }

                System.out.println("총 " + orderDetails.size() + "개의 주문 상세 정보가 조회되었습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("   [ 주문 상세 정보 조회 중 오류 발생 ]   ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
