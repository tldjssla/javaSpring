package dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.ItemDao;
import logic.Item;

public class ItemDaoImpl implements ItemDao {
	private SqlSession sqlSession;
	// SQLsession 이 datasource 가지고 있기 때문에 SimpleJdbcTemplate 대신 sqlSession 사용
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Item> findAll() {
		return sqlSession.selectList("getItemList");
	}
	
	@Override
	public Item findByPrimaryKey(Integer itemId) {
		return sqlSession.selectOne("getItem",itemId);
	}

}
