package mate.bbs.usrtrrqst.service;

import mate.bbs.usrtrrqst.vo.UsrTrRqstModifyVO;
import mate.bbs.usrtrrqst.vo.UsrTrRqstWriteVO;

public interface UsrTrRqstService {

	public boolean createNewUsTr(UsrTrRqstWriteVO usTrRqstWriteVO);
	
	public boolean modifyUsTr(UsrTrRqstModifyVO usTrRqstModifyVO);
	
	public boolean softDeleteUsTr(String usrTrPstId);
	
	
}
