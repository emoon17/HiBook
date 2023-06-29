package com.HiBook.purchase.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.HiBook.cart.bo.CartBO;
import com.HiBook.cart.model.Cart;
import com.HiBook.order.bo.OrderBO;
import com.HiBook.order.model.Order;
import com.HiBook.order.model.OrderView;
import com.HiBook.orderproduct.bo.OrderproductBO;
import com.HiBook.orderproduct.model.OrderProductView;
import com.HiBook.orderproduct.model.Orderproduct;
import com.HiBook.product.bo.ProductBO;
import com.HiBook.product.model.Product;
import com.HiBook.user.bo.UserBO;
import com.HiBook.user.model.User;

@Service
public class PurchaseBO {

	@Autowired
	private ProductBO productBO;
	@Autowired
	private CartBO cartBO;
	@Autowired
	private OrderproductBO orderproductBO;
	@Autowired
	private OrderBO orderBO;
	@Autowired
	private UserBO userBO;

	// cart, product insert (장바구니 추가)
	@Transactional
	public void addcartAndProductByCountIsbn13TitlePriceUserId(Integer count, Product product, Integer userId) {

		// 상품 insert
		List<Product> productList = productBO.getProductAllList();
		int i = -1;

		for (Product pr : productList) {
			Cart cart = cartBO.getCartByProductId(pr.getId());
			if (cart != null && cart.getProductId() == pr.getId()) { // 같으면 1 반환
				i = 1;
				Integer addCount = cart.getCount() + count;
				updateCartByCount(pr.getId(), addCount, pr.getPrice(), userId);
			}
		}
		// cart insert
		if (i == -1) {
			productBO.addProductByIsbn13(product);
			cartBO.addCartByProductIdUserIdCountPrice(product.getId(), userId, count, product.getPrice());

		}
		// Cart cart = cartBO.getCartByProductId(product.getId());

	}

	// 장바구니 없이 바로 주문하기 order insert
	@Transactional
	public void addProductAndOrderProductByProductCountUserId(Product product, Integer count, String title,
			Integer price, Integer userId) {
		productBO.addProductByIsbn13(product);
		orderproductBO.addOrderProductByProductIdCountPriceUserId(product.getId(), count, price, userId);
	}

	// cart, product delete (장바구니 삭제)
	@Transactional
	public void deleteCartANDProductBYProductIdUserId(Integer productId, Integer userId) {

		// cart delete
		cartBO.deleteCartBYProductIdUserId(productId, userId);
		// 상품 delete
		productBO.deleteProudctById(productId);

	}
	//장바구니 삭제
	public void deleteCartByProductIdUserId(Integer productId, Integer userId) {
		cartBO.deleteCartBYProductIdUserId(productId, userId);
	}

	// cart 수량, 가격 update (장바구니 변경)
	public void updateCartByCount(Integer productId, Integer count, Integer price, Integer userId) {

		price = price * count;
		cartBO.updateCartByCountProductIdUserId(productId, count, price, userId);

	}

	// cart -> orderproduct insert 장바구니에서 주문하기
	@Transactional
	public void addOrderProductAndOrderByProductIdUserId(List<Integer> productId, Integer userId) {

		Integer productid = 0;
		for (int i = 0; i < productId.size(); i++) {
			productid = productId.get(i);

			// orderProudct insert - cart의 price, count 필요
			List<Cart> cartList = cartBO.getCartListByProductIdUserId(productid, userId);
			for (Cart cart : cartList) {
				// orderproduct insert
				orderproductBO.addOrderProductByProductIdCountPriceUserId(productid, cart.getCount(), cart.getPrice(),
						userId);

				// order insert - productid, userId, cart- count, price , state(주문완료)
				// orderBO.addOrderByProductIdUserIdOrderproductIdCountPriceState(productid,
				// userId, cart.getCount(), cart.getPrice());
			}

			// cart 내용 지우기
			deleteCartByProductIdUserId(productid, userId);

		}
	}

