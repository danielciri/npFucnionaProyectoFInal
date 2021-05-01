package site.danielcirilo.springboot.app.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {
	private String url;
	private Page<T> page;

	private int totalPaginas;
	private int numElementPag;
	private int paginaActual;
	private List<PageItem> paginas;

	public PageRender(String url, Page<T> page) {
		this.paginas = new ArrayList<PageItem>();

		this.url = url;
		this.page = page;
		numElementPag = page.getSize();
		totalPaginas = page.getTotalPages();
		paginaActual = page.getNumber() + 1;

		int from;
		int to;
		if (totalPaginas <= numElementPag) {
			from = 1;
			to = totalPaginas;
		} else {
			if (paginaActual <= numElementPag / 2) {
				from = 1;
				to = numElementPag;
			} else if (paginaActual >= totalPaginas - numElementPag / 2) {
				from = totalPaginas - numElementPag + 1;
				to = numElementPag;

			} else {
				from = paginaActual - numElementPag / 2;
				to = numElementPag;

			}
		}

		for (int i = 0; i < to; i++) {
			paginas.add(new PageItem(from + i, paginaActual == from + i));
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public int getNumElementPag() {
		return numElementPag;
	}

	public void setNumElementPag(int numElementPag) {
		this.numElementPag = numElementPag;
	}

	public int getPaginaActual() {
		return paginaActual;
	}

	public void setPaginaActual(int paginaActual) {
		this.paginaActual = paginaActual;
	}

	public List<PageItem> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<PageItem> paginas) {
		this.paginas = paginas;
	}
	
	public boolean isFirst() {
		return page.isFirst();
	}


	public boolean isLast() {
		return page.isLast();
	}
	
	public boolean isHasNext() {
		return page.hasNext();
	}
	
	public boolean isHasPrevious() {
		return page.hasPrevious();
	}
}
