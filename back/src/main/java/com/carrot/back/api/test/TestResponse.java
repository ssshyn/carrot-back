package com.carrot.back.api.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "맛집 response")
public class TestResponse {

    @Schema(description = "맛집 데이터")
    private GetFoodKr getFoodKr;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GetFoodKr {
        private Header header;
        private List<Item> item;
//        private Integer numOfRows;
//        private Integer pageNo;
//        private Integer totalCount;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Header {
        private String code;
        private String message;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Item {

        @JsonProperty("UC_SEQ")
        private Integer ucSeq;
        @JsonProperty("MAIN_TITLE")
        private String mainTitle;
        @JsonProperty("GUGUN_NM")
        private String gugunNm;
        @JsonProperty("LAT")
        private Double lat;
        @JsonProperty("LNG")
        private Double lng;
        @JsonProperty("PLACE")
        private String place;
        @JsonProperty("TITLE")
        private String title;
        @JsonProperty("SUBTITLE")
        private String subTitle;
        @JsonProperty("ADDR1")
        private String addr1;
        @JsonProperty("ADDR2")
        private String addr2;
        @JsonProperty("CNTCT_TEL")
        private String cntCtTel;
        @JsonProperty("HOMEPAGE_URL")
        private String homepageUrl;
        @JsonProperty("USAGE_DAY_WEEK_AND_TIME")
        private String usageDayWeekAndTime;
        @JsonProperty("RPRSNTV_MENU")
        private String rprsntvMenu;
        @JsonProperty("MAIN_IMG_NORMAL")
        private String mainImgNormal;
        @JsonProperty("MAIN_IMG_THUMB")
        private String mainImgThumb;
        @JsonProperty("ITEMCNTNTS")
        private String itemContents;
    }

}