	// 주문화면 select
	public List<OrderProductView> getOrderproductList(Integer userId) {

		List<OrderProductView> orderproductViewList = new ArrayList<>();

		List<Orderproduct> orderproductList = orderproductBO.getOrderproductListByUserId(userId);

		for (Orderproduct orderproduct : orderproductList) {
			if (orderproduct.getState().equals("standby")) {

				OrderProductView orderproductView = new OrderProductView();

				orderproductView.setOrderproduct(orderproduct);

				Product product = productBO.getProductByUserId(orderproduct.getProductId());
				orderproductView.setProduct(product);

				orderproductViewList.add(orderproductView);
			}
		}

		return orderproductViewList;

	}

	// 주문 조회, 반품 신청 화면 select
	public List<OrderView> getOrderViewListByUserId(Integer userId) {

		List<OrderView> orderViewList = new ArrayList<>();

		List<Order> orderList = orderBO.getOrderListByUserId(userId);
		List<Order> newOrderList = new ArrayList<>();
		for (int i = 0; i < orderList.size(); i++) {
			 int flag = 0;
			 int iON = orderList.get(i).getOrderNumber();

			for (int j = 0; j < newOrderList.size(); j++) {
				int jON = newOrderList.get(j).getOrderNumber();

				if (iON == jON) { // orderNumber가 같을 때
					flag = 1;
				}
			}
			if (flag == 0) {
				newOrderList.add(orderList.get(i));
			}
		}

		List<Orderproduct> orderProduct = orderproductBO.getOrderproductListByUserId(userId);
		for (Order order : newOrderList) {
			OrderView orderView = new OrderView();
			orderView.setOrder(order);
			Orderproduct orderproduct = orderproductBO.getOrderproductById(order.getOrderproductId());
			if (orderproduct.getState().equals("order")) {
				orderView.setOrderproduct(orderproduct);

				Product product = productBO.getProductByUserId(orderproduct.getProductId());
				orderView.setProduct(product);

				orderViewList.add(orderView);
			}

		}

		return orderViewList;

	}

	// 
	// order detail select
	public List<OrderView> getOrderDetailListByUserId(Integer orderNumber, Integer userId) {

		List<OrderView> orderViewList = new ArrayList<>();

		List<Order> orderList = orderBO.getOrderListByOrderNumber(orderNumber);
		
		for(Order order : orderList) {
			OrderView orderView = new OrderView();
			orderView.setOrder(order);
			Orderproduct orderproduct = orderproductBO.getOrderproductById(order.getOrderproductId());
			orderView.setOrderproduct(orderproduct);
			Product product = productBO.getProductByUserId(orderproduct.getProductId());
			orderView.setProduct(product);
			
			orderViewList.add(orderView);
			
		}
		return orderViewList;
	}
	
	//// 주문 조회, 반품 신청 화면 날짜 조회
	public List<OrderView> getOrderByDateUserId(Date startDate, Date endDate, Integer userId){
		
		List<OrderView> orderViewList = new ArrayList<>();
		List<Order> orderList = orderBO.getOrderListByStartDateEndDateUserId(startDate, endDate, userId);
		List<Order> newOrderList = new ArrayList<>();
		for (int i = 0; i < orderList.size(); i++) {
			 int flag = 0;
			 int iON = orderList.get(i).getOrderNumber();

			for (int j = 0; j < newOrderList.size(); j++) {
				int jON = newOrderList.get(j).getOrderNumber();

				if (iON == jON) { // orderNumber가 같을 때
					flag = 1;
				}
			}
			if (flag == 0) {
				newOrderList.add(orderList.get(i));
			}
		}
		
		for (Order order : newOrderList) {
			if (order.getState().equals("주문 완료")) {
				
				OrderView orderView = new OrderView();
				orderView.setOrder(order);
				Orderproduct orderproduct = orderproductBO.getOrderproductById(order.getOrderproductId());
				orderView.setOrderproduct(orderproduct);
				Product product = productBO.getProductByUserId(orderproduct.getProductId());
				orderView.setProduct(product);
				
				orderViewList.add(orderView);
			}
		}
		
		return orderViewList;
	}
	
