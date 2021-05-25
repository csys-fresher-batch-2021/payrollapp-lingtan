package in.lingtan.service;



import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import in.lingtan.dto.PayRollDTO;


public class PayRollServiceTestCase {

	@Test
	public void test() {
		PayRollService payRollService = new PayRollService();
		try {
			List<PayRollDTO> payRollData = payRollService.getPayRoleData("HR");
			for(PayRollDTO payRoll : payRollData) {
		
				System.out.println(payRoll.getHraAllowance());
				System.out.println(payRoll.getFoodAllowance());
			}
			System.out.println(payRollData);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
