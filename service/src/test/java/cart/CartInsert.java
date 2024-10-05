package cart;

import edu.sm.dto.Cart;
import edu.sm.service.CartService;

public class CartInsert {
    public static void main(String[] args) {
        CartService cartService = new CartService();

        Cart cart = new Cart(0, 1, 6, 2, 0); // cartKey = 0, cid = 1, pid = 1, cnt = 2, price = 10000

        try {
            cartService.add(cart);
            System.out.println("=====================================");
            System.out.println("   [ 장바구니 항목 추가 성공 ]");
            System.out.println("-------------------------------------");
            System.out.println("  고객 ID      : " + cart.getCid());
            System.out.println("  상품 ID      : " + cart.getPid());
            System.out.println("  수량         : " + cart.getCnt());
            System.out.println("  가격         : " + cart.getPrice() + "원");

            System.out.println("-------------------------------------");
            System.out.println("장바구니 항목이 성공적으로 추가되었습니다.");
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("   [ 장바구니 항목 추가 중 오류 발생 ]");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
