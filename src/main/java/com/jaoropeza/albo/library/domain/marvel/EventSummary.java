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
 * EventSummary
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-01-25T21:10:15.548-06:00")
public class EventSummary {
    @JsonProperty("name")
    private String name = null;
    @JsonProperty("resourceURI")
    private String resourceURI = null;

    public EventSummary resourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
        return this;
    }

    /**
     * The path to the individual event resource.
     *
     * @return resourceURI
     **/
    @ApiModelProperty(value = "The path to the individual event resource.")
    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public EventSummary name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the event.
     *
     * @return name
     **/
    @ApiModelProperty(value = "The name of the event.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EventSummary eventSummary = (EventSummary) o;
        return Objects.equals(this.resourceURI, eventSummary.resourceURI) &&
            Objects.equals(this.name, eventSummary.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceURI, name);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EventSummary {\n");

        sb.append("    resourceURI: ").append(toIndentedString(resourceURI)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

