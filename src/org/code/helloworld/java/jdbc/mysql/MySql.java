package org.code.helloworld.java.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * 
 * 描述：mysql 连接数据库测试
 * 
 * @author yanchangyou@gmail.com
 * @date 2014-08-30 19:55:57
 *
 */
public class MySql {

	public void test() throws Exception {

		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 数据库连接信息：url，用户名，密码
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String userName = "root";
		String password = "";

		// 获取连接
		Connection conn = DriverManager.getConnection(url, userName, password);

		// 创建语句对象
		Statement stat = conn.createStatement();

		// 查询语句
		String sql = "SELECT * FROM information_schema.TABLES";

		// 执行查询
		ResultSet rs = stat.executeQuery(sql);
		
		//获取结果集元数据信息（包含有多少列，列名是什么等信息：适合做一些高级应用）
		ResultSetMetaData rsMeta = rs.getMetaData();

		// 输出列名称
		int columns = rsMeta.getColumnCount();
		for (int i = 0; i < columns; i++) {
			System.out.print(rsMeta.getColumnName(i + 1) + "\t");
		}

		System.out.println();
		System.out.println();

		while (rs.next()) {// 遍历每一行

			// 输出每行的列值
			for (int i = 0; i < columns; i++) {
				Object value = rs.getObject(i + 1);

				// 输出每列的列值
				System.out.print(value + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws Exception {
		new MySql().test();
	}

}
