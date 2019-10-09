import java.util.*;
import java.sql.*;
public class Dyna {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter n value");
		int n=sc.nextInt();
		int i=0;
		
		
		//System.out.println("enter name");
		//String name=sc.next();
		//System.out.println("enter address");
		//String address=sc.next();
		while(i<n) {
			i++;
			System.out.println("enter name,address and no");
		int empno=sc.nextInt();
		
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456789");
		PreparedStatement st=con.prepareStatement("delete from mphasi where empno=?");
		/*st.setString(1,name);  
		st.setString(2,address);*/
		st.setInt(1,empno);
		st.execute();

		Statement st1=con.createStatement();
		ResultSet rs=st1.executeQuery("select * from mphasi");  
		
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)); 
		
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
	
	}

}
