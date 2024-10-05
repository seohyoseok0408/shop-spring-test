package order;

import edu.sm.dto.Order;
import edu.sm.service.OrderService;

public class OrderInsert {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        try {
            Order order = Order.builder()
                    .cid(2)
                    .oname("김철수")
                    .address("서울시 강남구")
                    .addressDetail("아파트 101호")
                    .zipCode("123456")
                    .phone("01012345678")
                    .msg("문 앞에 두고 가주세요")
                    .price(50000)
                    .build();

            orderService.add(order);

            System.out.println("=====================================");
            System.out.println("         [ 주문 추가 성공 ]           ");
            System.out.println("-------------------------------------");
            System.out.println("  고객 ID     : " + order.getCid());
            System.out.println("  주문자 이름 : " + order.getOname());
            System.out.println("  주소        : " + order.getAddress());
            System.out.println("  상세 주소   : " + order.getAddressDetail());
            System.out.println("  우편번호    : " + order.getZipCode());
            System.out.println("  전화번호    : " + order.getPhone());
            System.out.println("  요청사항    : " + order.getMsg());
            System.out.println("  총 주문금액 : " + order.getPrice() + "원");
            System.out.println("-------------------------------------");
            System.out.println("주문이 성공적으로 추가되었습니다.");
            System.out.println("=====================================");

        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("      [ 주문 추가 중 오류 발생 ]       ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
