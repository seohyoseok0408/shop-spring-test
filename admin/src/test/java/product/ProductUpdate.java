package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductUpdate {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // ProductService 빈을 가져옴
        ProductService productService = (ProductService) context.getBean("productService");

        try {
            // 기존 상품 조회
            int pid = 15;
            Product product = productService.get(pid);

            if (product != null) {
                // 상품 정보 수정
                product.setPrice(60000);
                product.setCnt(20);
                product.setPublic(true);

                Product updatedProduct = productService.modify(product);

                if (updatedProduct != null) {
                    System.out.println("상품 정보가 성공적으로 수정되었습니다.");
                    System.out.println("수정된 가격 : " + updatedProduct.getPrice());
                } else {
                    System.out.println("상품 수정 중 오류 발생");
                }
            } else {
                System.out.println("해당 상품을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 상품 수정 중 오류 발생 ]       ");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}
