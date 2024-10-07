package product;

import edu.sm.dto.Product;
import edu.sm.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductInsert {
    public static void main(String[] args) {
        // Spring 컨텍스트 로드
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // ProductService 빈을 가져옴
        ProductService productService = (ProductService) context.getBean("productService");

        try {
            // 새로운 상품 생성
            Product product = Product.builder()
                    .categoryId(15)
                    .disId(4)
                    .pname("닌텐도")
                    .price(500000)
                    .cnt(10)
                    .img1("img1.jpg")
                    .img2("img2.jpg")
                    .img3("img3.jpg")
                    .img4("img4.jpg")
                    .content("마리오카트")
                    .isPublic(true)
                    .build();

            // 상품을 추가
            Product insertedProduct = productService.add(product);

            if (insertedProduct != null) {
                System.out.println("=====================================");
                System.out.println("          [ 상품 추가 성공 ]           ");
                System.out.println("  상품 ID       : " + insertedProduct.getPid());
                System.out.println("  상품명        : " + insertedProduct.getPname());
                System.out.println("=====================================");
            } else {
                System.out.println("상품 추가 실패");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 상품 추가 중 오류 발생 ]       ");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}
