package org.code.helloworld.java.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * 
 * ������mysql �������ݿ����
 * 
 * @author yanchangyou@gmail.com
 * @date 2014-08-30 19:55:57
 *
 */
public class MySql {

	public void test() throws Exception {

		// ��������
		Class.forName("com.mysql.jdbc.Driver");

		// ���ݿ�������Ϣ��url���û���������
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String userName = "root";
		String password = "";

		// ��ȡ����
		Connection conn = DriverManager.getConnection(url, userName, password);

		// ����������
		Statement stat = conn.createStatement();

		// ��ѯ���
		String sql = "SELECT * FROM information_schema.TABLES";

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
		new MySql().test();
	}

}
