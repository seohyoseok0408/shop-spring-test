package accesslog;

import edu.sm.dto.AccessLog;
import edu.sm.service.AccessLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AccessLogSelectAll {
    public static void main(String[] args) {
        // Spring 설정 파일을 로드하여 서비스 객체를 가져옴
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccessLogService accessLogService = context.getBean("accessLogService", AccessLogService.class);

        try {
            List<AccessLog> accessLogs = accessLogService.get(); // 수정된 메서드명 사용
            if (accessLogs.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("     [ 조회된 접근 로그가 없습니다  ]    ");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("         [ 전체 접근 로그 조회 ]        ");
                System.out.println("-------------------------------------");

                // 각 로그를 출력
                for (AccessLog log : accessLogs) {
                    String formattedDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    System.out.println("로그 ID        : " + log.getLogId());
                    System.out.println("사용자 ID (CID): " + log.getCid());
                    System.out.println("접속 시간      : " + log.getAccessTime());
                    System.out.println("-------------------------------------");
                }

                System.out.println("총 " + accessLogs.size() + "개의 로그가 조회되었습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 접근 로그 조회 실패 ]        ");
            System.out.println("-------------------------------------");
            System.out.println("에러가 발생했습니다: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}
