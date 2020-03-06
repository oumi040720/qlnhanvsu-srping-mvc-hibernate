package poly.model;

public class PageModel {

	private Integer page;
	private Integer maxPageItems;
	private Long totalItems;
	private Long totalPages;
	private Integer offset;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMaxPageItems() {
		return maxPageItems;
	}

	public void setMaxPageItems(Integer maxPageItems) {
		this.maxPageItems = maxPageItems;
	}

	public Long getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Long totalItems) {
		this.totalItems = totalItems;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

}
