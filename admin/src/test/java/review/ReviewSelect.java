package review;

import edu.sm.dto.Review;
import edu.sm.service.ReviewService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReviewSelect {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ReviewService reviewService = (ReviewService) context.getBean("reviewService");

        int rid = 5;  // 조회할 리뷰 ID

        try {
            Review review = reviewService.get(rid);
            if (review != null) {
                System.out.println("=====================================");
                System.out.println("          [ 리뷰 조회 성공 ]          ");
                System.out.println("리뷰 정보가 성공적으로 조회되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("      [ 해당 리뷰를 찾을 수 없습니다 ]    ");
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
