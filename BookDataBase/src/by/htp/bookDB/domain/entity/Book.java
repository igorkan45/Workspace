package by.htp.bookDB.domain.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

	private static final long serialVersionUID = 7299115114495935424L;

	private int id;
	private String title;
	private int pages;
	private Date date;

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public Book(int id, String title, int pages, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.date = date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Book(int id, String title, int pages) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
	}

	public Book() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + pages;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (pages != other.pages)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", date=" + date + "]";
	}

}
