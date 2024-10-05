package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;

import java.util.List;

public class ProductSelectPublicByCidCategoryId {
    public static void main(String[] args) {
        ProductService productService = new ProductService();

        try {
            // 카테고리별 공개된 상품 조회
            int categoryId = 13; // 조회할 카테고리 ID
            System.out.println("=====================================");
            System.out.println("   [ 카테고리 ID " + categoryId + "에 해당하는 공개된 상품 목록 ]   ");
            System.out.println("=====================================");

            List<Product> productsByCategory = productService.getPublicProductsByCategory(categoryId);

            if (productsByCategory.isEmpty()) {
                System.out.println("카테고리 ID " + categoryId + "에 해당하는 공개된 상품이 없습니다.");
            } else {
                for (Product product : productsByCategory) {
                    System.out.println("상품 ID       : " + product.getPid());
                    System.out.println("상품명        : " + product.getPname());
                    System.out.println("가격          : " + product.getPrice() + "원");
                    System.out.println("재고          : " + product.getCnt());
                    System.out.println("설명          : " + product.getContent());
                    System.out.println("-------------------------------------");
                }
                System.out.println("총 " + productsByCategory.size() + "개의 상품이 조회되었습니다.");
            }

            // 상품명으로 공개된 상품 조회
            String productName = "닌텐"; // 조회할 상품명
            System.out.println("\n=====================================");
            System.out.println("   [ '" + productName + "'으로 검색된 공개된 상품 목록 ]   ");
            System.out.println("=====================================");

            List<Product> productsByName = productService.getPublicByName(productName);

            if (productsByName.isEmpty()) {
                System.out.println("'" + productName + "'으로 검색된 공개된 상품이 없습니다.");
            } else {
                for (Product product : productsByName) {
                    System.out.println("상품 ID       : " + product.getPid());
                    System.out.println("상품명        : " + product.getPname());
                    System.out.println("가격          : " + product.getPrice() + "원");
                    System.out.println("재고          : " + product.getCnt());
                    System.out.println("설명          : " + product.getContent());
                    System.out.println("-------------------------------------");
                }
                System.out.println("총 " + productsByName.size() + "개의 상품이 조회되었습니다.");
            }

        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("    [ 공개된 상품 조회 중 오류 발생 ]     ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
