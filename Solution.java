import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

	private static boolean isBanlanced(String staff) {
		int halfLen = staff.length() / 2;
		String first = staff.substring(0, halfLen);
		String second = staff.substring(halfLen);
		float sum = getSum(staff);
		float mass = sum * (staff.length() + 1) /2;
		if (getMass(first.concat(second)) == mass || 
				getMass(first.concat(new StringBuilder(second).reverse().toString())) == mass ||
				getMass(new StringBuilder(first).reverse().toString().concat(second)) == mass ||
				getMass(new StringBuilder(first).reverse().toString().concat(new StringBuilder(second).reverse().toString())) == mass
				) {
			return true;
		}
		
		return false;
	}
	
	private static int getMass(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			result += Integer.valueOf(str.charAt(i) * (i + 1));
		}
		return result;
	}
	
	private static int getSum(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			result += Integer.valueOf(str.charAt(i));
		}
		return result;
	}
	
	public static void getStaff() throws IOException {
//		String branch = "7512839182731294837512653698759387212532563849823857812519853546649398328875256156256652116394915985281859358394738256421937941843758954891723598716547856473245243546392898871987152656238458214518158188152527386384518234758325165316563487283746285745938476523546127534721652812736459874658475366423876152387491872658763218276354827768598716283764571652637451962837648726876547826359871629836547862534761798346918275676473829648651672346981726587619462561625162561527384273482748237482734827348274827";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String branch = br.readLine();
		int len = branch.length();
		
		StringBuilder sbBranch = new StringBuilder(branch);
		
		int curlen = len / 2;
		
		while (curlen > 0) {
			int firstStart = 0;
			int firstEnd = len - 2 * curlen;
			for (int i = firstStart; i <= firstEnd; i++) {
				String first = sbBranch.substring(i, i + curlen);
				for (int j = i + curlen; j <= len - curlen; j++) {
					String second = sbBranch.substring(j, j + curlen);
					if (isBanlanced(first.concat(second))) {
						System.out.println(i + " " + j + " " + curlen);
						return;
					}
				}
			}
			curlen--;
		}
	}
	
	public static void main(String[] args) throws IOException {
		getStaff();
	}
}


