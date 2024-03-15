package com.mediasoft.warehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Класс, являющийся точкой входа в приложение.
 * @author Подкорытова Юлия
 */
@SpringBootApplication
public class WarehouseApplication {

	/**
	 * Метод main, запускающий приложение.
	 *
	 * @param args аргументы.
	 */
	public static void main(String[] args) {
		SpringApplication.run(WarehouseApplication.class, args);
	}

}
