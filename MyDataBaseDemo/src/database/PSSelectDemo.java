package database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.PreparedStatement;

import java.sql.Connection;

public class PSSelectDemo
{
	public static final String DBDRIVER="com.mysql.jdbc.Driver";
	public static final String DBURL="jdbc:mysql://localhost:3306/demo";
	public static final String DBUSER="root";
	public static final String DBPASSWD="root";
	
	public static void main(String[] args) throws Exception
	{
		//注册驱动
		Class.forName(DBDRIVER);
		//建立连接
		Connection cnn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWD);
		//创建PreparedStatement语句对象
		//执行查询数据的操作
		String sql = "select age,name as user_name,height,city from stu;";
		//执行sql语句
		PreparedStatement ps =cnn.prepareStatement(sql);
		 ResultSet rs = ps.executeQuery();
		 //处理查询数据
		System.out.println("age " + "\t\t" + "name " + "\t\t" +"height " + "\t\t" + "city "+ "\t\t" );
		System.out.println();
		
		 while (rs.next())
		{
			/*int age = rs.getInt("age");
			String name = rs.getString("user_name");
			int height = rs.getInt("height");
			String city = rs.getString("city");*/
			int age = rs.getInt(1);
			String name = rs.getString(2);
			int height = rs.getInt(3);
			String city = rs.getString(4);
			System.out.println(".........................................");
			System.out.print(age + "\t\t");
			System.out.print(name + "\t\t");
			System.out.print(height + "\t\t");
			System.out.print(city + "\t\t");
			System.out.println();
		}
		//释放资源
		rs.close();
		ps.close();
		cnn.close();
	}
}
