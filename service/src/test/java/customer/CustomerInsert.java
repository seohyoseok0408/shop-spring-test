package customer;

import edu.sm.dto.Customer;
import edu.sm.service.CustomerService;

import java.sql.Date;
import java.time.LocalDate;

public class CustomerInsert {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();

        // 생년월일을 올바르게 변환 (LocalDate 사용 후 Date로 변환)
        LocalDate birthDate = LocalDate.of(2001, 4, 8); // 2001년 4월 8일
        Date sqlBirthDate = Date.valueOf(birthDate);  // java.sql.Date로 변환

        Customer customer = Customer.builder()
                .pwd("1234")
                .cname("서효석")
                .email("ascc@naver.com")
                .phone("01079794192")
                .birth_date(sqlBirthDate)  // 변환된 생년월일 사용
                .nick_name("집보내줘")
                .build();

        try {
            customerService.add(customer);

            System.out.println("=====================================");
            System.out.println("         [ 고객 추가 성공 ]           ");
            System.out.println("-------------------------------------");
            System.out.println("  고객 이름    : " + customer.getCname());
            System.out.println("  이메일       : " + customer.getEmail());
            System.out.println("  전화번호     : " + customer.getPhone());
            System.out.println("  생년월일     : " + customer.getBirth_date());
            System.out.println("  닉네임       : " + customer.getNick_name());
            System.out.println("-------------------------------------");
            System.out.println("고객 정보가 성공적으로 추가되었습니다.");
            System.out.println("=====================================");

        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("     [ 고객 추가 중 오류 발생 ]        ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
