package database;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class PSUpdateDemo
{
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo";
	public static final String DBUSER = "root";
	public static final String DBPASSWD = "root";

	public static void main(String[] args) throws SQLException
	{
		
		Connection cnn = null;
		PreparedStatement ps = null;
		try
		{
			// 注册驱动
			Class.forName(DBDRIVER);
			// 建立连接
			cnn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWD);

			// 执行插入数据的操作
			String sql = "update cv set name = ?,age = ? where id =?;";

			// 创建PreparedStatement语句对象
			ps = cnn.prepareStatement(sql);
			// 设定位置参数
			ps.setString(1, "xiamen");
			ps.setInt(2, 11);
			ps.setInt(3, 5);

			// 执行sql语句
			ps.executeUpdate();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		// 释放资源
		try
		{
			ps.close();
			cnn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}finally {
			if (ps !=null)
			{
				ps.close();
			}
			if (cnn !=null)
			{
				cnn.close();
			}
		}
	}
}
