package com.gnt.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.review.service.ReviewService;
import com.gnt.review.vo.ReviewDetailVo;

@WebServlet(urlPatterns = "/funding/review/view")
public class FundingReviewViewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String revNo = req.getParameter("id");
		ReviewDetailVo vo = new ReviewService().selectReviewOne3(revNo);
		
		req.setAttribute("ReviewDetailVo", vo);
		req.getRequestDispatcher("/views/review/fundingReviewView.jsp").forward(req, resp);
	}
}
