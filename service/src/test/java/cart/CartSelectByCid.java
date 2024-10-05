package cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

import java.util.List;

public class CartSelectByCid {
    public static void main(String[] args) {
        CartService cartService = new CartService();

        try {
            int cid = 1; // 고객 ID

            // 해당 고객의 장바구니 항목 조회
            List<Cart> cartList = cartService.getCartByCid(cid);

            if (cartList.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("   [ 고객 ID: " + cid + " 의 장바구니가 비어 있습니다 ]");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("   [ 고객 ID: " + cid + " 의 장바구니 항목 조회 ]");
                System.out.println("=====================================");

                for (Cart cart : cartList) {
                    System.out.println("장바구니 ID  : " + cart.getCartKey());
                    System.out.println("상품 ID      : " + cart.getPid());
                    System.out.println("수량         : " + cart.getCnt());
                    System.out.println("금액         : " + cart.getPrice());
                    System.out.println("-------------------------------------");
                }

                System.out.println("총 " + cartList.size() + " 개의 항목이 장바구니에 있습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("   [ 장바구니 항목 조회 중 오류 발생 ]");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
