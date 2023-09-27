package ch10.vo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ch10.controller.NewsDO_Mapper;

public class NewsDAO {
    private SqlSessionFactory sqlSessionFactory;
//    public NewsDAO() {}
    public NewsDAO() {
		try {
			String resource = "ch10/vo/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public void addNews(NewsDO n) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            NewsDO_Mapper mapper = session.getMapper(NewsDO_Mapper.class);
            mapper.addNews(n);
            session.commit();
        }
    }

    public void delNews(int aid) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            NewsDO_Mapper mapper = session.getMapper(NewsDO_Mapper.class);
            mapper.delNews(aid);
            session.commit();
        }
    }

    public NewsDO getNews(int aid) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            NewsDO_Mapper mapper = session.getMapper(NewsDO_Mapper.class);
            return mapper.getNews(aid);
        }
    }

    public List<NewsDO> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            NewsDO_Mapper mapper = session.getMapper(NewsDO_Mapper.class);
            return mapper.getAll();
        }
    }
}