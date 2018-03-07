/**
 * 
 */
package xyz.nesting.example.domain;

import java.io.Serializable;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 
 * @Description: TODO(添加描述)
 * @Author zhengyue
 * @Version: 0.0.1
 * @CreateAt 2017年12月25日-下午5:13:02
 *
 */
@Document(indexName = "personindex", type = "person")
public class Person implements Serializable{

    private static final long serialVersionUID = -1L;

    private Long id;

    private String name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
	 * @return the {@link #name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the {@link #name} to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
