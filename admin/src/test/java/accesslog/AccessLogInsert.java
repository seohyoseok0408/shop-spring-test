package accesslog;

import edu.sm.dto.AccessLog;
import edu.sm.service.AccessLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccessLogInsert {
    public static void main(String[] args) {
        // Spring 설정 파일을 로드하여 ApplicationContext 사용
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccessLogService accessLogService = context.getBean("accessLogService", AccessLogService.class);

        AccessLog accessLog = new AccessLog();
        accessLog.setCid(20);  // 사용자의 ID를 설정
        try {
            accessLogService.add(accessLog); // 로그 추가

            String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            System.out.println("=====================================");
            System.out.println("         [ 접속 로그 추가 완료 ]        ");
            System.out.println("-------------------------------------");
            System.out.println("  사용자 ID (CID) : " + accessLog.getCid());
            System.out.println("  등록 시간       : " + formattedDateTime);
            System.out.println("-------------------------------------");
            System.out.println("접속 로그가 성공적으로 추가되었습니다.");
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("         [ 접속 로그 추가 실패 ]       ");
            System.out.println("-------------------------------------");
            System.out.println("에러가 발생했습니다: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            // context는 여기서 명시적으로 close할 필요는 없습니다.
            if (context instanceof ClassPathXmlApplicationContext) {
                ((ClassPathXmlApplicationContext) context).close();
            }
        }
    }
}
