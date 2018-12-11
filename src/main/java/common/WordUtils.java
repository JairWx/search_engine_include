package common;

public class WordUtils {
	
	public static String StrToTableName(String str,String separatorChar) {
		char[] strArray = str.toCharArray();
		StringBuffer wordSb = new StringBuffer();
		StringBuffer tableName = new StringBuffer();
		for(char strChar : strArray){
			if(strChar > 'A' && strChar < 'Z') {
				if(wordSb.length() != 0) {
					tableName.append(wordSb.toString().toLowerCase()).append(separatorChar);
					//wordSb = new StringBuffer(strChar); 竟然强转为int
					wordSb = new StringBuffer().append(strChar);
				}else {
					wordSb.append(strChar);
				}
			}else {
				wordSb.append(strChar);
			}
		}
		tableName.append(wordSb.toString().toLowerCase());
		return tableName.toString();
		
	}
	public static String StrToTableName(String str) {
		return StrToTableName(str,"_");
	}

	public static void main(String[] args) {
		System.out.println(WordUtils.StrToTableName("BlogUrl"));
	}
	
}
