package orderdetail;

import edu.sm.dto.OrderDetail;
import edu.sm.service.OrderDetailService;

public class OrderDetailInsert {
    public static void main(String[] args) {
        OrderDetailService orderDetailService = new OrderDetailService();

        OrderDetail newOrderDetail = OrderDetail.builder()
                .pid(5)        // 상품 ID
                .oid(1)        // 주문 ID
                .itemCnt(2)    // 상품 수량
                .build();

        try {
            orderDetailService.add(newOrderDetail);

            System.out.println("=====================================");
            System.out.println("       [ 주문 상세 정보 추가 성공 ]    ");
            System.out.println("-------------------------------------");
            System.out.println("  주문 ID     : " + newOrderDetail.getOid());
            System.out.println("  상품 ID     : " + newOrderDetail.getPid());
            System.out.println("  상품 수량    : " + newOrderDetail.getItemCnt());
            System.out.println("-------------------------------------");
            System.out.println("주문 상세 정보가 성공적으로 추가되었습니다.");
            System.out.println("=====================================");

        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("   [ 주문 상세 정보 추가 중 오류 발생 ] ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
