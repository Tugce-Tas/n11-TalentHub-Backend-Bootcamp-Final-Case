package com.tugcetasyildiz.restaurants.entity;

import com.tugcetasyildiz.restaurants.client.model.CommentRestaurantResponseDTO;
import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@SolrDocument(solrCoreName = "n11_restaurants")
public class Restaurant implements Serializable{

    @Serial
    private static final long serialVersionUID = 7735476347081228583L;

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "NAME", type = "string")
    private String name;

    @Indexed(name = "LONGITUDE", type = "pdouble")
    private Double longitude;

    @Indexed(name = "LATITUDE", type = "pdouble")
    private Double latitude;

    @Field
    private ArrayList<CommentRestaurantResponseDTO> commentList;

    @Indexed(name = "AVERAGE_SCORE", type = "pdouble")
    private Double averageScore = 0.0;

}