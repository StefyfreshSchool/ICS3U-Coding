package week11;
public class SelfDivisor{
    public static void main(String[] args) {
        System.out.println(isSelfDivisor(120));
    }
	
	public static boolean isSelfDivisor(int number){
		String num = Integer.toString(number);
		
		for (int i = 0; i < num.length(); i++){
			if (num.substring(i, i + 1).equals("0")) return false;
			if (number % Integer.parseInt(num.substring(i, i + 1)) != 0) return false;
		}
		return true;
	}
}