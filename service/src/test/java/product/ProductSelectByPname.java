package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.List;

public class ProductSelectByPname {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        try {
            String searchName = "DI"; // 조회할 상품명 (부분 일치)
            List<Product> products = productService.getByName(searchName);

            // 상품명으로 조회된 결과 출력
            if (products.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("     [ '" + searchName + "'으로 조회된 상품이 없습니다 ] ");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("   [ '" + searchName + "'으로 조회된 상품 목록 ]   ");
                System.out.println("=====================================");

                for (Product product : products) {
                    System.out.println("상품 ID       : " + product.getPid());
                    System.out.println("상품명        : " + product.getPname());
                    System.out.println("가격          : " + product.getPrice() + "원");
                    System.out.println("재고          : " + product.getCnt());
                    System.out.println("설명          : " + product.getContent());
                    System.out.println("-------------------------------------");
                }

                System.out.println("총 " + products.size() + "개의 상품이 '" + searchName + "'으로 조회되었습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("    [ 상품명 조회 중 오류 발생 ]     ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
