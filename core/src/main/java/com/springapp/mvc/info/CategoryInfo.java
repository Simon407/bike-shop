package com.springapp.mvc.info;

/**
 * Информация о категории
 */
public class CategoryInfo {

    /**
     * id раздела
     */
    private Long parentId;

    /**
     * id категории
     */
    private Long id;

    /**
     * Название категории
     */
    private String name;

    /**
     * Ссылка на соответствующий раздел
     */
    private String link;

    /**
     * Ссылка на картинку категории
     */
    private String picLink;

    /**
     * Описание категории
     */
    private String description;

    public CategoryInfo() {
    }

    public CategoryInfo(Long parentId, Long id, String name, String link, String picLink, String description) {
        this.parentId = parentId;
        this.id = id;
        this.name = name;
        this.link = link;
        this.picLink = picLink;
        this.description = description;
    }

    public CategoryInfo(Long parentId, Long id, String name, String link) {
        this.parentId = parentId;
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
