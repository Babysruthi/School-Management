package com.revature.project.Questionaire.DBUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	public static Connection getConnection() {

		Connection con = null;
		try {

			FileInputStream fileStream = new FileInputStream(
					"C:\\Users\\BabysruthiSekar\\Documents\\workspace-spring-tool-suite-4-4.11.0.RELEASE\\School-Management\\target\\jdbc.properties");
			Properties properties = new Properties();
			properties.load(fileStream);
			String url = properties.getProperty("url");
			String id = properties.getProperty("id");
			String pwd = properties.getProperty("pwd");

			con = DriverManager.getConnection(url, id, pwd);
		} catch (IOException | SQLException e) {
			System.out.println(e.getMessage());
		}

		return con;
	}
}
