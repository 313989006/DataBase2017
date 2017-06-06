package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;

public class UpdateDemo2
{
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo";
	public static final String DBUSER = "root";
	public static final String DBPASSWD = "root";

	public static void main(String[] args) throws Exception
	{
		// 注册驱动
		Class.forName(DBDRIVER);
		// 建立连接
		Connection cnn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWD);

		// 执行插入数据的操作
		String sql = "insert  into stu (id,name,age) values(?,?,?);";

		// 创建PreparedStatement语句对象
		PreparedStatement ps = cnn.prepareStatement(sql);
		// 设定位置参数
		ps.setInt(1, 6);
		ps.setString(2, "sun");
		ps.setInt(3, 30);

		// 执行sql语句
		ps.executeUpdate();
		// 释放资源
		ps.close();
		cnn.close();
	}
}
