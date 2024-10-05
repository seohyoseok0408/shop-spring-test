package pay;

import edu.sm.dto.Pay;
import edu.sm.service.PayService;

public class PayInsert {
    public static void main(String[] args) {
        PayService payService = new PayService();

        // 결제 정보 생성
        Pay pay = Pay.builder()
                .oid(21) // 주문 ID
                .payPrice(100000)
                .payMethod("신용카드")
                .card(1234567890123456L)
                .build();

        try {
            payService.add(pay);

            System.out.println("=====================================");
            System.out.println("          [ 결제 정보 추가 성공 ]      ");
            System.out.println("-------------------------------------");
            System.out.println("  주문 ID       : " + pay.getOid());
            System.out.println("  결제 금액     : " + pay.getPayPrice() + "원");
            System.out.println("  결제 방법     : " + pay.getPayMethod());
            System.out.println("  카드 번호     : **** **** **** " + (pay.getCard() % 10000)); // 카드 번호 마지막 4자리만 표시
            System.out.println("-------------------------------------");
            System.out.println("결제 정보가 성공적으로 추가되었습니다.");
            System.out.println("=====================================");

        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 결제 정보 추가 중 오류 발생 ] ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
