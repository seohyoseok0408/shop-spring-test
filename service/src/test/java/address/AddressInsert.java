package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;

public class AddressInsert {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        // 테스트용 주소 데이터 생성
        Address newAddress = Address.builder()
                .cid(1) // 고객 ID
                .aname("김철수")
                .address("서울시 강남구")
                .addressDetail("아파트 101호")
                .zipCode("123456")
                .phone("01012345678")
                .build();

        try {
            addressService.add(newAddress);

            System.out.println("=====================================");
            System.out.println("          [ 주소 추가 성공 ]          ");
            System.out.println("-------------------------------------");
            System.out.println("  고객 ID      : " + newAddress.getCid());
            System.out.println("  이름         : " + newAddress.getAname());
            System.out.println("  주소         : " + newAddress.getAddress());
            System.out.println("  상세 주소    : " + newAddress.getAddressDetail());
            System.out.println("  우편번호     : " + newAddress.getZipCode());
            System.out.println("  연락처       : " + newAddress.getPhone());
            System.out.println("-------------------------------------");
            System.out.println("주소가 성공적으로 추가되었습니다.");
            System.out.println("=====================================");

        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("         [ 주소 추가 중 오류 발생 ]   ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
