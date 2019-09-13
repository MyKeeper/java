package src.org.ccunix.record_manager.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwitchMenuItemUtil {
	/**
	 * ��Ӳ�ͬ��jpanel����
	 * 
	 * @param frame
	 *            ����
	 * @param jpanel
	 *            ԭҳ��
	 * @param switchJPanel
	 *            ��Ҫ��ӵ�ҳ��
	 */
	public static void switchJpane(JFrame frame, JPanel jpanel, JPanel switchJPanel) {
		// ���jpanel�е����
		jpanel.removeAll();
		// ��������ӵ���� ѧ�����ҳ��
		jpanel.setLayout(null);
		// studentAddJPanel.setBounds(x, y, width, height);
		jpanel.add(switchJPanel);
		// ˢ��jpanel
		jpanel.repaint();
		// ˢ��
		frame.validate();
	}

	/**
	 * ����������
	 * 
	 */
	public static void getJcomBoxItem(List list, JComboBox comBox, String fristItem) {
		// ��ʼ����ѧ���ݼ���
		if (list.size() > 0) {
			String[] arr = null;
			arr = new String[list.size() + 1];
			arr[0] = fristItem;

			for (int i = 0; i < list.size(); i++) {
				//��ȡÿһ��������Ϣ
				Object obj=list.get(i);
				// �ж�list����
				Class c = obj.getClass();
				// �ҵ�getItem����
				try {
					Method m_getItem = c.getMethod("getItem", null);
					//��invoke�д����� obj
					Object o_getItemValue = m_getItem.invoke(obj, null);
					//��toSting���������к�ķ���ֵ��������
					arr[i + 1] = o_getItemValue.toString();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			comBox.setModel(new DefaultComboBoxModel(arr));
		} else {
			comBox.setModel(new DefaultComboBoxModel(new String[] { fristItem }));
		}

	}
}
