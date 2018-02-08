package jdbcOperations;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Storing_Image_In_Db {

	public static void main(String args[]) throws SQLException{
		Scanner sc =new Scanner(System.in);
		ImageDetails img =new ImageDetails();
		
		System.out.println("Enter image id: ");
		int imgId =sc.nextInt();
		img.setId(imgId);
		System.out.println("Enter image name:");
		String name=sc.next();
		img.setImageName(name);
	
		boolean flag =imageStore(img);
		if(flag){
			System.out.println("Image store successfully...");
		}
		else{
			System.out.println("Image not store...");
		}
	}
	public static boolean imageStore(ImageDetails img) throws SQLException{

		Connection conn = null;
		PreparedStatement ps = null;
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ToDo","root","root");
			String query= "insert into image(id,name,image)values(?,?,?)";
			ps=conn.prepareStatement(query);
			ps.setInt(1, img.getId());
			ps.setString(2, img.getImageName());
			
			File file = new File("/home/bridgeit/Downloads/logo.jpg");
			FileInputStream fn = new FileInputStream(file);
			ps.setBinaryStream(3,fn);
			ps.executeUpdate();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conn.close();
		}
		return false;
	}
}
