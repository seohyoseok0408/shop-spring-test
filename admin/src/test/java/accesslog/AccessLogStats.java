package accesslog;

import edu.sm.service.AccessLogService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccessLogStats {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccessLogService accessLogService = context.getBean("accessLogService", AccessLogService.class);

        try {
            System.out.println("=====================================");
            System.out.println("       [ 접근 로그 통계 조회 ]         ");
            System.out.println("=====================================");

            // 시간별 접속 통계
            try {
                List<String> hourlyStats = accessLogService.getHourlyStats();
                System.out.println("\n 시간별 접속 통계 ");
                System.out.println("-------------------------------------");
                if (hourlyStats.isEmpty()) {
                    System.out.println("시간별 접속 기록이 없습니다.");
                } else {
                    for (String stat : hourlyStats) {
                        String[] parts = stat.split(":");
                        String hour = parts[0].trim() + "시";
                        String count = parts[1].trim() + "명";
                        System.out.println(hour + " : " + count);
                    }
                }
                System.out.println("-------------------------------------");
            } catch (Exception e) {
                System.out.println("[ 시간별 통계 조회 중 오류 발생 ]");
                e.printStackTrace();
            }

            // 일별 접속 통계
            try {
                List<String> dailyStats = accessLogService.getDailyStats();
                System.out.println("\n 일별 접속 통계 ");
                System.out.println("-------------------------------------");
                if (dailyStats.isEmpty()) {
                    System.out.println("일별 접속 기록이 없습니다.");
                } else {
                    for (String stat : dailyStats) {
                        System.out.println(stat);
                    }
                }
                System.out.println("-------------------------------------");
            } catch (Exception e) {
                System.out.println("[ 일별 통계 조회 중 오류 발생 ]");
                e.printStackTrace();
            }

            // 요일별 접속 통계
            try {
                List<String> weeklyStats = accessLogService.getWeeklyStats();
                System.out.println("\n 요일별 접속 통계 ");
                System.out.println("-------------------------------------");
                if (weeklyStats.isEmpty()) {
                    System.out.println("요일별 접속 기록이 없습니다.");
                } else {
                    for (String stat : weeklyStats) {
                        System.out.println(stat);
                    }
                }
                System.out.println("-------------------------------------");
            } catch (Exception e) {
                System.out.println("[ 요일별 통계 조회 중 오류 발생 ]");
                e.printStackTrace();
            }

            // 월별 접속 통계
            try {
                List<String> monthlyStats = accessLogService.getMonthlyStats();
                System.out.println("\n 월별 접속 통계 ");
                System.out.println("-------------------------------------");
                if (monthlyStats.isEmpty()) {
                    System.out.println("월별 접속 기록이 없습니다.");
                } else {
                    for (String stat : monthlyStats) {
                        String[] parts = stat.split(":");
                        String month = parts[0].trim() + "월";
                        String count = parts[1].trim() + "명";
                        System.out.println(month + " : " + count);
                    }
                }
                System.out.println("-------------------------------------");
            } catch (Exception e) {
                System.out.println("[ 월별 통계 조회 중 오류 발생 ]");
                e.printStackTrace();
            }

            // 연도별 접속 통계
            try {
                List<String> yearlyStats = accessLogService.getYearlyStats();
                System.out.println("\n 연도별 접속 통계 ");
                System.out.println("-------------------------------------");
                if (yearlyStats.isEmpty()) {
                    System.out.println("연도별 접속 기록이 없습니다.");
                } else {
                    for (String stat : yearlyStats) {
                        String[] parts = stat.split(":");
                        String year = parts[0].trim() + "년";
                        String count = parts[1].trim() + "명";
                        System.out.println(year + " : " + count);
                    }
                }
                System.out.println("-------------------------------------");
            } catch (Exception e) {
                System.out.println("[ 연도별 통계 조회 중 오류 발생 ]");
                e.printStackTrace();
            }

            System.out.println("=====================================");
            System.out.println("   [ 모든 접근 로그 통계 조회 완료 ]   ");
            System.out.println("=====================================");
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 접근 로그 통계 조회 실패 ]    ");
            System.out.println("-------------------------------------");
            System.out.println("에러가 발생했습니다: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        } finally {
            ((ClassPathXmlApplicationContext) context).close();
        }
    }
}
