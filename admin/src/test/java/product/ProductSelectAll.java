package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ProductSelectAll {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // ProductService 빈을 가져옴
        ProductService productService = (ProductService) context.getBean("productService");

        try {
            // 전체 상품 조회
            List<Product> products = productService.get();

            if (products != null && !products.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("         [ 전체 상품 목록 조회 ]       ");
                for (Product product : products) {
                    System.out.println("상품명        : " + product.getPname());
                    System.out.println("가격          : " + product.getPrice() + "원");
                    System.out.println("-------------------------------------");
                }
                System.out.println("총 " + products.size() + "개의 상품이 조회되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("조회된 상품이 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 상품 조회 중 오류 발생 ]      ");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}
