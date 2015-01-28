package next.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import next.model.Answer;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import core.jdbc.AbstractJdbcDaoSupport;

@Repository
public class AnswerDao extends AbstractJdbcDaoSupport {

	public void insert(Answer answer) {
		String sql = "INSERT INTO ANSWERS (writer, contents, createdDate, questionId) VALUES (?, ?, ?, ?)";
		getJdbcTemplate().update(sql, answer.getWriter(), answer.getContents(),
				new Timestamp(answer.getTimeFromCreateDate()),
				answer.getQuestionId());
	}

	public List<Answer> findAllByQuestionId(long questionId) {
		String sql = "SELECT answerId, writer, contents, createdDate FROM ANSWERS WHERE questionId = ? "
				+ "order by answerId desc";

		RowMapper<Answer> rm = new RowMapper<Answer>() {
			@Override
			public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Answer(rs.getLong("answerId"),
						rs.getString("writer"), rs.getString("contents"),
						rs.getTimestamp("createdDate"), questionId);
			}
		};

		return getJdbcTemplate().query(sql, rm, questionId);
	}
}
