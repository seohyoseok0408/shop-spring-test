package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ReviewSelectAll {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ReviewService reviewService = (ReviewService) context.getBean("reviewService");

        try {
            List<Review> reviews = reviewService.get();

            if (reviews.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("       [ 조회된 리뷰가 없습니다 ]      ");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("         [ 전체 리뷰 목록 조회 ]       ");
                for (Review review : reviews) {
                    System.out.println("리뷰 ID     : " + review.getRid());
                    System.out.println("상품 ID     : " + review.getPid());
                    System.out.println("고객 ID     : " + review.getCid());
                    System.out.println("평점        : " + review.getRate());
                    System.out.println("-------------------------------------");
                }
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 리뷰 조회 중 오류 발생 ]       ");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();  // Spring 컨텍스트 닫기
        }
    }
}
