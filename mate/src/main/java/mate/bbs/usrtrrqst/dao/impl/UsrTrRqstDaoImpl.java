package mate.bbs.usrtrrqst.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import mate.bbs.usrtrrqst.dao.UsrTrRqstDao;
import mate.bbs.usrtrrqst.vo.UsrTrRqstModifyVO;
import mate.bbs.usrtrrqst.vo.UsrTrRqstVO;
import mate.bbs.usrtrrqst.vo.UsrTrRqstWriteVO;

@Repository
public class UsrTrRqstDaoImpl extends SqlSessionDaoSupport implements UsrTrRqstDao {

	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertNewUsrTr(UsrTrRqstWriteVO usrTrRqstWriteVO) {
		return this.getSqlSession().insert(NAMESPACE + ".insertNewUsrTr", usrTrRqstWriteVO);
	}

	@Override
	public int updateUsrTr(UsrTrRqstModifyVO usrTrRqstModifyVO) {
		return this.getSqlSession().update(NAMESPACE + ".updateUsrTr", usrTrRqstModifyVO);
	}

	@Override
	public int updateUsrTrIsDltAndDltDt(String usrTrPstId) {
		return this.getSqlSession().update(NAMESPACE + ".updateUsrTrIsDltAndDltDt", usrTrPstId);
	}

	@Override
	public List<UsrTrRqstVO> selectAllUsrTrList() {
		return this.getSqlSession().selectList(NAMESPACE + ".selectAllUsrTrList");
	}

	@Override
	public UsrTrRqstVO selectOneUsrTrRqst(String usrTrPstId) {
		return this.getSqlSession().selectOne(NAMESPACE + ".selectOneUsrTrRqst", usrTrPstId);
	}

	
	
}
