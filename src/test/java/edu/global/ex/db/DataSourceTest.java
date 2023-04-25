package edu.global.ex.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest //모든 빈들을 스캔하고 애플리케이션 컨텍스트를 생성하여 테스트를 실행
class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	void testDataSource() {
		
		System.out.println(dataSource);
		assertNotNull(dataSource);
		
	}
	
	@Test
	void testConnection() throws Exception {
		
		System.out.println("DataSource = " + dataSource);
		
		try(Connection connection = dataSource.getConnection()) {
			System.out.println("Connection = " + connection);
			assertThat(connection).isInstanceOf(Connection.class);
			
			assertEquals(100, getLong(connection, "SELECT 100 FROM DUAL"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private long getLong(Connection connection, String sql) {
		// TODO Auto-generated method stub
		long result = 0;
		try (Statement statement = connection.createStatement()){
			ResultSet rs = statement.executeQuery(sql);
			
			if (rs.next()) {
				result = rs.getLong(1);
			}
			
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
			
}
