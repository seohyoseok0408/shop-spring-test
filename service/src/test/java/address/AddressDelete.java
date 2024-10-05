package address;

import edu.sm.service.AddressService;

public class AddressDelete {
    public static void main(String[] args) {
        AddressService addressService = new AddressService();

        int addressId = 1; // 삭제할 주소 ID

        try {
            boolean result = addressService.remove(addressId);
            if (result) {
                System.out.println("=====================================");
                System.out.println("         [ 주소 삭제 성공 ]           ");
                System.out.println("-------------------------------------");
                System.out.println("  삭제된 주소 ID : " + addressId);
                System.out.println("-------------------------------------");
                System.out.println("주소가 성공적으로 삭제되었습니다.");
                System.out.println("=====================================");
            } else {
                System.out.println("=====================================");
                System.out.println("         [ 주소 삭제 실패 ]           ");
                System.out.println("-------------------------------------");
                System.out.println("  해당 ID로 삭제할 주소가 없습니다: " + addressId);
                System.out.println("-------------------------------------");
                System.out.println("삭제에 실패하였습니다.");
                System.out.println("=====================================");
            }
        } catch (Exception e) {
            System.out.println("=====================================");
            System.out.println("         [ 주소 삭제 중 오류 발생 ]    ");
            System.out.println("-------------------------------------");
            System.out.println("에러 메시지: " + e.getMessage());
            System.out.println("=====================================");
            e.printStackTrace();
        }
    }
}
