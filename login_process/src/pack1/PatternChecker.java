package pack1;

import java.util.regex.Pattern;

public class PatternChecker {
    
    // ���̵� �˻�. �տ��� ���� , �ڿ��� ����� ���� , 3�̻� 9����
    public static boolean isId(String str) {
        return Pattern.matches("^[A-Za-z][A-Za-z0-9]{3,9}$", str);
    }
    
    // ��й�ȣ �˻�.  ����� ���� ��� Ư������ ���� 4�̻� 11����
    public static boolean isPw(String str) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{4,11}$", str);
    }
    
    // �ѱ۷θ� �����Ǿ������� ���� ���� �˻�
    public static boolean isKor(String str) {
        return Pattern.matches("^[��-����-�R]{3,30}*$", str);
    }
    
    // ����θ� �����Ǿ������� ���� ���� �˻�
    public static boolean isName(String str) {
        return Pattern.matches("^[a-zA-Z]{5,30}$", str);
    }
    
    // ������ ���ڷθ� �����Ǿ������� ���� ���� �˻�
    public static boolean isEngNum(String str) {
        return Pattern.matches("^[a-zA-Z0-9]*$", str);
    }
    
    // �ѱ۰� ���ڷθ� �����Ǿ������� ���� ���� �˻�
    public static boolean isKorNum(String str) {
        return Pattern.matches("^[��-����-�R0-9]*$", str);
    }
    
    // �̸��� ���������� ���� �˻� -> "���̵�@������"�� ������ �����ؾ� �Ѵ�.
    public static boolean isEmail(String str) {
        return Pattern.matches("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,50}$", str);
    }
    
//        �ڵ�����ȣ������ ���� ���İ˻�.
//        �ݵ�� ���ڸ��� 010,010,016~9���̸� �����ؾ� �ϸ�,
//        �� �κп� ���� �ڸ����� �������Ѿ� �Ѵ�.
//        "-"�� ������� �ʴ´�.
    public static boolean isPhoneNumber(String str) {
        return Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
    }
    
//    	   ��ȭ��ȣ������ ���� ���İ˻�. �� ����δ� "-"�� ���еǾ�� �Ѵ�.
//        �� �κп� ���� �ڸ����� �������Ѿ� �Ѵ�.
//        "-"�� ������� �ʴ´�.
    public static boolean isTel(String str) {
        return Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", str);
    }
    
//		   �ֹι�ȣ�� ���� ���ڼ� �� ���ڸ� ù���ڰ� 1~4�� ������ �ִ����� ���� �˻�.
//        "-"�� ������� �ʴ´�.
    public static boolean isJumin(String str) {
        return Pattern.matches("^\\d{6}[1-4]\\d{6}", str);
    }
    
    // 	�������ּ� ���Ŀ� ���� �˻� 
    public static boolean isIP(String str) {
        return Pattern.matches("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})", str);
    }
}