package address;

import edu.sm.dto.Address;
import edu.sm.service.AddressService;

import java.util.List;

public class AddressSelectByCid {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        int customerId = 1;  // 조회할 고객 ID

        try {
            List<Address> addressList = addressService.getByCustomerId(customerId);

            if (addressList.isEmpty()) {
                System.out.println("=====================================");
                System.out.println("    [ 조회된 주소가 없습니다 ]    ");
                System.out.println("고객 ID: " + customerId);
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("     [ 고객 ID " + customerId + "의 주소 목록 ]     ");
                System.out.println("=====================================");

                for (Address address : addressList) {
                    System.out.println("주소 ID      : " + address.getAid());
                    System.out.println("이름         : " + address.getAname());
                    System.out.println("주소         : " + address.getAddress());
                    System.out.println("상세 주소    : " + address.getAddressDetail());
                    System.out.println("우편번호     : " + address.getZipCode());
                    System.out.println("전화번호     : " + address.getPhone());
                    System.out.println("-------------------------------------");
                }

                System.out.println("총 " + addressList.size() + "개의 주소가 조회되었습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("    [ 주소 조회 중 오류 발생 ]    ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
