package cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartUpdateCnt {
    public static void main(String[] args) {
        CartService cartService = new CartService();
        int cartId = 1;  // 실제로 수정할 장바구니 항목 ID로 수정

        try {
            Cart cart = new Cart(cartId, 1, 6, 4, 0); // 수정할 정보를 담은 Cart 객체 생성
            cartService.modify(cart);
            System.out.println("=====================================");
            System.out.println("   [ 장바구니 항목 수정 성공 ]");
            System.out.println("-------------------------------------");
            System.out.println("  장바구니 ID : " + cart.getCartKey());
            System.out.println("  상품 ID     : " + cart.getPid());
            System.out.println("  수정된 수량 : " + cart.getCnt());
            System.out.println(" 총 금액 : " + cart.getPrice());
            System.out.println("-------------------------------------");
            System.out.println("장바구니 항목이 성공적으로 수정되었습니다.");
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("   [ 장바구니 항목 수정 중 오류 발생 ]");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
