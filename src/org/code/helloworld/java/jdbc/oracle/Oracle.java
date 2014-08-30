package org.code.helloworld.java.jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * 
 * ������ oracle �������ݿ����
 * 
 * @author yanchangyou@gmail.com
 * @date 2014-08-30 19:56:12
 *
 */
public class Oracle {

	public void test() throws Exception {

		// ��������
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// ���ݿ�������Ϣ��url���û���������
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userName = "p_soms_dev";
		String password = "p_soms_dev";

		// ��ȡ����
		Connection conn = DriverManager.getConnection(url, userName, password);

		// ����������
		Statement stat = conn.createStatement();

		// ��ѯ���
		String sql = "select * from dual";

		// ִ�в�ѯ
		ResultSet rs = stat.executeQuery(sql);
		ResultSetMetaData rsMeta = rs.getMetaData();

		// ���������
		int columns = rsMeta.getColumnCount();
		for (int i = 0; i < columns; i++) {
			System.out.print(rsMeta.getColumnName(i + 1) + "\t");
		}

		System.out.println();
		System.out.println();

		while (rs.next()) {// ����ÿһ��

			// ���ÿ�е���ֵ
			for (int i = 0; i < columns; i++) {
				Object value = rs.getObject(i + 1);

				// ���ÿ�е���ֵ
				System.out.print(value + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		new Oracle().test();
	}

}
