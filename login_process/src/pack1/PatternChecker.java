package pack1;

import java.util.regex.Pattern;

public class PatternChecker {
    
    // 아이디 검사. 앞에는 영어 , 뒤에는 영어랑 숫자 , 3이상 9이하
    public static boolean isId(String str) {
        return Pattern.matches("^[A-Za-z][A-Za-z0-9]{3,9}$", str);
    }
    
    // 비밀번호 검사.  영어와 숫자 섞어서 특수문자 금지 4이상 11이하
    public static boolean isPw(String str) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{4,11}$", str);
    }
    
    // 한글로만 구성되었는지에 대한 형식 검사
    public static boolean isKor(String str) {
        return Pattern.matches("^[ㄱ-ㅎ가-힣]{3,30}*$", str);
    }
    
    // 영어로만 구성되었는지에 대한 형식 검사
    public static boolean isName(String str) {
        return Pattern.matches("^[a-zA-Z]{5,30}$", str);
    }
    
    // 영문과 숫자로만 구성되었는지에 대한 형식 검사
    public static boolean isEngNum(String str) {
        return Pattern.matches("^[a-zA-Z0-9]*$", str);
    }
    
    // 한글과 숫자로만 구성되었는지에 대한 형식 검사
    public static boolean isKorNum(String str) {
        return Pattern.matches("^[ㄱ-ㅎ가-힣0-9]*$", str);
    }
    
    // 이메일 형식인지에 대한 검사 -> "아이디@도메인"의 형식을 충족해야 한다.
    public static boolean isEmail(String str) {
        return Pattern.matches("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,50}$", str);
    }
    
//        핸드폰번호인지에 대한 형식검사.
//        반드시 앞자리가 010,010,016~9사이를 충족해야 하며,
//        각 부분에 대한 자리수도 충족시켜야 한다.
//        "-"는 허용하지 않는다.
    public static boolean isPhoneNumber(String str) {
        return Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
    }
    
//    	   전화번호인지에 대한 형식검사. 각 연결부는 "-"로 구분되어야 한다.
//        각 부분에 대한 자리수도 충족시켜야 한다.
//        "-"는 허용하지 않는다.
    public static boolean isTel(String str) {
        return Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", str);
    }
    
//		   주민번호에 대한 글자수 및 뒷자리 첫글자가 1~4의 범위에 있는지에 대한 검사.
//        "-"는 허용하지 않는다.
    public static boolean isJumin(String str) {
        return Pattern.matches("^\\d{6}[1-4]\\d{6}", str);
    }
    
    // 	아이피주소 형식에 대한 검사 
    public static boolean isIP(String str) {
        return Pattern.matches("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})", str);
    }
}