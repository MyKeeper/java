package src.org.ccunix.record_manager.util;

import java.lang.reflect.Method;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwitchMenuItemUtil {
	/**
	 * 添加不同的jpanel功能
	 * 
	 * @param frame
	 *            窗口
	 * @param jpanel
	 *            原页面
	 * @param switchJPanel
	 *            想要添加的页面
	 */
	public static void switchJpane(JFrame frame, JPanel jpanel, JPanel switchJPanel) {
		// 清空jpanel中的组件
		jpanel.removeAll();
		// 创建新添加的组件 学生添加页面
		jpanel.setLayout(null);
		// studentAddJPanel.setBounds(x, y, width, height);
		jpanel.add(switchJPanel);
		// 刷新jpanel
		jpanel.repaint();
		// 刷新
		frame.validate();
	}

	/**
	 * 下拉框联级
	 * 
	 */
	public static void getJcomBoxItem(List list, JComboBox comBox, String fristItem) {
		// 初始化大学数据集合
		if (list.size() > 0) {
			String[] arr = null;
			arr = new String[list.size() + 1];
			arr[0] = fristItem;

			for (int i = 0; i < list.size(); i++) {
				//获取每一个类型信息
				Object obj=list.get(i);
				// 判断list类型
				Class c = obj.getClass();
				// 找到getItem方法
				try {
					Method m_getItem = c.getMethod("getItem", null);
					//在invoke中传对象 obj
					Object o_getItemValue = m_getItem.invoke(obj, null);
					//用toSting将方法运行后的返回值传给数组
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
