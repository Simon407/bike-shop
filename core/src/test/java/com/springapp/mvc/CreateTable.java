package com.springapp.mvc;

import com.springapp.mvc.info.CategoryInfo;
import com.springapp.mvc.info.GoodsInfo;
import com.springapp.mvc.repositories.CategoryRepository;
import com.springapp.mvc.repositories.GoodRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateTable {

    public static void main(String[] args) {
        try {
            createTableGoods();
            createTableCategory();
            testInsert();
//            testUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
//        Properties props = new Properties();                  // Доп класс для считывание данных с файла
//        props.load(new FileInputStream("etc/properties/tutor-db-connection.properties"));     // Считывание (загрузка) из файла
//        String driver = props.getProperty("driver");
        String url = "jdbc:h2:c:/Java/h2db/SpringProject";
        String user = "sa";
        String pass = "";
        Class.forName("org.h2.Driver");                       // Проверка правильности подключения драйвера
        return DriverManager.getConnection(url, user, pass);  // Открытие соединения к БД
    }

    private static void createTableGoods() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("create table if not exists GOODS " +
                    "(id bigint GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY, " +
                    "name VARCHAR(50), description varchar(200), imageUrl VARCHAR(150), " +
                    "price DOUBLE(5), categoryId bigint(10))");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void createTableCategory() throws SQLException, ClassNotFoundException, IOException {
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("create table if not exists CATEGORY " +
                    "(id bigint GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY, " +
                    "name varchar(50), parentId bigint)");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    private static void testInsert() {
        init();
//        CategoryInfo category = new CategoryInfo(1L, "Тестовая категория", null);
//        categoryRepository.addCategory(category);
//        goodRepository.addGood(new GoodsInfo(1L, "Men's", "Lorem ipsum dolor sit amet consectetur adipisicing.",
//                "/images/w1.jpg", category, new BigDecimal(100)));
//        goodRepository.addGood(new GoodsInfo(2L, "Men's", "Lorem ipsum dolor sit amet consectetur adipisicing.",
//                "/images/w2.jpg", category, new BigDecimal(200)));
//        goodRepository.addGood(new GoodsInfo(3L, "Women's", "Lorem ipsum dolor sit amet consectetur adipisicing.",
//                "/images/w3.jpg", category, new BigDecimal(200)));
    }

    private static void testUpdate() {
        init();
//        CategoryInfo category = new CategoryInfo(1L, "Тестовая категория", null);
//        goodRepository.updateGood(new GoodInfo(1L, "Новый товар", "Новое описание нового товара.",
//                "/images/w1.jpg", category, new BigDecimal(555)));
    }

    private static GoodRepository goodRepository;
    private static CategoryRepository categoryRepository;

    private static void init() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring-jdbc.xml" }, true);
        goodRepository = context.getBean(GoodRepository.class);
        categoryRepository = context.getBean(CategoryRepository.class);
    }
}
