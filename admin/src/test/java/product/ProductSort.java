package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductSort {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // ProductService 빈을 가져옴
        ProductService productService = (ProductService) context.getBean("productService");

        try {
            // 전체 상품 가격 오름차순 정렬
            List<Product> productsByPriceAsc = productService.getSortedBy("price_asc", null);
            System.out.println("=====================================");
            System.out.println("    [ 전체 상품 가격 오름차순 정렬 ]   ");
            for (Product product : productsByPriceAsc) {
                printProductDetails(product);
            }

            // 카테고리 ID 14 상품 가격 내림차순 정렬
            List<Product> productsByCategoryAndPriceDesc = productService.getSortedBy("price_desc", 14);
            System.out.println("=====================================");
            System.out.println(" [ 카테고리 ID 14 상품 가격 내림차순 정렬 ] ");
            for (Product product : productsByCategoryAndPriceDesc) {
                printProductDetails(product);
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 상품 정렬 중 오류 발생 ]       ");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }

    // 상품 정보를 출력하는 메서드
    private static void printProductDetails(Product product) {
        System.out.println("상품명        : " + product.getPname());
        System.out.println("가격          : " + product.getPrice() + "원");
        System.out.println("-------------------------------------");
    }
}
