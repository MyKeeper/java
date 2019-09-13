package src.org.ccunix.record_manager.util;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * ��֤��Ϣ
 */
public class Verify {
	// �绰 11λ
	public static boolean phone(String phone) {
		if (!"".equals(phone)) {
			if (phone.matches("^1[0-9&&[^2]]\\d{9}$")) {
				return true;
			}
		}
		return false;
	}

	// ���� ֻ�������� ������150
	public static boolean ageFelx(String age) {
		if (isCanInt(age)) {
			int a = Integer.parseInt(age);
			if (a > 0 && a < 150)
				return true;
		}
		return false;
	}

	// �ַ�������ȫ�������ֹ���
	public static boolean isCanInt(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	// �ַ��������ֺ�һ��.���
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
