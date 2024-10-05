package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;

public class AddressUpdate {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        Address updatedAddress = Address.builder()
                .aid(1) // 수정할 주소의 ID
                .aname("이태빈") // 수정된 이름
                .address("아산시 탕정면")
                .addressDetail("빌라 303호")
                .zipCode("543210")
                .phone("01099998888")
                .build();

        try {
            Address isUpdated = addressService.modify(updatedAddress);
            if (isUpdated != null) {
                System.out.println("=====================================");
                System.out.println("          [ 주소 수정 성공 ]          ");
                System.out.println("-------------------------------------");
                System.out.println("  주소 ID      : " + updatedAddress.getAid());
                System.out.println("  이름         : " + updatedAddress.getAname());
                System.out.println("  주소         : " + updatedAddress.getAddress());
                System.out.println("  상세 주소    : " + updatedAddress.getAddressDetail());
                System.out.println("  우편번호     : " + updatedAddress.getZipCode());
                System.out.println("  전화번호     : " + updatedAddress.getPhone());
                System.out.println("-------------------------------------");
                System.out.println("주소가 성공적으로 수정되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("         [ 주소 수정 실패 ]           ");
                System.out.println("-------------------------------------");
                System.out.println("해당 ID로 수정할 주소가 없습니다: " + updatedAddress.getAid());
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("       [ 주소 수정 중 오류 발생 ]      ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
