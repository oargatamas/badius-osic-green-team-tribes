package com.greenfox.exam.badiusosicgreentribes.domain.kingdom;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MapArea {

    @Column(name = "center_width")
    private Integer width;
    @Column (name = "center_height")
    private Integer height;
    @Column (name = "center_top")
    private Integer top;
    @Column (name = "center_left")
    private Integer left;

    public MapArea() {
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

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getLeft() {
        return left;
    }

    public void setLeft(Integer left) {
        this.left = left;
    }

    public static class Builder {

        private Integer width;
        private Integer height;
        private Integer top;
        private Integer left;

        public Builder width(Integer width) {
            this.width = width;
            return this;
        }

        public Builder height(Integer height) {
            this.height = height;
            return this;
        }

        public Builder top(Integer top) {
            this.top = top;
            return this;
        }

        public Builder left(Integer left) {
            this.left = left;
            return this;
        }

        public MapArea build () {
            return new MapArea(this);
        }
    }

    private MapArea(Builder builder) {
        this.width = builder.width;
        this.height = builder.height;
        this.top = builder.top;
        this.left = builder.left;
    }
}

