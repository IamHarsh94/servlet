package jdbcOperations;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.websocket.Decoder.BinaryStream;



public class retrive_Image_from_db {

	public static void main(String args[]) throws SQLException{
		Scanner sc =new Scanner(System.in);
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			String query = "select * from image";
			ps=conn.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
				
				Blob b = rs.getBlob(3);
				byte brr[]=b.getBytes(1, (int) b.length());
				
				FileOutputStream fs = new FileOutputStream("/home/bridgeit/Downloads/DBlogo.png");
				fs.write(brr);
			}
			 
			}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
	}
}
