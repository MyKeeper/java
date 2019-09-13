package src.org.ccunix.record_manager.util;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 验证信息
 */
public class Verify {
	// 电话 11位
	public static boolean phone(String phone) {
		if (!"".equals(phone)) {
			if (phone.matches("^1[0-9&&[^2]]\\d{9}$")) {
				return true;
			}
		}
		return false;
	}

	// 年龄 只能是数字 不超过150
	public static boolean ageFelx(String age) {
		if (isCanInt(age)) {
			int a = Integer.parseInt(age);
			if (a > 0 && a < 150)
				return true;
		}
		return false;
	}

	// 字符串必须全部由数字构成
	public static boolean isCanInt(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	// 字符串由数字和一个.组成
	public static boolean isCanDouble(String str) {
		if(isCanInt(str)){
			return true;
		}else{
			if(str.contains(".")){
				String[] strSon = str.split("\\.");
				if (!str.contains(" ")) {
					if (strSon.length == 2) {
						if (isCanInt(strSon[0]) && isCanInt(strSon[1])) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
