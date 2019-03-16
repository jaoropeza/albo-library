/*
 *
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: Cable
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.jaoropeza.albo.library.domain.marvel;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * ComicList
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-25T21:10:15.548-06:00")
public class ComicList {
    @JsonProperty("available")
    private Integer available = null;
    @JsonProperty("collectionURI")
    private String collectionURI = null;
    @JsonProperty("items")
    private java.util.List items = null;
    @JsonProperty("returned")
    private Integer returned = null;

    public ComicList available(Integer available) {
        this.available = available;
        return this;
    }

    /**
     * The number of total available issues in this list. Will always be greater than or equal to the \&quot;returned\&quot; value.
     *
     * @return available
     **/
    @ApiModelProperty(value = "The number of total available issues in this list. Will always be greater than or equal to the \"returned\" value.")
    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public ComicList returned(Integer returned) {
        this.returned = returned;
        return this;
    }

    /**
     * The number of issues returned in this collection (up to 20).
     *
     * @return returned
     **/
    @ApiModelProperty(value = "The number of issues returned in this collection (up to 20).")
    public Integer getReturned() {
        return returned;
    }

    public void setReturned(Integer returned) {
        this.returned = returned;
    }

    public ComicList collectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
        return this;
    }

    /**
     * The path to the full list of issues in this collection.
     *
     * @return collectionURI
     **/
    @ApiModelProperty(value = "The path to the full list of issues in this collection.")
    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public ComicList items(java.util.List items) {
        this.items = items;
        return this;
    }

    /**
     * The list of returned issues in this collection.
     *
     * @return items
     **/
    @ApiModelProperty(value = "The list of returned issues in this collection.")
    public java.util.List getItems() {
        return items;
    }

    public void setItems(java.util.List items) {
        this.items = items;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComicList comicList = (ComicList) o;
        return Objects.equals(this.available, comicList.available) &&
            Objects.equals(this.returned, comicList.returned) &&
            Objects.equals(this.collectionURI, comicList.collectionURI) &&
            Objects.equals(this.items, comicList.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(available, returned, collectionURI, items);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ComicList {\n");

        sb.append("    available: ").append(toIndentedString(available)).append("\n");
        sb.append("    returned: ").append(toIndentedString(returned)).append("\n");
        sb.append("    collectionURI: ").append(toIndentedString(collectionURI)).append("\n");
        sb.append("    items: ").append(toIndentedString(items)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

