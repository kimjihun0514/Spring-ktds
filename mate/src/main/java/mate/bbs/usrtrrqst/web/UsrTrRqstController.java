package mate.bbs.usrtrrqst.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsrTrRqstController {

	@GetMapping("/mypage/tourist")
	public String view() {
		return "ustrrqst/Mypage_Tourist_MyTour";
	}
	
	@GetMapping("/mypage/guide")
	public String view2() {
		return "ustrrqst/Guide";
	}
	
	@GetMapping("/mypage/review")
	public String view3() {
		return "ustrrqst/Mypage_Tourist_MyReview";
	}
}
