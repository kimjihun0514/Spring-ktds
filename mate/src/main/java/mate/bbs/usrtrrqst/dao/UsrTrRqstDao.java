package mate.bbs.usrtrrqst.dao;

import java.util.List;

import mate.bbs.usrtrrqst.vo.UsrTrRqstModifyVO;
import mate.bbs.usrtrrqst.vo.UsrTrRqstVO;
import mate.bbs.usrtrrqst.vo.UsrTrRqstWriteVO;

public interface UsrTrRqstDao {

	public String NAMESPACE = "mate.bbs.usrtrrqst.dao.UsrTrRqstDao";
	
	public int insertNewUsrTr(UsrTrRqstWriteVO usrTrRqstWriteVO);
	
	public int updateUsrTr(UsrTrRqstModifyVO usrTrRqstModifyVO);
	
	public int updateUsrTrIsDltAndDltDt(String usrTrPstId);
	
	public List<UsrTrRqstVO> selectAllUsrTrList();
	
	public UsrTrRqstVO selectOneUsrTrRqst(String usrTrPstId);
	
}
