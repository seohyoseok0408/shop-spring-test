package cart;

import edu.sm.service.CartService;

public class CartDeleteByCidPid {
    public static void main(String[] args) {
        CartService cartService = new CartService();

        try {
            int cid = 3; // 고객 ID
            int pid = 7; // 상품 ID

            // 카트 항목 삭제 시도
            boolean isRemoved = cartService.removeByCidPid(cid, pid);
            if (isRemoved) {
                System.out.println("=====================================");
                System.out.println("      [ 카트 항목 삭제 성공 ]         ");
                System.out.println("-------------------------------------");
                System.out.println("  고객 ID     : " + cid);
                System.out.println("  상품 ID     : " + pid);
                System.out.println("-------------------------------------");
                System.out.println("카트 항목이 성공적으로 삭제되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("      [ 카트 항목 삭제 실패 ]         ");
                System.out.println("-------------------------------------");
                System.out.println("  고객 ID     : " + cid);
                System.out.println("  상품 ID     : " + pid);
                System.out.println("-------------------------------------");
                System.out.println("해당 항목을 삭제하는 데 실패했습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("     [ 카트 항목 삭제 중 오류 발생 ]   ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
