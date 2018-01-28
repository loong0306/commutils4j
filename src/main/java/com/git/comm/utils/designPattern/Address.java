package com.git.comm.utils.designPattern;

/**
 * 设计模式-Builder设计模式
 */
public class Address {
    private final String province;
    private final String city;
    private final String area;
    private final String street;

    public static class Builder {
        private String province;
        private String city;
        private String area;
        private String street;

        public Builder() {

        }

        public Builder province(String province) {
            this.province = province;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder street(String street) {
            this.street = street;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }

    private Address(Builder builder) {
        province = builder.province;
        city = builder.city;
        area = builder.area;
        street = builder.street;
    }

}
