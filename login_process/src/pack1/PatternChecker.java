package pack1;

import java.util.regex.Pattern;

public class PatternChecker {
    
    // ¾ÆÀÌµğ °Ë»ç. ¾Õ¿¡´Â ¿µ¾î , µÚ¿¡´Â ¿µ¾î¶û ¼ıÀÚ , 3ÀÌ»ó 9ÀÌÇÏ
    public static boolean isId(String str) {
        return Pattern.matches("^[A-Za-z][A-Za-z0-9]{3,9}$", str);
    }
    
    // ºñ¹Ğ¹øÈ£ °Ë»ç.  ¿µ¾î¿Í ¼ıÀÚ ¼¯¾î¼­ Æ¯¼ö¹®ÀÚ ±İÁö 4ÀÌ»ó 11ÀÌÇÏ
    public static boolean isPw(String str) {
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{4,11}$", str);
    }
    
    // ÇÑ±Û·Î¸¸ ±¸¼ºµÇ¾ú´ÂÁö¿¡ ´ëÇÑ Çü½Ä °Ë»ç
    public static boolean isKor(String str) {
        return Pattern.matches("^[¤¡-¤¾°¡-ÆR]{3,30}*$", str);
    }
    
    // ¿µ¾î·Î¸¸ ±¸¼ºµÇ¾ú´ÂÁö¿¡ ´ëÇÑ Çü½Ä °Ë»ç
    public static boolean isName(String str) {
        return Pattern.matches("^[a-zA-Z]{5,30}$", str);
    }
    
    // ¿µ¹®°ú ¼ıÀÚ·Î¸¸ ±¸¼ºµÇ¾ú´ÂÁö¿¡ ´ëÇÑ Çü½Ä °Ë»ç
    public static boolean isEngNum(String str) {
        return Pattern.matches("^[a-zA-Z0-9]*$", str);
    }
    
    // ÇÑ±Û°ú ¼ıÀÚ·Î¸¸ ±¸¼ºµÇ¾ú´ÂÁö¿¡ ´ëÇÑ Çü½Ä °Ë»ç
    public static boolean isKorNum(String str) {
        return Pattern.matches("^[¤¡-¤¾°¡-ÆR0-9]*$", str);
    }
    
    // ÀÌ¸ŞÀÏ Çü½ÄÀÎÁö¿¡ ´ëÇÑ °Ë»ç -> "¾ÆÀÌµğ@µµ¸ŞÀÎ"ÀÇ Çü½ÄÀ» ÃæÁ·ÇØ¾ß ÇÑ´Ù.
    public static boolean isEmail(String str) {
        return Pattern.matches("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,50}$", str);
    }
    
//        ÇÚµåÆù¹øÈ£ÀÎÁö¿¡ ´ëÇÑ Çü½Ä°Ë»ç.
//        ¹İµå½Ã ¾ÕÀÚ¸®°¡ 010,010,016~9»çÀÌ¸¦ ÃæÁ·ÇØ¾ß ÇÏ¸ç,
//        °¢ ºÎºĞ¿¡ ´ëÇÑ ÀÚ¸®¼öµµ ÃæÁ·½ÃÄÑ¾ß ÇÑ´Ù.
//        "-"´Â Çã¿ëÇÏÁö ¾Ê´Â´Ù.
    public static boolean isPhoneNumber(String str) {
        return Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
    }
    
//    	   ÀüÈ­¹øÈ£ÀÎÁö¿¡ ´ëÇÑ Çü½Ä°Ë»ç. °¢ ¿¬°áºÎ´Â "-"·Î ±¸ºĞµÇ¾î¾ß ÇÑ´Ù.
//        °¢ ºÎºĞ¿¡ ´ëÇÑ ÀÚ¸®¼öµµ ÃæÁ·½ÃÄÑ¾ß ÇÑ´Ù.
//        "-"´Â Çã¿ëÇÏÁö ¾Ê´Â´Ù.
    public static boolean isTel(String str) {
        return Pattern.matches("^\\d{2,3}-\\d{3,4}-\\d{4}$", str);
    }
    
//		   ÁÖ¹Î¹øÈ£¿¡ ´ëÇÑ ±ÛÀÚ¼ö ¹× µŞÀÚ¸® Ã¹±ÛÀÚ°¡ 1~4ÀÇ ¹üÀ§¿¡ ÀÖ´ÂÁö¿¡ ´ëÇÑ °Ë»ç.
//        "-"´Â Çã¿ëÇÏÁö ¾Ê´Â´Ù.
    public static boolean isJumin(String str) {
        return Pattern.matches("^\\d{6}[1-4]\\d{6}", str);
    }
    
    // 	¾ÆÀÌÇÇÁÖ¼Ò Çü½Ä¿¡ ´ëÇÑ °Ë»ç 
    public static boolean isIP(String str) {
        return Pattern.matches("([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})", str);
    }
}