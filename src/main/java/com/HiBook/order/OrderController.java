package com.HiBook.order;

import java.util.Date;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HiBook.order.model.OrderView;
import com.HiBook.purchase.bo.PurchaseBO;
import com.HiBook.review.model.ReviewView;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/hiBook")
@Controller
public class OrderController {
	@Autowired
	private PurchaseBO purchaseBO;

	// 주문 조회, 반품 신청 view
	@GetMapping("/order_inquiry_view")
	public String orderInquiryView(Model model, HttpSession session) {

		// userId
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/hiBook/user/sign_in_view";
		}

		List<OrderView> orderViewList = purchaseBO.getOrderViewListByUserId(userId);
		model.addAttribute("orderViewList", orderViewList);
		model.addAttribute("veiwName", "mypage/orderInquiry");

		return "template/layout";
	}

	// 주문 상품 상세 조회 화면
	@GetMapping("/order_detail_view")
	public String orderDetailView(Model model, Integer orderNumber, HttpSession session) {
		// userId
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/hiBook/user/sign_in_view";
		}

		List<OrderView> orderViewList = purchaseBO.getOrderDetailListByUserId(orderNumber, userId);
		model.addAttribute("orderViewList", orderViewList);
		model.addAttribute("veiwName", "mypage/orderDetail");

		return "template/layout";
	}

	// 주문 화면 날짜 search 화면
	@GetMapping("/order_date_search_view")
	public String OrderDateSearchView(@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
			@RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate, HttpSession session,
			Model model) throws ParseException {

		Integer userId = (Integer) session.getAttribute("userId");

		List<OrderView> orderViewList = purchaseBO.getOrderByDateUserId(startDate, endDate, userId);
		model.addAttribute("orderViewList", orderViewList);

		return "mypage/orderSearch";
	}

	// 반품내역 view
	@GetMapping("/order_return_view")
	public String orderReturnView(Model model, HttpSession session) {

		model.addAttribute("veiwName", "mypage/orderReturn");

		return "template/layout";
	}
}
