package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductSelect {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // ProductService 빈을 가져옴
        ProductService productService = (ProductService) context.getBean("productService");

        try {
            // 상품 ID 조회
            int pid = 16;
            Product product = productService.get(pid);

            if (product != null) {
                System.out.println("=====================================");
                System.out.println("          [ 상품 정보 조회 ]          ");
                System.out.println("  상품명        : " + product.getPname());
                System.out.println("  가격          : " + product.getPrice() + "원");
                System.out.println("=====================================");
            } else {
                System.out.println("해당 상품 정보가 없습니다.");
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
