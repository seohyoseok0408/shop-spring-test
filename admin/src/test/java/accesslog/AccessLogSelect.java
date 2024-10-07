package accesslog;

import edu.sm.dto.AccessLog;
import edu.sm.service.AccessLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccessLogSelect {
    public static void main(String[] args) {
        // Spring 설정 파일을 로드하여 서비스 객체를 가져옴
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccessLogService accessLogService = context.getBean("accessLogService", AccessLogService.class);

        int logId = 7;  // 조회할 로그 ID 설정
        try {
            AccessLog accessLog = accessLogService.get(logId); // 수정된 메서드명 사용
            if (accessLog != null) {
                String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                System.out.println("=====================================");
                System.out.println("         [ 접근 로그 조회 결과 ]       ");
                System.out.println("-------------------------------------");
                System.out.println("  로그 ID        : " + accessLog.getLogId());
                System.out.println("  사용자 ID (CID): " + accessLog.getCid());
                System.out.println("  접속 시간      : " + accessLog.getAccessTime());
                System.out.println("-------------------------------------");
                System.out.println("로그 정보가 성공적으로 조회되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("         [ 접근 로그 조회 실패 ]       ");
                System.out.println("-------------------------------------");
                System.out.println("  해당 로그가 없습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("         [ 접근 로그 조회 실패 ]       ");
            System.out.println("-------------------------------------");
            System.out.println("에러가 발생했습니다: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}
