package edu.global.ex.db;

import static org.junit.jupiter.api.Assertions.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest  //This is run Test by scan all bean and create application context
class DataSourceTest {

	@Autowired
	private DataSource datasource;
	
	@Test
	void dataSourceTest() {
		System.out.println(datasource);
		assertNotNull(datasource);
	}

}
