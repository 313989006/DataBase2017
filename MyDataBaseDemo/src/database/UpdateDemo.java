package database;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

public class UpdateDemo
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
		//创建Statement语句对象
		Statement st =cnn.createStatement();
		//执行插入数据的操作
		//String sql = "update cv set name='sudo' where (id = 3);";
		
		//String sql = "update cv set name='sudo';";
		String sql = "alter table cv add name4 varchar(10);";
		
		//执行sql语句
		st.executeUpdate(sql);
		//释放资源
		st.close();
		cnn.close();
	}
}