	//반품화면 날짜 조회 select
	public List<OrderView> getOrderReturnByDateUserId(Date startDate, Date endDate, Integer userId){
		List<OrderView> orderViewList = new ArrayList<>();

		List<Order> orderList = orderBO.getOrderListUpdateByStartDateEndDateUserId(startDate, endDate, userId);
		List<Order> newOrderList = new ArrayList<>();
		for (int i = 0; i < orderList.size(); i++) {
			 int flag = 0;
			 int iON = orderList.get(i).getOrderNumber();

			for (int j = 0; j < newOrderList.size(); j++) {
				int jON = newOrderList.get(j).getOrderNumber();

				if (iON == jON) { // orderNumber가 같을 때
					flag = 1;
				}
			}
			if (flag == 0) {
				newOrderList.add(orderList.get(i));
			}
		}
		
		for (Order order : newOrderList) {
			if (order.getState().equals("반품 완료")) {
				
				OrderView orderView = new OrderView();
				orderView.setOrder(order);
				Orderproduct orderproduct = orderproductBO.getOrderproductById(order.getOrderproductId());
				orderView.setOrderproduct(orderproduct);
				Product product = productBO.getProductByUserId(orderproduct.getProductId());
				orderView.setProduct(product);
				
				orderViewList.add(orderView);
			}
		}
		
		return orderViewList;
	}
	
	//반품 신청
	public void updateOrderAndOrderprdocutByOrderNumber(List<Integer> orderNumberArr, Integer userId) {
		
		//order update
		for(Integer orderNumber : orderNumberArr) {
			orderBO.updateOrderByOrderNumber(orderNumber, userId);
			
			List<Order> orderList = orderBO.getOrderListByOrderNumber(orderNumber);
			for (Order order : orderList) {
				orderproductBO.updateOrderproductByIdResultReturn(order.getOrderproductId());
			}
		}
		
		//orderproduct update
		
	}
	
	// 반품 select
	public List<OrderView> getOrderReturnViewListByUserId(Integer userId) {

		List<OrderView> orderViewList = new ArrayList<>();

		List<Order> orderList = orderBO.getOrderListByUserId(userId);
		List<Order> newOrderList = new ArrayList<>();
		for (int i = 0; i < orderList.size(); i++) {
			 int flag = 0;
			 int iON = orderList.get(i).getOrderNumber();

			for (int j = 0; j < newOrderList.size(); j++) {
				int jON = newOrderList.get(j).getOrderNumber();

				if (iON == jON) { // orderNumber가 같을 때
					flag = 1;
				}
			}
			if (flag == 0) {
				newOrderList.add(orderList.get(i));
			}
		}
		List<Orderproduct> orderProduct = orderproductBO.getOrderproductListByUserId(userId);
		for (Order order : newOrderList) {
			OrderView orderView = new OrderView();
			orderView.setOrder(order);
			Orderproduct orderproduct = orderproductBO.getOrderproductById(order.getOrderproductId());
			if (orderproduct.getState().equals("return")) {
				orderView.setOrderproduct(orderproduct);

				Product product = productBO.getProductByUserId(orderproduct.getProductId());
				orderView.setProduct(product);

				orderViewList.add(orderView);
			}

		}

		return orderViewList;

	}

	// 결제하기
	@Transactional
	public void addOrder(List<Integer> orderproductIdArr, Integer orderNumber, Integer count, Integer price,
			String postcode, String address, String detailAddress, String phoneNumber, Integer userId) {

		List<User> userList = userBO.getUserListBYId(userId);
		for (Integer orderproductId : orderproductIdArr) {

			// 주문 주소 변경 시 user update
			for (User user : userList) {
				if (!user.getPostcode().equals(postcode)) {
					userBO.userAddressUpdate(user.getPhoneNumber(), postcode, user.getAddress(),
							user.getDetailAddress(), userId);
				}
				if (!user.getAddress().equals(address)) {
					userBO.userAddressUpdate(user.getPhoneNumber(), user.getPostcode(), address,
							user.getDetailAddress(), userId);
				}
				if (!user.getDetailAddress().equals(detailAddress)) {
					userBO.userAddressUpdate(user.getPhoneNumber(), user.getPostcode(), user.getAddress(),
							detailAddress, userId);
				}
				if (!user.getPhoneNumber().equals(phoneNumber)) {
					userBO.userAddressUpdate(phoneNumber, user.getPostcode(), user.getAddress(), detailAddress, userId);
				}
			}
			// order insert
			orderBO.addOrderByProductIdCountPriceUserId(orderproductId, orderNumber, count, price, userId);

			// orderproduct 상태 추가
			orderproductBO.updateOrderproductById(orderproductId);
		}

	}

}
