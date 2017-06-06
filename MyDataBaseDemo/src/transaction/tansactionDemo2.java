package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.sql.Statement;


//批量插入数据
public class tansactionDemo2
{
	public static final String DBDRIVER = "com.mysql.jdbc.Driver";
	public static final String DBURL = "jdbc:mysql://localhost:3306/demo";
	public static final String DBUSER = "root";
	public static final String DBPASSWD = "root";

	public static void main(String[] args) throws Exception
	{
		Connection cnn = null;
		Statement st = null;
		Savepoint sp = null;

		// 注册驱动
		Class.forName(DBDRIVER);
		// 建立连接
		cnn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWD);

		// 取消自动提交
		cnn.setAutoCommit(false);

		// 创建Statement语句对象
		st = cnn.createStatement();
		try
		{
			// 执行插入数据的操作
			String sql = "insert into cv (name,age) values";
			// 执行sql语句
			/*
			 * st.addBatch(sql +" ('shenchao01 ', 31);"); st.addBatch(sql
			 * +" ('shenchao02 ', 32);"); st.addBatch(sql
			 * +" ('shenchao03 ', 33);"); st.addBatch(sql
			 * +" ('shenchao04 ', 34);"); st.addBatch(sql
			 * +" ('shenchao05 ', 35);");
			 */

			/*
			 * st.addBatch(sql +" ('shenchao31 ', 51);"); st.addBatch(sql
			 * +" ('shenchao32 ', 52);"); //制造错误 st.addBatch(sql
			 * +" ('shenchao33 ', 53);");//这一行代码不会执行 st.addBatch(sql
			 * +" ('shenchao34 ', 54);"); st.addBatch(sql
			 * +" ('shenchao35 ', 55);");
			 */

			st.addBatch(sql + " ('shenchao41 ', 61);");
			sp = cnn.setSavepoint();
			st.addBatch(sql + " ('shenchao42 ', 62);");
			//设定标记点
			sp = cnn.setSavepoint();
			st.addBatch(sql + " ('shenchao43 ', 63);");
			sp = cnn.setSavepoint();
			st.addBatch(sql + " ('shenchao44 ', 64);");
			sp = cnn.setSavepoint();
			st.addBatch(sql + " ('shenchao35 ', 55);");
			sp = cnn.setSavepoint();
			//执行插入语句的操作
			st.executeBatch();
			cnn.commit();
		} catch (Exception e)
		{
			if (st !=null)
			{
				cnn.commit();
			}
			
			cnn.rollback();
			e.printStackTrace();
		}
		st.executeBatch();
		// 释放资源
		st.close();
		cnn.close();
	}

}
