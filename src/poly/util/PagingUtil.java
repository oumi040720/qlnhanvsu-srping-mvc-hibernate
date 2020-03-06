package poly.util;

import javax.servlet.http.HttpServletRequest;

import poly.model.PageModel;

public class PagingUtil {

	public static PageModel setPagging(HttpServletRequest request, long totalItems) {
		PageModel model = new PageModel();
		
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer maxPageItems = Integer.parseInt(request.getParameter("maxPageItems"));
		
		model.setPage(page);
		model.setMaxPageItems(maxPageItems);
		model.setTotalItems(totalItems);
		model.setOffset((page - 1) * maxPageItems);
		
		if (totalItems % maxPageItems != 0) {
			model.setTotalPages(((totalItems / maxPageItems) + 1));
		} else {
			model.setTotalPages((long) Math.ceil((totalItems / maxPageItems)));
		}
		
		request.setAttribute("totalPages", model.getTotalPages());
		request.setAttribute("page", model.getPage());
		
		return model;
	}
	
}
