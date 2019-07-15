package babushkaMemeBot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "meme_template")
public class MemeTemplate {

	@Id
	@Column(name = "id", nullable = false)
	private Long id;

	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;

	@URL
	@NotBlank
	@Column(name = "url", nullable = false)
	private String url;

	@NotNull
	@Column(name = "width", nullable = false)
	private Integer width;

	@NotNull
	@Column(name = "height", nullable = false)
	private Integer height;

	@NotNull
	@Column(name = "box_count", nullable = false)
	private Integer boxCount;

	public MemeTemplate() {

	}

	public MemeTemplate(Long id, String name, String url, Integer width, Integer height, Integer boxCount) {
		this();
		this.setId(id);
		this.setName(name);
		this.setUrl(url);
		this.setWidth(width);
		this.setHeight(height);
		this.setBoxCount(boxCount);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getBoxCount() {
		return boxCount;
	}

	public void setBoxCount(Integer boxCount) {
		this.boxCount = boxCount;
	}

}
